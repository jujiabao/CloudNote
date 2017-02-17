package org.tarena.cloudnote.service.test;

import org.junit.Assert;
import org.junit.Test;
import org.tarena.cloudnote.service.UserService;
import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.util.SpringTest;

public class TestRegist extends SpringTest {
	@Test
	public void test1(){
		UserService service = super.getContext().getBean("userServiceImpl", UserService.class);
		NoteResult result = service.regist("demo", "1234", "hello");
		Assert.assertEquals(1, result.getStatus());
	}
	@Test
	public void test2(){
		UserService service = super.getContext().getBean("userServiceImpl", UserService.class);
		NoteResult result = service.regist("tarena", "1234", "hello");
		Assert.assertEquals(0, result.getStatus());
	}
}
