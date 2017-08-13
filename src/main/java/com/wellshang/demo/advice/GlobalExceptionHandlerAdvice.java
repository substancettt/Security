package com.wellshang.demo.advice;

import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

public class GlobalExceptionHandlerAdvice {

	ModelAndView exception(Exception exception, WebRequest request) {
		ModelAndView modelAndView = new ModelAndView("/error");
		modelAndView.addObject("errorMessage", exception.getMessage());
		modelAndView.addObject("stackTrace", exception.getStackTrace());
		return modelAndView;
	}
}
