package com.easycodebox.common.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.easycodebox.common.Init;
import com.easycodebox.common.error.CodeMsg;
import com.easycodebox.common.lang.DataConvert;
import com.easycodebox.common.log.slf4j.Logger;
import com.easycodebox.common.log.slf4j.LoggerFactory;

/**
 * @author WangXiaoJin
 *
 */
public abstract class ApiAdapter implements Api, Init {
	
	protected Logger LOG = LoggerFactory.getLogger(getClass());
	
	public ApiAdapter() {
		this.init();
	}

	
	@Override
	public void init() {
		
	}


	@Override
	public CodeMsg send(Map<String, Object> params) throws Exception {
		
		return CodeMsg.SUC_MSG;
	}

	/**
	 * 处理API接口的逻辑
	 * @return
	 */
	@Override
	public CodeMsg receive(Map<String, Object> params, HttpServletRequest request) throws Exception {
		
		return CodeMsg.SUC_MSG;
	}
	
	@SuppressWarnings("unchecked")
	protected <T> T get(Map<String, Object> params, String key, Class<T> clazz) {
		if(params == null) return null;
		Object obj = params.get(key);
		if(obj == null)
			return null;
		else if(clazz.isAssignableFrom(obj.getClass())) {
			return (T)obj;
		}else {
			return DataConvert.convertType(obj.toString(), clazz);
		}
	}
	
}
