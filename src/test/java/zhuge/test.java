package zhuge;

import com.tt.common.utils.NumUtils;
import com.tt.dao.ZhugeCommunityMapper;
import com.tt.entity.ZhugeCommunity;
import com.tt.entity.ZhugeCommunityExample;
import com.tt.entity.ZhugeCommunityListExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/6 11:15
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        ZhugeCommunityMapper zhugeCommunityMapper=(ZhugeCommunityMapper)applicationContext.getBean("zhugeCommunityMapper");

        ZhugeCommunityExample zhugeCommunityExample = new ZhugeCommunityExample();
        ZhugeCommunityExample.Criteria criteria = zhugeCommunityExample.createCriteria();
        criteria.andJiaoyiNumIsNotNull();
        List<ZhugeCommunity> zhugeCommunities = zhugeCommunityMapper.selectByExample(zhugeCommunityExample);
        for (ZhugeCommunity zhugeCommunity : zhugeCommunities) {
            String title = zhugeCommunity.getTitle();
            Integer integer = NumUtils.getInteger(title);
            String jiaoyiNum = zhugeCommunity.getJiaoyiNum();
            if(integer!=null){
                //含有的数字
                String stt = integer.toString();
                int i = jiaoyiNum.indexOf(stt);
                if(i!=-1){
                    jiaoyiNum = jiaoyiNum.substring(i+stt.length(), jiaoyiNum.length());
                }
                System.out.println(jiaoyiNum);
            }
            zhugeCommunity.setJiaoyiNum(jiaoyiNum);
            zhugeCommunityMapper.updateByPrimaryKeySelective(zhugeCommunity);
        }
        /*Integer integer = NumUtils.getInteger("平顺7路90弄");
        String sr="79013";
        if(integer!=null){
            String stt = integer.toString();
            int i = sr.indexOf(stt);
            if(i!=-1){
                sr = sr.substring(i+stt.length(), sr.length());
            }
        }
        System.out.println(sr);
*/
    }
}
