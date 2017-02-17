package org.tarena.cloudnote.service;

import org.tarena.cloudnote.util.NoteResult;

public interface BookService {
	public NoteResult loadUserBooks(String userId);
	
	public NoteResult addBook(String userId, String bookName);
}
