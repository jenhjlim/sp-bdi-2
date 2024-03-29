package com.sp.bdi2.user;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SqlSessionFactory ssf;

	@Override
	public List<Map<String, String>> selectUserList() {
		SqlSession ss = ssf.openSession();
		
		try {
			return ss.selectList("com.sp.bdi2.dao.UserInfoMapper.selectUserInfoList");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			ss.close();
		}
		return null;
	}
}
