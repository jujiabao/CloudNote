package org.tarena.cloudnote.dao.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.tarena.cloudnote.dao.BookDao;
import org.tarena.cloudnote.entity.NoteBook;
import org.tarena.cloudnote.util.SpringTest;

public class TestBookDao extends SpringTest {
	@Test
	public void test1(){
		BookDao dao = super.getContext().getBean("bookDao", BookDao.class);
		List<NoteBook> list = dao.findByUserId("48595f52-b22c-4485-9244-f4004255b972");
		for (NoteBook noteBook : list) {
			System.out.println(noteBook.getCn_notebook_name());
		}
	}
	
	@Test
	public void test2(){
		BookDao dao = super.getContext().getBean("bookDao", BookDao.class);
		NoteBook book = new NoteBook();
		book.setCn_notebook_id("1");
		book.setCn_user_id("2");
		book.setCn_notebook_type_id("3");
		book.setCn_notebook_name("4");
		book.setCn_notebook_desc("5");
		book.setCn_notebook_createtime(new Timestamp(new Date().getTime()));
		dao.save(book);
		System.out.println("插入成功");
	}
}
