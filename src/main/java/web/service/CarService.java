package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService implements CarServiceInterface {
    private static final List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("mitsubishi", "red", 2025));
        cars.add(new Car("mercedes", "blue", 2015));
        cars.add(new Car("audi", "grey", 2022));
        cars.add(new Car("kia", "green", 2024));
        cars.add(new Car("bmw", "white", 2020));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("count < 0");
        }
        if (count >= cars.size()) {
            return cars;
        }
        return cars.subList(0, count);
    }
}
