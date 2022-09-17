package org.aibles.democar.dto.response;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.aibles.democar.entity.Car;
import org.aibles.democar.validation.ModelValidator;

public class CarResponse extends ModelValidator<CarResponse> {
  @NotNull(message = "carId.NotNull.message")
  private Long carId;
  @NotBlank(message = "name.NotBlank.message")
  @Size(min = 2, max = 128, message = "name.Size.message")
  private String name;

  @NotBlank(message = "brand.NotBlank.message")
  @Size(min = 2, max = 50, message = "brand.size.message")
  private String brand;

  @Min(value = 4, message = "wheelsNumber.Min.message")
  @NotNull(message = "wheelsNumber.NotNull.message")
  private Integer wheelsNumber;

  @NotBlank(message = "color.NotBlank.message")
  @Size(min = 2, max = 20, message = "color.Size.message")
  private String color;

  @NotNull(message = "price.NotNull.message")
  private Long price;

  @NotNull(message = "publicationDate.NotNull.message")
  private Integer publicationDate;

  public CarResponse() {}

  public long getCarId() {
    return carId;
  }

  public void setCarId(long carId) {
    this.carId = carId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Integer getWheelsNumber() {
    return wheelsNumber;
  }

  public void setWheelsNumber(Integer wheelsNumber) {
    this.wheelsNumber = wheelsNumber;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public Long getPrice() {
    return price;
  }

  public void setPrice(Long price) {
    this.price = price;
  }

  public Integer getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(Integer publicationDate) {
    this.publicationDate = publicationDate;
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
