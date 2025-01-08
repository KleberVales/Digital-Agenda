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

