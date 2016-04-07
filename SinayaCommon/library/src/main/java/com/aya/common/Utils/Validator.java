package com.aya.common.Utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Single on 2016/4/7.
 */
public class Validator {
    public Validator() {
    }

    public static final boolean isEmail(String str) {
        if(StringUtils.isBlank(str)) {
            return false;
        } else {
            Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
            Matcher matcher = pattern.matcher(str);
            return matcher.matches();
        }
    }

    public static final boolean isNumeric(String str) {
        if(StringUtils.isBlank(str)) {
            return false;
        } else {
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher matcher = pattern.matcher(str);
            return matcher.matches();
        }
    }

    public static final boolean isMobileNo(String str) {
        if(StringUtils.isBlank(str)) {
            return false;
        } else {
            Pattern pattern = Pattern.compile("^1\\d{10}$");
            Matcher matcher = pattern.matcher(str);
            return matcher.matches();
        }
    }
}
