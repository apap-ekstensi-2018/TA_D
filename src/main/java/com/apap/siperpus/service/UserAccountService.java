package com.apap.siperpus.service;

import java.util.List;

import com.apap.siperpus.model.UserAccountModel;

public interface UserAccountService {
	
	UserAccountModel selectUserAccountByUsername(String username);
	
	List<UserAccountModel> selectAllUserAccount();
}
