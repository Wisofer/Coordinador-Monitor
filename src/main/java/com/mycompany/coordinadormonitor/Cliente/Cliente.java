/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.coordinadormonitor.Cliente;

import Monitor.IMonitor;
import com.mycompany.coordinadormonitor.Cliente.Constantes.Constantes;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Scanner;

/**
 *
 * @author william
 */
public class Cliente {
    public static void main(String[] args) throws IOException, NotBoundException, InterruptedException {
        IMonitor monitor = (IMonitor) Naming.lookup(Constantes.nombreMonitor);
        System.out.println("Ingrese el intervalo del tiempo en segundos");
        final long intervaloTiempo = new Scanner(System.in).nextLong();

        for(;;) {
            monitor.iniciarCliente();
            monitor.obtenerUltimoContenido();
            Thread.sleep(intervaloTiempo * 1000);
        }
    }
}
