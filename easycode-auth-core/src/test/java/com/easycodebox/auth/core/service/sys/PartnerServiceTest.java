package com.easycodebox.auth.core.service.sys;

import org.junit.Test;

import com.easycodebox.auth.core.service.sys.PartnerService;
import com.easycodebox.auth.core.util.test.BaseTest;

public class PartnerServiceTest extends BaseTest<PartnerService> {
	
	@Test
    public void testRmove() {
    	try {
    		LOG.info(bean.remove(new String[] {"1"}));
		} catch (Exception e) {
			LOG.error("run error!!!", e);
		}
    }
    
}
