# Atividade — Padrão Abstract Factory

**Disciplina:** Design de Software  
**Atividade:** Padrão Abstract Factory  
**Data de entrega:** 13/08/2026

## Aluno(s)

- Nome do aluno

---

## Sobre a atividade

Esta atividade demonstra a utilização do padrão de projeto **Abstract Factory** em um ambiente escolar.

O projeto possui famílias de objetos relacionadas a diferentes tipos de escola:

- Escola Pública
- Escola Privada
- Escola Técnica
- Escola EAD (desafio opcional)

Cada família possui:

- Professor
- Material Didático
- Avaliação

O objetivo do padrão é garantir que os objetos criados por uma fábrica pertençam à mesma família e sejam compatíveis entre si.

---

# Pergunta 1

### O que muda na saída quando você escolhe Escola Pública ou Escola Privada?

A saída muda de acordo com a fábrica escolhida.

Quando é selecionada a **Escola Pública**, a `EscolaPublicaFactory` cria um professor, um material didático e uma avaliação específicos da escola pública.

Quando é selecionada a **Escola Privada**, a `EscolaPrivadaFactory` cria os produtos correspondentes à escola privada.

Assim, cada escolha produz comportamentos e mensagens diferentes, mas a `SalaDeAula` continua utilizando as mesmas interfaces.

---

# Pergunta 2

### Por que usar `MaterialEscolaPrivada` dentro de `EscolaTecnicaFactory` não é adequado?

Porque isso mistura produtos de famílias diferentes.

A `EscolaTecnicaFactory` deve criar exclusivamente produtos pertencentes à família **Escola Técnica**. Se ela criar um `MaterialEscolaPrivada`, teremos um professor e uma avaliação da escola técnica, mas um material da escola privada.

Isso quebra a principal ideia do Abstract Factory: **manter os produtos relacionados de uma mesma família juntos e compatíveis**.

---

# Pergunta 3

### O programa compila?

Sim. O programa **pode compilar normalmente**, desde que `MaterialEscolaPrivada` implemente a interface `MaterialDidatico`.

O método possui o retorno:

```java
public MaterialDidatico criarMaterialDidatico()
```

Como `MaterialEscolaPrivada` é um tipo de `MaterialDidatico`, o Java aceita o retorno.

O problema é principalmente de **projeto/design**, e não de compilação. O código está tecnicamente válido, mas a fábrica está criando um produto pertencente à família errada.

---

# Pergunta 4

### Como corrigir?

O método deve retornar `MaterialEscolaTecnica`:

```java
@Override
public MaterialDidatico criarMaterialDidatico() {
    return new MaterialEscolaTecnica();
}
```

Dessa forma, todos os produtos criados pela `EscolaTecnicaFactory` pertencem à família Escola Técnica.

---

# Parte 6 — Identifique os elementos do padrão

| Elemento | Classe no projeto |
|---|---|
| Abstract Factory | `EscolaFactory` |
| Concrete Factory da escola pública | `EscolaPublicaFactory` |
| Concrete Factory da escola privada | `EscolaPrivadaFactory` |
| Concrete Factory da escola técnica | `EscolaTecnicaFactory` |
| Abstract Product Professor | `Professor` |
| Abstract Product Material | `MaterialDidatico` |
| Abstract Product Avaliação | `Avaliacao` |
| Cliente que utiliza a fábrica | `SalaDeAula` |

---

# Pergunta 5

### Qual é a função da interface `EscolaFactory`?

A interface `EscolaFactory` define o contrato que todas as fábricas de escolas devem seguir.

Ela determina os métodos necessários para criar:

- `Professor`
- `MaterialDidatico`
- `Avaliacao`

Dessa forma, cada fábrica concreta implementa esses métodos e cria os produtos específicos de sua família.

---

# Pergunta 6

### Qual é a diferença entre `EscolaFactory` e `EscolaTecnicaFactory`?

`EscolaFactory` é uma **interface** e representa a Abstract Factory. Ela define quais tipos de produtos podem ser criados, mas não define quais classes concretas serão utilizadas.

`EscolaTecnicaFactory` é uma **Concrete Factory**. Ela implementa `EscolaFactory` e sabe exatamente quais classes criar:

- `ProfessorEscolaTecnica`
- `MaterialEscolaTecnica`
- `AvaliacaoEscolaTecnica`

