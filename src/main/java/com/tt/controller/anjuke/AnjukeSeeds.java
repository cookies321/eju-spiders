package com.tt.controller.anjuke;

import com.tt.common.utils.Pinyin4Util;
import com.tt.service.JedisClientService;
import com.tt.vo.AnjukeParamsVo;
import com.tt.vo.UrlType;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 发放爬虫的种子
 * @Auther: 赵乐
 * @Date: 2018/10/22 13:41
 * @Description:
 */
@RestController
public class AnjukeSeeds {

    @Autowired
    private JedisClientService jedisClientService;

    //redis中存放分页链接的key
    public static final String KEY_URL = "queueUrl";

    @RequestMapping("/go")
    public String goSeeds(){
        /*String[] citys={"北京","深圳","广州","南京","杭州","苏州","成都","武汉","青岛","重庆","东莞","天津","沈阳"};*/
        String[] citys={"沈阳"};
        for (String city : citys) {
            String cityPin = Pinyin4Util.parse13City(city);
            if (StringUtils.isBlank(cityPin)) {
                continue;
            }
            String url = "https://" + cityPin + ".anjuke.com/community/?from=esf_list_navigation";
            AnjukeParamsVo anjukeParamsVo = new AnjukeParamsVo();
            Map<String, String> map = new HashMap<>();
            map.put("city",city);
            anjukeParamsVo.setUrl(url);
            anjukeParamsVo.setHttpType(UrlType.GET);
            anjukeParamsVo.setUrkType(UrlType.ANJUKE_COMMUNITY_INDEX);
            //携带详情信息
            anjukeParamsVo.setDetail(map);
            jedisClientService.addObjectToList(KEY_URL,anjukeParamsVo);
        }
        System.out.println("放入初始链接结束");
        return "放入初始链接";
    }
}