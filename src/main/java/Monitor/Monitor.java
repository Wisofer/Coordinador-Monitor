/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Monitor;

import com.mycompany.coordinadormonitor.Cliente.Constantes.Constantes;
import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Coordinador.ICoordinador;
import Utilidades.Utilidades;
import Coordinador.Coordinador;
/**
 *
 * @author yulian
 */
public class Monitor extends UnicastRemoteObject implements IMonitor {
    private final ICoordinador coordinador;
    private double intervaloITiempo = 0;

    public Monitor() throws RemoteException, MalformedURLException, NotBoundException {
        this.coordinador = (ICoordinador) Naming.lookup(Constantes.nombreCoordinador);
        Naming.rebind(Constantes.nombreMonitor, this);
        this.iniciarMonitor();
        try {
            this.loadMonitor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void iniciarMonitor() throws RemoteException {
        this.setIntervaloITiempo(this.coordinador.iniciarMonitor(this));
    }

    private void loadMonitor() throws RemoteException, InterruptedException {
        while(true) {
            this.coordinador.cargarMonitor(Utilidades.obtenerContenidoFichero());
            Thread.sleep((long)this.getIntervaloITiempo());
        }
    }

    @Override
    public void pingMonitor() throws IOException {
        InetAddress ip = InetAddress.getByName(InetAddress.getLocalHost().getHostAddress());
        if(ip.isReachable(10000)) {
            System.out.println("El Monitor con ID de clase " + this.hashCode()  + " si hizo ping");
            Coordinador.totalMonitoresFuncionando++;
        } else
            System.out.println("El Monitor con ID de clase " + this.hashCode()  + " no hizo ping");
    }

    @Override
    public void iniciarCliente() throws IOException, NotBoundException {
        this.coordinador.iniciarCliente();
    }

    @Override
    public void obtenerUltimoContenido() throws RemoteException {
        this.coordinador.obtenerUltimoContenido();
    }

    public double getIntervaloITiempo() {
        return intervaloITiempo;
    }

    public void setIntervaloITiempo(double intervaloITiempo) {
        this.intervaloITiempo = intervaloITiempo;
    }
    
}
