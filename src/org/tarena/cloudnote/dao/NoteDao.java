package org.tarena.cloudnote.dao;

import java.util.List;

import org.tarena.cloudnote.entity.Note;
import org.tarena.cloudnote.entity.NoteBean;

public interface NoteDao {
	//组合查询
	public List<Note> findNotes(NoteBean note);
	
	public List<Note> findByBookId(String notebookId);
	
	public Note findById(String noteId);
	
	public void save(Note note);
	
	public void update(Note note);
	
	public void recycle(String noteId);
	
	public void move(Note note);
	
	public int batchDelete(String[] ids);
	
	public int dynamicUpdate(Note note);
}
