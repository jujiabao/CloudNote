package org.tarena.cloudnote.service;

import org.tarena.cloudnote.util.NoteResult;

public interface UserService {
	public NoteResult checkLogin(String name, String password);
	//注册
	public NoteResult regist(String name, String password, String nick);
}
