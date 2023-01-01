package edu.mission4.dao.log;

public interface LogDao {
	void addLog(String method, String sqlstring, boolean success);

}
