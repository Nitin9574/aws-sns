package com.qualigy.sns.model;


import lombok.Data;

import java.util.Date;

@Data
public class UserPayloadRequest {

    private int id;
    private String firstName;
    private String lastName;
    private double salary;
    private Date dob;
    private Address address;

}
