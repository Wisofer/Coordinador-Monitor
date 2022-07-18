/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coordinador;

import Utilidades.Utilidades;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 *
 * @author yulian
 */
public class ServidorCoordinador {

    public static void main(String[] args) throws MalformedURLException, RemoteException {
        Utilidades.iniciarRegistro(1099);
        ICoordinador coordinador = new Coordinador(Utilidades.leerNumerosEnteros("Ingrese el tiempo en numeros enteros del intervalo del tiempo"));
        System.out.println("Servidor encendido con el id de clase de: " + coordinador.hashCode());
    }
}
