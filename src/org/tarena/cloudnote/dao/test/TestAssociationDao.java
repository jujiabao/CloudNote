package org.tarena.cloudnote.dao.test;

import org.junit.Test;
import org.tarena.cloudnote.dao.AssociationDao;
import org.tarena.cloudnote.entity.NoteBook;
import org.tarena.cloudnote.entity.User;
import org.tarena.cloudnote.util.SpringTest;

public class TestAssociationDao extends SpringTest {
	@Test
	public void test1(){
		AssociationDao dao = super.getContext().getBean("associationDao", AssociationDao.class);
		User user = dao.findUserAndBooks("d6de5f2a-4a47-4ac3-831b-de92bf745b26");
		if (user != null) {
			System.out.println("用户名："+user.getCn_user_name());
			System.out.println("昵称："+user.getCn_user_nick());
			System.out.println("笔记本数量："+user.getBooks().size());
			System.out.println("=============笔记列表=============");
			for (NoteBook noteBook : user.getBooks()) {
				System.out.println(noteBook.getCn_notebook_name());
			}
		}
	}
}
