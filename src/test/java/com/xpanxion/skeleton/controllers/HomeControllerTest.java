/**
 * 
 */
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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.dto.beans.Car;
import com.xpanxion.skeleton.dto.beans.Lot;
import com.xpanxion.skeleton.dto.beans.Pinto;
import com.xpanxion.skeleton.service.LotService;

/**
 * @author brian
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

    @InjectMocks
    private HomeController testee;
    @Mock
    private Authentication authentication;
    @Mock
    private LotService lotService;

    /**
     * Test method for {@link com.xpanxion.skeleton.controllers.HomeController#getHomePage()}.
     */
    @Test
    public void testGetHomePage() {
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(this.authentication);
        Mockito.when(this.authentication.getName()).thenReturn("Grant");
        SecurityContextHolder.setContext(securityContext);

        List<Car> cars = new ArrayList<Car>();
        Lot lot = new Lot();
        cars.add(new Pinto());
        lot.setCars(cars);

        Mockito.when(this.lotService.getLot()).thenReturn(lot);

        ModelAndView mAndV = this.testee.getHomePage();
        Assert.assertEquals("common.home", mAndV.getViewName());
        Assert.assertEquals("Grant", mAndV.getModel().get(HomeController.USER_NAME));
        Assert.assertEquals(lot.getCars(), mAndV.getModel().get(HomeController.LOT));
    }
}
