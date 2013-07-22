/*******************************************************************************
 * Project Key : CPPII
 * Create on 2013-7-17 上午10:19:50
 * Copyright (c) 2013 - 2014.版权所有
 * 代码由黄雄星独立完成。注意：如需使用项目代码需经本人同意方可使用。
 ******************************************************************************/
package cn.javasoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

/**
 * <P>TODO</P>
 * 
 * 黄雄星(13077862552,420484141@qq.com)
 */
public class BaseWithLogService implements ApplicationEventPublisherAware, ApplicationContextAware {

	protected transient final Logger log = LoggerFactory.getLogger(getClass());

	private ApplicationEventPublisher applicationEventPublisher;

	private ApplicationContext applicationContext;

	/**
	 * @see org.springframework.context.ApplicationEventPublisherAware#setApplicationEventPublisher(org.springframework.context.ApplicationEventPublisher)
	 */
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
	}

	public void publishEvent(ApplicationEvent event) {
		applicationEventPublisher.publishEvent(event);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
