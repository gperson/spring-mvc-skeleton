package com.xpanxion.skeleton.controllers;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.dto.beans.Car;
import com.xpanxion.skeleton.dto.beans.Lot;
import com.xpanxion.skeleton.dto.beans.Pinto;
import com.xpanxion.skeleton.dto.beans.forms.CarForm;
import com.xpanxion.skeleton.service.CarService;
import com.xpanxion.skeleton.service.LotService;

@RunWith(MockitoJUnitRunner.class)
public class EditCarControllerTest {

    @InjectMocks
    private EditCarController testee;
    @Mock
    private LotService lotService;
    @Mock
    private CarService carService;

    @Test
    public void testGetEditCarPage() {
        String id = "1";
        List<Car> cars = new ArrayList<Car>();
        Lot lot = new Lot();
        lot.setId(Integer.parseInt(id));
        Car car = new Pinto();
        car.setCarId(Integer.parseInt(id));
        cars.add(car);
        lot.setCars(cars);
        Mockito.when(this.lotService.getLot()).thenReturn(lot);

        ModelAndView mAndV = this.testee.getViewCarPage(id);

        Mockito.verify(this.lotService).getLot();
        Assert.assertEquals("Editing Car, " + id, mAndV.getModel().get(AddCarController.PAGE_TITLE));
        Assert.assertNotNull(mAndV.getModel().get(AddCarController.OPTIONS));
        Assert.assertNotNull(mAndV.getModel().get(AddCarController.CAR_FORM));
    }

    @Test
    public void testPostEditCarPage() {
        String id = "1";
        CarForm carForm = new CarForm();
        carForm.setCarId(id);
        carForm.setFuelLevel(10);
        carForm.setOnSale(false);
        Car car = new Pinto();
        car.setCarId(Integer.parseInt(id));
        Mockito.when(this.carService.updateCar(this.lotService.getLot(), carForm.getCarId(), carForm.getFuelLevel(), carForm.getOnSale())).thenReturn(car);

        ModelAndView mAndV = this.testee.postEditCarPage(carForm, id);

        Mockito.verify(this.carService).updateCar(this.lotService.getLot(), carForm.getCarId(), carForm.getFuelLevel(), carForm.getOnSale());
        Assert.assertEquals("Car updated!", mAndV.getModel().get(AddCarController.MESSAGE));
        Assert.assertEquals("alert-success", mAndV.getModel().get(AddCarController.MESSAGE_TYPE));
        Assert.assertEquals("Editing Car, " + id, mAndV.getModel().get(AddCarController.PAGE_TITLE));
        Assert.assertNotNull(mAndV.getModel().get(AddCarController.OPTIONS));
    }

    @Test
    public void testPostEditCarPageNull() {
        String id = "1";
        CarForm carForm = new CarForm();
        carForm.setCarId(id);
        carForm.setFuelLevel(10);
        carForm.setOnSale(false);
        Mockito.when(this.carService.updateCar(this.lotService.getLot(), carForm.getCarId(), carForm.getFuelLevel(), carForm.getOnSale())).thenReturn(null);

        ModelAndView mAndV = this.testee.postEditCarPage(carForm, id);

        Mockito.verify(this.carService).updateCar(this.lotService.getLot(), carForm.getCarId(), carForm.getFuelLevel(), carForm.getOnSale());
        Assert.assertEquals("Car not updated!", mAndV.getModel().get(AddCarController.MESSAGE));
        Assert.assertEquals("alert-danger alert-error", mAndV.getModel().get(AddCarController.MESSAGE_TYPE));
        Assert.assertEquals("Editing Car", mAndV.getModel().get(AddCarController.PAGE_TITLE));
        Assert.assertNotNull(mAndV.getModel().get(AddCarController.OPTIONS));
    }
}
