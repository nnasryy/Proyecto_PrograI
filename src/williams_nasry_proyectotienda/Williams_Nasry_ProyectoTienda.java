package williams_nasry_proyectotienda;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Williams_Nasry_ProyectoTienda {

    public static void main(String[] args) {
        double monto = 0, totalventa =0;
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
        int codigo = 0, tipocliente, productos = 0;
        String producto = "";
        double kilogramos = 0, precioAzucar = 30.00, precioAvena = 25.00, precioTrigo = 32.00, precioMaiz = 20.00,
                azucarKg = 0, avenaKg = 0, trigoKg = 0, maizKg = 0, totalAzucar = 0,
                totalAvena = 0, totalTrigo = 0, totalMaiz = 0, totalDescuento = 0;

        do {
            System.out.println("                                                                                     ");
            System.out.println("*** VENTAS ***");
            System.out.println("                                                                                     ");
            System.out.println(" *** Tipos de Cliente ***");
            System.out.println("Cliente Tipo A - Puede comprar cualquier producto. ");
            System.out.println("Cliente Tipo B - Solo puede comprar Azúcar, Avena o Trigo");
            System.out.println("Cliente Tipo C- Solo puede comprar Maiz");
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
                    System.out.println("Codigo 1. Azúcar - L.30");
                    System.out.println("Codigo 2. Avena - L.25");
                    System.out.println("Codigo 3. Trigo - L.32");
                    System.out.println("Codigo 4. Maíz - L.20");
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

            if (codigo == 1) {
                producto = "Azucar";
                azucarKg += kilogramos;
                totalAzucar += kilogramos * precioAzucar;
            } else if (codigo == 2) {
                producto = "Avena";
                avenaKg += kilogramos;
                totalAvena += kilogramos * precioAvena;
            } else if (codigo == 3) {
                producto = "Trigo";
                trigoKg += kilogramos;
                totalTrigo += kilogramos * precioTrigo;
            } else if (codigo == 4) {
                producto = "Maiz";
                maizKg += kilogramos;
                totalMaiz += kilogramos * precioMaiz;
            }
            //Productos extra
            System.out.println("Desea Agregar otro producto?");
            respuesta = lea.nextLine();

            while (!respuesta.equals("si") && !respuesta.equals("no")) {
                System.out.println("Respuesta NO valida. Ingrese 'si' o 'no' ");
                respuesta = lea.nextLine().toLowerCase();
            }

            if (respuesta.equals("no")) {
                break;
            }
        } while (respuesta.toLowerCase().equals("si"));

        
        // Facturación
        System.out.println();
        System.out.println("****FACTURA*****");
        if (azucarKg > 0) {
            System.out.println("Azucar: " + azucarKg + "kg" + " - Total: L." + totalAzucar);
        }
        if (avenaKg > 0) {
            System.out.println("Avena: " + avenaKg + "kg" + " - Total: L." + totalAvena);
        }
        if (trigoKg > 0) {
            System.out.println("Trigo: " + trigoKg + "kg" + " - Total: L." + totalTrigo);
        }
        if (maizKg > 0) {
            System.out.println("Maiz: " + maizKg + "kg" + " - Total: L." + totalMaiz);
        }

        double subtotal = totalAzucar + totalAvena + totalTrigo + totalMaiz;
        System.out.println();
        System.out.println("Descuentos:");
        System.out.println("Compra Mayor o Igual a L.1,000 - 5%");
        System.out.println("Compras Mayor o Igual a L.5,000 - 10%");
        System.out.println();
        if (subtotal >= 1000) {
            totalDescuento = (subtotal - (subtotal * 0.5));
            System.out.println("Tu Compra Aplica a el 5% de Descuento");

        } else if (subtotal >= 5000) {
            totalDescuento = (subtotal - (subtotal * 0.10));
            System.out.println("Tu Compra Aplica a el 10% de Descuento");
        } else if (subtotal < 1000) {
            System.out.println("No Aplica Descuento");
            totalDescuento = (subtotal * 1);
        }

        double totalventa = (totalDescuento * 0.7);
        System.out.println("TOTAL: L." + totalventa);

        System.out.println("Presione Enter para volver al Menú...");
        lea.nextLine();

    }

    ///////////////////////////////////////////////////////////////////////////////
    
    public static void compras() {
        Scanner lea = new Scanner(System.in);
        String nombreproducto = "";
        int proveedor = 0, azucar = 25, avenab = 20, avenac = 22, trigo = 30, maiz = 18;
        double kilos = 0, azucarKilos = 0, avenabKilos = 0,avenacKilos = 0, trigoKilos = 0, maizKilos = 0, compraTotal = 0;
        do{
        System.out.println("*** COMPRAS ***");
        System.out.println();
        System.out.println("*** Menu de Proveedores ***");
        System.out.println("1. Proveedor A: Vende Azucar y Maiz.");
        System.out.println("2. Proveedor B: Vende Avena y Trigo");
        System.out.println("3. Proveedor C: Vende solamente Avena");
        System.out.println("Ingrese un numero del 1 al 3 para seleccionar el tipo de proveedor: ");
         proveedor = lea.nextInt();
        
        if (proveedor < 1 || proveedor > 3){
            System.out.println("Error. Ingrese una opcion del 1-3");
        }
        
        }while(proveedor < 1 || proveedor > 3);
        
        System.out.println("*** Menu de Productos ***");
        System.out.println("Codigo 1. Azucar - L. 25");
        System.out.println("Codigo 2. Avena (Proveedor B) - L.20");
        System.out.println("Codigo 3. Avena (Proveedor C) - L.22");
        System.out.println("Codigo 4. Trigo - L.30");
        System.out.println("Codigo 5. Maiz - L.18");
        int comPro = lea.nextInt(); //int compra de producto
        
        //verificación de proveedor con producto 
        if (proveedor == 1 && comPro == 1 || comPro == 5){
            System.out.println("Ha indicado una compra de Proveedor A");
        }else if(proveedor == 2 && comPro == 2 || comPro == 4){
        System.out.println("Ha indicado una compra de Proveedor B");
        }else if(proveedor == 3 && comPro == 3){
            System.out.println("Ha indicado una compra de Proveedor C");
        }else{
            System.out.println("Proveedor no vende dicho Producto");
        }
                //Kilogramos 
        System.out.println("Ingrese la cantidad que comprara en Kilogramos:");
        kilos = lea.nextDouble();
        
        if (comPro == 1 ){
        nombreproducto  = "Azucar";
        azucarKilos += kilos;
        compraTotal += kilos * azucar;
        }else if (comPro == 2){
        nombreproducto = "Avena, Proveedor B";
        avenabKilos += kilos;
        compraTotal += kilos * avenab;
        }else if(comPro == 3){
         nombreproducto = "Avena, Proveedor C";
         avenacKilos += kilos;
         compraTotal += kilos * avenac;
        }else if (comPro == 4){
           nombreproducto = "Trigo";
          trigoKilos += kilos;
          compraTotal += kilos * azucar;
        }else if (comPro == 5){
        nombreproducto = "Maiz";
        maizKilos += kilos;
        compraTotal += kilos * maiz;
        }
        
        System.out.println("*** Total de la Compra ***");
        System.out.println("Nombre del producto: " + nombreproducto);
        System.out.println("Total: L." + compraTotal);        

        System.out.println("Presione Enter para volver al Menú...");
        lea.nextLine();
        lea.nextLine();
    }
    
    ///////////////////////////////////////////////////////////////////////

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
