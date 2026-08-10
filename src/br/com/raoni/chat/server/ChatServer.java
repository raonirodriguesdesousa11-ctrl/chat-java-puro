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

           while (true) {
               Socket client = server.accept();
               System.out.println("Cliente conectado: " + client.getInetAddress().getHostAddress());
               BufferedReader input = new BufferedReader(new InputStreamReader(client.getInputStream()));
               BufferedWriter output = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

               while (true){
               String mensagemRecebida = input.readLine();
               System.out.println(mensagemRecebida);

               if (mensagemRecebida.equals("/sair")){
                   client.close();
                   break;
               }

               }

           }

       }catch (Exception e){
           System.out.println("erro: " + e.getMessage());
       }
   }

}
