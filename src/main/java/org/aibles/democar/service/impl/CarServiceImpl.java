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
    return CarResponse.from(repository.save(request.toCar()));
  }

  @Override
  @Transactional
  public void deleteById(long id) {
    log.info("(deleteById)id : {}", id);
    if(repository.existsById(id)) {
      repository.deleteById(id);
    } else {
      throw new CarNotFoundException(id);
    }
  }

  @Override
  @Transactional
  public List<CarResponse> list() {
    log.info("(list)");
    return repository.findAll().stream().map(CarResponse::from).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public CarResponse getById(long id) {
    log.info("(getById)id : {}", id);
    Car car = repository.findById(id).orElseThrow(() -> new CarNotFoundException(id));
    return CarResponse.from(car);
  }

  @Override
  @Transactional
  public CarResponse update(UpdateCarRequest request, long id) {
    log.info("(update)id : {}, name: {}", id, request.getName());
    Car car =
        repository
            .findById(id)
            .map(request::toCar)
            .orElseThrow(() -> new CarNotFoundException(id));
    return CarResponse.from(repository.save(car));
  }
}
