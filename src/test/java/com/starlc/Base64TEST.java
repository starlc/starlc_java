package com.starlc;


import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64TEST {

    @Test
    public void decode() throws Exception {
        String key = "oZImo5zozQggF2BymfTc090trJ3N6xyWfo18/8Lp7jTh8l2v5iCDg5phuOMsAthCWpnEJqsiMBtxMaMJ+1oBvaFyNeTZqGFtOftKQJ2mzawpwW8t2NFi23mXuzt0YFhqEdEndFeqIPylzAzI4blfu/v0mjUkjTGWFTywCICuvdyoBD5v8tTnSoioM66q7yswT1zhi/YMDhe5ab17zlFGyA==";
        key =Encrypt.Decrypt(key, "d8cg8gVakEq9Agup");
        Map<String, String> map = splitQueryString(key);
        map.forEach((k1,v1)-> System.out.println(k1+":"+v1));
    }
    public static final String OAUTH_REDIRECT_URI = "redirect_uri";
    public static final String OAUTH_STATE = "state";
    public static Map<String, String> splitQueryString(String queryStringBase64) {
        Map<String, String> map = new HashMap<String, String>(4);

        try {

            byte[] bt = Base64.decodeBase64(queryStringBase64);
            String queryString = new String(bt, "UTF-8");
            String pairs[] = queryString.split("&");
            if (pairs == null || pairs.length == 0) {
                return map;
            }
            for (String pair : pairs) {
                String strs[] = pair.split("=");
                if (strs == null || strs.length != 2) {
                    continue;
                }
                String key = strs[0].trim();
                String value = strs[1].trim();
                if (OAUTH_REDIRECT_URI.equals(key)) {
                    value = URLDecoder.decode(value, "UTF-8");
                }
                if (OAUTH_STATE.equals(key)) {
                    value = URLDecoder.decode(value, "UTF-8");
                }
                map.put(key, value);
            }

            return map;
        } catch (UnsupportedEncodingException e) {
            System.out.println("split queryStringBase64 " + queryStringBase64
                    + " error");
            return map;
        }

    }
}
class Encrypt {
    final static String ALGORITHMSTR = "AES/ECB/PKCS5Padding";

    /**
     */

    /*******************************************************************
     * 使用AES-128-CBC加密模式，key需要为16位。
     * */

    public static String Decrypt(String sSrc, String decryptKey) throws Exception {
        try {
            byte[] encryptBytes = new BASE64Decoder().decodeBuffer(sSrc);
            Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(decryptKey.getBytes(), "AES"));
            byte[] decryptBytes = cipher.doFinal(encryptBytes);
            return new String(decryptBytes);
        }catch (Exception e) {
            throw new Exception("sSrc="+sSrc+",key="+decryptKey);
        }
    }

    /**
     * AES加密为base 64 code
     * @param content 待加密的内容
     * @param encryptKey 加密密钥
     * @return 加密后的base 64 code
     * @throws Exception
     */
    public static String aesEncrypt(String content, String encryptKey) throws Exception {
        String result =  new BASE64Encoder().encode(aesEncryptToBytes(content, encryptKey));
        return result.replace("\n","");
    }
    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        Cipher cipher = Cipher.getInstance(ALGORITHMSTR);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(encryptKey.getBytes(), "AES"));

        return cipher.doFinal(content.getBytes("utf-8"));
    }
//
//    public static void main(String[] args) throws Exception {
//        String key = "d8cg8gVakEq9Agup";
//        String str = "H2gqYntH0MGiWNX27t9smQ==";
//        System.out.println(Decrypt(str, key));
//    }
}