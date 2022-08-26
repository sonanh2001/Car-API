package org.aibles.democar.dto.response;

import org.aibles.democar.dto.request.CreateCarRequest;
import org.aibles.democar.entity.Car;

public class CarResponse extends CreateCarRequest {
  private long carId;

  public CarResponse() {
    super();
  }

  public long getCarId() {
    return carId;
  }

  public void setCarId(long carId) {
    this.carId = carId;
  }

  public static CarResponse from(Car car) {
    CarResponse response = new CarResponse();
    response.setCarId(car.getCarId());
    response.setBrand(car.getBrand());
    response.setColor(car.getColor());
    response.setName(car.getName());
    response.setPrice(car.getPrice());
    response.setPublicationDate(car.getPublicationDate());
    response.setWheelsNumber(car.getWheelsNumber());
    return response;
  }
}
