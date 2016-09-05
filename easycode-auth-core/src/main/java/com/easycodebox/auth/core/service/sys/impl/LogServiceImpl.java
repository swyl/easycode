package com.easycodebox.auth.core.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easycodebox.auth.core.enums.ModuleType;
import com.easycodebox.auth.core.idconverter.UserIdConverter;
import com.easycodebox.auth.core.pojo.sys.Log;
import com.easycodebox.auth.core.service.sys.LogService;
import com.easycodebox.auth.core.util.R;
import com.easycodebox.common.enums.entity.LogLevel;
import com.easycodebox.common.jdbc.support.AbstractService;
import com.easycodebox.common.lang.StringUtils;
import com.easycodebox.common.lang.dto.DataPage;

/**
 * @author WangXiaoJin
 *
 */
@Service("logService")
public class LogServiceImpl extends AbstractService<Log> implements LogService {

	@Resource
	private UserIdConverter userIdConverter;
	
	@Override
	public List<Log> list(String url, String params, ModuleType moduleType, 
			LogLevel logLevel, String result, String clientIp) {
		return super.list(sql()
				.like(R.Log.url, url)
				.like(R.Log.params, params)
				.eq(R.Log.moduleType, moduleType)
				.eq(R.Log.logLevel, logLevel)
				.like(R.Log.result, result)
				.like(R.Log.clientIp, clientIp)
				.desc(R.Log.createTime)
				);
	}

	@Override
	public Log load(Long id) {
		Log data = super.get(id);
		if (data != null) {
			data.setCreatorName(userIdConverter.id2RealOrNickname(data.getCreator()));
		}
		return data;
	}

	@Override
	@Transactional
	public Log add(Log log) {
		if(StringUtils.isBlank(log.getTitle()))
			log.setTitle(null);
		super.save(log);
		return log;
	}
	
	@Override
	public int update(Log log) {
		return super.update(log);
	}

	@Override
	public int removePhy(Long[] ids) {
		return super.delete(ids);
	}

	@Override
	public DataPage<Log> page(String title, String url, String params, ModuleType moduleType, 
			LogLevel logLevel, String result, String clientIp, int pageNo, int pageSize) {
		return super.page(sql()
				.like(R.Log.title, title)
				.like(R.Log.url, url)
				.like(R.Log.params, params)
				.eq(R.Log.moduleType, moduleType)
				.eq(R.Log.logLevel, logLevel)
				.like(R.Log.result, result)
				.like(R.Log.clientIp, clientIp)
				.desc(R.Log.createTime)
				.limit(pageNo, pageSize)
				);
	}
	
}
