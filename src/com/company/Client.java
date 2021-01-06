package com.company;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;
    private static Scanner scanner = new Scanner(System.in);
    private int portNumber;

    public Client(int portNumber){
        this.portNumber=portNumber;
    }

    public void start(){
        try(Socket socket = new Socket("localhost",this.portNumber)){
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());

            while (true) {
                System.out.print("input> ");
                String message = scanner.nextLine();
                dataOutputStream.writeUTF(message);

                if(message.equalsIgnoreCase("exit()"))
                    break;
            }

        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

}
