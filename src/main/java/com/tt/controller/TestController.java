package com.tt.controller;

import com.tt.common.JnaLianjia;
import com.tt.service.IDownLoadPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: 赵乐
 * @Date: 2018/11/28 16:26
 * @Description:
 */
@RestController
public class TestController {

    @Autowired
    @Qualifier("ipPoolProxy")
    //@Qualifier("moguProxy")
    private IDownLoadPage downLoadPage;



    @RequestMapping("/test")
    public String tetsss(){
        JnaLianjia jnaLianjia = new JnaLianjia();
        String sec = jnaLianjia.getSec("city=%25E4%25B8%258A%25E6%25B5%25B7&gettype=android&isJiajuAD=1&isspecialpricefour=1&jkVersion=2&maptype=baidu&messagename=esflist&page=1&pagesize=20&purpose=%25E4%25BD%258F%25E5%25AE%2585");
        System.out.println(sec+"====");
        return sec+"====";
    }

}
