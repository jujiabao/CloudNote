package org.tarena.cloudnote.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.cloudnote.dao.NoteDao;
import org.tarena.cloudnote.dao.ShareDao;
import org.tarena.cloudnote.entity.Note;
import org.tarena.cloudnote.entity.NoteBean;
import org.tarena.cloudnote.entity.Share;
import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.util.NoteUtil;
import org.tarena.cloudnote.vo.SearchNoteParams;

@Service
@Transactional
public class NoteServiceImpl implements NoteService {
	@Resource
	private NoteDao noteDao;
	
	@Resource
	private ShareDao shareDao;
	
	@Override
	public NoteResult loadBookNotes(String notebookId) {
		NoteResult result = new NoteResult();
		List<Note> notes = noteDao.findByBookId(notebookId);
		result.setStatus(0);
		result.setMsg("加载笔记列表成功！");
		result.setData(notes);
		return result;
	}

	@Override
	public NoteResult loadNoteDetail(String id) {
		NoteResult result = new NoteResult();
		Note note = noteDao.findById(id);
		if (note == null) {
			result.setStatus(1);
			result.setMsg("找不到笔记信息！");
			return result;
		}
		result.setStatus(0);
		result.setMsg("查找笔记成功！");
		result.setData(note);
		return result;
	}

	@Override
	public NoteResult addNote(String userId, String bookId, String noteTitle) {
		NoteResult result = new NoteResult();
		Note note = new Note();
		String noteId = NoteUtil.createId();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
		note.setCn_user_id(userId);
		note.setCn_note_status_id("1");
		note.setCn_note_type_id("5");
		note.setCn_note_title(noteTitle);
		note.setCn_note_body("");
		//获取当前系统时间
		long time = new Date().getTime();
		note.setCn_note_create_time(time);
		note.setCn_note_last_modify_time(time);
		noteDao.save(note);
		result.setStatus(0);
		result.setMsg("创建笔记成功！");
		result.setData(noteId);
		return result;
	}

	@Override
	public NoteResult updateNote(String noteId, String noteTitle,
			String noteBody) {
		NoteResult result = new NoteResult();
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_body(noteBody);
		note.setCn_note_last_modify_time(new Date().getTime());
		noteDao.update(note);
		result.setStatus(0);
		result.setMsg("更新笔记信息成功！");
		return result;
	}

	@Override
	public NoteResult shareNote(String noteId) {
		NoteResult result = new NoteResult();
		Note note = noteDao.findById(noteId);
		if (note == null) {
			result.setStatus(1);
			result.setMsg("没有该笔记！");
			return result;
		}
		Share share = shareDao.findById(noteId);
		if (share != null) {
			result.setStatus(1);
			result.setMsg("已分享过该笔记！");
			return result;
		}
		note = noteDao.findById(noteId);
		String shareId = NoteUtil.createId();
		share = new Share();
		share.setCn_share_id(shareId);
		share.setCn_share_title(note.getCn_note_title());
		share.setCn_share_body(note.getCn_note_body());
		share.setCn_note_id(noteId);
		shareDao.save(share);
		result.setStatus(0);
		result.setMsg("分享成功！");
		result.setData(share);
		return result;
	}

	@Override
	public NoteResult searchShare(String noteTitle) {
		NoteResult result = new NoteResult();
		if ("".equals(noteTitle) || noteTitle == null) {
			result.setStatus(1);
			result.setMsg("请输入要查询的关键字！");
			return result;
		}
		noteTitle = "%" + noteTitle.replace(" ", "%") + "%";
		List<Share> list = shareDao.findLikeTitle(noteTitle);
		if (list.size() == 0) {
			result.setStatus(2);
			result.setMsg("未搜索到相关笔记！");
			return result;
		}
		result.setStatus(0);
		result.setMsg("共查询到"+list.size()+"篇笔记！");
		result.setData(list);
		return result;
	}

	@Override
	public NoteResult loadShareNoteDetail(String shareId) {
		NoteResult result = new NoteResult();
		Share share = shareDao.findByShareId(shareId);
		if (share == null) {
			result.setStatus(1);
			result.setMsg("找不到该笔记，可能被删除！");
			return result;
		}
		result.setStatus(0);
		result.setMsg("查询分享的笔记成功！");
		result.setData(share);
		return result;
	}

	@Override
	public NoteResult moveNote(String noteId, String bookId) {
		NoteResult result = new NoteResult();
		Note note = new Note();
		note.setCn_note_id(noteId);
		note.setCn_notebook_id(bookId);
		noteDao.move(note);
		result.setStatus(0);
		result.setMsg("移动成功！");
		return result;
	}

	/**
	 * 组合查询
	 */
	@Override
	public NoteResult searchNotes(SearchNoteParams params) {
		NoteResult result = new NoteResult();
		NoteBean noteBean = new NoteBean();
		//设置查询参数
		//标题不为空时
		if (params.getTitle() != null && !"".equals(params.getTitle())) {
			noteBean.setCn_note_title("%"+params.getTitle()+"%");
		}
		//状态不为all时追加sql条件参数
		if (!"-1".equals(params.getStatus())) {
			noteBean.setCn_note_status_id(params.getStatus());
		}
		//起始日期不为空时追加sql条件参数值
		if (!"".equals(params.getBeginTime()) && params.getBeginTime() != null) {
			java.sql.Date beginTime = java.sql.Date.valueOf(params.getBeginTime());
			noteBean.setBeginTime(beginTime.getTime());
		}
		//结束日期不为空时追加sql条件参数值
		if (!"".equals(params.getEndTime()) && params.getEndTime() != null) {
			java.sql.Date endTime = java.sql.Date.valueOf(params.getEndTime());
			noteBean.setEndTime(endTime.getTime());
		}
		//执行查询
		List<Note> list = noteDao.findNotes(noteBean);
		result.setStatus(0);
		result.setMsg("查询成功，共有"+list.size()+"条数据！");
		result.setData(list);
		return result;
	}
}
