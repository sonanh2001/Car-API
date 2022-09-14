package org.aibles.democar.dto.request;

import javax.validation.constraints.NotNull;
import org.aibles.democar.entity.Car;

public class UpdateCarRequest extends CreateCarRequest {

  @NotNull(message = "carId.NotNull.message")
  private Long carId;

  public UpdateCarRequest() {
    super();
  }

  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
    this.carId = carId;
  }

  public Car toCar(Car car) {
    Car carUpdated = super.toCar();
    carUpdated.setCarId(car.getCarId());
    return carUpdated;
  }
}
