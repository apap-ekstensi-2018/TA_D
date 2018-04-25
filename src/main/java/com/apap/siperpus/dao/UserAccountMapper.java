package com.apap.siperpus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.apap.siperpus.model.UserAccountModel;

@Mapper
public interface UserAccountMapper {
	
	public UserAccountModel selectUserAccountByUsername(String username);
	
	public List<UserAccountModel> selectAllUserAccount();
}
