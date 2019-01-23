package kr.green.springtest.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.springtest.vo.AccountVo;

public interface AccountDao {

	AccountVo getAccount(@Param("id")String id);

	void setAccount(@Param("user")AccountVo userInfo);

}
