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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import com.xpanxion.skeleton.service.TestService;

/**
 * @author brian
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {

    @InjectMocks
    private HomeController testee;
    @Mock
    private TestService testService;
    @Mock
    private Authentication authentication;

    /**
     * Test method for {@link com.xpanxion.skeleton.controllers.HomeController#getHomePage()}.
     */
    @Test
    public void testGetHomePage() {
        SecurityContext securityContext = Mockito.mock(SecurityContext.class);
        Mockito.when(securityContext.getAuthentication()).thenReturn(this.authentication);
        Mockito.when(this.authentication.getName()).thenReturn("Grant");
        SecurityContextHolder.setContext(securityContext);

        ModelAndView mAndV = this.testee.getHomePage();
        Assert.assertEquals("home", mAndV.getViewName());
    }

}
