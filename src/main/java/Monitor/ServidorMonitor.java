/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitor;

import Utilidades.Utilidades;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author yulian
 */
public class ServidorMonitor {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        Utilidades.iniciarRegistro(1099);
        IMonitor monitor = new Monitor();
        System.out.println("Monitor encendido con el id hash de: " + monitor.hashCode());
    }
}
