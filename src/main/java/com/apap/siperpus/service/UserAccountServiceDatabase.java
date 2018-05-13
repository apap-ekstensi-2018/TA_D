package com.apap.siperpus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apap.siperpus.dao.UserAccountMapper;
import com.apap.siperpus.model.UserAccountModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserAccountServiceDatabase implements UserAccountService{
	
	@Autowired
	private UserAccountMapper userAccountMapper;
	
	@Override
	public UserAccountModel selectUserAccountByUsername(String username) {
		return userAccountMapper.selectUserAccountByUsername(username);
	}

	@Override
	public List<UserAccountModel> selectAllUserAccount() {
		return userAccountMapper.selectAllUserAccount();
	}
	
}
