package org.aibles.democar.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.aibles.democar.validation.ModelValidator;

@Entity
@Table(name = "car")
public class Car extends ModelValidator<Car> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long carId;

  @Column(nullable = false, length = 128)
  @NotBlank(message = "name.NotBlank.message")
  @Size(min = 2, max = 128, message = "name.Size.message")
  private String name;

  @Column(nullable = false, length = 50)
  @NotBlank(message = "brand.NotBlank.message")
  @Size(min = 2, max = 50, message = "brand.size.message")
  private String brand;

  @Column(nullable = false)
  @Min(value = 4, message = "wheelsNumber.Min.message")
  @NotNull(message = "wheelsNumber.NotNull.message")
  private Integer wheelsNumber;

  @Column(nullable = false, length = 20)
  @NotBlank(message = "color.NotBlank.message")
  @Size(min = 2, max = 20, message = "color.Size.message")
  private String color;

  @Column(nullable = false)
  @NotNull(message = "price.NotNull.message")
  private Long price;

  @Column(nullable = false)
  @NotNull(message = "publicationDate.NotNull.message")
  private Integer publicationDate;

  public Long getCarId() {
    return carId;
  }

  public void setCarId(Long carId) {
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
}
