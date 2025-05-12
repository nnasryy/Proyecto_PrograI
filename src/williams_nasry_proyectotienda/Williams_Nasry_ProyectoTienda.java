package williams_nasry_proyectotienda;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Williams_Nasry_ProyectoTienda {

    public static void main(String[] args) {
        double monto = 0, totalventa = 0;
        Scanner lea = new Scanner(System.in);
        String entrada, nombreproductoCompra = "", producto = "";
        int opcionmenu = 0, proveedor = 0, codigo = 0, tipocliente = 0;
        double precioAzucarCompra = 25.0, precioAvenaBCompra = 20.0, precioAvenaCCompra = 22.0, precioTrigoCompra = 30.0, precioMaizCompra = 18.0, 
        kilos =0,  azucarKilosCompra = 0,  avenabKilosCompra = 0, avenacKilosCompra = 0, trigoKilosCompra = 0, maizKilosCompra = 0,  compraTotal = 0, kilogramos = 0,
              precioAzucarVenta = 30.00, precioAvenaVenta = 25.00, precioTrigoVenta = 32.00, precioMaizVenta = 20.00,azucarKilosVenta = 0, avenaKilosVenta = 0,
                trigoKilosVenta = 0, maizKilosVenta = 0,  totalAzucar = 0, totalAvena = 0,
                totalTrigo = 0, totalMaiz = 0;
                      
                      
                        
                        

        do {
            System.out.println("**** MENU ****");
            System.out.println("1. Abrir Caja");
            System.out.println("2. Ventas");
            System.out.println("3. Compras");
            System.out.println("4. Reportes");
            System.out.println("5. Cierre de Caja");
            System.out.println("6. Salir del Sistema");
            System.out.print("Ingrese el digito de la opcion deseada: ");

            entrada = lea.nextLine();
            opcionmenu = 0;

            if (entrada.equals("")) {
                System.out.println("Error: no ingreso ninguna opcion.");
            } else if (entrada.length() == 1 && entrada.charAt(0) >= '1' && entrada.charAt(0) <= '6') {
                opcionmenu = entrada.charAt(0) - '0';

                switch (opcionmenu) {
                    //CAJA
                    case 1:
                        System.out.println("*** CAJA ***");
                        System.out.print("Su monto actual: "+monto);
                        System.out.print("Ingrese el monto en HNL que anadira a Caja: ");
                        try {
                            monto = lea.nextDouble();
                        } catch (InputMismatchException e) {
                            System.out.println("Entrada invalida. Por favor ingrese un numero.");
                            lea.nextLine();
                            monto = 0;
                        }
                        lea.nextLine();
                        System.out.println("Su monto de caja actual es de: L." + monto);
                        System.out.println("Presione Enter para volver al Menu...");
                        lea.nextLine();
                        break;
                        
                    // VENTAS 
                        
                    case 2:
                      

                        do {
                            System.out.println();
                            System.out.println("*** VENTAS ***");
                            System.out.println(" *** Tipos de Cliente ***");
                            System.out.println("Cliente Tipo A - Puede comprar cualquier producto. ");
                            System.out.println("Cliente Tipo B - Solo puede comprar Azucar, Avena o Trigo");
                            System.out.println("Cliente Tipo C- Solo puede comprar Maiz");
                            System.out.println("Ingrese 1 si es un Cliente Tipo A");
                            System.out.println("Ingrese 2 si es un Cliente Tipo B");
                            System.out.println("Ingrese 3 si es un Cliente Tipo C");
                            System.out.print("Ingrese el Tipo de Cliente que es dependiendo del producto : ");

                            try {
                                tipocliente = lea.nextInt();
                                lea.nextLine();
                                if (tipocliente < 1 || tipocliente > 3) {
                                    System.out.println("Error. Opcion no valida, vuelva a intentar.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Error. Entrada no valida. Por favor ingrese un numero del 1 al 3.");
                                lea.nextLine();
                                tipocliente = 0;
                            }
                        } while (tipocliente < 1 || tipocliente > 3);

                        if (tipocliente == 1) {
                            System.out.println("Usted es: Cliente Tipo A");
                        } else if (tipocliente == 2) {
                            System.out.println("Usted es: Cliente Tipo B");
                        } else if (tipocliente == 3) {
                            System.out.println("Usted es: Cliente Tipo C");
                        }

                        String respuesta;

                        do {
                            boolean productInputValid = false;

                            do {
                                productInputValid = true;
                                try {
                                    System.out.println("Productos: ");
                                    System.out.println("Codigo 1. Azucar - L.30");
                                    System.out.println("Codigo 2. Avena - L.25");
                                    System.out.println("Codigo 3. Trigo - L.32");
                                    System.out.println("Codigo 4. Maiz - L.20");
                                    System.out.print("Ingrese el codigo del producto: ");
                                    codigo = lea.nextInt();
                                    lea.nextLine();

                                    boolean clientProductMatch = false;
                                    if (tipocliente == 1 && (codigo >= 1 && codigo <= 4)) {
                                        clientProductMatch = true;
                                    } else if (tipocliente == 2 && (codigo >= 1 && codigo <= 3)) {
                                        clientProductMatch = true;
                                    } else if (tipocliente == 3 && codigo == 4) {
                                        clientProductMatch = true;
                                    }

                                    if (!clientProductMatch) {
                                        System.out.println("Error. El tipo de cliente no puede comprar este producto. Intente de nuevo.");
                                        productInputValid = false;
                                    }

                                } catch (InputMismatchException e) {
                                    System.out.println("Error. Codigo no valido. Por favor ingrese un numero.");
                                    lea.nextLine();
                                    productInputValid = false;
                                }
                            } while (!productInputValid);

                            System.out.print("Ingrese la cantidad en kilogramos que comprara: ");
                            try {
                                kilogramos = lea.nextDouble();
                                lea.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Error. Cantidad en kilogramos no valida. Compra cancelada para este producto.");
                                lea.nextLine();
                                kilogramos = 0;
                            }

                            if (kilogramos > 0) {
                                if (codigo == 1) {
                                    producto = "Azucar";
                                    azucarKilosVenta += kilogramos;
                                    totalAzucar += kilogramos * precioAzucarVenta;
                                } else if (codigo == 2) {
                                    producto = "Avena";
                                    avenaKilosVenta += kilogramos;
                                    totalAvena += kilogramos * precioAvenaVenta;
                                } else if (codigo == 3) {
                                    producto = "Trigo";
                                    trigoKilosVenta += kilogramos;
                                    totalTrigo += kilogramos * precioTrigoVenta;
                                } else if (codigo == 4) {
                                    producto = "Maiz";
                                    maizKilosVenta += kilogramos;
                                    totalMaiz += kilogramos * precioMaizVenta;
                                }
                            }

                            System.out.print("Desea Agregar otro producto? (si/no): ");
                            respuesta = lea.nextLine().toLowerCase();

                            while (!respuesta.equals("si") && !respuesta.equals("no")) {
                                System.out.print("Respuesta NO valida. Ingrese 'si' o 'no' ");
                                respuesta = lea.nextLine().toLowerCase();
                            }

                        } while (respuesta.equals("si"));


                        System.out.println("****FACTURA*****");
                        if (azucarKilosVenta > 0) {
                            System.out.println("Azucar: " + azucarKilosVenta + "kg" + " - Total: L." + totalAzucar);
                        }
                        if (avenaKilosVenta > 0) {
                            System.out.println("Avena: " + avenaKilosVenta + "kg" + " - Total: L." + totalAvena);
                        }
                        if (trigoKilosVenta > 0) {
                            System.out.println("Trigo: " + trigoKilosVenta + "kg" + " - Total: L." + totalTrigo);
                        }
                        if (maizKilosVenta > 0) {
                            System.out.println("Maiz: " + maizKilosVenta + "kg" + " - Total: L." + totalMaiz);
                        }

                        double subtotal = totalAzucar + totalAvena + totalTrigo + totalMaiz;
                        System.out.println("Subtotal: L." + subtotal);

                        System.out.println("Descuentos:");
                        System.out.println("Compra Mayor o Igual a L.1,000 - 5%");
                        System.out.println("Compras Mayor o Igual a L.5,000 - 10%");

                        double descuentoAplicado = 0;
                        double montoConDescuento;

                        if (subtotal >= 5000) {
                            descuentoAplicado = subtotal * 0.10;
                            System.out.println("Tu Compra Aplica al 10% de Descuento");
                        } else if (subtotal >= 1000) {
                            descuentoAplicado = subtotal * 0.05;
                            System.out.println("Tu Compra Aplica al 5% de Descuento");
                        } else {
                            System.out.println("No Aplica Descuento");
                            descuentoAplicado = 0;
                        }

                        montoConDescuento = subtotal - descuentoAplicado;
                        totalventa = montoConDescuento;

                        System.out.println("Descuento aplicado: L." + descuentoAplicado);
                        System.out.println("TOTAL: L." + totalventa);

                        monto += totalventa;
                        
                        System.out.println("Presione Enter para volver al Menu...");
                        lea.nextLine();
                        break;
                        
                // COMPRAS 
                        
                    case 3:
                        do {
                            System.out.println("*** COMPRAS ***");
                            System.out.println("*** Menu de Proveedores ***");
                            System.out.println("1. Proveedor A: Vende Azucar y Maiz.");
                            System.out.println("2. Proveedor B: Vende Avena (L.20) y Trigo.");
                            System.out.println("3. Proveedor C: Vende solamente Avena (L.22).");
                            System.out.print("Ingrese un numero del 1 al 3 para seleccionar el tipo de proveedor: ");

                            try {
                                proveedor = lea.nextInt();
                                lea.nextLine();
                                if (proveedor < 1 || proveedor > 3) {
                                    System.out.println("Error. Ingrese una opcion del 1-3.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Error. Entrada no valida. Por favor ingrese un numero del 1 al 3.");
                                lea.nextLine();
                                proveedor = 0;
                            }
                        } while (proveedor < 1 || proveedor > 3);

                        System.out.println("*** Menu de Productos a Comprar ***");
                        System.out.println("Codigo 1. Azucar - L. " + precioAzucarCompra);
                        System.out.println("Codigo 2. Avena (Proveedor B) - L." + precioAvenaBCompra);
                        System.out.println("Codigo 3. Avena (Proveedor C) - L." + precioAvenaCCompra);
                        System.out.println("Codigo 4. Trigo - L." + precioTrigoCompra);
                        System.out.println("Codigo 5. Maiz - L." + precioMaizCompra);

                        int comPro = 0;
                        boolean productPurchaseValid = false;
                        do {
                            productPurchaseValid = true;
                            System.out.print("Ingrese el codigo del producto que desea comprar: ");
                            try {
                                comPro = lea.nextInt();
                                lea.nextLine();

                                boolean providerProductMatch = false;
                                if (proveedor == 1 && (comPro == 1 || comPro == 5)) {
                                    providerProductMatch = true;
                                    System.out.println("Ha indicado una compra de Proveedor A");
                                } else if (proveedor == 2 && (comPro == 2 || comPro == 4)) {
                                    providerProductMatch = true;
                                    System.out.println("Ha indicado una compra de Proveedor B");
                                } else if (proveedor == 3 && comPro == 3) {
                                    providerProductMatch = true;
                                    System.out.println("Ha indicado una compra de Proveedor C");
                                } else {
                                    System.out.println("Error: El proveedor seleccionado no vende dicho producto. Intente de nuevo.");
                                    productPurchaseValid = false;
                                }

                            } catch (InputMismatchException e) {
                                System.out.println("Error. Codigo de producto no valido. Por favor ingrese un numero.");
                                lea.nextLine();
                                productPurchaseValid = false;
                            }
                        } while (!productPurchaseValid);


                        System.out.print("Ingrese la cantidad que comprara en Kilogramos: ");
                        try {
                            kilos = lea.nextDouble();
                            lea.nextLine();
                        } catch (InputMismatchException e) {
                            System.out.println("Error. Cantidad en kilogramos no valida. Compra cancelada para este producto.");
                            lea.nextLine();
                            kilos = 0;
                        }

                        if (kilos > 0) {
                            if (comPro == 1) {
                                nombreproductoCompra = "Azucar (Prov A)";
                                azucarKilosCompra += kilos;
                                compraTotal += kilos * precioAzucarCompra;
                            } else if (comPro == 2) {
                                nombreproductoCompra = "Avena (Prov B)";
                                avenabKilosCompra += kilos;
                                compraTotal += kilos * precioAvenaBCompra;
                            } else if (comPro == 3) {
                                nombreproductoCompra = "Avena (Prov C)";
                                avenacKilosCompra += kilos;
                                compraTotal += kilos * precioAvenaCCompra;
                            } else if (comPro == 4) {
                                nombreproductoCompra = "Trigo (Prov B)";
                                trigoKilosCompra += kilos;
                                compraTotal += kilos * precioTrigoCompra;
                            } else if (comPro == 5) {
                                nombreproductoCompra = "Maiz (Prov A)";
                                maizKilosCompra += kilos;
                                compraTotal += kilos * precioMaizCompra;
                            }
                        }

                        System.out.println("*** Resumen de la Compra ***");
                        System.out.println("Producto: " + nombreproductoCompra);
                        System.out.println("Cantidad: " + kilos + " kg");
                        System.out.println("Compra Total: L." + compraTotal);
                  
                        if (monto > compraTotal){
                        monto -= compraTotal;
                        }else{
                            System.out.println("Compra no se puede realizar, no hay suficiente dinero en caja.");
                            break;
                        }

                        System.out.println("Presione Enter para volver al Menu...");
                        lea.nextLine();
                        break;
                    // REPORTES
                    case 4:
                        System.out.println("*** REPORTES ***");
                        System.out.println("Presione Enter para volver al Menu...");
                        lea.nextLine();
                        break;
                  // CIERRE DE CAJA
                    case 5:
                        System.out.println("*** CIERRE DE CAJA ***");
                        System.out.println("Monto final en caja: L." + monto);
                        System.out.println("Presione Enter para volver al Menu...");
                        lea.nextLine();
                        break;
                   // SALIDA DE SISTEMA
                    case 6:
                        System.out.println("Salida del Sistema...");
                        break;
                }

            } else {
                System.out.println("Error: debe ingresar solo un numero del 1 al 6.");
            }

        } while (opcionmenu != 6);

        lea.close();
    }
}




