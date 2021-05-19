package ru.uiqkos.carproject.services.deal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public  @ResponseBody
    List<Deal> list() {
        return (List<Deal>) dealRepository.findAll();
    }
}
