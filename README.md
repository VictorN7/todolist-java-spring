# TodoList API


API REST desenvolvida em Java com Spring Boot para gerenciamento de tarefas (ToDo), aplicando boas práticas de arquitetura, modelagem de domínio, tratamento global de exceções, profiles de ambiente e testes de integração.

Projeto desenvolvido durante mentoria com foco em consolidar boas práticas de backend com Java e Spring Boot.

Este projeto foi construído com foco em padrões utilizados no mercado, indo além de um CRUD simples, demonstrando maturidade técnica e organização de código.


### 🚀Funcionalidades

- Criar tarefas
- Listar tarefas
- Atualizar tarefas existentes
- Remover tarefas
- Definir prioridade da tarefa
- Controlar status da tarefa
- Ordenação automática das tarefas:
  - Prioridade (descendente)
  - Nome (ascendente)


## 📜Práticas adotadas no projeto

- SOLID
- DRY(Don't Repeat Yourself) 
- API Rest
- Consultas com Spring Data JPA
- Injeção de dependências
- Geração automática do Swagger com o OpenAPI 3
- Exceptions personalizadas
- Testes de integração com Spring Boot, JUnit 5 e MockMvc

### Estrutura completa da aplicação:

## <img width="auto" height="auto" alt="image" src="https://www.plantuml.com/plantuml/dpng/NP11ReGm34NtEON5dYjKI5Mxx8Bs0b5mHn4XHhOp6ZJYxYC80uILe-_t_UqqefOr3S6CrlNsXb0vYieK0d85JmFWWXM1FolzvzunipaCWdpt3g_qRvOBb74ayKeyPTf7HVwt3bT7ktSB4qRrEbt7Nv0qI2QMPyvNgqdC301dyk5mL4_nFAz5eSGEVqY_ASNkwmqj8ST_G5r_W6ndRNNLZhCAEIzkSidAicV9x54DnYuDuGK0"/>


### 🧠Regras de Negócio


- Toda tarefa nasce com status PENDING
- Não é permitido criar tarefas com nome ou descrição vazios
- Operações de atualização e remoção validam a existência do recurso
- Retorno de erros padronizado e semântico


### 🏗Arquitetura do Projeto

O projeto segue uma arquitetura em camadas, separando responsabilidades:

- Controller → Exposição da API REST
- Service → Regras de negócio e orquestração
- Repository → Acesso a dados
- Entity → Modelagem do domínio
- Enums → Estados e prioridades controladas
- Exception → Tratamento global de erros

Essa abordagem garante:

- Código limpo
- Baixo acoplamento
- Alta manutenibilidade

## 📌 Decisões Técnicas Importantes

- Utilização de Enums para status e prioridade para garantir integridade dos dados
- Uso de @ControllerAdvice para padronização de erros da API
- Separação de ambientes com Spring Profiles (dev e test)
- Banco H2 em memória para garantir testes rápidos e isolados

### 🛠Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring MVC
- SpringDoc OpenAPI 3 
- Hibernate
- MySQL
- H2 Database
- JUnit 5
- MockMvc
- Jackson

### 📦Modelagem de Domínio

Entidade: Todo

- id: identificador único
- name: nome da tarefa
- description: descrição da tarefa
- status: status da tarefa
- priority: prioridade da tarefa

Enums

- TaskStatus: PENDING, IN_PROGRESS, DONE
- TaskPriority: LOW, MEDIUM, HIGH


### 🔐Tratamento de Erros

A API possui tratamento global de exceções utilizando @ControllerAdvice, retornando erros padronizados com:

- Timestamp
- Status HTTP
- Tipo do erro
- Mensagem detalhada
- Path da requisição

### 🧪Testes

Foram implementados testes de integração cobrindo:

- Criação de tarefa com sucesso
- Validação de erro ao enviar dados inválidos
- Características dos testes:
- Execução com MockMvc
- Uso de H2 em memória
- Ambiente isolado com profile test
- Verificação de status HTTP e payload da resposta


### ⚙️Configuração de Ambientes

 **Dev (MySQL)**

```
spring.datasource.url=jdbc:mysql://localhost:3306/todolist
spring.datasource.username=root
spring.datasource.password=********
spring.jpa.hibernate.ddl-auto=update 
```

**Test (H2)**

```
spring.datasource.url=jdbc:h2:mem:todolist-test
spring.jpa.hibernate.ddl-auto=create-drop
```

**Configurações Globais**

- Profiles do Spring
- SQL logging habilitado
- open-in-view=false


## 🚀Como rodar localmente?

**1° Clone o repositório:**
`````
  git clone https://github.com/VictorN7/todolist-java-spring.git
`````

**2° Entre na pasta do projeto:**
```
  cd todolist-java-spring
```


**3° Executar aplicação:**
```
  java -jar target/todolist-0.0.1-SNAPSHOT.jar
```


A API pode ser acessada pelo [localhost:8080](localhost:8080)

O Swagger pode ser visualizado pelo [localhost:8080/swagger-ui.html](localhost:8080/swagger-ui.html)

## ☕ Endpoints API

Para realizar as requisições, utilizamos o [httpie](https://httpie.io/)(ferramenta de requisição via terminal). 

- **Criar tarefa**

```
$ http POST :8080/todos name="Elaborar Script" description="Montar script para codificação..." priority="MEDIUM"

[
    {
        "description": "Montar script para codificação...",
        "id": 9,
        "name": "Elaborar Script",
        "priority": "MEDIUM",
        "status": "IN_PROGRESS"
    }
]
```

- **Listar tarefa**

```
$ http GET :8080/todos

[
    {
        "description": "Montar script para codificação...",
        "id": 9,
        "name": "Elaborar Script",
        "priority": "LOW",
        "status": "PENDING"
    }
]
```

- **Alterar tarefa**

```
$ http PUT :8080/todos/9 name="Criar Script" description="Elaborar script para aula de POO na linguagem Java" priority="LOW" status="PENDING"

[
    {
        "description": "Elaborar script para aula de POO na linguagem Java",
        "id": 9,
        "name": "Criar Script",
        "priority": "LOW",
        "status": "PENDING" 
    }
]
```


- **Deletar tarefa**

```
$ http DELETE :8080/todos/9  

[]

```


## <img width="30" height="30" alt="image" src="https://github.com/user-attachments/assets/0c6ef9de-93f0-4cda-9187-70cb38bbe1e2"/> Autor do projeto

**Victor Hugo Nogueira Santos**

Conecte-se comigo no LinkeIn! 


<a href="https://www.linkedin.com/in/victor-nogueira-ti/" target="_blank"><img style="height:25px" src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"/></a>




