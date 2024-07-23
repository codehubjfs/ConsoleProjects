package com.ungalkadai.components;

import com.ecommerce.users.Vendor;

public class Product {
	private String productName;
	private int productId;
	private double productPrice;
	private String brand;
	private int quantity;
	private String subtitle;
	private String description;
	private String warranty;
	private Vendor vendor;
	private SubCategory subCategrory;
	private VerificationStatus verificationStatus;
	private ProductStatus productStatus;
	
	public Product() {
		
	}
	
	
	
	
	public Product(double productPrice,String productName, String brand, int quantity, String subtitle, String description, String warranty,
			Vendor vendor, SubCategory subCategrory, ProductStatus productStatus,VerificationStatus verificationStatus) {
		this.productPrice = productPrice;
		this.productName = productName;
		this.brand = brand;
		this.quantity = quantity;
		this.subtitle = subtitle;
		this.description = description;
		this.warranty = warranty;
		this.vendor = vendor;
		this.subCategrory = subCategrory;
		this.productStatus = productStatus;
		this.verificationStatus = verificationStatus;
	}

	

	public Product(String productName, int productId, String brand, int quantity, String subtitle, String description,
			String warranty, Category category, SubCategory subCategrory, ProductStatus productStatus) {
		this.productName = productName;
		this.productId = productId;
		this.brand = brand;
		this.quantity = quantity;
		this.subtitle = subtitle;
		this.description = description;
		this.warranty = warranty;
		//this.category = category;
		this.subCategrory = subCategrory;
		this.productStatus = productStatus;
	}
	
	

	public Product(String productName, int productId, double productPrice, String brand, String subtitle,
			String description, String warranty, SubCategory subCategrory) {
		this.productName = productName;
		this.productId = productId;
		this.productPrice = productPrice;
		this.brand = brand;
		this.subtitle = subtitle;
		this.description = description;
		this.warranty = warranty;
		this.subCategrory = subCategrory;
	}



	public Product(String productName, String brand, int quantity, String subtitle, String description, String warranty,
			 SubCategory subCategrory, ProductStatus productStatus) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.quantity = quantity;
		this.subtitle = subtitle;
		this.description = description;
		this.warranty = warranty;
		//this.category = category;
		this.subCategrory = subCategrory;
		this.productStatus = productStatus;
	}
	
	
	
	public Product(String productName, int productId, double productPrice, String brand, int quantity, String subtitle
			,String description,String warranty) {
		this.productName = productName;
		this.productId = productId;
		this.productPrice = productPrice;
		this.brand = brand;
		this.quantity = quantity;
		this.subtitle = subtitle;
		this.description = description;
		this.warranty = warranty;
	}



	public double getProductPrice() {
		return productPrice;
	}



	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public VerificationStatus getVerificationStatus() {
		return verificationStatus;
	}



	public void setVerificationStatus(VerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWarranty() {
		return warranty;
	}

	public void setWarranty(String warranty) {
		this.warranty = warranty;
	}

//	public Category getCategory() {
//		return category;
//	}

//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public SubCategory getSubCategrory() {
		return subCategrory;
	}

	public void setSubCategrory(SubCategory subCategrory) {
		this.subCategrory = subCategrory;
	}

	public ProductStatus getProductStatus() {
		return productStatus;
	}

	public void setProductStatus(ProductStatus productStatus) {
		this.productStatus = productStatus;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n"+"-".repeat(200)+"\n");
		builder.append("Product Name : "+productName+"\n");
		builder.append("Subtitle : "+subtitle+"\n");
		builder.append("Brand : "+brand+"\n");
		builder.append("Price : "+productPrice+"\n");
		builder.append("Description : "+description+"\n");
		//builder.append("Quantity : "+quantity+"\n");
		builder.append("warranty : "+warranty+"\n");
		builder.append("-".repeat(200)+"\n");
		return builder.toString();
	}
	
//	private static void displayProductTable(Product product,int id) {
//        String format = "| %-15s | %-80s |\n";
//        String separator = "+-----------------+----------------------------------------------------------------------------------+";
//        
//        System.out.println(separator);
//        System.out.printf(format, "Product Code", id);
//        System.out.println(separator);
//        System.out.printf(format, "Product Name", product.getProductName());
//        System.out.println(separator);
//        System.out.printf(format, "Subtitle", product.getSubtitle());
//        System.out.println(separator);
//        System.out.printf(format, "Brand", product.getBrand());
//        System.out.println(separator);
//        System.out.printf(format, "Price", product.getProductPrice());
//        System.out.println(separator);
//        System.out.printf(format, "Description", product.getDescription());
//        System.out.println(separator);
//        System.out.printf(format, "Warranty", product.getWarranty());
//        System.out.println(separator);
//    }
//	
//	public static void  display(Product product,int id) {
//		displayProductTable(product,id);
//	}
	
	public static void displayTableHeader() {
        String separator = "+-------+-----------------------------+---------------------------+---------+----------+----------------------------------------------------+------------------+------------------------------------+";
        String formatHeader = "| %-5s | %-27s | %-35s | %-7s | %-8s | %-85s | %-9s |\n";
        System.out.println(separator);
        System.out.printf(formatHeader, "S.no", "Product Name", "Subtitle", "Brand", "Price", "Description", "Warranty");
        System.out.println(separator);
    }

    public static void display(Product product, int serialNumber) {
        String format = "| %-5d | %-27s | %-35s | %-7s | %-8.2f | %-85s | %-9s |\n";
        String separator = "+-------+-----------------------------+---------------------------+---------+----------+----------------------------------------------------+------------------+------------------------------------+";
        System.out.printf(format, serialNumber, product.getProductName(), product.getSubtitle(), product.getBrand(), product.getProductPrice(), product.getDescription(), product.getWarranty());
        System.out.println(separator);
    }

	

}
