package beike;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.tt.common.Constants;
import com.tt.common.utils.PageDownLoadUtil;
import com.tt.dao.KeLoudongBdToGdCrawlerMapper;
import com.tt.dao.KeLoudongMapper;
import com.tt.entity.KeLoudong;
import com.tt.entity.KeLoudongBdToGdCrawler;
import com.tt.entity.KeLoudongBdToGdCrawlerExample;
import com.tt.entity.KeLoudongExample;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/11 18:54
 * @Description: ke_loudong 中百度坐标，转高德坐标
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class ke_LayLouDongAddressToGaoDe {

    @Autowired
    private KeLoudongBdToGdCrawlerMapper keLoudongBdToGdCrawlerMapper;

    @Autowired
    private KeLoudongMapper keLoudongMapper;


    @Test
    public void addressToGaoDe(){
        KeLoudongExample keLoudongExample = new KeLoudongExample();
        keLoudongExample.setOrderByClause("id asc");
        keLoudongExample.or().andPointLatIsNotNull().andPointLatIsNotNull().andGaodeLatIsNull();
        /*KeLoudongBdToGdCrawlerExample keLoudongBdToGdCrawlerExample = new KeLoudongBdToGdCrawlerExample();
        keLoudongBdToGdCrawlerExample.setOrderByClause("building_id asc");
        keLoudongBdToGdCrawlerExample.or().andPointLngIsNotNull().andPointLatIsNotNull().andGaodeLatIsNull();*/
        for (int k = 1; k < 4336; k++) {
            PageHelper.startPage(1, 40);
            List<KeLoudong> list = keLoudongMapper.selectByExample(keLoudongExample);
            System.out.println(list.size());
            StringBuffer sb=new StringBuffer();
            for (int i=0; i<list.size();i++) {
                if(i==0){
                    KeLoudong keLoudong = list.get(0);
                    String pointLng = keLoudong.getPointLng();
                    String pointLat = keLoudong.getPointLat();
                    if(StringUtils.isNotBlank(pointLat) && StringUtils.isNotBlank(pointLng)){
                        String address = pointLng + "," + pointLat;
                        sb.append(address);
                    }
                }else{
                    KeLoudong keLoudong = list.get(i);
                    String pointLng = keLoudong.getPointLng();
                    String pointLat = keLoudong.getPointLat();
                    if(StringUtils.isNotBlank(pointLat) && StringUtils.isNotBlank(pointLng)){
                        String address = pointLng + "," + pointLat;
                        sb.append("%7c"+address);
                    }
                }
            }
            /*String url="https://restapi.amap.com/v3/place/text?keywords=翰林花园&city=hangzhou&output=xml&offset=20&page=1&key=7a87d5b75e0eac5784d90c8654296167&extensions=all";*/
            String strAddress = sb.toString();
            System.out.println(strAddress);
            String url="https://restapi.amap.com/v3/assistant/coordinate/convert?locations="+strAddress+"&coordsys=baidu&output=json&key="+ Constants.AMAP_KEY;
            String result = PageDownLoadUtil.httpClientDefultGet(url,null);

            if(StringUtils.isNotBlank(result)){
                JSONObject object = JSON.parseObject(result);
                if("1".equals(object.getString("status"))){
                    String locations = object.getString("locations");
                    String[] address = locations.split(";");
                    if(address.length==list.size()){
                        for (int i=0; i<list.size();i++) {
                            String addre = address[i];
                            String[] split = addre.split(",");
                            if(split.length==2){
                                KeLoudong keLoudong = list.get(i);
                                keLoudong.setGaodeLng(split[0]);
                                keLoudong.setGaodeLat(split[1]);
                                keLoudongMapper.updateByPrimaryKeySelective(keLoudong);
                            }

                        }
                    }

                }
            }
        }
    }

}
