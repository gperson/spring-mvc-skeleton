package com.xpanxion.skeleton.controllers;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.service.TestService;

/**
 * Controller for the Home Page.
 * 
 * @author brian
 * 
 */
@Controller
public class HomeController {

    private static final String USER_NAME = "username";
    private static final String HOME_PAGE = "home";
    private TestService testService;
    private Authentication authentication;

    /**
     * The default controller action for the home page.
     * 
     * @return the Model and View for the home page.
     */
    @RequestMapping("/home")
    public ModelAndView getHomePage() {
        ModelAndView mAndV = new ModelAndView(HOME_PAGE);
        mAndV.addObject("test", this.testService.getTestBeans());

        this.authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = this.authentication.getName();
        mAndV.addObject(USER_NAME, name);

        return mAndV;
    }

    /**
     * Sets the service for this controller
     * 
     * @param service
     *            the service to use in this controller.
     */
    @Resource
    public void setTestService(TestService service) {
        this.testService = service;
    }

}
