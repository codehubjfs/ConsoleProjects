package com.letsbuy.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.letsbuy.beans.Category;

@Mapper
public interface CategoryMapper {
	
	@Select("select * from category")
	@Results({
		@Result(property="categoryId",column="category_id"),
		@Result(property="categoryName",column="category_name"),
		@Result(property="verificationStatus",column="cat_v_status")
	})
	List<Category> getAllCategory();
	
	@Update("update category set cat_v_status=#{verificationStatus} where category_id=#{categoryId}")
	boolean editCategorystatus(Category category);
	
	@Insert("insert into category(category_id,category_name,cat_v_status) VALUES(category_sequence.nextval,#{categoryName},#{verificationStatus})")
	boolean addCategory(Category category);
}
