package com.tt.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cric.ess.common.HttpMethods;
import com.cric.ess.common.auth.AuthBuilder;
import com.cric.ess.common.md5.Md5Utils;
import com.eju.houseparent.common.security.MD5;
import com.tt.common.ESSConfig;
import com.tt.service.IEssUploadService;
import com.tt.vo.BaseDTO;
import com.tt.vo.Context;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static com.eju.houseparent.common.utils.ImageReaderUtils.imageToByte;
import static com.eju.houseparent.common.utils.ImageReaderUtils.imgUrlUpdate;


/**
 * @author NJ
 * @create 2018-09-20 16:06
 **/
@Service
public class EssUploadServiceImpl implements IEssUploadService {
    private static final Logger log = LoggerFactory.getLogger(EssUploadServiceImpl.class);

    @Resource
    private ESSConfig essConfig;

    /**
     * ESS 文件上传
     *
     * @param context
     * @return
     */
    @Override
    public String fileUpload(Context context) throws IOException {
        CloseableHttpClient closeableHttpClient = HttpClientBuilder.create().build();
        String fileKey = context.getFilename();
        fileKey = fileKey.replaceAll(" ", "");
        String url = essConfig.getUploadUrl() + fileKey;
        String accessKeyId = essConfig.getAccessKeyId();
        String secretAccessKey = essConfig.getSecretAccessKey();
        String encode = "utf-8";
        String bucketName = essConfig.getBucketName();
        InputStream input = new ByteArrayInputStream(context.getData());
        String contentMD5 = Md5Utils.md5AsBase64(input);

        HttpPut httpPut = new HttpPut(url);
        DateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date = sdf.format(new Date());
        httpPut.addHeader("Date", date);
        httpPut.addHeader("Content-Type", context.getContenttype());
        httpPut.addHeader("Content-MD5", contentMD5);

        AuthBuilder builder = new AuthBuilder.Builder(accessKeyId, secretAccessKey)
                .bucketName(bucketName)
                .contentMD5(contentMD5)
//                .contentType(ContentType.APPLICATION_OCTET_STREAM.getMimeType())
                .contentType(context.getContenttype())
                .date(date)
                .fileKey(fileKey)
                .httpMethod(HttpMethods.PUT)
                .build();
        httpPut.addHeader("Authorization", builder.makeAuth());
        InputStreamEntity entity = new InputStreamEntity(new ByteArrayInputStream(context.getData()), ContentType.APPLICATION_OCTET_STREAM); //文件流 上传

        entity.setChunked(true);
        httpPut.setEntity(entity);

        try (CloseableHttpResponse resp = closeableHttpClient.execute(httpPut)) {
            int statusCode = resp.getStatusLine().getStatusCode();
            String content = EntityUtils.toString(resp.getEntity(), encode);
            if (statusCode == 200) {  //上传成功
                url = essConfig.getDownloadUrl() + fileKey;
                //log.info(">> 上传成功，返回URL： >>>" + url);
                return url;
            } else {  //上传失败
                if (StringUtils.isNotBlank(content)) {
                    JSONObject jsonObject = JSON.parseObject(content);
                    log.info(jsonObject.getString("message"));
                }
            }
            log.info(">> 上传状态 >>>" + statusCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * ESS 文件上传
     *
     * @param cityCd
     * @param communityId
     * @param file
     * @param fileUrl
     * @return
     */
    @Override
    public BaseDTO fileUpload(Long cityCd, Long communityId, MultipartFile file, String fileUrl) throws IOException {
        if(file == null && StringUtils.isBlank(fileUrl)){
            return new BaseDTO().fail("请选择导入图片或输入URL");
        }
        Context context = new Context();
        byte[] data = null;
        String filename = null;
        if(file != null){
            data = file.getBytes();
            filename = "fang/"+cityCd+"/layout/"+ MD5.encrypt(file.getOriginalFilename(),"")+".jpg";
        }else{
            data = imageToByte(imgUrlUpdate("[0-9]+x[0-9]+","900x675",fileUrl));
            filename =  "fang/"+cityCd+"/layout/"+ MD5.encrypt(fileUrl,"")+".jpg";
        }
        context.setFilename(filename);
        context.setData(data);
        context.setContenttype("image/jpeg");
        String resultFileUrl = fileUpload(context);
        return new BaseDTO().addObject(resultFileUrl);
    }
}
