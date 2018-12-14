package com.tt.common.utils;

import java.util.Random;

/**
 * @author NJ
 * @create 2018-04-10 14:23
 **/
public class RandomUtil {

    public static final Double randomDouble(double min, double max) {
        Double d = Math.random() * (max - min) + min;
        return d;
    }

    public static final Integer randomInteger(Integer min, Integer max) {
        Double d = Math.random() * (max - min) + min;
        return d.intValue();
    }

    //根据指定长度生成字母和数字的随机数
    //0~9的ASCII为48~57
    //A~Z的ASCII为65~90
    //a~z的ASCII为97~122
    public static String createRandomCharData(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();//随机用以下三个随机生成器
        Random randdata = new Random();
        int data = 0;
        for (int i = 0; i < length; i++) {
            int index = rand.nextInt(3);
            //目的是随机选择生成数字，大小写字母
            switch (index) {
                case 0:
                    data = randdata.nextInt(10);//仅仅会生成0~9
                    sb.append(data);
                    break;
//                case 1:
//                    data = randdata.nextInt(26) + 65;//保证只会产生65~90之间的整数
//                    sb.append((char) data);
//                    break;
                case 2:
                    data = randdata.nextInt(26) + 97;//保证只会产生97~122之间的整数
                    sb.append((char) data);
                    break;
            }
        }
        String result = sb.toString();
        return result;
    }

    public static String RandomChoiceUserAgents() {
        String[] USER_AGENTS = new String[]{
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; AcooBrowser; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
                "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Acoo Browser; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.0.04506)",
                "Mozilla/4.0 (compatible; MSIE 7.0; AOL 9.5; AOLBuild 4337.35; Windows NT 5.1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
                "Mozilla/5.0 (Windows; U; MSIE 9.0; Windows NT 9.0; en-US)",
                "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)",
                "Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 1.0.3705; .NET CLR 1.1.4322)",
                "Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 5.2; .NET CLR 1.1.4322; .NET CLR 2.0.50727; InfoPath.2; .NET CLR 3.0.04506.30)",
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN) AppleWebKit/523.15 (KHTML, like Gecko, Safari/419.3) Arora/0.3 (Change: 287 c9dfb30)",
                "Mozilla/5.0 (X11; U; Linux; en-US) AppleWebKit/527+ (KHTML, like Gecko, Safari/419.3) Arora/0.6",
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.2pre) Gecko/20070215 K-Ninja/2.1.1",
                "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9) Gecko/20080705 Firefox/3.0 Kapiko/3.0",
                "Mozilla/5.0 (X11; Linux i686; U;) Gecko/20070322 Kazehakase/0.4.5",
                "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.8) Gecko Fedora/1.9.0.8-1.fc10 Kazehakase/0.5.6",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11",
                "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.20 (KHTML, like Gecko) Chrome/19.0.1036.7 Safari/535.20",
                "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52",
                "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.170 Safari/537.36 OPR/53.0.2907.99",
                "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt"
        };
        Random random = new Random();
        int n = random.nextInt(USER_AGENTS.length);
        return USER_AGENTS[n];
    }


    public static void main(String[] args) {
//        System.out.println(randomInteger(1200, 5000));
        System.out.println(RandomChoiceUserAgents());
        System.out.println(RandomChoiceUserAgents());
    }

}
