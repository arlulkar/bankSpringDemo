package com.example.bank.dto;

import jakarta.persistence.Column;
import lombok.*;
import org.springframework.http.HttpStatusCode;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountDto {

    private int id;
    private String accountHolderName;
    private double balance;
}
