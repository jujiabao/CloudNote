package org.tarena.cloudnote.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.tarena.cloudnote.dao.NoteDao;
import org.tarena.cloudnote.util.NoteResult;

@Service
@Transactional
public class RecycleServiceImpl implements RecycleService {
	@Resource
	private NoteDao noteDao;

	@Override
	public NoteResult recycleNote(String noteId) {
		NoteResult result = new NoteResult();
		noteDao.recycle(noteId);
		result.setStatus(0);
		result.setMsg("放入回收站成功！");
		return result;
	}

}
