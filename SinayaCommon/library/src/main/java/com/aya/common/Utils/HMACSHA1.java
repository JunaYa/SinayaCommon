package com.aya.common.Utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Single on 2016/4/7.
 */
public class HMACSHA1 {
    private static final String HMAC_SHA1 = "HmacSHA1";

    public HMACSHA1() {
    }

    public static String getSignature(String data, String key) throws Exception {
        byte[] keyBytes = key.getBytes();
        SecretKeySpec signingKey = new SecretKeySpec(keyBytes, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(data.getBytes());
        String s = byte2hex(rawHmac);
        StringBuilder sb = new StringBuilder();
        byte[] var8 = rawHmac;
        int var9 = rawHmac.length;

        for(int var10 = 0; var10 < var9; ++var10) {
            byte b = var8[var10];
            sb.append(byteToHexString(b));
        }

        return sb.toString();
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";

        for(int n = 0; n < b.length; ++n) {
            stmp = Integer.toHexString(b[n] & 255);
            if(stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }

        return hs;
    }

    private static String byteToHexString(byte ib) {
        char[] Digit = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] ob = new char[]{Digit[ib >>> 4 & 15], Digit[ib & 15]};
        String s = new String(ob);
        return s;
    }
}
