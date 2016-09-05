package com.easycodebox.common.zookeeper;

/**
 * zookeeper序列化数据异常
 * @author WangXiaoJin
 * 
 */
public class ZkSerializeException extends Exception {

	private static final long serialVersionUID = -3383769643835708013L;

	public ZkSerializeException() {
		super();
	}

	public ZkSerializeException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ZkSerializeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ZkSerializeException(String message) {
		super(message);
	}

	public ZkSerializeException(Throwable cause) {
		super(cause);
	}

}
