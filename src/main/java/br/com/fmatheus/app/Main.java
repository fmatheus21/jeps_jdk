package br.com.fmatheus.app;

import br.com.fmatheus.app.domain.*;

import java.math.BigDecimal;
import java.util.logging.Logger;
import java.util.random.RandomGenerator;

public class Main {

    static Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        var customer = new Customer("CT6693");
        var supplier = new Supplier("SPP639RJ");

        /*
        enhancedPseudoRandomNumberGenerators();

        sealedClasses(customer);
        sealedClasses(supplier);
        sealedClasses(new User());
        sealedClasses(new Defaulter(customer.getRegistration()));

        textBlocks();

        patternMatchingForInstanceof(customer);
        patternMatchingForInstanceof(supplier);

        patternMatchingForSwitch(supplier);*/

        recordPatterns();
    }

    /**
     * JEP 356 – Enhanced Pseudo-Random Number Generators
     * Introduzida no Java 17, a JEP 356 aprimora a API de geração de números pseudoaleatórios em Java, tornando-a mais flexível, extensível e fácil de usar.
     */
    private static void enhancedPseudoRandomNumberGenerators() {
        var random = RandomGenerator.of("Xoshiro256PlusPlus");
        var value = random.nextInt(1, 100);
        logger.info("Número Pseudo-aleatorio: " + value);
    }

    /**
     * JEP 409 – Sealed Classes (Final Feature)
     * Introduzida no Java 17, a JEP 409 torna as Sealed Classes uma funcionalidade estável (final feature).
     * Elas foram originalmente propostas na JEP 360 no Java 15 como uma feature experimental.
     *
     * @param person Person
     */
    private static void sealedClasses(Person person) {
        switch (person) {
            case Defaulter d -> logger.info("Este e um cliente inadimplente.");
            case Customer c -> logger.info("Este e um cliente.");
            case Supplier s -> logger.info("Este e um fornecedor");
            case User u -> logger.info("Este e um usuario");
        }
    }

    /**
     * JEP 378 – Text Blocks
     * Foi introduzida no Java 15 e fornece uma forma mais simples e legível de lidar com strings multilinha sem precisar usar concatenação manual ou \n.
     */
    private static void textBlocks() {
        //Antes
        String json = "{\n" +
                "  \"nome\": \"João\",\n" +
                "  \"idade\": 30\n" +
                "}";
        logger.info(json);

        //Depois
        String textBlocks = """
                {
                  "nome": "João",
                  "idade": 30
                }
                """;
        logger.info(textBlocks);
    }

    /**
     * JEP 394 – Pattern Matching for instanceof
     * A JEP 394 introduziu um aprimoramento importante para a linguagem Java, permitindo que a verificação do tipo de uma variável usando instanceof seja feita de forma mais concisa e legível.
     */
    private static void patternMatchingForInstanceof(Object object) {

        //Antes
        if (object instanceof Customer) {
            Customer c = (Customer) object;
            logger.info("Registro do cliente: " + c.getRegistration());
        } else if (object instanceof Supplier) {
            Supplier s = (Supplier) object;
            logger.info("Identificação do fornecedor" + s.getIdentifier());
        }

        //Depois
        if (object instanceof Customer c) {
            logger.info("Registro do cliente: " + c.getRegistration());
        } else if (object instanceof Supplier s) {
            logger.info("Identificação do fornecedor" + s.getIdentifier());
        }

    }

    /**
     * JEP 441 - Pattern Matching for switch
     * A JEP 441 - Pattern Matching for switch é uma proposta de aprimoramento do Java que visa melhorar o uso do Pattern Matching
     * no contexto do switch, trazendo uma maneira mais concisa, expressiva e poderosa de realizar correspondência de padrões em instruções switch.
     */
    private static void patternMatchingForSwitch(Object object) {
        switch (object) {
            case Customer c -> logger.info("Registro do cliente: " + c.getRegistration());
            case Supplier s -> logger.info("Identificação do fornecedor: " + s.getIdentifier());
            default -> logger.info("Nenhuma instancia encontrada.");
        }
    }

    /**
     * JEP 440 – Record Patterns
     * Record Patterns é uma proposta de aprimoramento da linguagem Java que introduz padrões de correspondência (pattern matching)
     * especificamente para records. O objetivo dessa JEP é tornar a correspondência de padrões mais flexível e concisa ao trabalhar
     * com records, permitindo que você extraia dados de objetos de forma mais expressiva e natural, sem precisar acessar explicitamente
     * os componentes do record através de métodos getters ou outros métodos auxiliares.
     */
    private static void recordPatterns() {
        var payment = new Payment("TV Samsung 65", new BigDecimal("6347.90"));
        logger.info("Pruduto: " + payment.product() + " - Valor: " + payment.value());
    }
}