package com.xpanxion.skeleton.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.dto.beans.Car;
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
    private static final String HOME_PAGE = "common.home";
    private static final String HOME_URL = "home";
    private static final String LOT = "lot";

    @Autowired
    private LotService lotService;

    private Authentication authentication;

    /**
     * The default controller action for the home page.
     * 
     * @return the Model and View for the home page.
     */
    @RequestMapping(value = "/" + HOME_URL, method = RequestMethod.GET)
    public ModelAndView getHomePage() {
        ModelAndView mAndV = new ModelAndView(HOME_PAGE);
        this.authentication = SecurityContextHolder.getContext().getAuthentication();
        mAndV.addObject(USER_NAME, this.authentication.getName());
        List<Car> cars = this.lotService.getLot().getCars();
        mAndV.addObject(LOT, cars);
        return mAndV;
    }
}
