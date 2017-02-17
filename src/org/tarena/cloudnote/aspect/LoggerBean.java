package org.tarena.cloudnote.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//打桩切面
@Component//扫描进spring容器，相当于<bean id="loggerBean" class="org.tarena.cloudnote.aspect.LoggerBean"></bean>
@Aspect//定义为切面组件等价于<aop:aspect>
public class LoggerBean {
	@Before("within(org.tarena.cloudnote.controller..*)")
	public void logController(){
		System.out.println("------>请求进入Controller<------");
	}
}
