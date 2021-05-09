package ru.uiqkos.carproject.services.vehicle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
//import ru.uiqkos.carproject.services.Repositories.*;

import java.util.List;

@Controller
@RequestMapping(path = "/vehicle")
public class VehicleController {
    private final VehicleRepository vehicleRepository;

    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @GetMapping(path = "/list")
    public  @ResponseBody List<Vehicle> list() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }
}
