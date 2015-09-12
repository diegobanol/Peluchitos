/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peluchitos;
import java.util.Scanner;

/**
 *
 * @author diego
 */
public class Peluchitos {

     private Scanner teclado;
     public String nombre;
     public int cantidad;
     public int precio;
     public int ventas;
     
     public void AgregarProducto(){
         teclado= new Scanner(System.in);
         System.out.println("Ingrese el nombre del nuevo producto");
         nombre=teclado.nextLine();
         System.out.println("Cuanta cantidad hay de dicho producto");
         cantidad=teclado.nextInt();
         System.out.println("Cual es el precio del producto en pesos");
         precio=teclado.nextInt();  
     }
       
    public static void main(String[] args) {
        
        int i;
        Peluchitos[] Productos;
        Productos= new Peluchitos[100];
        Interfaz Empresa;
        Empresa = new Interfaz();
        
        for(i=0; i<100; i++){
            Productos[i]= new Peluchitos();
        }
        
        Empresa.menu(Productos);        
        
        
        
    }
    
}
