package br.com.raoni.chat.server;

import java.io.ObjectOutputStream;
import java.net.*;

public class ChatServer {
   public static void main(String[] args){
       try {
           ServerSocket server = new ServerSocket(12345);
           System.out.println("servidor escutando na porta 12345");

           while (true) {
               Socket client = server.accept();
               System.out.println("Cliente conectado: " + client.getInetAddress().getHostAddress());
               ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
               output.flush();
               output.writeObject("Hello World");
               output.close();
               client.close();
           }

       }catch (Exception e){
           System.out.println("erro: " + e.getMessage());
       }
   }

}
