package org.tarena.cloudnote.dao;

import java.util.List;

import org.tarena.cloudnote.entity.NoteBook;
import org.tarena.cloudnote.entity.User;

public interface AssociationDao {
	
	public User findUserAndBooks(String userId);
	
	public User findUserAndBooks1(String userId);
	//查询所有NoteBook并加载相关的user关联的信息
	public List<NoteBook> findBooksAndUser();
}
