package com.github.MineMybug.security.core.enums;

/**
 * Created by xuxueli on 17/5/10.
 */
public class RegistryConfig {

	/**
	 * 任务调度中心获取在线机器时间间隔
	 */
    public static final int BEAT_TIMEOUT = 30;
    /**
     * 在线机器（执行器） 90秒
     */
    public static final int DEAD_TIMEOUT = BEAT_TIMEOUT * 3;

    public enum RegistType{ EXECUTOR, ADMIN }

}
