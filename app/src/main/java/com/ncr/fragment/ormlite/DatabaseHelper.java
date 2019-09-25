package com.ncr.fragment.ormlite;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class DatabaseHelper extends OrmLiteSqliteOpenHelper {

	//Database name
	private static final String DATABASE_NAME = "users";
	//Version of the database. Changing the version will call {@Link OrmLite.onUpgrade}
	private static final int DATABASE_VERSION = 2;

	/**
	 * The data access object used to interact with the Sqlite database to do C.R.U.D operations.
	 */
	private Dao<Users, Integer> usersDao;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
		try {
			/**
			 * creates the database table
			 */
			TableUtils.createTable(connectionSource, Users.class);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (java.sql.SQLException e) {
			e.printStackTrace();
		}
	}
	/*
		It is called when you construct a SQLiteOpenHelper with version newer than the version of the opened database.
	 */
	@Override
	public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource,
	                      int oldVersion, int newVersion) {
		try {
			TableUtils.dropTable(connectionSource, Users.class, false);
			onCreate(database, connectionSource);

		} catch (SQLException | java.sql.SQLException e) {
			e.printStackTrace();
		}
	}

	Dao<Users, Integer> getDaoObject() throws SQLException {
		if(usersDao == null) {
			try {
				usersDao = this.getDao(Users.class);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usersDao;
	}
}