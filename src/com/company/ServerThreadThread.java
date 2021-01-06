package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThreadThread extends Thread{
    private Server server;
    private Socket socket;
    private PrintWriter printWriter;
    public ServerThreadThread(Socket socket,Server server){
        this.server=server;
        this.socket=socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.printWriter=new PrintWriter(socket.getOutputStream(),true);
            while(true) server.sendMessage(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
            server.getServerThreadThreads().remove(this);
        }
    }

    public PrintWriter getPrintWriter(){
        return printWriter;
    }

}
