package com.ncr.fragment.ormlite;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.util.List;

public class OrmLiteActivity extends AppCompatActivity {

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		DatabaseHelper databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
		UserAccessor userAccessor = new UserAccessor(databaseHelper.getDaoObject());

	/*	userAccessor.storeUserToSqLite(new Users("Test1", "Test1"));
		userAccessor.storeUserToSqLite(new Users("Test2", "Test2"));
		userAccessor.storeUserToSqLite(new Users("Test3", "Test3"));*/

		List<Users> lst = userAccessor.getAllUsersByUsername();
		lst.clear();

	}
}
