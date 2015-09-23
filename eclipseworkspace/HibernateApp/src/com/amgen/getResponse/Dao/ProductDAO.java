package com.amgen.getResponse.Dao;

import java.util.List;

import com.amgen.getResponse.entity.campaign.Product;

public interface ProductDAO  {
	public void addProduct(String productName);
   
	/**
	 * @param productName
	 * @return
	 */
    public List<Product> fetchData(String productName);
}
