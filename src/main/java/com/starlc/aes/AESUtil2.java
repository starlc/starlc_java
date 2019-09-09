package com.starlc.aes;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Description: AES加密解密工具类
 * @Author: liuc
 * @CreateDate: 2019/9/6 16:36
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
public class AESUtil2 {


    private static final String defaultCharset = "UTF-8";

    private static final String KEY_AES = "AES";

    private static final String KEY = "123456";

    private static final String KEY_MD5 = "MD5";

    private static MessageDigest md5Digest;

    static {
        try {
            md5Digest = MessageDigest.getInstance(KEY_MD5);
        } catch (NoSuchAlgorithmException e) {
            //logger.error("获取MD5摘要出错");
        }
    }


    /**
     * 加密
     *
     * @param data 需要加密的内容
     * @param key  加密密码
     */

    public static String encrypt(String data, String key) {
        return doAES(data, key, Cipher.ENCRYPT_MODE);
    }


    /**
     * 解密
     *
     * @param data 待解密内容
     * @param key  解密密钥
     */

    public static String decrypt(String data, String key) {
        return doAES(data, key, Cipher.DECRYPT_MODE);
    }



    /**
     * 加解密
     * @param data
     * @param key
     * @param mode
     * @return
     */
    private static String doAES(String data, String key, int mode) {
        try {
//            if (StringUtils.isBlank(data) || StringUtils.isBlank(key)) {
//                return null;
//            }
            boolean encrypt = mode == Cipher.ENCRYPT_MODE;
            byte[] content;

            //true 加密内容 false 解密内容
            if (encrypt) {
                content = data.getBytes(defaultCharset);
            } else {
                content = parseHexStr2Byte(data);
            }

            SecretKeySpec keySpec = new SecretKeySpec(md5Digest.digest(key.getBytes(defaultCharset)), KEY_AES);//构造一个密钥
            Cipher cipher = Cipher.getInstance(KEY_AES);// 创建密码器
            cipher.init(mode, keySpec);// 初始化
            byte[] result = cipher.doFinal(content);//加密或解密
            if (encrypt) {
                return parseByte2HexStr(result);
            } else {
                return new String(result, defaultCharset);

            }

        } catch (Exception e) {
            //logger.error("AES 密文处理异常", e);
        }
        return null;
    }


    /**
     * 将二进制转换成16进制
     */

    public static String parseByte2HexStr(byte buf[]) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     */
    public static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) {
            return null;
        }

        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    public static void main(String[] args) throws Exception {

        String content = "{'repairPhone':'18547854787','customPhone':'12365478965','captchav':'58m7'}";

        System.out.println("加密前：" + content);

        System.out.println("加密密钥和解密密钥：" + KEY);

        String encrypt = encrypt(content, KEY);

        System.out.println("加密后：" + encrypt);

        String decrypt = decrypt(encrypt, KEY);

        System.out.println("解密后：" + decrypt);

    }

}
