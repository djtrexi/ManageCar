package com.example.demo.response.bill;

public class BillGetIdByIdClientAndIdWorkerResponse {
  private long id;
  
  public BillGetIdByIdClientAndIdWorkerResponse() {}
  
  public BillGetIdByIdClientAndIdWorkerResponse(long id) {
	  this.id = id;
  }
  
  public long getId() {
	  return id;
  }
  
  public void setId(long id) {
	  this.id = id;
  }
}
