/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author william
 */
public class Utilidades {
  private static final String nombreFichero = "/proc/loadavg";

    public static String obtenerContenidoFichero() {
        try {
            File fichero = new File(nombreFichero);
            if(fichero.canRead() && fichero.isFile()) {
                BufferedReader buffer = new BufferedReader(new FileReader(fichero));
                return buffer.readLine();
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }
        return null;
    }

    public static void iniciarRegistro(int puerto) throws RemoteException {
        Registry registro;
        try {
            registro = LocateRegistry.getRegistry(puerto);
            registro.list();
        } catch (RemoteException exception) {
            registro = LocateRegistry.createRegistry(puerto);
        }
    }

    public static int leerNumerosEnteros(String enunciado) {
        try {
            System.out.println(enunciado);
            return new Scanner(System.in).nextInt();
        } catch (Exception exception) {
            return leerNumerosEnteros(enunciado);
        }
    }  
}
