package com.tj.ex.service;

import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;

public interface Service {
	public void execute(HttpServletRequest request, HttpServletResponse response);
}
