package com.letsbuy.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.letsbuy.beans.Order;
import com.letsbuy.beans.Product;

@Mapper
public interface ProductMapper {
	
	@Update("update product set p_quantity=p_quantity+#{product.quantity} where p_id=#{product.productId}")
	boolean updateProductTable(Order order);
	
	@Select("select p.*,v.v_id,v.username,ca.*,sub.* from product p JOIN vendor v ON p.v_id=v.v_id JOIN category ca ON p.category_id = ca.category_id JOIN subcategory sub ON p.subcategory_id = sub.subcategory_id")
	@Results({
		@Result(property="productId",column="p_id"),
		@Result(property="warranty",column="warranty"),
		@Result(property="brand",column="p_brand"),
		@Result(property="description",column="p_description"),
		@Result(property="productName",column="p_name"),
		@Result(property="subtitle",column="p_subtitle"),
		@Result(property="productPrice",column="p_price"),
		@Result(property="quantity",column="p_quantity"),
		@Result(property="vendor.account.userName",column="username"),
		@Result(property="vendor.vendorId",column="v_id"),
		@Result(property="subCategory.subCategoryId",column="subcategory_id"),
		@Result(property="subCategory.subCategoryName",column="subcategory_name"),
		@Result(property="subCategory.verificationStatus",column="sub_v_status"),
		@Result(property="subCategory.category.categoryId",column="category_id"),
		@Result(property="subCategory.category.categoryName",column="category_name"),
		@Result(property="subCategory.category.verificationStatus",column="cat_v_status"),
		@Result(property="verificationStatus",column="verified_status"),
		@Result(property="productStatus",column="product_status")
	})
	List<Product> getAllProduct();
	@Update("update product set p_quantity=p_quantity-#{quantity} WHERE p_id=#{productId}")
	boolean updateProductOrderQuantity(Product product);
	@Update("update product set verified_status=#{verificationStatus} where p_id=#{productId}")
	boolean updateProductStatus(Product product);
}
