package es.etg.dam.calculadora;

import java.io.IOException;
import java.net.Socket;

public class Cliente {
    static final int PUERTO = 8888;
    static final String HOST = "localhost";

    public static void main(String[] args) {
        // Validación básica de argumentos
        if (args.length == 0) {
            System.out.println("Uso: Cliente <numero>");
            return;
        }

        try (Socket socket = new Socket(HOST, PUERTO)) {
            Conexion conn = new Conexion(socket);

           
            conn.escribir(args[0]);

            // Leer respuesta cifrada
            String respuesta = conn.leer();
            System.out.println("Resultado: " + respuesta);

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.getMessage());
        }
    }
}
