package com.example.carServiceUser;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("/")
    public Car chercherVpiture(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/jpa/cars";

        HttpHeaders myHeader = new HttpHeaders();


        myHeader.add("User-Agent", "Spring's RestTemplate" );
        myHeader.add("Content-Type", "application/json");
        //myHeader.set("Authorization","Bearer "+response.getBody());
        HttpEntity<String> request = new HttpEntity<>(myHeader);
        ResponseEntity<Car[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, request, Car[].class);
        List<Car> cars = Arrays.asList(responseEntity.getBody());
        Car car = null;
        if(cars.size() > 0){
            car = cars.get(0);
            String plaque = car.getPlaque();
            url = "http://localhost:8080/jpa/cars/" + plaque;
            ResponseEntity<Car> entityCar = restTemplate.getForEntity(url, Car.class);
            car = entityCar.getBody();
        }
        return car;

        /*ResponseEntity<List<Car>>  entity = restTemplate.getForEntity(url, new ParameterizedTypeReference<List<Car>>());
        Iterator<Car> cars = entity.iterator();
        Car car = null;
        if(cars.hasNext()){
            car = cars.next();
            String plaque = car.getPlaque();
            url = "http://localhost:8080/jpa/cars/" + plaque;
            ResponseEntity<Car> entityCar = restTemplate.getForEntity(url, Car.class);
            car = entityCar.getBody();
        }
        return car;*/
    }
}
