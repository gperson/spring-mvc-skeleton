package com.xpanxion.skeleton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.dto.beans.forms.SelectCarForm;
import com.xpanxion.skeleton.service.CarService;
import com.xpanxion.skeleton.service.LotService;

@Controller
public class DriveCarController {

    public static final String DRIVE_CAR_URL = "driveCar";
    public static final String DRIVE_CAR_PAGE = "common.driveCar";
    public static final String LOT = "lot";
    public static final String SELECT_CAR_FORM = "selectCarForm";
    public static final String MESSAGE = "message";
    public static final String MESSAGE_TYPE = "alertType";

    @Autowired
    public CarService carService;

    @Autowired
    private LotService lotService;

    @RequestMapping(value = "/" + DRIVE_CAR_URL, method = RequestMethod.POST)
    public ModelAndView driveCar(@ModelAttribute SelectCarForm selectCarForm) {
        ModelAndView mAndV = new ModelAndView(DRIVE_CAR_PAGE);
        boolean success = this.carService.driveCar(this.lotService.getLot().getCar(Integer.parseInt(selectCarForm.getCarId())));
        if (success) {
            mAndV.addObject(MESSAGE, "Car driven!");
            mAndV.addObject(MESSAGE_TYPE, "alert-success");
        } else {
            mAndV.addObject(MESSAGE, "Car did not have suffcient fuel to drive!!!");
            mAndV.addObject(MESSAGE_TYPE, "alert-danger alert-error");
        }
        mAndV.addObject(LOT, this.lotService.getLot().getCars());
        mAndV.addObject(SELECT_CAR_FORM, new SelectCarForm());
        return mAndV;
    }

    @RequestMapping(value = "/" + DRIVE_CAR_URL, method = RequestMethod.GET)
    public ModelAndView getDriveCarPage() {
        ModelAndView mAndV = new ModelAndView(DRIVE_CAR_PAGE);
        mAndV.addObject(LOT, this.lotService.getLot().getCars());
        mAndV.addObject(SELECT_CAR_FORM, new SelectCarForm());
        return mAndV;
    }
}