---

# Pergunta 7

### Por que `SalaDeAula` não precisa saber se está trabalhando com uma escola pública, privada ou técnica?

Porque `SalaDeAula` depende apenas da interface `EscolaFactory`.

Ela recebe uma fábrica e chama métodos como:

```java
factory.criarProfessor();
factory.criarMaterialDidatico();
factory.criarAvaliacao();
```

A classe não precisa conhecer diretamente as classes concretas.

A fábrica é responsável por decidir quais objetos serão criados.

---

# Pergunta 8

### Qual vantagem existe em programar usando a interface `Professor`?

Programar utilizando a interface `Professor` reduz o acoplamento entre as classes.

Por exemplo:

```java
Professor professor;
```

permite que a variável receba diferentes implementações, como:

```java
ProfessorEscolaPublica
ProfessorEscolaPrivada
ProfessorEscolaTecnica
```

Assim, `SalaDeAula` não fica presa a uma implementação específica e pode trabalhar com qualquer professor que siga o contrato definido pela interface `Professor`.

---

# Pergunta 9

### Ao acrescentar `EscolaTecnicaFactory`, foi necessário modificar `SalaDeAula`?

Não.

A `SalaDeAula` já trabalha com a interface `EscolaFactory`, portanto ela consegue receber uma nova implementação sem precisar conhecer os detalhes da nova fábrica.

Isso demonstra uma das vantagens do **Abstract Factory**: podemos adicionar uma nova família de produtos sem modificar o código cliente que trabalha com as abstrações.

---

# Escola Técnica

A nova família criada para a atividade é:

```text
EscolaTecnicaFactory
        |
        +-- ProfessorEscolaTecnica
        +-- MaterialEscolaTecnica
        +-- AvaliacaoEscolaTecnica
```

### ProfessorEscolaTecnica

```java
public class ProfessorEscolaTecnica implements Professor {

    @Override
    public void apresentar() {
        System.out.println("Professor da escola técnica se apresenta à turma.");
    }

    @Override
    public void ensinar() {
        System.out.println("Ensino com atividades práticas e uso de laboratório.");
    }
}
```

### MaterialEscolaTecnica

```java
public class MaterialEscolaTecnica implements MaterialDidatico {

    @Override
    public void disponibilizar() {
        System.out.println("Apostila técnica, equipamentos e material de laboratório disponibilizados.");
    }
}
```

### AvaliacaoEscolaTecnica

```java
public class AvaliacaoEscolaTecnica implements Avaliacao {

    @Override
    public void aplicar() {
        System.out.println("Avaliação prática realizada por meio de projeto e atividade de laboratório.");
    }
}
```

### EscolaTecnicaFactory

```java
public class EscolaTecnicaFactory implements EscolaFactory {

    @Override
    public Professor criarProfessor() {
        return new ProfessorEscolaTecnica();
    }

    @Override
    public MaterialDidatico criarMaterialDidatico() {
        return new MaterialEscolaTecnica();
    }

    @Override
    public Avaliacao criarAvaliacao() {
        return new AvaliacaoEscolaTecnica();
    }
}
```

---

# Desafio — Escola EAD

Como desafio opcional, pode ser criada uma quarta família:

```text
EscolaEADFactory
        |
        +-- ProfessorEAD
        +-- MaterialEAD
        +-- AvaliacaoEAD
```

A regra é a mesma: a `EscolaEADFactory` deve criar somente produtos pertencentes à família EAD.

---

# Execução

Para executar o projeto:

```bash
mvn compile
mvn exec:java
```

Também é possível executar `Aplicacao.java` diretamente pela IDE.

O menu deverá apresentar:

```text
1 - Escola pública
2 - Escola privada
3 - Escola técnica
```

Ao selecionar a opção `3`, todos os objetos utilizados na aula devem pertencer à família Escola Técnica.

---

# Conclusão

O padrão **Abstract Factory** permite criar famílias de objetos relacionados sem que o código cliente precise conhecer as classes concretas.

Neste projeto, `SalaDeAula` trabalha com `EscolaFactory` e as fábricas concretas são responsáveis pela criação dos produtos de cada tipo de escola.

A principal vantagem observada é a organização das famílias de produtos e a redução do acoplamento entre o cliente e as implementações concretas.
