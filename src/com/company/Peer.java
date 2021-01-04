package com.company;

import java.io.IOException;

public class Peer {
    public static void main(String[] args) throws IOException {
    Server server=new Server(10000);
    Client client=new Client(10000);
    server.start();
    client.start();
    }
}
