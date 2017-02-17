package org.tarena.cloudnote.dao.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.tarena.cloudnote.dao.NoteDao;
import org.tarena.cloudnote.entity.Note;
import org.tarena.cloudnote.entity.NoteBean;
import org.tarena.cloudnote.util.SpringTest;

public class TestNoteDao extends SpringTest {
	@Test
	public void test1(){
		NoteDao dao = super.getContext().getBean("noteDao", NoteDao.class);
		List<Note> notes = dao.findByBookId("6d763ac9-dca3-42d7-a2a7-a08053095c08");
		for (Note note : notes) {
			System.out.println(note);
		}
	}
	
	@Test
	public void test2(){
		NoteDao dao = super.getContext().getBean("noteDao", NoteDao.class);
		Note note = dao.findById("046b0110-67f9-48c3-bef3-b0b23bda9d4e");
		System.out.println(note);
	}
	
	@Test
	public void test3(){
		NoteDao dao = super.getContext().getBean("noteDao", NoteDao.class);
		Note note = new Note();
		note.setCn_note_id("1");
		note.setCn_notebook_id("2");
		note.setCn_user_id("3");
		note.setCn_note_status_id("4");
		note.setCn_note_type_id("5");
		note.setCn_note_title("6");
		note.setCn_note_body("7");
		note.setCn_note_create_time(new Date().getTime());
		note.setCn_note_last_modify_time(new Date().getTime());
		dao.save(note);
		System.out.println("保存成功");
	}
	
	@Test
	public void test4(){
		NoteDao dao = super.getContext().getBean("noteDao", NoteDao.class);
		Note note = new Note();
		note.setCn_note_id("9bff2cfc-3c4b-4e69-9ba3-9109cd738a38");
		note.setCn_note_title("再次测试");
		note.setCn_note_body("52316561asdasfanioaklmcaivni");
		note.setCn_note_last_modify_time(new Date().getTime());
		dao.update(note);
		System.out.println("更新成功");
	}
	
	@Test
	public void test5(){
		NoteDao dao = super.getContext().getBean("noteDao", NoteDao.class);
		String noteId = "0dc41e74-1194-4055-8bd7-b5f5117f989f";
		dao.recycle(noteId);
		System.out.println("删除成功");
	}
	
	@Test
	public void test6(){
		NoteDao dao = super.getContext().getBean("noteDao", NoteDao.class);
		//设置查询参数
		NoteBean params = new NoteBean();
//		params.setCn_note_title("%的发%");
//		params.setCn_note_status_id("1");
		java.sql.Date beginTime = java.sql.Date.valueOf("2016-01-01");
		params.setBeginTime(beginTime.getTime());
		java.sql.Date endTime = java.sql.Date.valueOf("2016-03-01");
		params.setEndTime(endTime.getTime());
		List<Note> list = dao.findNotes(params);
		for (Note note : list) {
			System.out.println(note);
		}
		System.out.println("总数："+list.size());
	}
	
	@Test
	public void test7(){
		NoteDao dao = super.getContext().getBean("noteDao", NoteDao.class);
		String[] ids = {"003ec2a1-f975-4322-8e4d-dfd206d6ac0c","019cd9e1-b629-4d8d-afd7-2aa9e2d6afe0"};
		System.out.println(dao.batchDelete(ids));
	}
	
	@Test
	public void test8(){
		NoteDao dao = super.getContext().getBean("noteDao", NoteDao.class);
		Note note = new Note();
		note.setCn_note_id("01da5d69-89d5-4140-9585-b559a97f9cb0");
		note.setCn_note_body("已经55555555");
		System.out.println(dao.dynamicUpdate(note));
	}
}
