package com.demo.giftmoney.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(value = "/testTool", method = RequestMethod.GET)
    public String testTool(Map<String, Object> model, HttpServletRequest request){
        model.put("request", request);
        return "testTool";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String resourceNotFound(){
        return "404";
    }

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public String serverException(){
        return "500";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/wechat/auth", method = RequestMethod.GET)
    public String auth(@RequestParam("code") String code, @RequestParam(name="state",required = false) String state, ModelMap modelMap){
        modelMap.put("code",code);
        return "login2";
    }
}
