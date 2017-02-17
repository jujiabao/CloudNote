package org.tarena.cloudnote.dao.test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.tarena.cloudnote.dao.ShareDao;
import org.tarena.cloudnote.entity.Share;
import org.tarena.cloudnote.util.SpringTest;

public class TestShareDao extends SpringTest {
	@Test
	public void test1(){
		ShareDao dao = super.getContext().getBean("shareDao", ShareDao.class);
		Share share = new Share();
		share.setCn_share_id("1");
		share.setCn_share_title("2");
		share.setCn_share_body("3");
		share.setCn_note_id("4");
		dao.save(share);
		System.out.println("分享成功");
	}
	
	@Test
	public void test2(){
		ShareDao dao = super.getContext().getBean("shareDao", ShareDao.class);
		Share share = dao.findById("4");
		System.out.println(share);
	}
	
	@Test
	public void test3(){
		ShareDao dao = super.getContext().getBean("shareDao", ShareDao.class);
		List<Share> list = dao.findLikeTitle("%笔记%");
		for (Share share : list) {
			System.out.println(share);
		}
	}
	
	@Test
	public void test4(){
		String s = "            ";
		String[] ss = s.split(" ");
		System.out.println(Arrays.toString(ss));
		String sss = s.replace(" ", "%");
		
		System.out.println(sss);
	}
}
