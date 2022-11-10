package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.model.Bill;
import com.example.demo.model.Car;
import com.example.demo.model.Client;
import com.example.demo.model.Door;
import com.example.demo.model.Worker;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.CarRepository;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.DoorRepository;
import com.example.demo.repository.WorkerRepository;

@Service
@Component
public class CarService {
	@Autowired
	CarRepository cr;

	@Autowired
	ClientRepository crl;

	@Autowired
	WorkerRepository wr;

	@Autowired
	DoorRepository dr;

	@Autowired
	BillRepository br;

	public boolean rentalCar(long idCar, long idClient, LocalDate dataBegin, LocalDate dataFinish) {
		try {
			if(crl.getReferenceById(idClient) == null) {
				return false;
			}
			else {
				if(cr.getCarById(idCar) == null) {
					return false;
				}
				else {
					Car car = cr.getCarById(idCar);
					if(car.getDateAvalableFinish().isBefore(dataBegin) || car.getDateAvalableFinish().isBefore(dataFinish)) {
						return false;
					}
					else {
						car.setDateRentalStart(dataBegin);
						car.setDateRentalFinish(dataFinish);
						car.setAvailable(false);
						car.setRental(true);
						Client c = crl.getReferenceById(idClient);
						car.setClient(c);
						cr.save(car);
						return true;
					}
				}
			}
		} catch(Exception e) {
			return false;
		}
	}

	public boolean addCar(long idWorker, Car c) {
		try {
			if(c.getDateAvalableStart().isEqual(LocalDate.now())) {
				c.setAvailable(true);
				c.setRental(false);
			}
			else {
				c.setAvailable(false);
				c.setRental(false);
			}
			Worker w = wr.getReferenceById(idWorker);
			c.setWorker(w);

			cr.save(c);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public Car getCarById(long id) {
		try {
			if(cr.getCarById(id) == null) {
				return null;
			}
			else {
				return cr.getCarById(id);
			}
		} catch(Exception e) {
			return null;
		}
	}

	public Boolean changeVisibilityCar(long id) {
		try {
			if(cr.existsById(id)) {
				Car car = cr.getReferenceById(id);
				if(car.isRental()) {
					return null;
				}
				else {
					car.setDateAvalableStart(null);
					car.setDateAvalableFinish(null);
					car.setAvailable(false);
					cr.save(car);
					return true;
				}
			}
			else {
				return null;
			}
		} catch(Exception e) {
			return null;
		}
	}

	public Boolean checkVisibilityCarDate(long id, LocalDate dateAvailableStart, LocalDate dateAvailableFinish) {
		try {
			if(cr.existsById(id)) {
				Car car = cr.getReferenceById(id);
				if(car.isRental()) {
					return null;
				}
				else {
					car.setDateAvalableStart(dateAvailableStart);
					car.setDateAvalableFinish(dateAvailableFinish);
					if(car.getDateAvalableStart().equals(LocalDate.now())) {
						car.setAvailable(true);
					}
					else {
						car.setAvailable(false);
					}
					cr.save(car);
					return true;
				}

			}
			else {
				return null;
			}
		} catch(Exception e) {
			return null;
		}
	}

	public Boolean deleteCar(long id) {
		try {
			if(cr.existsById(id)) {
				Car car = cr.getReferenceById(id);
				if(car.getClient() != null) {
					return null;
				}
				else {
					car.setAvailable(false);
					car.setDateRentalStart(null);
					car.setDateRentalFinish(null);
					car.setDateAvalableStart(null);
					car.setDateAvalableFinish(null);
					cr.save(car);
					return true;
				}
			}
			else {
				return false;
			}
		} catch(Exception e) {
			return false;
		}
	}

	public Boolean updatePayment(long id, double totalMoneyRental, boolean typePay) {
		try {
			if(cr.getReferenceById(id) == null) {
				return null;
			}
			else {
				List<Worker> workers = new ArrayList<>();
				workers = wr.searchWorkerFree();
				if(workers == null) {
					return null;
				}
				else {
					Worker worker = workers.get(0);
					long idClient = cr.getIdClientByCarRentalId(id);
					Client c = crl.getReferenceById(idClient);
					if(c == null) {
						return null;
					}
					else {
						Car car = cr.getReferenceById(id);
						List<Door> doors = dr.getDoorAvailable();
						if(doors == null) {
							return null;
						}
						else {
							Door d = doors.get(0);
							if(!typePay) {
								Bill bCart = new Bill(totalMoneyRental, typePay, workers.get(0), c, car);
								bCart.setPay(true);
								bCart.setDone(true);
								br.save(bCart);
								return true;
							}
							else {
								worker.setDoor(d);
								c.setDoor(d);
								Bill bCash = new Bill(totalMoneyRental, typePay, workers.get(0), c, car);
								bCash.setDone(false);
								bCash.setPay(false);
								br.save(bCash);
								crl.save(c);
								wr.save(worker);
								return false;
							}
						}
					}
				}
			}
		} catch(Exception e) {
			return null;
		}
	}

	public List<Car> viewAllCar(){
		return cr.viewAllCar();
	}

	public List<Car> viewAllCarRental(){
		return cr.viewAllCarRental();
	}

	public List<Car> viewAllCarAvailable(){
		return cr.viewAllCarAvailable();
	}

	public List<Car> viewCarForTheRental(){
		return cr.viewCarForTheRental();
	}

	public List<Car> viewCarOfWorker(long id){
		try {
			if(wr.getReferenceById(id) == null) {
				return null;
			}
			else {
				return cr.viewCarOfWorker(id);
			}
		} catch (Exception e) {
			return null;
		}
	}

	public List<Car> viewCarsOfClient(long id){
		try {
			if(crl.getReferenceById(id) == null) {
				return null;
			}
			else {
				return cr.viewCarsOfClient(id);
			}
		}
		catch(Exception e) {
			return null;
		}
	}

	public int countTotCarAvailable() {
		try {
			return cr.countTotCarAvailable();
		} catch(Exception e) {
			return -1;
		}
	}

	public String getBrandCarById(long id) {
		try {
			return cr.getBrandCarById(id);
		} catch(Exception e) {
			return null;
		}
	}

	//da errore questo service
	public long getIdWorkerByCarId(long id) {
		//try {
		System.out.println(cr.getIdWorkerByCarId(id));
		return cr.getIdWorkerByCarId(id);
		/*} catch(Exception e) {
			return 0;
		}*/
	}

	public Boolean getIsRentalById(long id) {
		try {
			return cr.getIsRentalById(id);
		} catch(Exception e) {
			return null;
		}
	}

	public int countTotCarRentalByIdClient(long id) {
		try {
			return cr.countTotCarRentalByIdClient(id);
		} catch(Exception e) {
			return -1;
		}
	}

	public int differenceDate(long id) {
		try {
			if(cr.existsById(id)) {
				Car car = cr.getReferenceById(id);
				if(car == null) {
					return -1;
				}
				else {
					int totDifferenceDate = car.getDateRentalFinish().compareTo(car.getDateRentalStart());
					return totDifferenceDate;
				}
			}
			else {
				return -1;
			}
		} catch(Exception e) {
			return -1;
		}
	}

	public double moneyDailyById(long id) {
		try {
			return cr.moneyDailyById(id);
		} catch(Exception e) {
			return -1;
		}
	}

	public String getDateAvalableStartById(long id) {
		try {
			return cr.getDateAvalableStartById(id);
		} catch(Exception e) {
			return null;
		}
	}

	public String getdateAvalableFinishById(long id) {
		try {
			return cr.getdateAvalableFinishById(id);
		} catch(Exception e) {
			return null;
		}
	}
}