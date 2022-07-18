/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author yulian
 */
public interface IMonitor extends Remote {

    void pingMonitor() throws RemoteException, MalformedURLException, NotBoundException, IOException;

    void iniciarCliente() throws IOException, NotBoundException;

    void obtenerUltimoContenido() throws RemoteException;
}