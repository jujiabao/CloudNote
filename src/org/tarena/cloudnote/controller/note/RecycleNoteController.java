package org.tarena.cloudnote.controller.note;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.RecycleService;
import org.tarena.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/recycle")
public class RecycleNoteController {
	@Resource
	private RecycleService recycleService;
	
	@RequestMapping("/recycle.do")
	@ResponseBody
	public NoteResult execute(String noteId){
		NoteResult result = recycleService.recycleNote(noteId);
		return result;
	}
}
