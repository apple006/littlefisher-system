package com.yc.core.utils;

/**
 * 
 * Description: 字符串帮助类
 *  
 * Created on 2016年12月30日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public final class StringUtil {
    
    /**
     * 禁止实例化
     */
    private StringUtil() {
    }
    
    /**
     * 
     * Description: 检查字符串是否为空，值为null或长度为0都为空
     * 
     * @author jinyanan
     *
     * @param val 要检查的字符串
     * @return boolean true-为空，false-不为空
     */
    public static boolean isEmpty(String val) {
        if (val == null || val.length() == 0) {
            return true;
        }
        return false;
    }
    
    /**
     * 
     * Description: 检查字符串trim后是否为空，val.trim()为null或长度为0都为空
     * 
     * @author jinyanan
     *
     * @param val 要检查的字符串
     * @return boolean true-为空，false-不为空
     */
    public static boolean isEmptyInTrim(String val) {
        if (val == null || val.trim().length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 
     * Description: 检查字符串是否不为空，要求val不为空且长度大于0
     * 
     * @author jinyanan
     *
     * @param val 要检查的字符
     * @return boolean true-为空, false-不为空
     */
    public static boolean isNotEmpty(String val) {
        if (val == null || val.length() == 0) {
            return false;
        }

        return true;
    }
    
    /**
     * 
     * Description: 检查字符串trim后是否不为空，要求val.trim()不为空且长度大于0
     * 
     * @author jinyanan
     *
     * @param val 要检查的字符
     * @return boolean true-为空, false-不为空
     */
    public static boolean isNotEmptyInTrim(String val) {
        if (val == null || val.trim().length() == 0) {
            return false;
        }

        return true;
    }
    
    /**
     * 
     * Description: 检查字符串是否全由数字构成的
     * 
     * @author jinyanan
     *
     * @param str 要检查的字符
     * @return boolean true-全数字，false-不全为数字或字符串不存在
     */
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 去掉字符串的空格
     * 
     * @param str 字符串
     * @return String 去掉空格后的字符串
     */
    public static String trim(String str) {
        return (str == null) ? str : str.trim();
    }
    
    /**
     * 
     * Description: 字符串替换：如（"aa_a","a_","A"）即将字符串"aa_a"中的"a_"替换为"A" 得到aAa
     * 
     * @author jinyanan
     *
     * @param source source
     * @param oldString oldString
     * @param newString newString
     * @return String
     */
    public static String replace(String source, String oldString, String newString) {
        StringBuffer output = new StringBuffer();
        int lengthOfSource = source.length();
        int lengthOfOld = oldString.length();
        int posStart;
        int pos;
        for (posStart = 0; (pos = source.indexOf(oldString, posStart)) >= 0; posStart = pos + lengthOfOld) {
            output.append(source.substring(posStart, pos));
            output.append(newString);
        }

        if (posStart < lengthOfSource) {
            output.append(source.substring(posStart));
        }
        return output.toString();
    }
}
