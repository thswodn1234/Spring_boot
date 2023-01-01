package com.mission2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mission2.domain.MemberVO;

import common.JDBConnect;

public class MemberDao extends JDBConnect {
	public MemberDao() {
		super("org.h2.Driver", "jdbc:h2:tcp://localhost/~/test", "sa", ""); // h2 DB
	}

	public MemberVO postMember(MemberVO memberVO) {
		try {
			Statement st = con.createStatement();

//			st.executeUpdate("insert into member (id, pass, name)" + "values"+ "('"+ id+"','" +pass +"','"+name +"')");
			st.executeUpdate(String.format("insert into member (id, pass, name) values ('%s','%s','%s')",
					memberVO.getId(), memberVO.getPass(), memberVO.getName()));

			return getMember(memberVO.getId());

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

	public MemberVO putMembers(int id, String pass, String name) {
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