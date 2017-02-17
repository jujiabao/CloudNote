package org.tarena.cloudnote.service;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.cloudnote.dao.BookDao;
import org.tarena.cloudnote.entity.NoteBook;
import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.util.NoteUtil;

@Service
@Transactional
public class BookServiceImpl implements BookService {
	@Resource
	private BookDao bookDao;

	@Override
	public NoteResult loadUserBooks(String userId) {
		NoteResult result = new NoteResult();
		List<NoteBook> books = bookDao.findByUserId(userId);
		result.setStatus(0);
		result.setMsg("加载成功！");
		result.setData(books);
		return result;
	}

	@Override
	public NoteResult addBook(String userId, String bookName) {
		NoteResult result = new NoteResult();
		//TODO 检测创建笔记本是否重名，暂时不做
		NoteBook book = new NoteBook();
		String bookId = NoteUtil.createId();
		book.setCn_notebook_id(bookId);
		book.setCn_user_id(userId);
		book.setCn_notebook_type_id("5");//normal
		book.setCn_notebook_name(bookName);
		book.setCn_notebook_desc("");
		book.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
		bookDao.save(book);
		result.setStatus(0);
		result.setMsg("创建笔记本成功！");
		result.setData(bookId);
		return result;
	}
}
