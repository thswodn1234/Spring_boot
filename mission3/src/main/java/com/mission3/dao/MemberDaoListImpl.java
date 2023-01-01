package com.mission3.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mission3.domain.MemberVO;

public class MemberDaoListImpl implements MemberInterface {

	private List<MemberVO> list;

	public MemberDaoListImpl() {
		list = new ArrayList<MemberVO>();
		for (int i = 1; i < 21; i++) {
			list.add(new MemberVO(i, "1234", "이름" + i, new Date()));
		}
	}

	@Override
	public MemberVO postMember(int id, String pass, String name) {
		MemberVO m = new MemberVO();
		m.setId(id);
		m.setPass(pass);
		m.setName(name);
		m.setRegidate(new Date());
		list.add(m);
		return getMember(id);
	}

	@Override
	public List<MemberVO> getMembers() {
		return list;
	}

	@Override
	public MemberVO getMember(int id) {
		for (MemberVO m : list) {
			if (m.getId() == id)
				return m;
		}
		return null;
	}

	@Override
	public MemberVO putMember(int id, String pass, String name) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				m.setPass(pass);
				m.setName(name);
				return m;
			}
		}
		return null;
	}

	@Override
	public MemberVO deleteMember(int id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				list.remove(m);
				return getMember(id);
			}
		}
		return null;
	}

	
}
