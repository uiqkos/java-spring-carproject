package ru.uiqkos.carproject.services.insurance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/insurance")
public class InsuranceController {
    private final InsuranceRepository insuranceRepository;

    public InsuranceController(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    Insurance createInsurance(@RequestBody Insurance insurance) {
        return insuranceRepository.save(insurance);
    }

    @GetMapping(path = "/list")
    public  @ResponseBody
    List<Insurance> list() {
        return (List<Insurance>) insuranceRepository.findAll();
    }
}
