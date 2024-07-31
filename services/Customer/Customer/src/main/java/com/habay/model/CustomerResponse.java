package com.habay.model;

public record CustomerResponse (

        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {

        }


