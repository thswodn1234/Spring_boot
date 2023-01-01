package edu.pnu.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import edu.pnu.domain.MemberVO;

public class MemberDaoFileImpl implements MemberInterface {
	private List<MemberVO> list;

	public MemberDaoFileImpl() {
		list = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("list.txt"));

			String str;

			while ((str = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(str, ",");
				String s1 = st.nextToken();
				String s2 = st.nextToken();
				String s3 = st.nextToken();
				list.add(new MemberVO(Integer.parseInt(s1), s2, s3, new Date()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<MemberVO> getMembers() {
		return list;
	}

	@Override
	public MemberVO getMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id)
				return m;
		}
		return null;
	}

	private int getNextId() {
		return list.size() + 1;
	}

	@Override
	public MemberVO addMember(MemberVO member) {
		member.setId(getNextId());
		member.setRegidate(new Date());
		return member;
	}

	@Override
	public MemberVO updateMember(MemberVO member) {
		for (MemberVO m : list) {
			if (m.getId() == member.getId()) {
				m.setName(member.getName());
				m.setPass(member.getPass());
				return m;
			}
		}
		return null;
	}

	@Override
	public int deleteMember(Integer id) {
		for (MemberVO m : list) {
			if (m.getId() == id) {
				list.remove(m);
				return 1;
			}
		}
		return 0;
	}

}
