# NexusLog — Projeto Completo Comentado
## Projeto de referência da Unidade Curricular Design de Software — 80h

> Este repositório reúne a **versão consolidada do NexusLog**, utilizada como projeto de referência do professor ao longo das 20 aulas.  
> O código está comentado com finalidade didática: os comentários explicam **o que o código faz, por que a decisão existe e a qual conceito de Design de Software ela se relaciona**.

---

# 1. Finalidade do projeto

O NexusLog é uma plataforma didática de logística e entregas.

O domínio foi escolhido porque permite trabalhar, dentro de um mesmo projeto:

- requisitos funcionais e não funcionais;
- contexto e stakeholders;
- problemas de design;
- princípios de design;
- planejamento técnico;
- estilos arquiteturais;
- modelo de domínio;
- C4 e UML;
- comunicação entre sistemas;
- contratos de integração;
- segurança e desempenho;
- padrões de projeto;
- interface e fluxo de usuário;
- qualidade;
- ADRs;
- avaliação e auditoria;
- validação com público/demanda;
- consolidação e apresentação técnica.

O objetivo **não é produzir um sistema comercial de logística completo**.  
O objetivo é transformar o projeto em um laboratório no qual cada conceito da Unidade Curricular modifica ou explica uma parte real da solução.

---

# 2. Metodologia pedagógica adotada

A metodologia segue uma evolução incremental:

**professor demonstra → aluno observa o problema → grupo aplica no próprio projeto → grupo registra a decisão → grupo comunica/valida → professor orienta a próxima evolução**

A aplicação deve ser conduzida com quatro regras:

1. **começar pelo problema, não pelo padrão**;
2. **justificar cada decisão**;
3. **manter rastreabilidade entre requisito, decisão e artefato**;
4. **evoluir o mesmo projeto, evitando exercícios desconectados**.

O NexusLog é o exemplo do professor.  
Os grupos não precisam copiar o domínio de logística: devem transportar o princípio demonstrado para o projeto escolhido pelo grupo.

---

# 3. Como usar o projeto em sala

Em cada encontro:

## Parte A — retomada
O professor abre a versão/estado anterior e revisa rapidamente:
- o problema existente;
- o artefato produzido;
- o que ainda ficou pendente.

## Parte B — conceito
O conteúdo teórico é apresentado com exemplos simples e, depois, relacionado ao NexusLog.

## Parte C — demonstração supervisionada
O professor altera ou apresenta os arquivos correspondentes ao novo conteúdo.

## Parte D — prática dos grupos
Cada grupo aplica o **mesmo princípio** no seu projeto.

## Parte E — registro
O grupo registra:
- problema;
- decisão;
- justificativa;
- diagrama, código ou documento;
- consequência;
- commit.

## Parte F — comunicação/validação
Flash Demo, revisão cruzada, Issue, checklist ou devolutiva, conforme a aula.

---

# 4. Organização sugerida de um encontro de 4h

A aula pode ser conduzida no seguinte ritmo:

- **18h30–18h50** — retomada e objetivos;
- **18h50–19h35** — conceito e exemplos;
- **19h35–20h10** — demonstração do professor no NexusLog;
- **20h10–20h30** — início da prática orientada;
- **20h30–20h45** — intervalo;
- **20h45–21h45** — desenvolvimento supervisionado dos grupos;
- **21h45–22h15** — validação, peer review ou Flash Demo;
- **22h15–22h35** — documentação, commit e entrega;
- **22h35–22h45** — fechamento e preparação da aula seguinte.

A divisão pode ser ajustada conforme avaliação, dificuldade da turma e atividades institucionais.

---

# 5. Evolução completa — Aulas 01 a 20

## Aula 01 — Fundamentos
### Objetivo
Distinguir requisito, design, arquitetura e implementação; organizar equipe e repositório.

### NexusLog
O projeto nasce pequeno. Não há arquitetura sofisticada.

### Artefatos
- `docs/conceitos-iniciais.md`
- `docs/equipe.md`
- `README.md`
- estrutura `docs/`

### Aprendizado central
Antes de escrever código, é preciso saber qual problema será resolvido.

---

## Aula 02 — Contexto
### Objetivo
Trabalhar contexto de software, stakeholders, restrições e o ciclo compreender → propor → validar.

### NexusLog
São identificados cliente, operador, destinatário, transportadoras e serviços externos.

### Artefatos
- `docs/contexto.md`
- `docs/diagramas/contexto.md`

### Aprendizado central
Nenhuma decisão técnica existe fora de um contexto de negócio.

---

## Aula 03 — Diagnóstico
### Objetivo
Identificar acoplamento excessivo, baixa coesão, duplicação, condicionais crescentes e responsabilidades mal definidas.

### NexusLog
`LegacyShippingService` foi mantido propositalmente como exemplo de código problemático.

### Artefatos
- `src/.../legacy/LegacyShippingService.java`
- `docs/achados-tecnicos.md`

