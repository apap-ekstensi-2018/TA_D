package com.apap.siperpus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.apap.siperpus.model.UserAccountModel;

@Mapper
public interface UserAccountMapper {
	
	@Select("SELECT * FROM user_account WHERE username=#{username}")
	public UserAccountModel selectUserAccountByUsername(String username);
	
	@Select("SELECT * FROM user_account")
	public List<UserAccountModel> selectAllUserAccount();
}
