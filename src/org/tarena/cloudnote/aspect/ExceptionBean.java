package org.tarena.cloudnote.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect//定义为切面
public class ExceptionBean {
	@AfterThrowing(throwing="e",pointcut="within(org.tarena.cloudnote.controller..*)")
	public void logException(Exception e){ 
		//笔记异常信息
//		System.out.println("发生异常："+e);
		try {
			FileWriter writer = new FileWriter("cloud_note.log",true);
			PrintWriter pw = new PrintWriter(writer);
			pw.println("==========================================================");
			pw.println("发生了异常："+e.getMessage());
			pw.println("发生时间："+getDate());
			pw.println("详情如下：");
			e.printStackTrace(pw);
			pw.flush();
			pw.close();
			writer.close();
		} catch (IOException e1) {
			System.out.println("记录异常失败！");
		}
	}
	
	public String getDate(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
