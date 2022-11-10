package com.example.demo.response.car;

public class GetBrandCarByIdResponse {
  private String brand;
  
  public GetBrandCarByIdResponse() {}
  
  public GetBrandCarByIdResponse(String brand) {
	  this.brand = brand;
  }
  
  public void setBrand(String brand) {
	  this.brand = brand;
  }
  
  public String getBrand() {
	  return brand;
  }
}