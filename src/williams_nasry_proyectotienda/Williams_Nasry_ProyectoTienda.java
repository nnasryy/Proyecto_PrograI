package williams_nasry_proyectotienda;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Williams_Nasry_ProyectoTienda {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        String entrada;
        int opcionmenu = 0;

        do {
            System.out.println("**** MENÚ ****");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Ventas");
            System.out.println("3. Compras");
            System.out.println("4. Reportes");
            System.out.println("5. Cierre de Caja");
            System.out.println("6. Salir del Sistema");
            System.out.print("Ingrese el dígito de la opción deseada: ");
            entrada = lea.nextLine();

            if (entrada.equals("")) {
                System.out.println("Error: no ingresó ninguna opción.");
            } else if (entrada.length() == 1 && entrada.charAt(0) >= '1' && entrada.charAt(0) <= '6') {
                opcionmenu = entrada.charAt(0) - '0';

                switch (opcionmenu) {
                    case 1:
                        caja();
                        break;
                    case 2:
                        ventas();
                        break;
                    case 3:
                        compras();
                        break;
                    case 4:
                        reportes();
                        break;
                    case 5:
                        cierredecaja();
                        break;
                    case 6:
                        System.out.println("Salida del Sistema...");
                        break;
                }
            } else {
                System.out.println("Error: debe ingresar solo un número del 1 al 6.");
            }

        } while (opcionmenu != 6);

        lea.close();
    }
    
    /////////////////////////////////////////////////////////////////////////////////////

    public static void caja() {
        Scanner lea = new Scanner(System.in);
        System.out.println("*** CAJA ***");
        System.out.print("Ingrese el monto en HNL que añadirá a Caja: ");
        double monto = lea.nextDouble();
        lea.nextLine();
        System.out.println("Su monto de caja actual es de: L." + monto);
        System.out.println("Presione Enter para volver al Menú...");
        lea.nextLine();
    }

    ////////////////////////////////////////////////////////////////////////////////////
    
    public static void ventas() {
        Scanner lea = new Scanner(System.in);
         int codigo = 0, tipocliente;
         double kilogramos =0, precioAzucar = 30.00, precioAvena = 25.00, precioTrigo = 32.00, precioMaiz = 20.00,
                 azucarKg = 0, avenaKg = 0, trigoKg = 0, maizKg = 0, totalAzucar = 0, 
                 totalAvena = 0, totalTrigo = 0, totalMaiz = 0;
                 
                 
        do {
            System.out.println("                                                                                     ");
            System.out.println("*** VENTAS ***");
            System.out.println("                                                                                     ");
            System.out.println(" *** Tipos de Cliente ***");
            System.out.println("Cliente Tipo A - Puede comprar cualquier producto. ");
            System.out.println("Cliente Tipo B - Solo puede comprar Azúcar, Avena o Trigo");
            System.out.println("Cliente Tipo C- Solo puede comprar Maíz");
            System.out.println("                                                                                     ");
            System.out.println("Ingrese 1 si es un Cliente Tipo A");
            System.out.println("Ingrese 2 si es un Cliente Tipo B");
            System.out.println("Ingrese 3 si es un Cliente Tipo C");
            System.out.println("Ingrese el Tipo de Cliente que es dependiendo del producto :");
            tipocliente = lea.nextInt();
            lea.nextLine();

            if (tipocliente < 1 || tipocliente > 3) {
                System.out.println("Error. Opción no válida, vuelva a intentar.");
            }
        } while (tipocliente < 1 || tipocliente > 3);

        if (tipocliente == 1) {
            System.out.println("Usted es: Cliente Tipo A");
        } else if (tipocliente == 2) {
            System.out.println("Usted es: Cliente Tipo B");
        } else if (tipocliente == 3) {
            System.out.println("Usted es: Cliente Tipo C");
        } else {
            System.out.println("Error: debe ingresar un número del 1 al 3.");
        }

        String respuesta;
         
    //Productos
        
        do {
   
          boolean codigovalido;
          
            do {
                codigovalido = true;
                try {
                System.out.println("Productos: ");
                System.out.println("Código 1. Azúcar - L.30");
                System.out.println("Código 2. Avena - L.25");
                System.out.println("Código 3. Trigo - L.32");
                System.out.println("Código 4. Maíz - L.20");
                System.out.println("Ingrese el codigo del producto: ");
                codigo = lea.nextInt();
                lea.nextLine();

                if (codigo < 1 || codigo > 4) {
                    System.out.println("Error. Opción no válida, vuelva a intentar");
                }

                } catch (InputMismatchException e) {
                    System.out.println("Error. Codigo no valido");
                    lea.nextLine();
                }
               
            } while (!codigovalido);
            
             //Validación de opción ingresada
            if (codigo >= 1 && codigo <= 4 && tipocliente == 1) {
                System.out.println("El tipo de cliente con el producto es válido.");
            } else if (codigo >= 1 && codigo < 4 && tipocliente == 2) {
                System.out.println("El tipo de cliente con el producto es válido.");
            } else if (codigo == 4 && tipocliente == 3) {
                System.out.println("El tipo de cliente con el producto es válido");
            } else {
                System.out.println("Error. Opción no válida, vuelva a intentar");
            }
        
            //Kilogramos 
            System.out.println("Ingrese la cantidad en kilogramos que comprara: ");
             kilogramos = lea.nextDouble();
            lea.nextLine();

            //Productos extra
            System.out.println("Desea Agregar otro producto?");
            respuesta = lea.nextLine();
           
          while (!respuesta.equals("si") && !respuesta.equals("no")){
              System.out.println("Respuesta NO valida. Ingrese 'si' o 'no' ");
              respuesta = lea.nextLine().toLowerCase();
          }
          
          if (respuesta.equals("no")){
          break;
          }
   } while (respuesta.toLowerCase().equals("si"));
        
        // Facturación
     
       if (codigo == 1){
           azucarKg += kilogramos;
           totalAzucar += kilogramos * precioAzucar;
       } else if (codigo == 2) {
       avenaKg += kilogramos;
       totalAvena += kilogramos * precioAvena;
       }else if (codigo == 3){
           trigoKg += kilogramos;
           totalTrigo += kilogramos * precioTrigo;
       }else if(codigo == 4){
       maizKg += kilogramos;
       totalMaiz += kilogramos * precioMaiz;
       }
    

if (codigo == 1) {
String producto = "Azucar";
}
       

       
       System.out.println("****FACTURA*****"); 
       
        
        
       
        
        
        
        
        
        
        
        
        
        System.out.println("Presione Enter para volver al Menú...");
        lea.nextLine();

    }

    
    ///////////////////////////////////////////////////////////////////////////////
    
    public static void compras() {
        Scanner lea = new Scanner(System.in);
        System.out.println("*** COMPRAS ***");
        System.out.println("Presione Enter para volver al Menú...");
        lea.nextLine();
    }

    public static void reportes() {
        Scanner lea = new Scanner(System.in);
        System.out.println("*** REPORTES ***");
        System.out.println("Presione Enter para volver al Menú...");
        lea.nextLine();
    }

    public static void cierredecaja() {
        Scanner lea = new Scanner(System.in);
        System.out.println("*** CIERRE DE CAJA ***");
        System.out.println("Presione Enter para volver al Menú...");
        lea.nextLine();
    }

}
