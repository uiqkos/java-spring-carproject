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

    @DeleteMapping(path = "/{id}/delete")
    public boolean delete(@PathVariable String id) {
        try {
            trafficAccidentRepository.delete(
                trafficAccidentRepository
                    .findById(id)
                    .orElseThrow()
            );
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @PutMapping(path = "/{id}/update")
    public @ResponseBody
    TrafficAccident update(@RequestBody TrafficAccident newTrafficAccident, @PathVariable String id) {
        return trafficAccidentRepository
            .findById(id)
            .map((trafficAccident) -> {
                trafficAccident.setDate(newTrafficAccident.getDate());
                trafficAccident.setMessage(newTrafficAccident.getMessage());
                trafficAccident.setVehicle(newTrafficAccident.getVehicle());
                return trafficAccident;
            })
            .orElseGet(() -> trafficAccidentRepository.save(newTrafficAccident));
    }
}
