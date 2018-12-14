package com.tt.service;

import com.tt.vo.BaseDTO;
import com.tt.vo.Context;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author NJ
 * @create 2018-09-20 16:05
 **/
public interface IEssUploadService {
    /**
     * ESS 文件上传
     *
     * @param context
     * @return
     */
    String fileUpload(Context context) throws IOException;

    /**
     * ESS 文件上传
     *
     * @return
     */
    BaseDTO fileUpload(Long cityCd, Long communityId, MultipartFile file, String fileUrl) throws IOException;

}
