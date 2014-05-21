package com.xpanxion.skeleton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.dto.beans.Car;
import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.beans.forms.CarForm;
import com.xpanxion.skeleton.service.CarService;
import com.xpanxion.skeleton.service.LotService;

@Controller
public class AddCarController {

    public static final String NEW_CAR_PAGE = "common.addCar";
    public static final String NEW_CAR_URL = "addCar";
    public static final String MESSAGE = "message";
    public static final String MESSAGE_TYPE = "alertType";
    public static final String CAR_FORM = "carForm";
    public static final String OPTIONS = "optionsMap";
    public static final String PAGE_TITLE = "title";

    @Autowired
    public CarService carService;

    @Autowired
    private LotService lotService;

    @RequestMapping(value = "/" + NEW_CAR_URL, method = RequestMethod.GET)
    public ModelAndView getNewCarPage() {
        ModelAndView mAndV = new ModelAndView(NEW_CAR_PAGE);
        CarForm cf = new CarForm();
        mAndV.addObject(OPTIONS, cf.getOptions());
        mAndV.addObject(CAR_FORM, cf);
        mAndV.addObject(PAGE_TITLE, "Add Car");
        return mAndV;
    }

    @RequestMapping(value = "/" + NEW_CAR_URL, method = RequestMethod.POST)
    public ModelAndView postNewCarPage(@ModelAttribute CarForm carForm) {
        ModelAndView mAndV = new ModelAndView(NEW_CAR_PAGE);
        CarType type = carForm.getCarTypeEnum();
        Car car = this.carService.addCar(this.lotService.getLot(), type, carForm.getFuelLevel(), carForm.getHybrid(), carForm.getOnSale());
        if (car != null) {
            mAndV.addObject(MESSAGE, "Car added! - New car Id: " + car.getCarId());
            mAndV.addObject(MESSAGE_TYPE, "alert-success");
        } else {
            mAndV.addObject(MESSAGE, "Car not added!");
            mAndV.addObject(MESSAGE_TYPE, "alert-danger alert-error");
        }
        mAndV.addObject(OPTIONS, carForm.getOptions());
        mAndV.addObject(PAGE_TITLE, "Add Car");
        return mAndV;
    }
}
