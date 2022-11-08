package com.example.addressbookapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class AddressBookDTO {

    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Invalid First Name")
    private String firstName;
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Invalid Last Name")
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    public String phoneNumber;

}
