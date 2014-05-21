package com.xpanxion.skeleton.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.dto.beans.Car;
import com.xpanxion.skeleton.dto.beans.forms.CarForm;
import com.xpanxion.skeleton.service.CarService;
import com.xpanxion.skeleton.service.LotService;

/**
 * Controller for the Edit car Page.
 * 
 * @author Grant
 * 
 */
@Controller
public class EditCarController {

    public static final String VIEW_CAR_PAGE = "common.viewCar";
    public static final String VIEW_CAR_URL = "viewCar";
    public static final String PARAMETER_CAR_ID = "car";

    @Autowired
    public CarService carService;

    @Autowired
    private LotService lotService;

    @RequestMapping(value = "/" + VIEW_CAR_URL, method = RequestMethod.GET)
    public ModelAndView getViewCarPage(@RequestParam(value = PARAMETER_CAR_ID, required = true) String id) {
        ModelAndView mAndV = new ModelAndView(VIEW_CAR_PAGE);
        CarForm cf = new CarForm(this.lotService.getLot().getCar(Integer.parseInt(id)));
        mAndV.addObject(AddCarController.OPTIONS, cf.getOptions());
        mAndV.addObject(AddCarController.CAR_FORM, cf);
        mAndV.addObject(AddCarController.PAGE_TITLE, "Editing Car, " + id);
        return mAndV;
    }

    @RequestMapping(value = "/" + VIEW_CAR_URL, method = RequestMethod.POST)
    public ModelAndView postNewCarPage(@ModelAttribute CarForm carForm, @RequestParam(value = PARAMETER_CAR_ID, required = true) String id) {
        ModelAndView mAndV = new ModelAndView(VIEW_CAR_PAGE);
        carForm.setCarId(id);
        Car car = this.carService.updateCar(this.lotService.getLot(), carForm.getCarId(), carForm.getFuelLevel(), carForm.getOnSale());
        if (car != null) {
            mAndV.addObject(AddCarController.MESSAGE, "Car updated!");
            mAndV.addObject(AddCarController.MESSAGE_TYPE, "alert-success");
        } else {
            mAndV.addObject(AddCarController.MESSAGE, "Car not updated!");
            mAndV.addObject(AddCarController.MESSAGE_TYPE, "alert-danger alert-error");
        }
        mAndV.addObject(AddCarController.OPTIONS, carForm.getOptions());
        mAndV.addObject(AddCarController.PAGE_TITLE, "Editing Car, " + car.getCarId());
        return mAndV;
    }
}