### Aprendizado central
Primeiro localizar evidências; depois propor solução.

---

## Aula 04 — Princípios
### Objetivo
Aplicar simplicidade, coesão, baixo acoplamento, reúso e visão geral de SOLID.

### NexusLog
As responsabilidades começam a ser separadas:
- domínio;
- cálculo simples;
- notificação.

### Artefatos
- `Shipment`
- `SimpleFreightService`
- `NotificationService`
- `ADR-001`

### Vantagem
Responsabilidades mais claras e testáveis.

### Cuidado
Separar demais sem necessidade pode criar abstração prematura.

---

## Aula 05 — Planejamento
### Objetivo
Transformar achados em backlog de decisões, critérios de aceitação e plano de trabalho.

### Artefatos
- `docs/planejamento/backlog.md`
- `docs/planejamento/checklist.md`

### Aprendizado central
Design é também decisão planejada e verificável.

---

## Aula 06 — Arquitetura
### Objetivo
Comparar monólito, camadas, microsserviços e arquitetura orientada a eventos.

### Decisão do NexusLog
Monólito modular/em camadas, com eventos usados pontualmente.

### Artefatos
- `docs/arquitetura/tradeoffs.md`
- `docs/diagramas/c4-contexto.md`

### Vantagens
Menor complexidade operacional e boa clareza didática.

### Desvantagens
Sem disciplina, um monólito modular pode degenerar em alto acoplamento.

---

## Aula 07 — Requisitos
### Objetivo
Classificar requisitos funcionais e não funcionais e iniciar rastreabilidade.

### Artefatos
- `docs/requisitos/requisitos.md`
- `docs/requisitos/rastreabilidade.md`

### Aprendizado central
A arquitetura deve responder a necessidades e restrições explícitas.

---

## Aula 08 — Documentação
### Objetivo
Consolidar documentação, ADRs e auditoria cruzada.

### Artefatos
- `docs/revisao/checklist-n1.md`
- `docs/revisao/peer-review.md`

### Vantagem
A decisão deixa de existir apenas na memória da equipe.

### Cuidado
Documento sem manutenção pode ficar pior do que nenhum documento.

---

## Aula 09 — Síntese
### Objetivo
Verificar coerência entre problemas, princípios, planejamento, arquitetura e requisitos.

### Artefato
- `docs/revisao/sintese-n1.md`

### Pergunta de controle
Se o código fosse removido, a documentação explicaria por que a solução tomou essa forma?

---

## Aula 10 — Avaliação / Checkpoint N1
### Objetivo
Congelar o estado da primeira etapa para avaliação e revisão.

### Artefato
- `docs/revisao/checkpoint-n1.md`

### Observação
Não há necessidade de inserir funcionalidade artificial apenas porque há uma aula.

---

## Aula 11 — Domínio
### Objetivo
Aplicar CRC, classes conceituais, responsabilidades e colaborações.

### NexusLog
Entram:
- `Shipment`;
- `Delivery`;
- `DeliveryStatus`.

### Artefatos
- `docs/dominio/crc.md`
- `docs/diagramas/modelo-dominio.md`

### Aprendizado central
Modelo de domínio não é simplesmente reproduzir tabelas ou classes de implementação.

---

## Aula 12 — Modelagem
### Objetivo
Relacionar domínio, C4, componentes e sequência de um cenário crítico.

### Artefatos
- `docs/diagramas/c4-container.md`
- `docs/diagramas/sequencia-envio.md`

### Vantagem
Mermaid mantém diagramas versionados junto ao código.

### Cuidado
Diagramas precisam evoluir junto com o sistema.

---

## Aula 13 — Integração
### Objetivo
Trabalhar comunicação entre sistemas, contratos e integração.

### NexusLog
A API externa dos Correios é simulada por `CorreiosLegacyClient`.

A aplicação não depende diretamente dela: utiliza `CarrierGateway` e `CorreiosAdapter`.

### Artefatos
- `CarrierGateway`
- `CorreiosLegacyClient`
- `CorreiosAdapter`
- `shipment-contract.json`
- `ADR-002`

### Padrão relacionado
**Adapter**

### Vantagem
Isola detalhes do fornecedor externo.

### Desvantagem
Cada integração relevante tende a exigir adaptação própria.

---

## Aula 14 — Padrões de Projeto
### Objetivo
Aplicar padrões apenas onde existe um problema concreto.

O projeto consolida seis padrões:

### 1. Strategy
Problema: diferentes cálculos de frete.  
Local: `patterns/strategy`.

### 2. Factory Method
Problema: diferentes veículos precisam ser criados.  
Local: `patterns/factorymethod`.

### 3. Observer
Problema: várias partes precisam reagir a mudanças no status da entrega.  
Local: `patterns/observer`.

### 4. Abstract Factory
Problema: cada operador logístico possui uma família compatível de serviços.  
Local: `patterns/abstractfactory`.

