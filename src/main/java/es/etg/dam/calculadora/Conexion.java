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

    public String leer() throws IOException {

        InputStream aux = cliente.getInputStream();
        DataInputStream input = new DataInputStream(aux);
        String msg = input.readUTF();
        return msg;

    }

    public void escribir(String msg) throws IOException {
       DataOutputStream dos = new DataOutputStream(cliente.getOutputStream()); 
       dos.writeUTF(msg);
    }

}