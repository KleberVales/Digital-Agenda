# 🗓️ Agenda Digital

Este é um projeto de uma aplicação monolítica desenvolvida em Java com conexão ao banco de dados MySQL. A Agenda Digital permite gerenciar compromissos de forma simples, com opções para adicionar horários e tarefas vinculadas a cada horário.

## 🚀 Funcionalidades

- Adicionar agendas com ano, mês, dia e hora.
- Associar tarefas a um horário específico.
- Listar agendas existentes.

## 🛠️ Tecnologias Utilizadas
- Linguagem: Java (JDK 17+ recomendado).
- Banco de Dados: MySQL.
- ORM Simples: Conexão direta via JDBC.
- Estrutura: Arquitetura Monolítica.
- IDE Recomendada: Eclipse.

## 📂 Estrutura de Pastas

```
src/
├── model/
│   ├── Agenda.java         # Classe de modelo para a Agenda
│   └── Tarefa.java         # Classe de modelo para a Tarefa
├── dao/
│   ├── AgendaDAO.java      # Acesso aos dados da tabela Agenda
│   └── TarefaDAO.java      # Acesso aos dados da tabela Tarefa
├── service/
│   └── AgendaService.java  # Lógica de negócios
├── util/
│   └── DatabaseConnection.java  # Classe para gerenciar conexão com o banco
└── Main.java               # Classe principal para execução do programa
```
## 🎲 Configuração do Banco de Dados

1. Crie o banco de dados no MySQL:

```
CREATE DATABASE AgendaDigital;

USE AgendaDigital;

CREATE TABLE Agenda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ano INT NOT NULL,
    mes INT NOT NULL,
    dia INT NOT NULL,
    hora INT NOT NULL
);

CREATE TABLE Tarefa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    agenda_id INT NOT NULL,
    descricao TEXT NOT NULL,
    FOREIGN KEY (agenda_id) REFERENCES Agenda(id) ON DELETE CASCADE
);

```
2. Configure o usuário e a senha no arquivo DatabaseConnection.java:

```
private static final String USER = "seu_usuario";
private static final String PASSWORD = "sua_senha";

```
## 💻 Como Executar

1. Clone o repositório:
```
git clone https://github.com/seu-usuario/agenda-digital.git
cd agenda-digital

```
2. Compile o projeto:
```
javac -d bin src/**/*.java
```


