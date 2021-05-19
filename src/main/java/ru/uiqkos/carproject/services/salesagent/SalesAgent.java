package ru.uiqkos.carproject.services.salesagent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.uiqkos.carproject.services.deal.Deal;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesAgent {
    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO) Integer agentId;
    private String salesAgentFirstName;
    private String salesAgentLastName;
    private String phoneNumber;
    private String email;
}