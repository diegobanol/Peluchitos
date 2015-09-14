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
public class Interfaz {
    
    private Scanner teclado;
    private int o, i, k; 
    private boolean seguir, find;
    private String nombre;
    private int limite=0;
    private int vender=0;
    private int ganancias=0;
        
    public void menu(Peluchitos[] Producto){
        seguir=true;
        teclado= new Scanner(System.in);
        System.out.println("\nAdministración de productos");
            do{
                System.out.println("\n¿Que desea hacer?");
                System.out.println("1.Registro de nuevos productos");
                System.out.println("2.Buscar Producto");
                System.out.println("3.Eliminar Producto");
                System.out.println("4.Mostrar Inventario");
                System.out.println("5.Realizar Ventas");
                System.out.println("6.Mostrar Ganancias totales");
                System.out.println("7.Salir");
                o=teclado.nextInt();
                this.seleccion(Producto);
            }while(seguir);
        }
   
        public void seleccion(Peluchitos[] Producto){
            teclado= new Scanner(System.in);
            seguir=true;
            switch(o){
               case 1:
                    this.AgregarProducto(Producto);
                    System.out.println("Registrado exitosamente");
                    break;
               case 2:            
                   System.out.println("Ingrese el nombre del producto que desea buscar");
                   nombre=teclado.nextLine();
                   for(i=0; i<limite; i++){
                        this.BuscarProducto(Producto, i);    
                   }
                   if(find==false) System.out.println("No se encuentra el producto");
                break;
                case 3:
                    System.out.println("Ingrese el nombre del producto que desea eliminar");
                    nombre=teclado.nextLine();
                    for(i=0; i<limite; i++){
                        this.EliminarProducto(Producto, i);    
                   }
                    if(find==false) System.out.println("No se encuentra el producto");
                break;
                case 4:
                    this.MostrarInventario(Producto);
                break;
                case 5:
                    System.out.println("Ingrese el nombre del producto que desea vender");
                    nombre=teclado.nextLine();
                    for(i=0; i<limite; i++){
                        this.RealizarVentas(Producto, i);                      
                    }
                    if(find==false) System.out.println("No se encuentra el producto");
                break;
                case 6:
                    this.MostrarGanancias(Producto);
                break;
                case 7:
                    seguir=false;
                break;    
                default:
                    System.out.println("\nOpcion incorrecta\n");
                    break;
        }
    }
        
    public void AgregarProducto(Peluchitos[] Producto){
        teclado= new Scanner(System.in);
        System.out.println("Ingrese el nombre del nuevo producto");
        Producto[limite].nombre=teclado.nextLine();
        System.out.println("Cuanta cantidad hay de dicho producto");
        Producto[limite].cantidad=teclado.nextInt();
        System.out.println("Cual es el precio del producto en pesos");
        Producto[limite].precio=teclado.nextInt(); 
        limite++;
     }
    
    public void BuscarProducto(Peluchitos[] Producto, int i){
        teclado= new Scanner(System.in);
        find=false;
        //nombre=teclado.nextLine();
        if(nombre.equals(Producto[i].nombre)){
            System.out.println("Nombre: "+Producto[i].nombre);
            System.out.println("Cantidad: "+Producto[i].cantidad);
            System.out.println("Precio: "+Producto[i].precio);
            find=true;
        }  
    }
        
    public void EliminarProducto(Peluchitos[] Producto, int i){
        if(nombre.equals(Producto[i].nombre)){
            for(k=i; k<limite; k++){
                if((k+1)==limite){
                    Producto[k].nombre=null;
                    Producto[k].cantidad=0;
                    Producto[k].precio=0;                   
                }else{
                    Producto[k].nombre=Producto[k+1].nombre;
                    Producto[k].cantidad=Producto[k+1].cantidad;
                    Producto[k].precio=Producto[k+1].precio;
                }
            }
            limite--;
            find=true;
        }
    }   
    
    public void MostrarInventario(Peluchitos[] Producto){
        for(i=0;i<limite;i++){
            System.out.println("El "+ (i+1) +" Producto");
            System.out.println("Nombre: "+Producto[i].nombre);
            System.out.println("Cantidad: "+Producto[i].cantidad);
            System.out.println("Precio: "+Producto[i].precio);
            System.out.println(" ");
        }
    }
    
    public void RealizarVentas(Peluchitos[] Producto, int i){
        teclado= new Scanner(System.in);
        find=false;
        if(nombre.equals(Producto[i].nombre)){
            System.out.println("Producto encontrado, cuantos vendera: ");
            vender=teclado.nextInt();
            if(Producto[i].cantidad-vender<0){
                System.out.println("No hay suficiente ingrese otra cantidad");
            }else{
                Producto[i].ventas=Producto[i].ventas+vender;
                Producto[i].cantidad=Producto[i].cantidad-vender;
                System.out.println("Venta exitosa");
            }
            find=true;
        }
    }
    
    public void MostrarGanancias(Peluchitos[] Producto){
        ganancias=0;
        for(i=0; i<limite; i++){
            System.out.println("Las ventas de " + Producto[i].nombre+ " son :" +Producto[i].ventas);
            ganancias=ganancias+(Producto[i].precio*Producto[i].ventas);
            System.out.println("");
        }
        System.out.println("Las ganancias totales son: "+ ganancias);
    }
           
}
