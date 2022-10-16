package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public String getAllCars(@RequestParam(defaultValue =  "count") String count, Model model){
        if(count.equals("count")){
            model.addAttribute("cars", carsService.getCars(5));
            return "cars";
        }else{
            int result = Integer.parseInt(count);
            model.addAttribute("cars", carsService.getCars(result));
            return "cars";
        }
    }


}
