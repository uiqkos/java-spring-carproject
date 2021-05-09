package ru.uiqkos.carproject.services.salesagent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesAgent {
    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO) Integer agentId;
    private String customerFirstName;
    private String customerLastName;
    private String phoneNumber;
    private String email;
}