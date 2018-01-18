package com.luwojtaszek.springbootjsp.web.controller;

import com.luwojtaszek.springbootjsp.model.UserModel;
import com.luwojtaszek.springbootjsp.repository.UserRepository;
import com.luwojtaszek.springbootjsp.service.MerchantConnector;
import com.luwojtaszek.springbootjsp.web.UrlPaths;
import com.luwojtaszek.springbootjsp.web.constant.View;
import com.mercadolibre.sdk.AuthorizationFailure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lukasz on 27.08.2017.
 * With IntelliJ IDEA 15
 */
@Controller
public class HomeController {

    @Autowired
    private MerchantConnector merchantConnector;

    @Autowired
    private UserRepository userRepository;

    private String url="http://localhost:8080";

    @GetMapping(UrlPaths.HOME)
    public ModelAndView getHomePage(Model model) {
        model.addAttribute("message", "Spring Boot application that uses JSP With Embedded Tomcat");
        String url = this.merchantConnector.getMeli().getAuthUrl(this.url+UrlPaths.AUTH);
        return new ModelAndView("redirect:" + url);
    }

    @RequestMapping(UrlPaths.AUTH)
    public String auth(Model model, @RequestParam String code) {
        try {
            this.merchantConnector.getMeli().authorize(code,this.url+UrlPaths.AUTH);
            UserModel userModel=this.userRepository.me();
            return View.HOME;
        } catch (AuthorizationFailure authorizationFailure) {
            return View.ERROR;
        }
    }

}
