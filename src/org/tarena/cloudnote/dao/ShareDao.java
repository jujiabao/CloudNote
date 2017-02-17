package org.tarena.cloudnote.dao;

import java.util.List;

import org.tarena.cloudnote.entity.Share;

public interface ShareDao {
	
	public void save(Share share);
	
	public Share findById(String noteId);
	
	public List<Share> findLikeTitle(String noteTitle);
	
	public Share findByShareId(String shareId);
	
}
