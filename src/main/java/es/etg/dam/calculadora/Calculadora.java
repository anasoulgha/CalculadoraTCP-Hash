package es.etg.dam.calculadora;

public class Calculadora {
    
    public static String procesar(String n){
        try {
            double num1 = Double.parseDouble(n);

            return String.valueOf(num1*num1);

        } catch (Exception e) {
            return "error";
        }

    }
}
