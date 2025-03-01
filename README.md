# <div align="center"> JEPs (JDK Enhancement Proposals)  </div>

<br/>

# <div align="center"> 🚧 Em Construção 🚧  </div>

<br/>

## Sobre

JEPs (JDK Enhancement Proposals) são propostas de aprimoramento para o JDK (Java Development Kit). Elas são usadas para sugerir, discutir e documentar mudanças significativas na linguagem Java, na JVM (Java Virtual Machine) ou nas bibliotecas do JDK.

<br/>

#### Como Funcionam as JEPs?

- Elas são criadas para mudanças maiores que não se encaixam como simples correções de bugs ou pequenas melhorias.
- Passam por um processo de revisão e aprovação antes de serem implementadas no JDK.
- Cada JEP possui um número e uma descrição detalhada da proposta.

<br/>

#### JEPs Importantes:

- ``JEP 286`` – Inferência de Tipo para Variáveis Locais (var) (Java 10)
- ``JEP 354`` – Blocos de Texto (""" para strings multilinha) (Java 13)
- ``JEP 394`` – Records (Java 16)
- ``JEP 440`` – Pattern Matching para switch (Java 21)
- ``JEP 378 – Text Blocks (Java 15)``
    - Foi introduzida no Java 15 e fornece uma forma mais simples e legível de lidar com strings multilinha sem precisar usar concatenação manual ou \n.
- ``JEP 394 – Pattern Matching for instanceof (Java 16)``
    - A JEP 394 introduziu um aprimoramento importante para a linguagem Java, permitindo que a verificação do tipo de uma variável usando instanceof seja feita de forma mais concisa e legível.
- ``JEP 356 – Enhanced Pseudo-Random Number Generators``
    - Introduzida no Java 17, a JEP 356 aprimora a API de geração de números pseudoaleatórios em Java, tornando-a mais flexível, extensível e fácil de usar.
- ``JEP 403`` – Strongly Encapsulate JDK Internals (Java 17)
- ``JEP 406`` – Pattern Matching for switch (Java 17)
- ``JEP 409 – Sealed Classes - Final Feature (Java 17)``
    - Introduzida no Java 17, a JEP 409 torna as Sealed Classes uma funcionalidade estável (final feature). Elas foram originalmente propostas na JEP 360 no Java 15 como uma feature experimental.
- ``JEP 413`` – Code Snippets in Java API Documentation (Java 18)
- ``JEP 425`` – Virtual Threads - Preview (Java 19)
- ``JEP 428`` – Structured Concurrency - Incubation (Java 19)
- ``JEP 436`` – Virtual Threads - 2ª Preview (Java 20)
- ``JEP 437`` – Structured Concurrency - 2ª Incubação (Java 20)
- ``JEP 440`` – Pattern Matching for switch - Final Feature (Java 21)
- ``JEP 441 - Pattern Matching for switch``
    - A JEP 441 - Pattern Matching for switch é uma proposta de aprimoramento do Java que visa melhorar o uso do Pattern Matching no contexto do switch, trazendo uma maneira mais concisa, expressiva e poderosa de realizar correspondência de padrões em instruções switch.
- ``JEP 440 – Record Patterns (Java 21)``
    - É uma proposta de aprimoramento da linguagem Java que introduz padrões de correspondência (pattern matching) especificamente para records. O objetivo dessa JEP é tornar a correspondência de padrões mais flexível e concisa ao trabalhar com records, permitindo que você extraia dados de objetos de forma mais expressiva e natural, sem precisar
      acessar explicitamente os componentes do record através de métodos getters ou outros métodos auxiliares.
- ``JEP 444`` – Virtual Threads - Final Feature (Java 21)

<br/>

### Exemplos

### ``JEP 394 – Pattern Matching for instanceof (Java 16)``

#### Antes

```java
public void patternMatchingForInstanceof() {
    if (obj instanceof String) {
        String str = (String) obj;
        System.out.println(str.length());
    }
}
```

#### Depois

```java
public void patternMatchingForInstanceof() {
    if (obj instanceof String str) {
        System.out.println(str.length());
    }
}
```

<br/>

### ``JEP 378 – Text Blocks (Java 15)``

#### Antes

```java
public void textBlocks() {
    String json = "{\n" +
            "  \"nome\": \"João\",\n" +
            "  \"idade\": 30\n" +
            "}";
    System.out.println(json);
}
```

#### Depois

```java
public void textBlocks() {
    String json = """
            {
              "nome": "João",
              "idade": 30
            }
            """;
    System.out.println(json);
}
```

<br/>

### ``JEP 409 – Sealed Classes - Final Feature (Java 17)``

```java
public void SealedClasses() {
    public sealed class Person permits Customer, Supplier, User {
    }

    public final class Supplier extends Person {
    }

    public final class User extends Person {
    }

    public non-sealed class Customer extends Person {
    }
}
```

- A classe Person é selada (sealed), e somente Customer, Supplier e User podem estendê-la.

As Sealed Classes usam a palavra-chave sealed e a cláusula permits para definir quais classes podem estendê-las.
Existem três maneiras de lidar com classes que herdam de uma sealed class:

1. ``final`` → A subclasse não pode ser estendida.
2. ``sealed`` → A subclasse pode ser selada novamente e restringir ainda mais.
3. ``non-sealed`` → Permite que qualquer classe herde dela.

<br/>

### ``JEP 356 – Enhanced Pseudo-Random Number Generators``

A JEP 356 introduz três novas interfaces dentro do pacote java.util.random:

1. ``RandomGenerator``

- Interface principal para todos os geradores de números aleatórios.
- Substitui a antiga java.util.Random.

```java
public void enhancedPseudoRandomNumberGenerators() {
    RandomGenerator generator = RandomGenerator.of("L128X128MixRandom");
    int randomNumber = generator.nextInt(100);
    System.out.println(randomNumber);
}
```

<br/>

2. ``RandomGeneratorFactory``

- Permite criar instâncias de geradores de números aleatórios específicos de forma dinâmica.

```java
public void enhancedPseudoRandomNumberGenerators() {
    RandomGenerator generator = RandomGeneratorFactory
            .of("Xoshiro256PlusPlus")
            .create();
    System.out.println(generator.nextDouble());
}
```

<br/>

3. ``SplittableRandom e JumpableRandom``

- ``SplittableRandom`` → Melhora a geração paralela de números aleatórios.
- ``JumpableRandom`` → Pode "pular" números da sequência para simulações complexas.

```java
public void enhancedPseudoRandomNumberGenerators() {
    RandomGenerator generator = RandomGeneratorFactory.of("L128X256MixRandom").create();
    System.out.println(generator.nextInt());
}
```

Exemplos Comparando Antes x Depois

#### Antes

```java
public void random() {
    Random random = new Random();
    int value = random.nextInt(100);
}
```

#### Depois

```java
public void enhancedPseudoRandomNumberGenerators() {
    RandomGenerator generator = RandomGenerator.of("L64X128MixRandom");
    int value = generator.nextInt(100);
}
```

<br/>

### ``JEP 440 – Record Patterns (Java 21)``

```java
public void recordPatterns() {
    public record Calculator(int x, int y) {
    }

    public class Main {
        public static void main(String[] args) {
            Calculator point = new Calculator(1, 2);

            // Usando Record Pattern
            if (point instanceof Calculator(int x, int y)) {
                System.out.println("Point x: " + x + ", y: " + y);
            }
        }
    }
}
```

Exemplo em um switch (Usando Record Patterns em Switch)

```java
public void recordPatterns() {
    public record Calculator(int x, int y) {
    }
    public record Circle(int radius) {
    }

    public class Main {
        public static void main(String[] args) {
            Object obj = new Calculator(3, 4);

            switch (obj) {
                case Calculator(int x, int y) -> System.out.println("Point: x=" + x + ", y=" + y);
                case Circle(int radius) -> System.out.println("Circle with radius: " + radius);
                default -> System.out.println("Unknown object");
            }
        }
    }
}
```

<br/>

### ``JEP 441 - Pattern Matching for switch``

```java
public void patternMatchingForSwitch() {
    Object obj = new Point(3, 4);

    switch (obj) {
        case Calculator cl -> System.out.println("Calculator with x = " + cl.x() + " and y = " + cl.y());
        case Circle c -> System.out.println("Circle with radius = " + c.radius());
        default -> System.out.println("Unknown shape");
    }
}
```

<br/>