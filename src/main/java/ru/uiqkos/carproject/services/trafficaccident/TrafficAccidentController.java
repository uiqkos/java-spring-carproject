package ru.uiqkos.carproject.services.trafficaccident;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/trafficAccident")
public class TrafficAccidentController {
    private final TrafficAccidentRepository trafficAccidentRepository;

    public TrafficAccidentController(TrafficAccidentRepository trafficAccidentRepository) {
        this.trafficAccidentRepository = trafficAccidentRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    TrafficAccident createTrafficAccident(@RequestBody TrafficAccident trafficAccident) {
        return trafficAccidentRepository.save(trafficAccident);
    }

    @GetMapping(path = "/list")
    public @ResponseBody List<TrafficAccident> list() {
        return (List<TrafficAccident>) trafficAccidentRepository.findAll();
    }
}
