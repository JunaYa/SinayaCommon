package com.aya.common.Utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Single on 2016/4/7.
 */
public class Md5 {
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public Md5() {
    }

    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);

        for(int i = 0; i < b.length; ++i) {
            sb.append(HEX_DIGITS[(b[i] & 240) >>> 4]);
            sb.append(HEX_DIGITS[b[i] & 15]);
        }

        return sb.toString();
    }

    public static String md5(String s) {
        try {
            MessageDigest e = MessageDigest.getInstance("MD5");
            e.update(s.getBytes());
            byte[] messageDigest = e.digest();
            return toHexString(messageDigest);
        } catch (NoSuchAlgorithmException var3) {
            var3.printStackTrace();
            return "";
        }
    }
}
