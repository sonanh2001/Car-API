package org.aibles.democar.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aibles.democar.dto.request.CreateCarRequest;
import org.aibles.democar.dto.request.UpdateCarRequest;
import org.aibles.democar.dto.response.CarResponse;
import org.aibles.democar.entity.Car;
import org.aibles.democar.exception.CarNotFoundException;
import org.aibles.democar.repository.CarRepository;
import org.aibles.democar.service.CarService;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
public class CarServiceImpl implements CarService {

  private final CarRepository repository;

  public CarServiceImpl(CarRepository repository) {
    this.repository = repository;
  }

  @Override
  @Transactional
  public CarResponse create(CreateCarRequest request) {
    log.info("(create)name : {}", request.getName());
    Car car = request.toCar();
    car.isValid();
    CarResponse response = CarResponse.from(repository.save(car));
    response.isValid();
    return response;
  }

  @Override
  @Transactional
  public void deleteById(long id) {
    log.info("(deleteById)id : {}", id);
    if (repository.existsById(id)) {
      repository.deleteById(id);
    } else {
      throw new CarNotFoundException(id);
    }
  }

  @Override
  @Transactional
  public List<CarResponse> list() {
    log.info("(list)");
    return repository.findAll().stream()
        .map(
            (entity) -> {
              CarResponse response = CarResponse.from(entity);
              response.isValid();
              return response;
            })
        .collect(Collectors.toList());
  }

  @Override
  @Transactional
  public CarResponse getById(long id) {
    log.info("(getById)id : {}", id);
    return repository
        .findById(id)
        .map(
            (entity) -> {
              CarResponse response = CarResponse.from(entity);
              response.isValid();
              return response;
            })
        .orElseThrow(() -> new CarNotFoundException(id));
  }

  @Override
  @Transactional
  public CarResponse update(UpdateCarRequest request, long id) {
    log.info("(update)name : {}, id: {}", request.getName(), id);
    Car car =
        repository.findById(id).map(request::toCar).orElseThrow(() -> new CarNotFoundException(id));
    car.isValid();
    CarResponse response = CarResponse.from(repository.save(car));
    response.isValid();
    return response;
  }
}
