package com.example.appapi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NotNull(message = "Full name can not be empty")
    private String fullName;

    @NotNull(message = "Phone number can not be empty")
    private Integer phoneNumber;

    @NotNull(message = "Address can not be empty")
    private String address;
}
