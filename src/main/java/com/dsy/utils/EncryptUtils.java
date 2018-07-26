package com.dsy.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class EncryptUtils {

    private static final String KEY = "1234567812345678";
    //先进行DES加密，再进行md5加密
    public static String encrypt(String password){
        DES des = new DES();
        String encontent = des.authcode(password,"DECODE",KEY);//加密
        encontent = DigestUtils.md5Hex(encontent);
        return encontent;
    }

    public static void main(String[] args) {
        System.out.println(encrypt("111"));
    }


}
