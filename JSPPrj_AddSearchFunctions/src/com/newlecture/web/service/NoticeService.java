package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.Notice;

public class NoticeService {

	public List<Notice> getNoticeList() {

		return getNoticeList("title", "", 1);

	}

	public List<Notice> getNoticeList(int page) {

		return getNoticeList("title", "", page);

	}

	public List<Notice> getNoticeList(String field/* TITLE,WRITER_ID */, String query/* A */, int page) {

		List<Notice> list = new ArrayList<>();

		String sql = "select * from notice where " + field + " LIke ? order by regdate desc limit ?,? ";
		String url = "jdbc:mysql://localhost:3306/people?serverTimezone=UTC";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "universe4");
			PreparedStatement st = con.prepareStatement(sql);

			st.setString(1, "%"+query+"%");
			st.setInt(2, page); // 이거 다시봐야한다., (1,1+(page-1) * 10)
			st.setInt(3, 10);// 갑자기 왜 꺠졌지
			// Statement st = con.createStatement();
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");

				Notice notice = new Notice(id, title, writerId, regdate, hit, files, content);
				list.add(notice);
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}

	public int getNoticeCount() {

		return getNoticeCount("title", "");
	}

	public int getNoticeCount(String field, String query) {

		int count = 0;
		
		String sql = "select count(id) COUNT from ( " + 
				" select * from notice order by regdate desc limit 0,2 " + 
				")a";
		String url = "jdbc:mysql://localhost:3306/people?serverTimezone=UTC";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "universe4");
			PreparedStatement st = con.prepareStatement(sql);


			st.setString(1,  "%"+query+"%");
			
			ResultSet rs = st.executeQuery();

			count = rs.getInt("count");	//count나 COUNT나 상관없다.
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public Notice getNotice(int id) {

		Notice notice = null;
		String sql = "SELECT * from notice where ID = ?";
		String url = "jdbc:mysql://localhost:3306/people?serverTimezone=UTC";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "universe4");
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");

				notice = new Notice(
						nid, 
						title, 
						writerId, 
						regdate, 
						hit, 
						files, 
						content
						);
				
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return notice;
	}

	public Notice getNextNotice(int id) {

		Notice notice = null;
		String sql = "select ID from notice " + "where ID = ( " + "	select ID from notice "
				+ "	where REGDATE > (select regdate from notice where id = ?) limit 1 " + ")";

		String url = "jdbc:mysql://localhost:3306/people?serverTimezone=UTC";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "universe4");
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");

				notice = new Notice(
						nid, 
						title, 
						writerId, 
						regdate, 
						hit, 
						files, 
						content
						);
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

	public Notice getPrevNotice(int id) {

		Notice notice = null;
		String sql = "select ID from notice " + "where ID = ( " + "	select ID from notice "
				+ "    where REGDATE < (select regdate from notice where id = ?) order by REGDATE desc limit 1 " + ")";

		String url = "jdbc:mysql://localhost:3306/people?serverTimezone=UTC";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, "root", "universe4");
			PreparedStatement st = con.prepareStatement(sql);

			st.setInt(1, id);

			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				int nid = rs.getInt("ID");
				String title = rs.getString("TITLE");
				String writerId = rs.getString("WRITER_ID");
				Date regdate = rs.getDate("REGDATE");
				String hit = rs.getString("HIT");
				String files = rs.getString("FILES");
				String content = rs.getString("CONTENT");

				notice = new Notice(
						nid, 
						title, 
						writerId, 
						regdate, 
						hit, 
						files, 
						content
						);
				
			}

			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}

}
