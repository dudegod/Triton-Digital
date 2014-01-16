package com.tritondigital;

import org.joda.time.DateTime;
import org.joda.time.MutableDateTime;

/**
 * This class is idempotent with the class submitted in the test
 * 
 * Also, the response given in the test is incorrect since it does change the method signature of 
 * isWoolTooOldToSell --- the parameter is changed from DateTime to Date
 * 
 * class LamaWoolService {
 *     public boolean isWoolTooOldToSell(DateTime shearDate) {
 *         MutableDateTime now = new MutableDateTime();
 *         // Joda mutable DateTime instance initialized
 *         // to the current system date/time
 *         now.addDays(-10);
 *         return now.isBefore(shearDate); 
 *     }
 * }
 * class LamaWoolServiceTest {
 *     @Test
 *     public void checkShearDate_AllOk() throws Exception { 
 *         assertTrue(service.isWoolTooOldToSell(new DateTime(2013, 01, 15)));
 *     }
 * }
 *
 * <p>
 * The information contained herein is the property of Myriad Group and is strictly proprietary and 
 * confidential. Except as expressly authorized in writing by Myriad Group, you do not have the right 
 * to use the information contained herein and you shall not disclose it to any third party.</p>
 *
 *
 * @author sebastien.laporte
 * @since Jan 15, 2014
 */
public class LamaWoolService
{
    private MutableDateTime now;
    
    public boolean isWoolTooOldToSell(DateTime shearDate) 
    {
        // Joda mutable DateTime instance initialized to the current system date/time
        now = getMutableDateTime();
        now.addDays(-10);
        return now.isBefore(shearDate);
    }  
    
    /**
     * Gets a new mutable date time
     * @return a current mutable date time
     */
    private MutableDateTime getMutableDateTime()
    {
        return new MutableDateTime();
    }
}
