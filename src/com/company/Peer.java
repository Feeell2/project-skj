package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Peer {
    public static void main(String[] args) throws Exception {
  BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter your port");
        String[] setupValues=bufferedReader.readLine().split(" ");
        Server server=new Server(setupValues[0]);
        server.start();
        new Peer().updateListenToPeers(bufferedReader,server);
    }
    public void updateListenToPeers(BufferedReader bufferedReader,Server server) throws Exception{
        System.out.println("> hostname:port#");
        System.out.println(" Peer to receives messeges");
        String input=bufferedReader.readLine();
        String[] inputValues=input.split(" ");
        if (!input.equals("s")) for (int i = 0; i < inputValues.length; i++) {
            String[] adress = inputValues[i].split(":");
            Socket socket = null;
            try {
                socket=new Socket(adress[0],Integer.parseInt(adress[1]));
                new PeerThread(socket).start();
            }catch (Exception e){
                if(socket !=null) socket.close();
                else System.out.println("invalid input");
            }
        }
        communicate(bufferedReader,server);
    }
    public void communicate(BufferedReader bufferedReader, Server server){
        try {
            boolean flag=true;
            while(flag) {
                String message=bufferedReader.readLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
