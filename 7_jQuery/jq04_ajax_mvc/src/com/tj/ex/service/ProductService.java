package com.tj.ex.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tj.ex.dao.ProductDao;

public class ProductService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String pname = request.getParameter("pname");
		ProductDao pDao = ProductDao.getInstance();
		request.setAttribute("product", pDao.getProduct(pname));
	}

}
