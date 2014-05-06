package com.xpanxion.skeleton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.service.CarService;

@Controller
public class NewCarController {

    public static final String NEW_CAR_PAGE = "newCar";

    @Autowired
    public CarService carService;

    @RequestMapping(value = "/" + NEW_CAR_PAGE, method = RequestMethod.GET)
    public ModelAndView getNewCarPage() {
        ModelAndView mAndV = new ModelAndView(NEW_CAR_PAGE);
        // this.carService.addOrSaveCar(null, null, true);
        return mAndV;
    }
}
