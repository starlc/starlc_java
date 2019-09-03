package com.starlc.communication.rmi.client;

import com.starlc.communication.rmi.interfaces.HelloRegistryFacade;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    public static void main(String[] args) {

        rmiClient();
        namingClient();
    }

    public static void rmiClient(){
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            HelloRegistryFacade hello = (HelloRegistryFacade) registry.lookup("HelloRegistry");
            String response = hello.helloWorld("ZhenJin");
            System.out.println("=======> " + response + " <=======");
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }
    public static void namingClient () {
        try {
            String remoteAddr="rmi://localhost:1100/HelloNaming";
            HelloRegistryFacade hello = (HelloRegistryFacade) Naming.lookup(remoteAddr);
            String response = hello.helloWorld("ZhenJin");
            System.out.println("=======> " + response + " <=======");
        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
