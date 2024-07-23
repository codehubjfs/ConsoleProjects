package com.letsbuy.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.letsbuy.beans.Vendor;

@Mapper
public interface VendorMapper {
	
	@Select("select * from vendor")
	@Results({
		@Result(property="vendorId",column="v_id"),
		@Result(property="registeredNumber",column="reg_no"),
		@Result(property="aadharNumber",column="aadhar_no"),
		@Result(property="address",column="address"),
		@Result(property="email",column="email"),
		@Result(property="mobileNumber",column="mobile_no"),
		@Result(property="account.userName",column="username"),
		@Result(property="account.password",column="password"),
		@Result(property="account.accountType",column="account_type"),
		@Result(property="account.accountStatus",column="account_status")
	})
	List<Vendor> getAllVendors();
	@Update("update vendor set account_status=#{account.accountStatus} where v_id=#{vendorId}")
	boolean updateStatus(Vendor vendor);
}
