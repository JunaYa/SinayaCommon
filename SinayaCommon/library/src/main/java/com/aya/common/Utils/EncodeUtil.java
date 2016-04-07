package com.aya.common.Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Single on 2016/4/7.
 */
public class EncodeUtil {
    public static String iv = "1234567890123456";

    public EncodeUtil() {
    }

//    public static String Encrypt(String sSrc, String sKey) throws Exception {
//        if(sKey != null && sKey.length() == 16) {
//            byte[] raw = sKey.getBytes();
//            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
//            IvParameterSpec iv = new IvParameterSpec(iv.getBytes());
//            cipher.init(1, skeySpec, iv);
//            byte[] srawt = sSrc.getBytes();
//
//            int len;
//            for(len = srawt.length; len % 16 != 0; ++len) {
//                ;
//            }
//
//            byte[] sraw = new byte[len];
//
//            for(int encrypted = 0; encrypted < len; ++encrypted) {
//                if(encrypted < srawt.length) {
//                    sraw[encrypted] = srawt[encrypted];
//                } else {
//                    sraw[encrypted] = 0;
//                }
//            }
//
//            byte[] var10 = cipher.doFinal(sraw);
//            return Base64.encode(var10);
//        } else {
//            return null;
//        }
//    }
//
//    public static String Decrypt(String sSrc, String sKey) throws Exception {
//        if(sKey != null && sKey.length() == 16) {
//            byte[] raw = sKey.getBytes("ASCII");
//            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
//            IvParameterSpec iv = new IvParameterSpec(iv.getBytes());
//            cipher.init(2, skeySpec, iv);
//            byte[] encrypted = Base64.decode(sSrc);
//            byte[] original = cipher.doFinal(encrypted);
//            String originalString = new String(original);
//            return originalString.trim();
//        } else {
//            return null;
//        }
//    }
}
