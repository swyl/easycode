package com.easycodebox.common.zookeeper;

import java.net.SocketException;

import org.apache.commons.lang.StringUtils;

import com.easycodebox.common.lang.Symbol;
import com.easycodebox.common.log.slf4j.Logger;
import com.easycodebox.common.log.slf4j.LoggerFactory;
import com.easycodebox.common.net.InetAddresses;

/**
 * zookeeper的节点名制造器，用IP作为节点名。
 * @author WangXiaoJin
 * 
 */
public class ZkIpNodeNameMaker implements ZkNodeNameMaker {

	private static final Logger LOG = LoggerFactory.getLogger(ZkIpNodeNameMaker.class);
	
	/**
	 * 前缀节点名
	 */
	private String prefixNodeName;
	
	/**
	 * IP前缀符
	 */
	private String ipPrefix = StringUtils.EMPTY;
	/**
	 * IP后缀符
	 */
	private String ipPostfix = StringUtils.EMPTY;
	
	@Override
	public String make() {
		prefixNodeName = prefixNodeName == null ? StringUtils.EMPTY : prefixNodeName;
		prefixNodeName = prefixNodeName.endsWith(Symbol.SLASH) ? prefixNodeName : prefixNodeName + Symbol.SLASH;
		String name = null;
		try {
			String ip = InetAddresses.getLocalIp();
			name = prefixNodeName + ipPrefix + ip + ipPostfix;
		} catch (SocketException e) {
			LOG.error("Make zookeeper node name error.", e);
		}
		return name;
	}
	
	public String getPrefixNodeName() {
		return prefixNodeName;
	}

	public void setPrefixNodeName(String prefixNodeName) {
		this.prefixNodeName = prefixNodeName;
	}

	public String getIpPrefix() {
		return ipPrefix;
	}

	public void setIpPrefix(String ipPrefix) {
		this.ipPrefix = ipPrefix;
	}

	public String getIpPostfix() {
		return ipPostfix;
	}

	public void setIpPostfix(String ipPostfix) {
		this.ipPostfix = ipPostfix;
	}
	
}
