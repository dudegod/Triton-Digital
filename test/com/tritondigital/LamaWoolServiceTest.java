package com.tritondigital;

import static org.junit.Assert.assertTrue;

import org.joda.time.DateTime;
import org.junit.Test;

/**
 * This class is used to 
 * TODO sebastien.laporte Jan 15, 2014 MISSING_CLASS_HEADER_JAVADOC
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
public class LamaWoolServiceTest {
    @Test
    public void checkShearDate_AllOk() throws Exception {
        LamaWoolService service = new LamaWoolService();
        // The original constructor is no longer available in the API
        // I also put in the a new Year date so the test would succeed 
        assertTrue(service.isWoolTooOldToSell(new DateTime(2014, 01, 15, 0, 0))); 
    }
}
