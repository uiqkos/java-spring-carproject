package ru.uiqkos.carproject.services.insurance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.uiqkos.carproject.services.insurance.Insurance;

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


    @DeleteMapping(path = "/{id}/delete")
    public boolean delete(@PathVariable String id) {
        try {
            insuranceRepository.delete(
                insuranceRepository
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
    Insurance update(@RequestBody Insurance newInsurance, @PathVariable String id) {
        return insuranceRepository
            .findById(id)
            .map((insurance) -> {
                insurance.setPolicyType(newInsurance.getPolicyType());
                insurance.setRenewalDate(newInsurance.getRenewalDate());
                return insurance;
            })
            .orElseGet(() -> insuranceRepository.save(newInsurance));
    }
}
