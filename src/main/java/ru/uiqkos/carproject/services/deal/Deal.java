package ru.uiqkos.carproject.services.deal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.uiqkos.carproject.services.vehicle.Vehicle;
import ru.uiqkos.carproject.services.salesagent.SalesAgent;
import ru.uiqkos.carproject.services.customer.Customer;
import ru.uiqkos.carproject.services.insurance.Insurance;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Deal {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Integer dealId;
    private @OneToOne Vehicle vehicleId;
    private @OneToOne SalesAgent agentId;
    private @OneToOne Customer customerId;
    private @OneToOne Insurance insuranceId;
    private Date dealDate;
}