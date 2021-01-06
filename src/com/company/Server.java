package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server {
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;
    private Set<UserThread> userThreadSet= new HashSet<>();
    private int portNumber;

    public Server(int portNumber){
        this.portNumber=portNumber;
    }
    public void start(){
        try(ServerSocket serverSocket = new ServerSocket(portNumber)){
            System.out.println("listening to port:"+this.portNumber);
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket+" connected\n");
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            String message;
            while (true) {
                message = dataInputStream.readUTF();
                System.out.println(message);
                if(message.equalsIgnoreCase("exit()"))
                    break;
            }
            clientSocket.close();

        } catch (Exception e){
            System.out.println(e.toString());
        }
    }
    void broadcast(String message, UserThread excludeUser) {
        for (UserThread aUser : userThreadSet) {
            if (aUser != excludeUser) {
                aUser.sendMessage(message);
            }
        }
    }

    public static void main(String[] args) {
        Server server=new Server(10004);
        server.start();
    }
}
