package com.letsbuy.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.letsbuy.beans.SubCategory;

@Mapper
public interface SubCategoryMapper {
	
	@Select("select sub.*,ca.* from subcategory sub JOIN category ca ON ca.category_id=sub.category_id")
	@Results({
		@Result(property="subCategoryId",column="subcategory_id"),
		@Result(property="subCategoryName",column="subcategory_name"),
		@Result(property="verificationStatus",column="sub_v_status"),
		@Result(property="category.categoryId",column="category_id"),
		@Result(property="category.categoryName",column="category_name"),
		@Result(property="category.verificationStatus",column="cat_v_status")
	})
	List<SubCategory> getAllSubCategories();
	@Update("update subcategory set sub_v_status=#{verificationStatus} where subcategory_id=#{subCategoryId}")
	boolean updateSubCategory(SubCategory subCategory);
	@Insert("insert into subcategory(subcategory_id,category_id,subcategory_name,sub_v_status) VALUES (subcategory_sequence.nextval,#{category.categoryId},#{subCategoryName},#{verificationStatus})")
	boolean addSubCategory(SubCategory subCategory);
}
