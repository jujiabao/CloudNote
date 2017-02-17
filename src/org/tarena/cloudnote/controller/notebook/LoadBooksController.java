package org.tarena.cloudnote.controller.notebook;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.BookService;
import org.tarena.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/notebook")
public class LoadBooksController {
	@Resource
	private BookService bookService;
	
	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult execute(String userId){
		NoteResult result = bookService.loadUserBooks(userId);
		return result;
	}
}
