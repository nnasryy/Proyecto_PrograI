package williams_nasry_proyectotienda;

import java.util.Scanner;

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

    public static void ventas() {
        Scanner lea = new Scanner(System.in);
        
        System.out.println("*** VENTAS ***");
        System.out.println("Productos: ");
        System.out.println("Código 1. Azúcar - L.30");
        System.out.println("Código 2. Avena - L.25");
        System.out.println("Código 3. Trigo - L.32");
        System.out.println("Código 4. Maíz - L.20");
        System.out.println(" *** Tipos de Cliente ***");
        System.out.println("Cliente Tipo A - Puede comprar cualquier producto. ");
        System.out.println("Cliente Tipo B - Solo puede comprar Azúcar, Avena Y Trigo");
        System.out.println("Cliente Tipo C- Solo puede comprar Maíz");
        System.out.println("*************************************************");
        System.out.println("Ingrese el Tipo de Cliente que es: ");
        System.out.println("");
        int tipocliente = lea.nextInt();
         lea.nextLine(); 
        
        System.out.println("Productos: ");
        System.out.println("Código 1. Azúcar - L.30");
        System.out.println("Código 2. Avena - L.25");
        System.out.println("Código 3. Trigo - L.32");
        System.out.println("Código 4. Maíz - L.20");
        System.out.println("Ingrese el codigo del producto: ");
        int codigo = lea.nextInt();
         lea.nextLine(); 
        
        if (codigo >=1 ||codigo <= 4 && tipocliente >=1 || tipocliente <=3 ){
            if (codigo >= 1 || codigo <= 4 && tipocliente == 1){
                System.out.println("Usted es Cliente Tipo A");
         } else if (codigo >=1 || codigo < 4 && tipocliente == 2){
                System.out.println("Usted es Cliente Tipo B");
         }else if (codigo == 4 && tipocliente == 3)
                System.out.println("Usted es Cliente Tipo C");
        }else{
         lea.nextLine(); 
        } 
        
        
        
        
        System.out.println("Presione Enter para volver al Menú...");
        lea.nextLine();
    }

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
