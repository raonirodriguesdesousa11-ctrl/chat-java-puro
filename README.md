# Java Chat - Cliente/Servidor com Sockets

Aplicação simples de chat cliente-servidor em Java, utilizando **Sockets TCP** e **multithreading** para atender múltiplos clientes simultaneamente.

## 📋 Sobre o projeto

O objetivo deste projeto foi estudar na prática comunicação em rede com sockets e concorrência com threads em Java. O servidor aceita múltiplas conexões e, para cada cliente conectado, cria uma thread dedicada (`ClientHandler`) responsável por gerenciar a troca de mensagens.

## 🗂️ Estrutura

```
src/
└── br/com/raoni/chat/
    ├── client/
    │   └── ChatClient.java      # Aplicação cliente
    └── server/
        ├── ChatServer.java      # Servidor principal (aceita conexões)
        └── ClientHandler.java   # Thread que atende cada cliente
```

## ⚙️ Como funciona

1. `ChatServer` sobe um `ServerSocket` na porta `12345` e fica em loop aguardando conexões.
2. A cada cliente conectado, uma nova `Thread` é criada rodando um `ClientHandler`, que:
   - Pergunta o nome do cliente;
   - Recebe e envia mensagens via `BufferedReader`/`BufferedWriter`;
   - Encerra a conexão quando recebe o comando `/sair`.
3. `ChatClient` se conecta ao servidor, troca mensagens via terminal e também encerra com `/sair`.

## ▶️ Como executar

**1. Compile o projeto:**
```bash
javac -d bin src/br/com/raoni/chat/server/*.java src/br/com/raoni/chat/client/*.java
```

**2. Inicie o servidor:**
```bash
java -cp bin br.com.raoni.chat.server.ChatServer
```

**3. Em outro terminal, inicie o cliente:**
```bash
java -cp bin br.com.raoni.chat.client.ChatClient
```

> ⚠️ No `ChatClient`, o socket está apontando para o host `"Raoni"`. Para rodar localmente, altere para `"localhost"` ou `"127.0.0.1"`.

## 🛠️ Tecnologias

- Java (Sockets - `java.net`)
- I/O bloqueante (`BufferedReader` / `BufferedWriter`)
- Multithreading (`Thread` / `Runnable`)

## 💡 Próximos passos

- [ ] Suportar múltiplos clientes conversando entre si (broadcast), não só atendimento 1:1
- [ ] Migrar para I/O não-bloqueante (NIO) ou `CompletableFuture` para operações assíncronas de verdade
- [ ] Adicionar interface gráfica com Swing
- [ ] Tratar desconexões inesperadas de clientes
- [ ] Externalizar porta/host em arquivo de configuração

## 📄 Licença

Projeto de estudo, livre para uso e adaptação.
