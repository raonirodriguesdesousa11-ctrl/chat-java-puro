package br.com.raoni.chat.server;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler implements Runnable{
    private Socket socket;
    private BufferedWriter output;
    private BufferedReader input;
    private String name;
    Scanner scanner = new Scanner(System.in);

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {

        try {

            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            output.write("qual seu nome?");
            output.newLine();
            output.flush();
            name = input.readLine();
            output.write("atendente: olá, " + name);
            output.newLine();
            output.flush();

            while(input.readLine() != null){
                String menssagemRecebida = input.readLine();
                System.out.println(menssagemRecebida);

                String mensagem = scanner.nextLine();
                output.write("atendente:" + mensagem);
                output.newLine();
                output.flush();
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
