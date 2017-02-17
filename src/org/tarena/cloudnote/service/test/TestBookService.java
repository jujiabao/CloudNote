package org.tarena.cloudnote.service.test;

import java.util.List;

import org.junit.Test;
import org.tarena.cloudnote.entity.NoteBook;
import org.tarena.cloudnote.service.BookService;
import org.tarena.cloudnote.service.BookServiceImpl;
import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.util.SpringTest;

public class TestBookService extends SpringTest {
	@Test
	public void test1(){
		BookService service = super.getContext().getBean("bookServiceImpl", BookServiceImpl.class);
		NoteResult result = service.loadUserBooks("48595f52-b22c-4485-9244-f4004255b972");
		List<NoteBook> books = (List)result.getData();
		for (NoteBook noteBook : books) {
			System.out.println(noteBook);
		}
	}
}
