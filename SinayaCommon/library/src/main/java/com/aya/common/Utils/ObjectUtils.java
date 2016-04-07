package com.aya.common.Utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Single on 2016/4/7.
 */
public class ObjectUtils {
    private ObjectUtils() {
        throw new AssertionError();
    }

    public static String ObjectToString(Object o) {
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(o);
            oos.flush();
            oos.close();
            bos.close();
            return new String(Base64.encode(bos.toByteArray()));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object StringToObject(String s) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(Base64.decode(s));
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object o = ois.readObject();
            bis.close();
            ois.close();
            return o;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isEquals(Object actual, Object expected) {
        boolean var10000;
        if (actual != expected) {
            label29:
            {
                if (actual == null) {
                    if (expected == null) {
                        break label29;
                    }
                } else if (actual.equals(expected)) {
                    break label29;
                }

                var10000 = false;
                return var10000;
            }
        }

        var10000 = true;
        return var10000;
    }

    public static String nullStrToEmpty(Object str) {
        return str == null ? "" : (str instanceof String ? (String) str : str.toString());
    }

    public static Long[] transformLongArray(long[] source) {
        Long[] destin = new Long[source.length];

        for (int i = 0; i < source.length; ++i) {
            destin[i] = Long.valueOf(source[i]);
        }

        return destin;
    }

    public static long[] transformLongArray(Long[] source) {
        long[] destin = new long[source.length];

        for (int i = 0; i < source.length; ++i) {
            destin[i] = source[i].longValue();
        }

        return destin;
    }

    public static Integer[] transformIntArray(int[] source) {
        Integer[] destin = new Integer[source.length];

        for (int i = 0; i < source.length; ++i) {
            destin[i] = Integer.valueOf(source[i]);
        }

        return destin;
    }

    public static int[] transformIntArray(Integer[] source) {
        int[] destin = new int[source.length];

        for (int i = 0; i < source.length; ++i) {
            destin[i] = source[i].intValue();
        }

        return destin;
    }

    public static <V> int compare(V v1, V v2) {
        return v1 == null
               ? (v2 == null ? 0 : -1)
               : (v2 == null ? 1 : ((Comparable) v1).compareTo(v2));
    }
}
