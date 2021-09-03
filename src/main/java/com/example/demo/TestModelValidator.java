package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TestModelValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(TestModel.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        TestModel testModel = (TestModel)o;
        if (!StringUtils.hasText(testModel.getName())){
            errors.rejectValue("name","","姓名不能为空");
        }
        if (!StringUtils.hasText(testModel.getPhoneNumber())){
            errors.rejectValue("phoneNumber","","手机号不能为空");
        }
        if (!StringUtils.hasText(testModel.getAddress())){
            errors.rejectValue("address","","地址不能为空");
        }
    }
}
