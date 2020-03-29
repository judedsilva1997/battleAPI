package com.got.battleAPI.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.got.battleAPI.model.responses.ErrorClass;

@Controller
public class APIErrorController implements ErrorController {

  @RequestMapping("/error")
  @ResponseBody
  public ErrorClass handleError(HttpServletRequest request) {
      Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
      String message = "Something went wrong...Check the API usage to learn more";
      return new ErrorClass(statusCode,message);
      
  }

  @Override
  public String getErrorPath() {
      return "/error";
  }
}
