package br.com.raoni.chat.server;

import java.io.ObjectOutputStream;
import java.net.*;
import java.io.*;
import javax.swing.*;

public class ChatServer {
   public static void main(String[] args){
       try {
           ServerSocket server = new ServerSocket(12345);
           System.out.println("servidor escutando na porta 12345");

               Socket client = server.accept();
               System.out.println("Cliente conectado: " + client.getInetAddress().getHostAddress() + " (" + client.getInetAddress().getHostName() + ")");

               ClientHandler clientHandler = new ClientHandler(client);
               clientHandler.run();

       }
       catch (Exception e){
           System.out.println("erro: " + e.getMessage());
       }
   }

}
