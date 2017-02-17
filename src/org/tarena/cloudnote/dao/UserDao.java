package org.tarena.cloudnote.dao;

import org.tarena.cloudnote.entity.User;

public interface UserDao {
	public User findByName(String name);
	public void save(User user);
}
