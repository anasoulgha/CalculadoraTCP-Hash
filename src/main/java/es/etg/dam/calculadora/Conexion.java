package es.etg.dam.calculadora;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.net.Socket;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Conexion {
    
    private Socket cliente;

    public void escribir(String msg) throws Exception {
        DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());


        dos.writeUTF(UtilSeguridad.prepararPaquete(msg));
    }

    public String leer() throws Exception {
        DataInputStream dis = new DataInputStream(cliente.getInputStream());
        String paqueteBruto = dis.readUTF();
        
        System.out.println("DEBUG - Paquete recibido (cifrado + hash): " + paqueteBruto);
        //return UtilSeguridad.desempaquetar(dis.readUTF());
        return UtilSeguridad.desempaquetar(paqueteBruto);
    }
}

