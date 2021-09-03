package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    @Autowired
    private TestModelValidator testModelValidator;

    private static final List<ObjectError> EMPTY_ERRORS = new ArrayList<>();

    @RequestMapping("")
    @ResponseBody
    public List<ObjectError> home(@ModelAttribute("testModel") TestModel testModel,BindingResult bindingResult){
        testModelValidator.validate(testModel,bindingResult);
        if (bindingResult.hasErrors()){
            return bindingResult.getAllErrors();
        }
        return EMPTY_ERRORS;
    }
}
