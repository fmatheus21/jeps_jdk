package br.com.fmatheus.app.domain;

public final class Supplier extends Person {
    private final String identifier;

    public Supplier(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }
}
