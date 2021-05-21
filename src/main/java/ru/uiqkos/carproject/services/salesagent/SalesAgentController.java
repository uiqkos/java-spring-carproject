package ru.uiqkos.carproject.services.salesagent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    SalesAgent createSalesAgent(@RequestBody SalesAgent salesAgent) {
        return salesAgentRepository.save(salesAgent);
    }

    @GetMapping(path = "/list")
    public  @ResponseBody List<SalesAgent> list() {
        return (List<SalesAgent>) salesAgentRepository.findAll();
    }

    @DeleteMapping(path = "/{id}/delete")
    public boolean delete(@PathVariable String id) {
        try {
            salesAgentRepository.delete(
                salesAgentRepository
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
    SalesAgent update(@RequestBody SalesAgent newSalesAgent, @PathVariable String id) {
        return salesAgentRepository
            .findById(id)
            .map((salesAgent) -> {
                salesAgent.setAgentId(newSalesAgent.getAgentId());
                salesAgent.setEmail(newSalesAgent.getEmail());
                salesAgent.setSalesAgentFirstName(newSalesAgent.getSalesAgentFirstName());
                salesAgent.setSalesAgentLastName(newSalesAgent.getSalesAgentLastName());
                salesAgent.setPhoneNumber(newSalesAgent.getPhoneNumber());
                return salesAgent;
            })
            .orElseGet(() -> salesAgentRepository.save(newSalesAgent));
    }
}
