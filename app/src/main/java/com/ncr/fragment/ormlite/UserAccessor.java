package com.ncr.fragment.ormlite;

import com.j256.ormlite.dao.Dao;

import java.util.List;

public class UserAccessor {
	Dao<Users, Integer> simpleDao;

	public UserAccessor(Dao<Users, Integer> dao) {
		simpleDao = dao;
	}

	public void storeUserToSqLite(Users user) {

		try {
			simpleDao.create(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Users> list = null;
		try {
			list = simpleDao.queryForAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		StringBuilder sb = new StringBuilder();
		int simpleC = 1;
		for (Users simple : list) {
			sb.append('#').append(simpleC).append(": ").append(simple.getUsername()).append('\n');
			simpleC++;
		}
		System.out.println(sb.toString());
	}

	//Query to database to get all forms by username
	public List<Users> getAllUsersByUsername() {
		List<Users> results = null;
		try {
			results = simpleDao.queryForAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return results;
	}
}