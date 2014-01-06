package com.xpanxion.skeleton.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Logout Page.
 * 
 * @author Grant
 * 
 */
@Controller
public class LogoutController {

    /**
     * The default controller action for the logout page.
     * 
     * @return the Model and View for the logout page.
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(ModelMap model) {
        ModelAndView mAndV = new ModelAndView("logout");
        return mAndV;
    }

}
