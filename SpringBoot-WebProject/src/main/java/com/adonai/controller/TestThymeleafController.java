package com.adonai.controller;

import com.adonai.entity.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试Thymeleaf
 */
@Controller
@RequestMapping("/thymeleaf")
public class TestThymeleafController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @RequestMapping("/list2")
    public String skipToList2(Model model) throws Exception{
        model.addAttribute("hello","Hello,Thymeleaf!");
        model.addAttribute("userInfoList", userInfoRepository.getOne(19L));
        return "thymeleaf/list2";
    }

}
