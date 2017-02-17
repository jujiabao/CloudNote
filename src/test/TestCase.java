package test;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

import org.apache.commons.dbcp.BasicDataSource;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.junit.Assert;
import org.junit.Test;
import org.tarena.cloudnote.dao.UserDao;
import org.tarena.cloudnote.entity.User;
import org.tarena.cloudnote.service.UserService;
import org.tarena.cloudnote.util.NoteResult;
import org.tarena.cloudnote.util.NoteUtil;
import org.tarena.cloudnote.util.SpringTest;

public class TestCase extends SpringTest {
	@Test
	public void testUserDao(){
		UserDao dao = super.getContext().getBean("userDao", UserDao.class);
		User user = dao.findByName("pc");
		System.out.println(user.toString());
	}
	
	@Test
	public void test2(){
		BasicDataSource dataSource = super.getContext().getBean("dbcp", BasicDataSource.class);
		System.out.println(dataSource);
	}
	
	@Test
	public void test3(){
		UserDao dao = super.getContext().getBean("userDao", UserDao.class);
		User user = dao.findByName("oo");
		if (user == null) {
			System.out.println("用户不存在");
		} else {
			System.out.println(user.getCn_user_nick());
			System.out.println(user.getCn_user_password());
		}
	}
	
	@Test
	public void test4(){
		UserService service = super.getContext().getBean("userServiceImpl", UserService.class);
		NoteResult result = service.checkLogin("demo", "123");
		//断言
		Assert.assertEquals(0, result.getStatus());
//		System.out.println(result.toString());
	}
	
	@Test
	public void test5(){
		UserDao dao = super.getContext().getBean("userDao", UserDao.class);
		User user = new User();
		user.setCn_user_id(UUID.randomUUID()+"");
		user.setCn_user_name("jujiabao");
		user.setCn_user_password(NoteUtil.md5("08101911"));
		user.setCn_user_token("1");
		user.setCn_user_nick("Hello.Ju");
		dao.save(user);
		System.out.println("完成");
	}
	
	@Test
	public void test6(){
		System.out.println(066);
	}
	
	@Test
	public void test7(){
		String rex = "\\d+";
		System.out.println("输入数字 ：");
		Scanner scanner = new Scanner(System.in);
		String inputStr = scanner.nextLine();
		if (!inputStr.matches(rex)) {
			throw new RuntimeException("不是数字！");
		}
		int input = Integer.parseInt(inputStr);
		if (input<2 || input>32) {
			throw new RuntimeException("数字超标");
		}
		
		for (int i = 1; i <= input + 1; i++) {
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2*input+2-2*i-1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		scanner.close();
	}
	
	@Test
	public void test8(){
		int index = 1;
		String[] test = new String[3];
		System.out.println(Arrays.toString(test));
		System.out.println(test[index]);
	}
	
	@Test
	public void test9(){
		Scanner scanner = new Scanner(System.in);
	}
}
