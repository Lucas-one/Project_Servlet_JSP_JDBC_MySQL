package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {

	public List<Notice> getNoticeList() {

		return getNoticeList("title","",1);

	}

	public List<Notice> getNoticeList(int page) {

		return getNoticeList("title","",page);

	}

	public List<Notice> getNoticeList(String field, String query, int page) {

		String sql = "select * from notice order by regdate desc limit 5,5";
		
		return null;

	}
	
	public int getNoticeCount() {
		
		return getNoticeCount("title","");
	}
	
	public int getNoticeCount(String field, String query) {
		return 0;
	}
	
	public Notice getNotice(int id) {
		
		String sql = "SELECT * from notice where ID = ?";
		
		return null;
	}
	
	public Notice getNextNotice(int id) {
		
		String sql = "select ID from notice " + 
				"where ID = ( " + 
				"	select ID from notice " + 
				"	where REGDATE > (select regdate from notice where id = 3) limit 1 " + 
				")";
		
		return null;
	}
	
	public Notice getPrevNotice(int id) {
		
		
		String sql = "select ID from notice " + 
				"where ID = ( " + 
				"	select ID from notice " + 
				"    where REGDATE < (select regdate from notice where id = 3) order by REGDATE desc limit 1 " + 
				")";
		
		return null;
	}
	
}
