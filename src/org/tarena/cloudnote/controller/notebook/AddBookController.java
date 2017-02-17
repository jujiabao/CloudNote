package org.tarena.cloudnote.controller.notebook;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.tarena.cloudnote.service.BookService;
import org.tarena.cloudnote.util.NoteResult;

@Controller
@RequestMapping("/notebook")
public class AddBookController {
	@Resource
	private BookService bookService;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult execute(String userId, String bookName){
		NoteResult result = bookService.addBook(userId, bookName);
		return result;
	}
}
