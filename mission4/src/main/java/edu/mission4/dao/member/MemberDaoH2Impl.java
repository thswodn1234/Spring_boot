package edu.mission4.dao.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.mission4.domain.MemberVO;

public class MemberDaoH2Impl implements MemberInterface {

	private Connection con = null;

	public MemberDaoH2Impl() {
		try {
			// JDBC 드라이버 로드
			Class.forName("org.h2.Driver");

			con = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberVO postMember(int id, String pass, String name) {
		try {
			Statement st = con.createStatement();

//			st.executeUpdate("insert into member (id, pass, name)" + "values"+ "('"+ id+"','" +pass +"','"+name +"')");
			st.executeUpdate(
					String.format("insert into member (id, pass, name) values ('%s','%s','%s')", id, pass, name));
			// 넣은 데이터 출력하고 싶음
			MemberVO m = new MemberVO();
			m.setId(id);
			m.setName(name);
			m.setPass(pass);
			m.setRegidate(new Date());
			return m;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MemberVO> getMembers() {
		List<MemberVO> list = new ArrayList<>();
		// query
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from Member");
			while (rs.next()) {
				MemberVO m = new MemberVO();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setPass(rs.getString("pass"));
				m.setRegidate(rs.getDate("regidate"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public MemberVO getMember(int id) {
		// query
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(String.format("select * from Member where id = '%s'", id));
			rs.next();
			MemberVO m = new MemberVO();
			m.setId(rs.getInt("id"));
			m.setName(rs.getString("name"));
			m.setPass(rs.getString("pass"));
			m.setRegidate(rs.getDate("regidate"));
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MemberVO putMember(int id, String pass, String name) {
		try {

			Statement st = con.createStatement();

			st.executeUpdate(
					String.format("UPDATE member SET pass = '%s', name = '%s'  where id = '%s'", pass, name, id));

			MemberVO m = getMember(id);
			return m;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public MemberVO deleteMember(int id) {
		try {
			MemberVO m = getMember(id);

			Statement st = con.createStatement();

			st.executeUpdate(String.format("DELETE FROM member where id = '%s'", id));
			// 삭제한 데이터 출력하고 싶음
			return m;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
