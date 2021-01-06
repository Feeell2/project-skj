package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class Server extends Thread{
    private ServerSocket serverSocket;
    private Set<ServerThreadThread> serverThreadThreads=new HashSet<ServerThreadThread>();
    public Server(String portNumb) throws IOException{
        serverSocket=new ServerSocket(Integer.parseInt(portNumb));
    }
    public void run(){
        try {
            ServerThreadThread serverThreadThread=new ServerThreadThread(serverSocket.accept(),this);
            serverThreadThreads.add(serverThreadThread);
            serverThreadThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendMessage(String message){
        try {
            serverThreadThreads.forEach(t->t.getPrintWriter().println(message));
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    public Set<ServerThreadThread> getServerThreadThreads(){
        return serverThreadThreads;
    }
}
