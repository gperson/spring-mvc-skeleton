/**
 * 
 */
package com.xpanxion.skeleton.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.dto.beans.Car;
import com.xpanxion.skeleton.dto.beans.Pinto;
import com.xpanxion.skeleton.dto.beans.enums.CarType;
import com.xpanxion.skeleton.dto.beans.forms.CarForm;
import com.xpanxion.skeleton.service.CarService;
import com.xpanxion.skeleton.service.LotService;

/**
 * @author Grant
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class AddCarControllerTest {

    @InjectMocks
    private AddCarController testee;
    @Mock
    private LotService lotService;
    @Mock
    private CarService carService;

    /**
     * Test method for {@link com.xpanxion.skeleton.controllers.AddCarController#getNewCarPage()}.
     */
    @Test
    public void testGetNewCarPage() {
        CarForm carForm = new CarForm();
        ModelAndView mAndV = this.testee.getNewCarPage();
        Assert.assertEquals(carForm.getOptions(), mAndV.getModel().get(AddCarController.OPTIONS));
        Assert.assertNotNull(mAndV.getModel().get(AddCarController.CAR_FORM));
        Assert.assertEquals("Add Car", mAndV.getModel().get(AddCarController.PAGE_TITLE));
        Assert.assertEquals("common.addCar", mAndV.getViewName());
    }

    @Test
    public void testPostNewCarFullPage() {
        CarForm carForm = new CarForm();
        carForm.setCarType("pinto");
        carForm.setFuelLevel(5);
        carForm.setHybrid(true);
        carForm.setPrice(20000);
        carForm.setOnSale(false);

        Car car = new Pinto(carForm.getHybrid(), carForm.getOnSale());
        car.setCarId(1);
        CarType type = carForm.getCarTypeEnum();
        Mockito.when(this.carService.addCar(this.lotService.getLot(), type, carForm.getFuelLevel(), carForm.getHybrid(), carForm.getOnSale())).thenReturn(null);

        ModelAndView mAndV = this.testee.postNewCarPage(carForm);

        Mockito.verify(this.carService).addCar(this.lotService.getLot(), type, carForm.getFuelLevel(), carForm.getHybrid(), carForm.getOnSale());
        Assert.assertEquals(CarType.PINTO, carForm.getCarTypeEnum());
        Assert.assertEquals("Add Car", mAndV.getModel().get(AddCarController.PAGE_TITLE));
        Assert.assertEquals("common.addCar", mAndV.getViewName());
        Assert.assertEquals("Car not added!", mAndV.getModel().get(AddCarController.MESSAGE));
        Assert.assertEquals("alert-danger alert-error", mAndV.getModel().get(AddCarController.MESSAGE_TYPE));

    }

    @Test
    public void testPostNewCarSucessPage() {
        CarForm carForm = new CarForm();
        carForm.setCarType("pinto");
        carForm.setFuelLevel(5);
        carForm.setHybrid(true);
        carForm.setPrice(20000);
        carForm.setOnSale(false);

        Car car = new Pinto(carForm.getHybrid(), carForm.getOnSale());
        car.setCarId(1);
        CarType type = carForm.getCarTypeEnum();
        Mockito.when(this.carService.addCar(this.lotService.getLot(), type, carForm.getFuelLevel(), carForm.getHybrid(), carForm.getOnSale())).thenReturn(car);

        ModelAndView mAndV = this.testee.postNewCarPage(carForm);
        Assert.assertEquals(CarType.PINTO, carForm.getCarTypeEnum());
        Assert.assertEquals("Add Car", mAndV.getModel().get(AddCarController.PAGE_TITLE));
        Assert.assertEquals("common.addCar", mAndV.getViewName());
        Assert.assertEquals("Car added! - New car Id: 1", mAndV.getModel().get(AddCarController.MESSAGE));
        Assert.assertEquals("alert-success", mAndV.getModel().get(AddCarController.MESSAGE_TYPE));
    }
}
