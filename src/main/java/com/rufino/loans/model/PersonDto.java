package com.rufino.loans.model;

import java.math.BigDecimal;

public record PersonDto(int age, String name, String cpf, BigDecimal income, String location) {

}
