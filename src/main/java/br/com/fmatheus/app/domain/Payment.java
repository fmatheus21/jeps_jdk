package br.com.fmatheus.app.domain;

import java.math.BigDecimal;

public record Payment(String product, BigDecimal value) {
}
