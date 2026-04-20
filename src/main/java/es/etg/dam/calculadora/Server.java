package es.etg.dam.calculadora;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PUERTO = 8888;

    static String n1 = null;

    public static void main(String[] args) throws IOException {

        try (ServerSocket server = new ServerSocket(PUERTO)) {
            System.out.println("Servidor escuchando en  " + PUERTO);

            while (true) {
                Socket cliente = server.accept();
                Conexion conn = new Conexion(cliente);

                try {
                    String recibido = conn.leer();
                    System.out.println("Recibido: " + recibido);

                    if (n1 == null) {
                        n1 = recibido;
                    }

                    if (n1 != null) {
                        String respuesta = Calculadora.procesar(n1);

                        DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
                        dos.writeUTF(respuesta);
                        n1 = null;

                    }
                } catch (Exception e) {
                    DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
                    dos.writeUTF("KO");

                }
                cliente.close();
            }

        }

    }
}