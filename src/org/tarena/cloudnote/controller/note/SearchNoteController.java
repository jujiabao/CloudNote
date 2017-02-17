package org.tarena.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.NoteService;
import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.vo.SearchNoteParams;

@Controller
@RequestMapping("/note")
public class SearchNoteController {
	@Resource
	private NoteService noteService;
	
	@RequestMapping("/searchNotes.do")
	@ResponseBody
	public NoteResult execute(SearchNoteParams params){
		System.out.println(params);
		NoteResult result = noteService.searchNotes(params);
		return result;
	}
}
