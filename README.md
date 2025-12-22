# To-Do List



API de gerenciador de tarefas To-Do para aprofundar na construção de CRUD.

Projeto faz parte [desse](https://www.youtube.com/watch?v=IjProDV001o) desafio.

### 💻Tecnologias



- Spring Boot
- Spring Data JPA
- MySQL
- Spring MVC
- SpringDoc OpenAPI 3 

## 📜Práticas adotadas no projeto

- SOLID
- DRY(Don't Repeat Yourself) 
- API Rest
- Consultas com Spring Data JPA
- Injeção de dependências
- Geração automática do Swagger com o OpenAPI 3 


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
$ http POST :8080/todos name="Elaborar Script" description="Montar script para codificação..." priority=1

[
    {
        "description": "Montar script para codificação...",
        "id": 9,
        "name": "Elaborar Script",
        "priority": 1,
        "completed": false
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
        "priority": 1,
        "completed": false
    }
]
```

- **Alterar tarefa**

```
$ http PUT :8080/todos/9 name="Criar Script" description="Elaborar script para aula de POO na linguagem Java" priority=1 completed=true

[
    {
        "description": "Elaborar script para aula de POO na linguagem Java",
        "id": 9,
        "name": "Criar Script",
        "priority": 1,
        "completed": true
    }
]
```


- **Deletar tarefa**

```
$ http DELETE :8080/todos/9  

[]

```



Adicione comandos de execução e exemplos que você acha que os usuários acharão úteis. Forneça uma referência de opções para pontos de bônus!

## 🤝 Colaboradores

Agradecemos às seguintes pessoas que contribuíram para este projeto:

<table>
  <tr>
    <td align="center">
      <a href="#" title="defina o título do link">
        <img src="https://avatars.githubusercontent.com/u/78637454?v=4" width="100px;" alt="Foto do Victor no GitHub"/><br>
        <sub>
          <b>Victor Nogueira</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#" title="defina o título do link">
        <img src="https://s2.glbimg.com/FUcw2usZfSTL6yCCGj3L3v3SpJ8=/smart/e.glbimg.com/og/ed/f/original/2019/04/25/zuckerberg_podcast.jpg" width="100px;" alt="Foto do Mark Zuckerberg"/><br>
        <sub>
          <b>Mark Zuckerberg</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#" title="defina o título do link">
        <img src="https://files.sunoresearch.com.br/p/uploads/2018/09/Elon-Musk.jpg" width="100px"; alt="Foto do Elon Musk"/><br>
        <sub>
          <b>Elon Musk</b>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#" title="defina o título do link">
        <img src="https://miro.medium.com/max/360/0*1SkS3mSorArvY9kS.jpg" width="100px;" alt="Foto do Steve Jobs"/><br>
        <sub>
          <b>Steve Jobs</b>
        </sub>
      </a>
    </td>
  </tr>
</table>


## <img width="30" height="30" alt="image" src="https://github.com/user-attachments/assets/0c6ef9de-93f0-4cda-9187-70cb38bbe1e2"/> Autor do projeto

**Victor Hugo Nogueira Santos**

Conecte-se comigo no LinkeIn! 


<a href="https://www.linkedin.com/in/victor-nogueira-32a519184/" target="_blank"><img style="height:25px" src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"/></a>