### 5. Adapter
Problema: API externa incompatível com a interface interna.  
Local: `integration`.

### 6. Facade
Problema: o fluxo de expedição envolve muitos subsistemas.  
Local: `patterns/facade`.

### Regra
Nunca escolher o padrão pelo nome.  
Escolher porque há uma força/problema que justifica a solução.

### Artefato
- `docs/padroes/mapa-dos-6-padroes.md`

---

## Aula 15 — Interfaces
### Objetivo
Relacionar fluxo de interface, requisitos e serviços, sem transformar a disciplina em programação frontend.

### Artefato
- `docs/interfaces/fluxo-usuario.md`

### Aprendizado central
A tela é consequência de um fluxo e de responsabilidades internas.

---

## Aula 16 — Qualidade
### Objetivo
Avaliar o design por critérios de qualidade.

### Artefatos
- `QualityCheck`
- `docs/qualidade/checklist-iso25010.md`
- `docs/qualidade/auditoria.md`

### Dimensões observadas
Adequação funcional, desempenho, confiabilidade, segurança, manutenibilidade, compatibilidade e portabilidade.

### Cuidado
Checklist não substitui testes e métricas de engenharia.

---

## Aula 17 — Validação / Checkpoint N2
### Objetivo
Consolidar arquitetura, modelagem, integração, padrões e documentação.

### Artefato
- `docs/revisao/checkpoint-n2.md`

---

## Aula 18 — Extensão
### Objetivo
Aproximar a solução de uma demanda real ou contextualizada.

### Artefato
- `docs/extensao/validacao-demanda.md`

### Aprendizado central
Requisito real deve nascer de interação, observação e validação.

---

## Aula 19 — Feedback
### Objetivo
Incorporar ou rejeitar feedback de forma justificada.

### Artefato
- `docs/extensao/feedback.md`

### Regra
Feedback não é ordem automática.  
Deve ser analisado quanto a valor, impacto, custo e coerência.

---

## Aula 20 — Consolidação
### Objetivo
Apresentar a solução completa e demonstrar rastreabilidade.

### Artefatos
- `docs/final/roteiro-apresentacao.md`
- `docs/final/checklist-entrega.md`

### Linha narrativa da apresentação
problema → contexto → requisitos → arquitetura → domínio → integração → padrões → qualidade → feedback → resultado.

---

# 6. Estrutura do código

```text
src/main/java/br/edu/nexuslog/
├── App.java
├── PatternsDemo.java
├── QualityCheck.java
├── application/
├── domain/
├── integration/
│   └── external/
├── legacy/
├── patterns/
│   ├── abstractfactory/
│   ├── facade/
│   ├── factorymethod/
│   ├── observer/
│   └── strategy/
└── service/
```

## `legacy`
Mantém a versão problemática para comparação.

## `domain`
Contém conceitos centrais do negócio.

## `application`
Representa casos de uso/orquestração de aplicação.

## `integration`
Isola interfaces com sistemas externos.

## `patterns`
Mostra explicitamente os padrões estudados.

## `service`
Serviços simples introduzidos durante a evolução.

---

# 7. Execução

## Pré-requisitos
- JDK 17 ou superior;
- Maven 3.8+;
- VS Code, IntelliJ IDEA, Eclipse ou outra IDE Java.

## Compilar

```bash
mvn compile
```

## Executar exemplos

### Projeto legado
Execute:

`br.edu.nexuslog.App`

### Demonstração dos padrões
Execute:

`br.edu.nexuslog.PatternsDemo`

### Verificação didática de qualidade
Execute:

`br.edu.nexuslog.QualityCheck`

---

# 8. Como o professor deve usar o código comentado

Os comentários internos foram escritos em três níveis:

- **O QUE**: explica o comportamento da linha/classe;
- **POR QUÊ**: explica a decisão;
- **DESIGN**: relaciona a decisão ao conteúdo da disciplina.

Em aula, o ideal é não ler todos os comentários.  
Use-os como roteiro de apoio e peça que os alunos identifiquem a justificativa antes de revelá-la.

---

# 9. O que os grupos devem entregar ao longo do semestre

O repositório de cada grupo deve acumular evidências:

- README;
- contexto;
- requisitos;
- diagramas;
- ADRs;
- código;
- contratos;
- checklists;
- Issues/peer review;
- commits;
- protótipos/fluxos;
- evidências de validação;
- apresentação final.

A avaliação deve observar principalmente:

1. coerência;
2. justificativa;
3. rastreabilidade;
4. aplicação correta dos conceitos;
5. capacidade de explicar trade-offs.

---

# 10. Regra final do projeto

> **Um bom Design de Software não é o que utiliza mais padrões, diagramas ou abstrações.  
> É o que resolve o problema com responsabilidades claras, decisões justificadas e complexidade proporcional à necessidade.**
