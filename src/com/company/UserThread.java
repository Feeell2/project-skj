package com.company;

import java.io.*;
import java.net.Socket;

public class UserThread extends Thread{
    private Socket socket;
    private Server server;
    private PrintWriter writer;
    public UserThread(Socket socket,Server server){
        this.socket=socket;
        this.server=server;
    }

    public void run(){
        try {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            OutputStream output = socket.getOutputStream();
            writer = new PrintWriter(output, true);
            String serverMessage = "New user connected: " ;
            server.broadcast(serverMessage, this);

        } catch (IOException ex){
            System.out.println("nie działa coś  "+ ex.getMessage());
        }
    }

void sendMessage(String messege){
writer.println(messege);
}
}

