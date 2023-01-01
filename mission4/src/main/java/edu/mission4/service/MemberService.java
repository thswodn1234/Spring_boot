package edu.mission4.service;

import edu.mission4.dao.log.LogDao;
import edu.mission4.dao.log.LogDaoH2Impl;
import edu.mission4.dao.member.MemberDaoH2Impl;
import edu.mission4.dao.member.MemberInterface;

public class MemberService {
	private MemberInterface memberDao;

	private LogDao logDao;

	public MemberService() {
		memberDao = new MemberDaoH2Impl();
		// memberDao = new MemberDaoListImpl();

		logDao = new LogDaoH2Impl();
//		logDao = new LogDaoFileImpl();
	}

}
