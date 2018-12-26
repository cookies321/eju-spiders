package lianjia.app;

import com.tt.common.utils.LianjiaAppUtil;
import com.tt.service.IDownLoadPage;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: 赵乐
 * @Date: 2018/12/18 17:24
 * @Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml"})
public class parseCommunity {

    @Autowired
    @Qualifier("ipPoolProxy")
    private IDownLoadPage iDownLoadPage;


    @Test
    public void test(){
        System.load("/libSouFunSec.so");
    }

    /**
     *
     * 功能描述: 获取杭州小区列表数据
     *
     * @param:
     * @return: 
     * @auther: 赵乐
     * @date: 2018/12/19 17:35
     */
    @Test
    public void parseIndex(){
        //爬取杭州小区列表数据
        //每页只能只能返回3000
        //不限
        String indexUrl="https://app.api.lianjia.com/house/community/search?limit_offset=0&city_id=330100&limit_count=100";
        String plateUrl="https://app.api.ke.com/yezhu/publish/getBuildings?community_id=1811043642571";
        String authorization = LianjiaAppUtil.getAuthorization(plateUrl);
        Map<String, String> map = new HashMap<>();
        map.put("Authorization",authorization);
        Document document = iDownLoadPage.downLoadPageByGet(plateUrl,map);
        if(document!=null){
            String text = document.select("body").text();
            System.out.println(text);
        }
    }

}
