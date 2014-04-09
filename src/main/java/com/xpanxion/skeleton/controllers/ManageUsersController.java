package com.xpanxion.skeleton.controllers;

import javax.annotation.Resource;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.dto.beans.UserBean;
import com.xpanxion.skeleton.service.UserService;

/**
 * Controller for the Login Page.
 * 
 * @author Grant
 * 
 */
@Controller
public class ManageUsersController {

    private static final String MANAGE_USERS_PAGE = "manage_users";
    private static final String USERNAME_FIELD = "user";
    private static final String PASSWORD_FIELD = "password";
    private static final String AUTHORITY_FIELD = "authority";
    private static final String ENABLED_FIELD = "enabled";
    private UserService userService;

    /**
     * The default controller action for the manage users page.
     * 
     * @return the Model and View for the login page.
     */
    @RequestMapping(value = "/manage_users", method = RequestMethod.GET)
    public ModelAndView login(ModelMap model) {
        ModelAndView mAndV = new ModelAndView(MANAGE_USERS_PAGE);
        UserBean user = this.userService.getUserBean(SecurityContextHolder.getContext().getAuthentication().getName());
        mAndV.addObject(USERNAME_FIELD, user.getUsername());
        mAndV.addObject(PASSWORD_FIELD, user.getPassword());
        mAndV.addObject(AUTHORITY_FIELD, user.getAuthority());
        mAndV.addObject(ENABLED_FIELD, user.isEnabled());
        return mAndV;
    }

    /**
     * Sets the service for this controller
     * 
     * @param service
     *            the service to use in this controller.
     */
    @Resource
    public void setTestService(UserService service) {
        this.userService = service;
    }
}
