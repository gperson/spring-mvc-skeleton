package com.xpanxion.skeleton.controllers;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    private TestService testService;

    /**
     * The default controller action for the homepage.
     * 
     * @return the Model and View for the home page.
     */
    @RequestMapping("**/home")
    public ModelAndView getHomePage() {
        ModelAndView mAndV = new ModelAndView("home");
        mAndV.addObject("test", this.testService.getTestBeans());
        return mAndV;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelMap model) {
        ModelAndView mAndV = new ModelAndView("login");
        return mAndV;

    }

    // @RequestMapping(value = "/home", method = RequestMethod.GET)
    // public String printWelcome(ModelMap model, Principal principal) {
    //
    // String name = principal.getName();
    // model.addAttribute("username", name);
    // model.addAttribute("message", "Spring Security Custom Form example");
    // return "home";
    //
    // }
    //
    // @RequestMapping(value="/loginfailed", method = RequestMethod.GET)
    // public String loginerror(ModelMap model) {
    //
    // model.addAttribute("error", "true");
    // return "login";
    //
    // }
    //
    // @RequestMapping(value="/logout", method = RequestMethod.GET)
    // public String logout(ModelMap model) {
    //
    // return "login";
    //
    // }

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
