package fang.xinfang;

import com.tt.common.DownLoadPage;
import com.tt.dao.FangXfLoupangListMapper;
import com.tt.entity.FangXfLoupangList;
import com.tt.entity.FangXfLoupangListExample;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/6 18:56
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        FangXfLoupangListMapper fangXfLoupangListMapper = (FangXfLoupangListMapper)applicationContext.getBean("fangXfLoupangListMapper");

        FangXfLoupangListExample fangXfLoupangListExample = new FangXfLoupangListExample();
        FangXfLoupangListExample.Criteria criteria = fangXfLoupangListExample.createCriteria();
        criteria.andTitleLike("%�%");
        List<FangXfLoupangList> fangXfLoupangLists = fangXfLoupangListMapper.selectByExample(fangXfLoupangListExample);
        System.out.println(fangXfLoupangLists.size());
        for (FangXfLoupangList fangXfLoupangList : fangXfLoupangLists) {
            String detailPc = fangXfLoupangList.getDetailPc();

            Document document = DownLoadPage.downLoadPage(detailPc);
            if(document!=null){
                Elements select = document.select("div.inf_left1>div.tit>h1");

                if(select.isEmpty()){
                    select=document.select("div.lp-info>h1>span");
                }
                if(!select.isEmpty()){
                    String text = select.text();
                    System.out.println(text);
                    fangXfLoupangList.setTitle(text);
                    fangXfLoupangListMapper.updateByPrimaryKeySelective(fangXfLoupangList);
                }
            }
        }
    }
}
