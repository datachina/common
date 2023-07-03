package com.data.common.web.validation.validate;


import com.data.common.web.validation.annotation.ChinaPhoneNumber;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 手机号码校验器
 *
 * @author jidaojiuyou
 */
public class ChinaPhoneNumberValidator implements ConstraintValidator<ChinaPhoneNumber, String> {

    /**
     * 中国手机号码正则
     */
    private static final Pattern CHINA_PHONE_PATTEN = Pattern.compile("1([3-9])\\d{9}$");

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (isBlank(value)) {
            return true;
        }

        return checkChinaPhoneNumber(value);
    }

    /**
     * 校验是否为手机号
     *
     * @param value 值
     * @return 是否为手机号
     */
    private boolean checkChinaPhoneNumber(String value) {
        return CHINA_PHONE_PATTEN.matcher(value).matches();
    }

    /**
     * 是否为空
     *
     * @param value 值
     * @return 是否为空
     */
    private boolean isBlank(String value) {
        return value == null || "".equals(value);
    }
}