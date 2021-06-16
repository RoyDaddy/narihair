package com.dh.narihair.controller;

import com.dh.narihair.domain.UserDTO;
import com.dh.narihair.entity.User;
import com.dh.narihair.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    final private UserRepo userRepo;

    @RequestMapping
    public String userMain(ModelMap model, UserDTO param, Pageable page){
        Page<UserDTO> list = userRepo.getUserList(param, page);
        model.addAttribute("list",list);
        return "/content/users/index";
    }
}
