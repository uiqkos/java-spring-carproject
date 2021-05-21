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
    public @ResponseBody List<Vehicle> list() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @DeleteMapping(path = "/{id}/delete")
    public boolean delete(@PathVariable String id) {
        try {
            vehicleRepository.delete(
                vehicleRepository
                    .findById(id)
                    .orElseThrow()
            );
        } catch(Exception e) { return false; }
        return true;
    }

    @PutMapping(path = "/{id}/update")
    public @ResponseBody Vehicle update(@RequestBody Vehicle newVehicle, @PathVariable String id) {
        return vehicleRepository
            .findById(id)
            .map((vehicle) -> {
                vehicle.setMake(newVehicle.getMake());
                vehicle.setBodyType(newVehicle.getBodyType());
                vehicle.setModel(newVehicle.getModel());
                vehicle.setPrice(newVehicle.getPrice());
                vehicle.setModelYear(newVehicle.getModelYear());
                vehicle.setTrafficAccidents(newVehicle.getTrafficAccidents());
                return vehicle;
            })
            .orElseGet(() -> vehicleRepository.save(newVehicle));
    }
}
