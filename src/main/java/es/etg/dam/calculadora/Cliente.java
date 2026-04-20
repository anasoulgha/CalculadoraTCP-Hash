package es.etg.dam.calculadora;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

    static final int PUERTO = 8888;
    static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {

        String dato = args[0];

        Socket socket = new Socket(HOST, PUERTO);
        Conexion conn = new Conexion(socket);

        // Enviar dato al servidor
        conn.escribir(dato);

        // Intentar leer respuesta (solo llegará cuando se envíe n2)
        try {
            String respuesta = conn.leer();
            System.out.println("Resultado: " + respuesta);
        } catch (Exception e) {
            // El servidor aún no responde, es normal
        }

        socket.close();
    }
}
