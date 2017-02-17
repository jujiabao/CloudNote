package org.tarena.cloudnote.service;

import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.vo.SearchNoteParams;

public interface NoteService {
	public NoteResult loadBookNotes(String notebookId);

	public NoteResult loadNoteDetail(String id);

	public NoteResult addNote(String userId, String bookId, String noteTitle);

	public NoteResult updateNote(String noteId, String noteTitle,
			String noteBody);
	
	public NoteResult shareNote(String noteId);
	
	public NoteResult searchShare(String noteTitle);
	
	public NoteResult loadShareNoteDetail(String shareId);
	
	public NoteResult moveNote(String noteId, String bookId);
	
	public NoteResult searchNotes(SearchNoteParams params);
}
