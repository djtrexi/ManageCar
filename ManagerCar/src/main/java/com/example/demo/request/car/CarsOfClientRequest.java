package com.example.demo.request.car;

public class CarsOfClientRequest {
  private long id;
  
  public CarsOfClientRequest() {}
  
  public CarsOfClientRequest(long id) {
	  this.id = id;
  }
  
  public void setId(long id) {
	  this.id = id;
  }
  
  public long getId() {
	  return id;
  }
}