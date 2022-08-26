package org.aibles.democar.dto.request;

import org.aibles.democar.entity.Car;

public class UpdateCarRequest extends CreateCarRequest {

  private long carId;

  public UpdateCarRequest() {
    super();
  }

  public long getCarId() {
    return carId;
  }

  public void setCarId(long carId) {
    this.carId = carId;
  }

  public Car toEntity(Car car) {
    Car carUpdated = super.toEntity();
    carUpdated.setCarId(car.getCarId());
    return carUpdated;
  }
}
