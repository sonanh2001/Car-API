package org.aibles.democar.dto.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.aibles.democar.entity.Car;

public class CreateCarRequest {

  @NotBlank(message = "name must not blank")
  @Size(min = 2, max = 128, message = "length of name must between 2 and 128")
  private String name;

  @NotBlank(message = "brand must not blank")
  @Size(min = 2, max = 50, message = "length of brand must between 2 and 50")
  private String brand;

  @Min(value = 4, message = "a car must have more than 3 wheels")
  @NotNull(message = "a car must have wheel numbers")
  private int wheelsNumber;

  @NotBlank(message = "a car must have a color")
  @Size(min = 2, max = 20, message = "length of color must between 2 and 20")
  private String color;

  @NotNull(message = "a car must have a price")
  private long price;

  @NotNull(message = "a car must have a publication date")
  private int publicationDate;

  public CreateCarRequest() {}

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

  public Car toEntity() {
    Car car = new Car();
    car.setBrand(this.getBrand());
    car.setColor(this.getColor());
    car.setName(this.getName());
    car.setPrice(this.getPrice());
    car.setPublicationDate(this.getPublicationDate());
    car.setWheelsNumber(this.getWheelsNumber());
    return car;
  }
}
