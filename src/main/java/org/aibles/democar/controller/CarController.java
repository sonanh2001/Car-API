package org.aibles.democar.controller;

import static org.aibles.democar.constants.ApiConstants.CARS_API_URI;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.democar.dto.request.CreateCarRequest;
import org.aibles.democar.dto.request.UpdateCarRequest;
import org.aibles.democar.dto.response.CarResponse;
import org.aibles.democar.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CARS_API_URI)
@Slf4j
public class CarController {
  private final CarService service;

  public CarController(CarService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CarResponse create(@RequestBody @Valid CreateCarRequest request) {
    log.info("(create)name : {}", request.getName());
    return service.create(request);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public String deleteById(@PathVariable long id) {
    log.info("(deleteById)id : {}", id);
    service.deleteById(id);
    return "Delete car successfully";
  }

  @GetMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public CarResponse getById(@PathVariable long id) {
    log.info("(getById)id : {}", id);
    return service.getById(id);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<CarResponse> list() {
    log.info("(list)");
    return service.list();
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public CarResponse update(@PathVariable long id, @RequestBody @Valid UpdateCarRequest request) {
    log.info("(update)name : {}, id : {}", request.getName(), id);
    return service.update(request, id);
  }
}
