package ru.uiqkos.carproject.services.deal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.uiqkos.carproject.services.deal.Deal;

import java.util.List;

@Controller
@RequestMapping(path = "/deal")
public class DealController {
    private final DealRepository dealRepository;

    public DealController(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    @PostMapping(path = "/add")
    public @ResponseBody
    Deal createDeal(@RequestBody Deal deal) {
        return dealRepository.save(deal);
    }

    @GetMapping(path = "/list")
    public @ResponseBody
    List<Deal> list() {
        return (List<Deal>) dealRepository.findAll();
    }

    @DeleteMapping(path = "/{id}/delete")
    public boolean delete(@PathVariable String id) {
        try {
            dealRepository.delete(
                dealRepository
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
    Deal update(@RequestBody Deal newDeal, @PathVariable String id) {
        return dealRepository
            .findById(id)
            .map((deal) -> {
                deal.setDealDate(newDeal.getDealDate());
                deal.setAgentId(newDeal.getAgentId());
                deal.setCustomerId(newDeal.getCustomerId());
                deal.setInsuranceId(newDeal.getInsuranceId());
                deal.setVehicleId(newDeal.getVehicleId());
                return deal;
            })
            .orElseGet(() -> dealRepository.save(newDeal));
    }
}
