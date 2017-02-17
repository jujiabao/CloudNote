package org.tarena.cloudnote.service.test;

import java.util.List;

import org.junit.Test;
import org.tarena.cloudnote.entity.Note;
import org.tarena.cloudnote.service.NoteService;
import org.tarena.cloudnote.service.NoteServiceImpl;
import org.tarena.cloudnote.service.RecycleService;
import org.tarena.cloudnote.service.RecycleServiceImpl;
import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.util.SpringTest;

public class TestNoteService extends SpringTest {
	@Test
	public void test1(){
		NoteService noteService = super.getContext().getBean("noteServiceImpl", NoteServiceImpl.class);
		NoteResult results = noteService.loadBookNotes("6d763ac9-dca3-42d7-a2a7-a08053095c08");
		List<Note> notes = (List<Note>) results.getData();
		for (Note note : notes) {
			System.out.println(note.getCn_note_title());
		}
	}
	
	@Test
	public void test2(){
		NoteService noteService = super.getContext().getBean("noteServiceImpl", NoteServiceImpl.class);
		NoteResult result = noteService.loadNoteDetail("046b0110-67f9-48c3-bef3-b0b23bda9d4e");
		Note note = (Note) result.getData();
		System.out.println(note);
	}
	
	@Test
	public void test3(){
		NoteService noteService = super.getContext().getBean("noteServiceImpl", NoteServiceImpl.class);
		noteService.addNote("78", "79", "80");
		System.out.println("插入成功");
	}
	
	@Test
	public void test4(){
		NoteService noteService = super.getContext().getBean("noteServiceImpl", NoteServiceImpl.class);
		noteService.updateNote("796f8de3-24bb-4952-b719-4cc7b29884ea", "你曾是我的全部", "啊，多么痛的领悟，你曾是我的全部。");
		System.out.println("更新完毕");
	}
	
	@Test
	public void test5(){
		RecycleService recycleService = super.getContext().getBean("recycleServiceImpl", RecycleServiceImpl.class);
		recycleService.recycleNote("ac255b26-4a52-4535-9da4-2d877264dfd5");
		System.out.println("更新完毕");
	}
	
	@Test
	public void test6(){
		NoteService noteService = super.getContext().getBean("noteServiceImpl", NoteServiceImpl.class);
		NoteResult result = noteService.shareNote("4");
		System.out.println(result);
	}
	
	@Test
	public void test7(){
		NoteService noteService = super.getContext().getBean("noteServiceImpl", NoteServiceImpl.class);
		NoteResult result = noteService.shareNote("ac255b26-4a52-4535-9da4-2d877264dfd5");
		System.out.println(result);
	}
	
	@Test
	public void test8(){
		NoteService noteService = super.getContext().getBean("noteServiceImpl", NoteServiceImpl.class);
		NoteResult result = noteService.shareNote("4");
		System.out.println(result);
	}
	
	@Test
	public void test9(){
		NoteService noteService = super.getContext().getBean("noteServiceImpl", NoteServiceImpl.class);
		NoteResult result = noteService.searchShare("安笔");
		System.out.println(result);
	}
}
