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
import com.xpanxion.skeleton.dto.beans.forms.SelectCarForm;
import com.xpanxion.skeleton.service.CarService;
import com.xpanxion.skeleton.service.LotService;

@RunWith(MockitoJUnitRunner.class)
public class DriveCarControllerTest {

    @InjectMocks
    private DriveCarController testee;
    @Mock
    private LotService lotService;
    @Mock
    private CarService carService;

    @Test
    public void testGetDriveCarPage() {
        List<Car> cars = new ArrayList<Car>();
        Lot lot = new Lot();
        cars.add(new Pinto());
        lot.setCars(cars);
        Mockito.when(this.lotService.getLot()).thenReturn(lot);

        ModelAndView mAndV = this.testee.getDriveCarPage();

        Assert.assertEquals(lot.getCars(), mAndV.getModel().get(DriveCarController.LOT));
        Assert.assertNotNull(mAndV.getModel().get(DriveCarController.SELECT_CAR_FORM));
    }

    @Test
    public void testPostDriveCarPageFail() {
        List<Car> cars = new ArrayList<Car>();
        SelectCarForm selectCarForm = new SelectCarForm();
        selectCarForm.setCarId("1");
        Lot lot = new Lot();
        Car car = new Pinto();
        car.setCarId(1);
        cars.add(car);
        lot.setCars(cars);
        Mockito.when(this.lotService.getLot()).thenReturn(lot);
        Mockito.when(this.carService.driveCar(this.lotService.getLot().getCar(Integer.parseInt(selectCarForm.getCarId())))).thenReturn(false);

        ModelAndView mAndV = this.testee.driveCar(selectCarForm);

        Mockito.verify(this.carService).driveCar(this.lotService.getLot().getCar(Integer.parseInt(selectCarForm.getCarId())));
        Assert.assertEquals("Car did not have suffcient fuel to drive!!!", mAndV.getModel().get(DriveCarController.MESSAGE));
        Assert.assertEquals("alert-danger alert-error", mAndV.getModel().get(DriveCarController.MESSAGE_TYPE));
        Assert.assertEquals(lot.getCars(), mAndV.getModel().get(DriveCarController.LOT));
        Assert.assertNotNull(mAndV.getModel().get(DriveCarController.SELECT_CAR_FORM));
    }

    @Test
    public void testPostDriveCarPageSucess() {
        List<Car> cars = new ArrayList<Car>();
        SelectCarForm selectCarForm = new SelectCarForm();
        selectCarForm.setCarId("1");
        Lot lot = new Lot();
        Car car = new Pinto();
        car.setCarId(1);
        cars.add(car);
        lot.setCars(cars);
        Mockito.when(this.lotService.getLot()).thenReturn(lot);
        Mockito.when(this.carService.driveCar(this.lotService.getLot().getCar(Integer.parseInt(selectCarForm.getCarId())))).thenReturn(true);

        ModelAndView mAndV = this.testee.driveCar(selectCarForm);

        Assert.assertEquals("Car driven!", mAndV.getModel().get(DriveCarController.MESSAGE));
        Assert.assertEquals("alert-success", mAndV.getModel().get(DriveCarController.MESSAGE_TYPE));
        Assert.assertEquals(lot.getCars(), mAndV.getModel().get(DriveCarController.LOT));
        Assert.assertNotNull(mAndV.getModel().get(DriveCarController.SELECT_CAR_FORM));
    }
}
