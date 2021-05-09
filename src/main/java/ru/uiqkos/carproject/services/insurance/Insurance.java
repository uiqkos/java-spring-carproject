package ru.uiqkos.carproject.services.insurance;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {
    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Integer insuranceId;
    private String policyType;
    private Date renewalDate;
}
