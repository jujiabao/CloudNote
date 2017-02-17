package org.tarena.cloudnote.dao;

import java.util.List;

import org.tarena.cloudnote.entity.NoteBook;

public interface BookDao {
	public List<NoteBook> findByUserId(String userId);
	
	public void save(NoteBook book);
}
