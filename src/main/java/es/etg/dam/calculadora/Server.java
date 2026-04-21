package es.etg.dam.calculadora;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PUERTO = 8888;

    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PUERTO)) {
            System.out.println("Servidor escuchando en " + PUERTO);

            while (true) {
                Socket cliente = server.accept();
                Conexion conn = new Conexion(cliente);

                try {
          
                    String recibido = conn.leer();
                    System.out.println("Recibido: " + recibido);

                   
                    String respuesta = Calculadora.procesar(recibido);

                  
                    conn.escribir(respuesta); 

                } catch (Exception e) {
                    System.err.println("Error en la transacción: " + e.getMessage());
                    try {
                        conn.escribir("KO"); 
                    } catch (Exception ex) { }
                } finally {
                    cliente.close();
                }
            }
        }
    }
}