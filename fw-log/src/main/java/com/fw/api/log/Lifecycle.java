package com.fw.api.log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * 
 * 放入Spring容器中的bean如果需要生命周期回调，则需要实现该接口
 *
 * @author:lw
 *
 */
public interface Lifecycle {

	/**
	 * 
	 * 用{@link PostConstruct @PostConstruct}批注修饰则不用在XML文件中配置
	 */
	public void initializing();

	/**
	 * 
	 * 用{@link PreDestroy @PreDestroy}批注修饰则不用在XML文件中配置
	 *
	 */
	public void cleanup();

}
