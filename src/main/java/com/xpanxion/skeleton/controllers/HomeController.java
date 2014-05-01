package com.xpanxion.skeleton.controllers;

import javax.annotation.Resource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.service.LotService;

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
    private static final String LOT = "lot";

    private LotService lotService;
    // private CarService carService;

    private Authentication authentication;

    /**
     * The default controller action for the home page.
     * 
     * @return the Model and View for the home page.
     */
    @RequestMapping(value = "/" + HOME_PAGE, method = RequestMethod.GET)
    public ModelAndView getHomePage() {
        ModelAndView mAndV = new ModelAndView(HOME_PAGE);
        this.authentication = SecurityContextHolder.getContext().getAuthentication();
        mAndV.addObject(USER_NAME, this.authentication.getName());
        mAndV.addObject(LOT, this.lotService.getLot());
        return mAndV;
    }

    @RequestMapping(value = "/" + HOME_PAGE, method = RequestMethod.POST)
    public ModelAndView postHomePage() {
        ModelAndView mAndV = new ModelAndView(HOME_PAGE);
        // TODO this.carService.addOrSaveCar(lot, car, isHybrid);
        return mAndV;
    }

    // @Resource
    // public void setCarService(CarService service) {
    // this.carService = service;
    // }

    @Resource
    public void setLotService(LotService service) {
        this.lotService = service;
    }
}
