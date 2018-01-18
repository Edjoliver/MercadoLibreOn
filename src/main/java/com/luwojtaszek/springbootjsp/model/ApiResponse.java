package com.luwojtaszek.springbootjsp.model;

import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;
import java.util.Map;

public class ApiResponse extends LinkedCaseInsensitiveMap {

  public ApiResponse(String data) {
    this.put("success", true);
    this.put("data", data);
  }
  public ApiResponse(Object data) {
    this.put("success", true);
    this.put("data", data);
  }
  public ApiResponse(Map data) {
    this.put("success", true);
    this.put("data", data);
  }

  public ApiResponse(List data) {
    this.put("success", true);
    this.put("data", data);
  }

  public ApiResponse(boolean success, List data) {
    this.put("success", success);
    this.put("data", data);
  }

  public ApiResponse(boolean success, String message, String information) {
    this.put("success", success);
    this.put("message", message);
    this.put("information", information);
  }

}
