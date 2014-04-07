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
public class ManageUsersController {

    private static final String MANAGE_USERS_PAGE = "manage_users";

    /**
     * The default controller action for the manage users page.
     * 
     * @return the Model and View for the login page.
     */
    @RequestMapping(value = "/manage_users", method = RequestMethod.GET)
    public ModelAndView login(ModelMap model) {
        ModelAndView mAndV = new ModelAndView(MANAGE_USERS_PAGE);
        return mAndV;
    }
}
