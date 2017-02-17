package org.tarena.cloudnote.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
	public ApplicationContext getContext() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		return ac;
	}
}
