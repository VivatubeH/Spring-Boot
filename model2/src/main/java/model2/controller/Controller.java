package model2.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {

	String exe(HttpServletRequest req, HttpServletResponse res)
		throws Exception;
}
