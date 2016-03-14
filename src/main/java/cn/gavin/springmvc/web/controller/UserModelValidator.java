package cn.gavin.springmvc.web.controller;

import cn.gavin.springmvc.model.UserModel;
import org.springframework.validation.*;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by gaoxs on 2016/3/11.
 */
public class UserModelValidator implements Validator {

    private static final Pattern USERNAME_PATTERN = Pattern.compile("[a-zA-Z]\\w{4,19}]");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9]\\w{5,20}]");
    private static final Set<String> FORBINDDEN_WORD_SET = new HashSet<String>();

    static {
        FORBINDDEN_WORD_SET.add("fuck");
        FORBINDDEN_WORD_SET.add("admin");
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return UserModel.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        //这个表示如果目标对象的username属性为空，则表示错误
        ValidationUtils.rejectIfEmpty(errors,"username","username.not.empty");
        UserModel userModel = (UserModel) target;
        if(!USERNAME_PATTERN.matcher(userModel.getUsername()).matches()) {
            errors.rejectValue("username","username.not.illegal");
        }
        for(String forbiddenword: FORBINDDEN_WORD_SET) {
            if(userModel.getUsername().contains(forbiddenword)) {
                errors.rejectValue("username","username.forbidden",new Object[]{forbiddenword},"您的用户名包含非法关键词！");
                break;
            }
        }
        if(!PASSWORD_PATTERN.matcher(userModel.getPassword()).matches()) {
            errors.rejectValue("password","password.not.illegal","密码不合法！");
        }
    }
}
