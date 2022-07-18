/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coordinador;

import Monitor.IMonitor;
import com.mycompany.coordinadormonitor.Cliente.Constantes.Constantes;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author yulian
 */
public class Coordinador extends UnicastRemoteObject implements ICoordinador {

    private final List<IMonitor> monitores = new LinkedList<>();
    private int contador = 0, intervaloTiempo = 0;
    public static int totalMonitoresFuncionando = 0;
    private String ultimoContenidoLeidoFichero = "";

    public Coordinador(int intervaloTiempo) throws RemoteException, MalformedURLException {
        Naming.rebind(Constantes.nombreCoordinador, this);
        this.setIntervaloTiempo(intervaloTiempo);
    }

    @Override
    public double iniciarMonitor(IMonitor monitor) throws NullPointerException {
        synchronized (monitores) {
            monitores.add(monitor);
        }
        return this.generarIntervaloTiempo();
    }

    @Override
    public void cargarMonitor(String contenidoFichero) {
        this.ultimoContenidoLeidoFichero = contenidoFichero;
        System.out.println("Valor leido numero: {" + ++this.contador + "} del fichero: " + contenidoFichero);
    }

    @Override
    public void iniciarCliente() throws IOException, NotBoundException {
        for(IMonitor monitor : this.monitores)
            monitor.pingMonitor();
    }

    @Override
    public void obtenerUltimoContenido() {
        System.out.println("Ultimo valor leido: " + this.ultimoContenidoLeidoFichero);
    }

    private int getIntervaloTiempo() {
        return intervaloTiempo;
    }

    private void setIntervaloTiempo(int intervaloTiempo) {
        this.intervaloTiempo = intervaloTiempo;
    }

    private int generarIntervaloTiempo() {
        return this.getIntervaloTiempo() * 1000;
    }
}
