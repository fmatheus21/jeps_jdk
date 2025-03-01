package br.com.fmatheus.app.domain;

public non-sealed class Customer extends Person {
    private final String registration;

    public Customer(String registration) {
        this.registration = registration;
    }

    public String getRegistration() {
        return registration;
    }
}
