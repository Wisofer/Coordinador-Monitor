/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coordinador;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import Monitor.IMonitor;

/**
 *
 * @author yulian
 */
public interface ICoordinador extends Remote {

    // metodo correspondiente a iniMonitor
    double iniciarMonitor(IMonitor monitor) throws RemoteException;

    // metodo correspondiente a loadMonitor
    void cargarMonitor(String contenidoFichero) throws RemoteException;

    // metodo correspondiente a iniClient
    void iniciarCliente() throws IOException, NotBoundException;

    // metodo correspondiente a getLoadAvg
    void obtenerUltimoContenido() throws RemoteException;
}
