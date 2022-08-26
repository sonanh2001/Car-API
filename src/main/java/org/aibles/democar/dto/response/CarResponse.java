package org.aibles.democar.dto.response;

import org.aibles.democar.entity.Car;

public class CarResponse {
  private long carId;
  private String name;

  private String brand;

  private int wheelsNumber;

  private String color;

  private long price;

  private int publicationDate;

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

  public int getWheelsNumber() {
    return wheelsNumber;
  }

  public void setWheelsNumber(int wheelsNumber) {
    this.wheelsNumber = wheelsNumber;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public long getPrice() {
    return price;
  }

  public void setPrice(long price) {
    this.price = price;
  }

  public int getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(int publicationDate) {
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
