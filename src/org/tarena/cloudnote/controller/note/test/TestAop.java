package org.tarena.cloudnote.controller.note.test;

import org.junit.Test;
import org.tarena.cloudnote.util.SpringTest;

public class TestAop extends SpringTest {
	@Test
	public void test1(){
		Object object = super.getContext().getBean("addNoteController");
		System.out.println(object.getClass().getName());
	}
}
