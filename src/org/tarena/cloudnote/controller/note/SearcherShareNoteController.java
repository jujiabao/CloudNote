package org.tarena.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.NoteService;
import org.tarena.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/note")
public class SearcherShareNoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/search.do")
	@ResponseBody
	public NoteResult execute(String noteTitle){
		NoteResult result = noteService.searchShare(noteTitle);
		return result;
	}
}
