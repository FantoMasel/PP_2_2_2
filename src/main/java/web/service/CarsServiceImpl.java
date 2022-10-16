package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarsServiceImpl {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Tesla", 300, 2019));
        cars.add(new Car("VAZ", 99, 1997));
        cars.add(new Car("Mazda", 127, 2006));
        cars.add(new Car("Honda", 199, 2015));
        cars.add(new Car("Lada", 110, 2022));
    }

    public List<Car> getCars(int count){
        if(count>=5 || count <=0){
            return  this.cars;
        }
        return cars.stream().limit(count).toList();
    }

}
