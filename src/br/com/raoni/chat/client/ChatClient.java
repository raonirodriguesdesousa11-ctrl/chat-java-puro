package br.com.raoni.chat.client;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {

        try{
            Socket socket = new Socket("Raoni", 12345);
            System.out.println("conectado ao servidor");
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Scanner scanner = new Scanner(System.in);

            while (true){
                String msg = scanner.nextLine();

                output.write(msg);
                output.newLine();
                output.flush();

                if (msg.equals("/sair")){
                    socket.close();
                    break;
                }
            }

        }catch (Exception e){
            System.out.println("erro:" + e.getMessage());
        }

    }

}
