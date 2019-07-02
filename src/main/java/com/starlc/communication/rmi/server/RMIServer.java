package com.starlc.communication.rmi.server;

import com.starlc.communication.rmi.interfaces.HelloRegistryFacade;
import com.starlc.communication.rmi.interfaces.HelloRegistryFacadeImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {

    public static void main(String[] args)throws Exception {
        createRMIServer();
        createRMIServerByNaming();
    }

    public static void createRMIServer(){
        try {
            // 本地主机上的远程对象注册表Registry的实例,默认端口1099
            Registry registry = LocateRegistry.createRegistry(1099);
            // 创建一个远程对象
            HelloRegistryFacade hello = new HelloRegistryFacadeImpl();
            // 把远程对象注册到RMI注册服务器上，并命名为HelloRegistry
            registry.rebind("HelloRegistry", hello);
            System.out.println("======= 启动RMI服务成功! =======");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void createRMIServerByNaming(){
        try {
            // 本地主机上的远程对象注册表Registry的实例,默认端口1099
            LocateRegistry.createRegistry(1100);
            // 创建一个远程对象
            HelloRegistryFacade hello = new HelloRegistryFacadeImpl();
            //第二种
            // 把远程对象注册到RMI注册服务器上，并命名为Hello
            //绑定的URL标准格式为：rmi://host:port/name
            Naming.bind("rmi://localhost:1100/HelloNaming", hello);

            System.out.println("======= 启动RMI服务成功! =======");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }

    }
}
