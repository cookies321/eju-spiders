package com.tt.common.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
/**
 * 
 * @Description: Pinyin4Util工具类
 * @author 赵乐
 * @date 2017年11月14日 下午1:37:46
 */
public class Pinyin4Util {
	/**
     * 汉字转换位汉语拼音首字母，英文字符不变，特殊字符丢失 支持多音字，生成方式如（长沙市长:cssc,zssz,zssc,cssz）
     *
     * @param chines
     *            汉字
     * @return 拼音
     */
    public static String converterToFirstSpell(String chines) {
        StringBuffer pinyinName = new StringBuffer();
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    // 取得当前汉字的所有全拼  
                    String[] strs = PinyinHelper.toHanyuPinyinStringArray(
                            nameChar[i], defaultFormat);
                    if (strs != null) {
                        for (int j = 0; j < strs.length; j++) {
                            // 取首字母  
                            pinyinName.append(strs[j].charAt(0));
                            if (j != strs.length - 1) {
                                pinyinName.append(",");
                            }
                        }
                    }
                    // else {  
                    // pinyinName.append(nameChar[i]);  
                    // }  
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName.append(nameChar[i]);
            }
            pinyinName.append(" ");
        }
        // return pinyinName.toString();  
        return parseTheChineseByObject(discountTheChinese(pinyinName.toString()));
    }

    /**
     * 汉字转换位汉语全拼，英文字符不变，特殊字符丢失
     * 支持多音字，生成方式如（重当参:zhongdangcen,zhongdangcan,chongdangcen
     * ,chongdangshen,zhongdangshen,chongdangcan）
     *
     * @param chines
     *            汉字
     * @return 拼音
     */
    public static String converterToSpell(String chines) {
        StringBuffer pinyinName = new StringBuffer();
        char[] nameChar = chines.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (int i = 0; i < nameChar.length; i++) {
            if (nameChar[i] > 128) {
                try {
                    // 取得当前汉字的所有全拼  
                    String[] strs = PinyinHelper.toHanyuPinyinStringArray(
                            nameChar[i], defaultFormat);
                    if (strs != null) {
                        for (int j = 0; j < strs.length; j++) {
                            //首字母变大写

                            char c = strs[j].charAt(0);// 大写第一个字母
                            //String pinyin = String.valueOf(c).toUpperCase().concat(strs[j].substring(1));
                            String pinyin = String.valueOf(c).concat(strs[j].substring(1));

                            pinyinName.append(pinyin);
                            if (j != strs.length - 1) {
                                pinyinName.append(",");
                            }
                        }
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName.append(nameChar[i]);
            }
            pinyinName.append(" ");
        }
        // return pinyinName.toString();  
        return parseTheChineseByObject(discountTheChinese(pinyinName.toString()));
    }

    /**
     * 去除多音字重复数据
     *
     * @param theStr
     * @return
     */
    private static List<Map<String, Integer>> discountTheChinese(String theStr) {
        // 去除重复拼音后的拼音列表  
        List<Map<String, Integer>> mapList = new ArrayList<Map<String, Integer>>();
        // 用于处理每个字的多音字，去掉重复  
        Map<String, Integer> onlyOne = null;
        String[] firsts = theStr.split(" ");
        // 读出每个汉字的拼音  
        for (String str : firsts) {
            onlyOne = new Hashtable<String, Integer>();
            String[] china = str.split(",");
            // 多音字处理  
            for (String s : china) {
                Integer count = onlyOne.get(s);
                if (count == null) {
                    onlyOne.put(s, new Integer(1));
                } else {
                    onlyOne.remove(s);
                    count++;
                    onlyOne.put(s, count);
                }
            }
            mapList.add(onlyOne);
        }
        return mapList;
    }

    /**
     * 解析并组合拼音，对象合并方案
     *
     * @return
     */
    private static String parseTheChineseByObject(
            List<Map<String, Integer>> list) {
        Map<String, Integer> first = null; // 用于统计每一次,集合组合数据  
        // 遍历每一组集合  
        for (int i = 0; i < list.size(); i++) {
            // 每一组集合与上一次组合的Map  
            Map<String, Integer> temp = new Hashtable<String, Integer>();
            // 第一次循环，first为空  
            if (first != null) {
                // 取出上次组合与此次集合的字符，并保存  
                for (String s : first.keySet()) {
                    for (String s1 : list.get(i).keySet()) {
                        String str = s + s1;
                        temp.put(str, 1);
                    }
                }
                // 清理上一次组合数据  
                if (temp != null && temp.size() > 0) {
                    first.clear();
                }
            } else {
                for (String s : list.get(i).keySet()) {
                    String str = s;
                    temp.put(str, 1);
                }
            }
            // 保存组合数据以便下次循环使用  
            if (temp != null && temp.size() > 0) {
                first = temp;
            }
        }
        String returnStr = "";
        if (first != null) {
            // 遍历取出组合字符串  
            for (String str : first.keySet()) {
                returnStr += (str + ",");
            }
        }
        if (returnStr.length() > 0) {
            returnStr = returnStr.substring(0, returnStr.length() - 1);
        }
        return returnStr;
    }

    /**
     *
     * @param city
     * @return
     */
    public static String parse13City(String city){
        /*String[] citys={"北京","深圳","广州","南京","杭州","苏州","成都","武汉","青岛","重庆","东莞","天津","沈阳"};*/

        String cityPin="";
        switch (city){
            case "北京":
                cityPin="beijing";
                break;
            case "深圳":
                cityPin="shenzhen";
                break;
            case "广州":
                cityPin="guangzhou";
                break;
            case "南京":
                cityPin="nanjing";
                break;
            case "杭州":
                cityPin="hangzhou";
                break;
            case "苏州":
                cityPin="suzhou";
                break;
            case "成都":
                cityPin="chengdu";
                break;
            case "武汉":
                cityPin="wuhan";
                break;
            case "青岛":
                cityPin="qingdao";
                break;
            case "重庆":
                cityPin="chongqing";
                break;
            case "东莞":
                cityPin="dg";
                break;
            case "天津":
                cityPin="tianjin";
                break;
            case "沈阳":
                cityPin="shenyang";
                break;
            default:
                break;
    }
        return cityPin;
    }

    public static void main(String[] args) throws IOException {
        /*String[] citys={"北京","深圳","广州","南京","杭州","苏州","成都","武汉","青岛","重庆","东莞","天津","沈阳"};
        for (String city : citys) {
            String ss = parse13City(city);
            String url="https://"+ss+".qfang.com/newhouse";
            String s = PageDownLoadUtil.httpMoguproxyGet(url);
            System.out.println(s);
        }*/
        /*String ss = parse13City("重庆");
        String url="https://"+ss+".qfang.com/newhouse";
        HttpResponse httpResponse = PageDownLoadUtil.httpMoguproxyGet(url);
        HttpEntity entity = httpResponse.getEntity();
        String s = EntityUtils.toString(entity);

        System.out.println(s);
        System.out.println("jieshu");*/

        String[] citys={"北京","深圳","广州","南京","杭州","苏州","成都","武汉","青岛","重庆","东莞","天津","沈阳"};
        for (String city : citys) {
            String ciytPin = parse13City(city);
            String url="https://"+ciytPin+".anjuke.com/community/?from=esf_list_navigation";
            System.out.println(city+"---"+url);
        }
    }




}
