package williams_nasry_proyectotienda;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Williams_Nasry_ProyectoTienda {

    public static void main(String[] args) {
        double monto = 0, totalventa = 0;
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
                    case 1: {
                        System.out.println("*** CAJA ***");
                        System.out.print("Ingrese el monto en HNL que añadirá a Caja: ");
                        monto = lea.nextDouble();
                        lea.nextLine();
                        System.out.println("Su monto de caja actual es de: L." + monto);
                        System.out.println("Presione Enter para volver al Menú...");
                        lea.nextLine();
                        break;
                    }

                    case 2: {
                        int codigo = 0, tipocliente;
                        String producto = "", respuesta;
                        double kilogramos = 0, precioAzucar = 30.00, precioAvena = 25.00, precioTrigo = 32.00, precioMaiz = 20.00;
                        double azucarKg = 0, avenaKg = 0, trigoKg = 0, maizKg = 0;
                        double totalAzucar = 0, totalAvena = 0, totalTrigo = 0, totalMaiz = 0, totalDescuento = 0;

                        do {
                            System.out.println("*** VENTAS ***");
                            System.out.println("Ingrese el Tipo de Cliente (1=A, 2=B, 3=C):");
                            tipocliente = lea.nextInt();
                            lea.nextLine();
                            if (tipocliente < 1 || tipocliente > 3) {
                                System.out.println("Error. Opción no válida, vuelva a intentar.");
                            }
                        } while (tipocliente < 1 || tipocliente > 3);

                        do {
                            boolean codigovalido = false;
                            while (!codigovalido) {
                                try {
                                    System.out.println("Productos: \n1. Azúcar\n2. Avena\n3. Trigo\n4. Maíz");
                                    System.out.print("Ingrese el código del producto: ");
                                    codigo = lea.nextInt();
                                    lea.nextLine();
                                    codigovalido = codigo >= 1 && codigo <= 4;
                                    if (!codigovalido) System.out.println("Código inválido. Intente nuevamente.");
                                } catch (InputMismatchException e) {
                                    System.out.println("Error. Código no válido");
                                    lea.nextLine();
                                }
                            }

                            if ((tipocliente == 1) || (tipocliente == 2 && codigo < 4) || (tipocliente == 3 && codigo == 4)) {
                                System.out.print("Ingrese la cantidad en kilogramos: ");
                                kilogramos = lea.nextDouble();
                                lea.nextLine();

                                switch (codigo) {
                                    case 1:
                                        producto = "Azúcar";
                                        azucarKg += kilogramos;
                                        totalAzucar += kilogramos * precioAzucar;
                                        break;
                                    case 2:
                                        producto = "Avena";
                                        avenaKg += kilogramos;
                                        totalAvena += kilogramos * precioAvena;
                                        break;
                                    case 3:
                                        producto = "Trigo";
                                        trigoKg += kilogramos;
                                        totalTrigo += kilogramos * precioTrigo;
                                        break;
                                    case 4:
                                        producto = "Maíz";
                                        maizKg += kilogramos;
                                        totalMaiz += kilogramos * precioMaiz;
                                        break;
                                }
                            } else {
                                System.out.println("El cliente no puede comprar ese producto.");
                            }

                            System.out.print("¿Desea agregar otro producto? (si/no): ");
                            respuesta = lea.nextLine().toLowerCase();
                        } while (respuesta.equals("si"));

                        double subtotal = totalAzucar + totalAvena + totalTrigo + totalMaiz;
                        if (subtotal >= 5000) {
                            totalDescuento = subtotal * 0.9;
                            System.out.println("Aplica 10% de descuento");
                        } else if (subtotal >= 1000) {
                            totalDescuento = subtotal * 0.95;
                            System.out.println("Aplica 5% de descuento");
                        } else {
                            totalDescuento = subtotal;
                            System.out.println("No aplica descuento");
                        }

                        totalventa = totalDescuento * 0.7;
                        System.out.println("TOTAL: L." + totalventa);
                        System.out.println("Presione Enter para volver al Menú...");
                        lea.nextLine();
                        break;
                    }

                    case 3: {
                        String nombreproducto = "";
                        int proveedor = 0;
                        int azucar = 25, avenab = 20, avenac = 22, trigo = 30, maiz = 18;
                        double kilos = 0, compraTotal = 0;
                        System.out.println("*** COMPRAS ***");
                        do {
                            System.out.println("1. Proveedor A\n2. Proveedor B\n3. Proveedor C");
                            proveedor = lea.nextInt();
                            if (proveedor < 1 || proveedor > 3) System.out.println("Opción inválida");
                        } while (proveedor < 1 || proveedor > 3);

                        System.out.println("Productos: \n1. Azúcar\n2. Avena (B)\n3. Avena (C)\n4. Trigo\n5. Maíz");
                        int comPro = lea.nextInt();

                        if ((proveedor == 1 && (comPro == 1 || comPro == 5)) ||
                            (proveedor == 2 && (comPro == 2 || comPro == 4)) ||
                            (proveedor == 3 && comPro == 3)) {

                            System.out.print("Ingrese los kilogramos: ");
                            kilos = lea.nextDouble();
                            switch (comPro) {
                                case 1:
                                    nombreproducto = "Azúcar";
                                    compraTotal = kilos * azucar;
                                    break;
                                case 2:
                                    nombreproducto = "Avena (B)";
                                    compraTotal = kilos * avenab;
                                    break;
                                case 3:
                                    nombreproducto = "Avena (C)";
                                    compraTotal = kilos * avenac;
                                    break;
                                case 4:
                                    nombreproducto = "Trigo";
                                    compraTotal = kilos * trigo;
                                    break;
                                case 5:
                                    nombreproducto = "Maíz";
                                    compraTotal = kilos * maiz;
                                    break;
                            }
                            System.out.println("Producto: " + nombreproducto + ", Total: L." + compraTotal);
                        } else {
                            System.out.println("Proveedor no vende ese producto");
                        }
                        lea.nextLine(); lea.nextLine();
                        break;
                    }

                    case 4: {
                        System.out.println("*** REPORTES ***");
                        System.out.println("Presione Enter para volver al Menú...");
                        lea.nextLine();
                        break;
                    }

                    case 5: {
                        System.out.println("*** CIERRE DE CAJA ***");
                        System.out.println("Presione Enter para volver al Menú...");
                        lea.nextLine();
                        break;
                    }

                    case 6: {
                        System.out.println("Salida del Sistema...");
                        break;
                    }
                }
            } else {
                System.out.println("Error: debe ingresar solo un número del 1 al 6.");
            }

        } while (opcionmenu != 6);
        lea.close();
    }
}
