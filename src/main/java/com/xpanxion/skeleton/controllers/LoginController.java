package com.xpanxion.skeleton.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Login Page.
 * 
 * @author Grant
 * 
 */
@Controller
public class LoginController {

    /**
     * The default controller action for the login page.
     * 
     * @return the Model and View for the login page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelMap model) {
        ModelAndView mAndV = new ModelAndView("login");
        return mAndV;
    }
}
