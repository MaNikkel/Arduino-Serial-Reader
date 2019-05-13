/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

import junit.framework.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Mathias
 */
public class ReadingDataTest {
    
    private ReadingData rd = new ReadingData();
    
    
    public ReadingDataTest() {
    }

    /**
     * Test of getData_ method, of class ReadingData.
     */
    @Test
    public void testGetData_() {
        assertEquals("dado", rd.getData_());
    }

    /**
     * Test of setData_ method, of class ReadingData.
     */
    @Before
    @Test
    public void testSetData_() {
        rd.setData_("dado");
    }
    
}
