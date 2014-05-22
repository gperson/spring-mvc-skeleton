/**
 * 
 */
package com.xpanxion.skeleton.dao;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.xpanxion.skeleton.dao.impl.TestDaoImpl;

/**
 * @author brian
 * 
 */
@RunWith(MockitoJUnitRunner.class)
public class CarDaoImplTest {

    @InjectMocks
    private TestDaoImpl testee;

    @Mock
    private SessionFactory factory;

    /**
     * Test method for {@link com.xpanxion.skeleton.dao.CarDaoImpl#getAllItems()}.
     */
    @Test
    public void testGetAllItems() {

    }

}
