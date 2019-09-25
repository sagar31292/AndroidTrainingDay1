package com.ncr.fragment.ormlite;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "user")
public class Users implements Serializable {

	public static final String ID_FIELD = "user_id";

	@DatabaseField(generatedId = true, columnName = ID_FIELD)
	public int id;

	@DatabaseField(dataType = DataType.STRING)
	public String username;

	@DatabaseField(dataType = DataType.STRING)
	public String password;

	Users(String username, String password) {
		this.username = username;
		this.password = password;
	}

	Users() {
	}

	String getUsername() {
		return username;
	}
}