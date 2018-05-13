package com.apap.siperpus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.apap.siperpus.model.UserAccountModel;
import com.apap.siperpus.service.UserAccountService;

import lombok.extern.slf4j.Slf4j;

/**
 * Created on : April 24, 2018
 * Author     : Kurniawan Hendi Wijaya
 * Name       : Hendi
 */
@Slf4j
@Controller
public class MainController {
	@Autowired
	UserAccountService userAccountDAO;
	
    @RequestMapping("/")
    public String index (Model model) {
    		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String username = authentication.getName();
			
			UserAccountModel user = userAccountDAO.selectUserAccountByUsername(username);
			
			model.addAttribute("role", user.getRole());
		} catch (Exception e) {
			log.error("MainController, index, error : " , e);
		}
    		
		
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
