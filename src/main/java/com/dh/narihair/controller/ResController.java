package com.dh.narihair.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/res")
public class ResController {

    @RequestMapping
    public String resMain(ModelMap model){
        return "content/res/index";
    }
}
