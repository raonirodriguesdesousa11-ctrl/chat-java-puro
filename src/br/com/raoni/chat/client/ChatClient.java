package br.com.raoni.chat.client;

import javax.swing.*;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {

        try{
            Socket client = new Socket("Raoni", 12345);
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            String hello = (String) input.readObject();
            JOptionPane.showMessageDialog(null, "messagem:"+ hello);
            input.close();



        }catch (Exception e){
            System.out.println("erro:" + e.getMessage());
        }


    }



}
