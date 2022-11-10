package com.example.demo.request.car;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CarCheckVisibilityCarDateRequest {
	private long id;
	private LocalDate dateAvailableStart;
	private LocalDate dateAvailableFinish;

	public CarCheckVisibilityCarDateRequest() {}

	public CarCheckVisibilityCarDateRequest(long id, LocalDate dateAvailableStart, LocalDate dateAvailableFinish) {
		this.id = id;
		this.dateAvailableStart = dateAvailableStart;
		this.dateAvailableFinish = dateAvailableFinish;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getDateAvailableStart() {
		return dateAvailableStart;
	}

	public void setDateAvailableStart(LocalDate dateAvailableStart) {
		this.dateAvailableStart = dateAvailableStart;
	}

	public LocalDate getDateAvailableFinish() {
		return dateAvailableFinish;
	}

	public void setDateAvailableFinish(LocalDate dateAvailableFinish) {
		this.dateAvailableFinish = dateAvailableFinish;
	}

	@JsonIgnore
	public boolean isValid() {
		if(id <= 0) {
			return false;
		}
		else if(dateAvailableStart.isAfter(dateAvailableFinish) || dateAvailableFinish.isBefore(dateAvailableStart)) {
			return false;
		}
		else {
			return true;
		}
	}
}
