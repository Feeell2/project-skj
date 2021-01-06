package com.company;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class PeerThread extends Thread{
    private BufferedReader bufferedReader;
    public PeerThread(Socket socket) throws IOException{
        bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        boolean flag=true;
        System.out.println("dziala");
//        while (flag){
//            try {
//                System.out.println("lala");
//            }catch (Exception e){
//                flag=false;
//                interrupt();
//            }
//        }
    }
}
