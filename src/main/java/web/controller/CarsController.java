package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarsServiceImpl;

@Controller
public class CarsController {
    CarsServiceImpl carsService;

    @Autowired
    public CarsController(CarsServiceImpl carsService) {
        this.carsService = carsService;
    }


    @GetMapping("/cars")
    public String getAllCars(@RequestParam(defaultValue =  "5") int count, Model model){
            model.addAttribute("cars", carsService.getCars(count));
        return "cars";
    }


}
