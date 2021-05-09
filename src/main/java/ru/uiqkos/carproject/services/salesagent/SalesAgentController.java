package ru.uiqkos.carproject.services.salesagent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.uiqkos.carproject.services.vehicle.Vehicle;
import ru.uiqkos.carproject.services.vehicle.VehicleRepository;

import java.util.List;

@Controller
@RequestMapping(path = "/salesagent")
public class SalesAgentController {
    private final SalesAgentRepository salesAgentRepository;

    public SalesAgentController(SalesAgentRepository salesAgentRepository) {
        this.salesAgentRepository = salesAgentRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    SalesAgent createVehicle(@RequestBody SalesAgent salesAgent) {
        return salesAgentRepository.save(salesAgent);
    }

    @GetMapping(path = "/list")
    public  @ResponseBody List<SalesAgent> list() {
        return (List<SalesAgent>) salesAgentRepository.findAll();
    }
}
