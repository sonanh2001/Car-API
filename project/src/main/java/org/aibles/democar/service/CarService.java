package org.aibles.democar.service;

import java.util.List;
import org.aibles.democar.dto.request.CreateCarRequest;
import org.aibles.democar.dto.request.UpdateCarRequest;
import org.aibles.democar.dto.response.CarResponse;

public interface CarService {

  /**
   * create a car
   *
   * @param request request from client
   * @return a response of created car
   */
  CarResponse create(CreateCarRequest request);

  /**
   * delete a car by id
   *
   * @param id - a request id of a car from client
   */
  void deleteById(long id);

  /**
   * list all of cars
   *
   * @return a list of all cars for client
   */
  List<CarResponse> list();

  /**
   * get a car by id
   *
   * @param id - a request id of car from client
   * @return a car from the request of client
   */
  CarResponse getById(long id);

  /**
   * update a car by id
   *
   * @param request - a request from client
   * @param id - a request id of car from client
   * @return a response of updated car
   */
  CarResponse update(UpdateCarRequest request, long id);
}
