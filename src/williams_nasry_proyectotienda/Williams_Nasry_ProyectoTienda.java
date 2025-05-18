package williams_nasry_proyectotienda;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Williams_Nasry_ProyectoTienda {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        boolean montoValido = false, compraValida = false, cajacerrada = false, depositovalido = false;
        String entrada, nombreproductoCompra = "", producto = "", tipocliente = "", proveedor = "";
        int opcionmenu = 0, codigo = 0, compras = 0, ventas = 0;
        double monto = 0, totalventa = 0, precioAzucarCompra = 25.0, precioAvenaBCompra = 20.0, precioAvenaCCompra = 22.0, precioTrigoCompra = 30.0, precioMaizCompra = 18.0,
                kilos = 0, azucarKilosCompra = 0, avenabKilosCompra = 0, avenacKilosCompra = 0, trigoKilosCompra = 0, maizKilosCompra = 0, compraTotal = 0,
                kilogramos = 0, precioAzucarVenta = 30.00, precioAvenaVenta = 25.00, precioTrigoVenta = 32.00, precioMaizVenta = 20.00, azucarKilosVenta = 0,
                avenaKilosVenta = 0, trigoKilosVenta = 0, maizKilosVenta = 0, totalAzucar = 0, totalAvena = 0,
                totalTrigo = 0, totalMaiz = 0, stockAzucar = 0, stockAvena = 0, stockTrigo = 0, stockMaiz = 0, volumenVentas = 0, volumenCompras = 0, maxdepositar = 0,
                gananciaTotal = 0;

        double compraMasCostosa = 0;
        String productoCompraMasCostosa = "";
        double ventaMayorGanancia = 0;
        String productoVentaMayorGanancia = "";
        int cantidadAzucarVendida = 0;
        int cantidadAvenaVendida = 0;
        int cantidadTrigoVendida = 0;
        int cantidadMaizVendida = 0;
        String productoEstrella = "Ninguno";
        int maxVentasProducto = 0;

        do {
            System.out.println();
            System.out.println("==== MENU ====");
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
                opcionmenu = Integer.parseInt(entrada);

                switch (opcionmenu) {

                    //CAJA

                    case 1:
                        if (cajacerrada) {
                            cajacerrada = false;
                            montoValido = false;
                            System.out.println("La caja ha sido reabierta.");
                            System.out.println("Presione Enter para volver al Menu...");
                            lea.nextLine();
                            break;
                        }

                        System.out.println();
                        System.out.println("==== CAJA ====");
                        System.out.println("Su monto actual: " + monto);
                        do {
                            System.out.printf("Ingrese el monto en HNL que anadira a Caja: ");
                            try {
                                String nuevoMontoStr = lea.nextLine();
                                double nuevoMonto = Double.parseDouble(nuevoMontoStr);
                                if (nuevoMonto < 0) {
                                    System.out.print("Error, Valor Ingresado No Valido.");
                                } else {
                                    monto += nuevoMonto;
                                    montoValido = true;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Error, Valor Ingresado No Valido. ");
                            }
                        } while (!montoValido);
                        System.out.println("Su monto de caja actual es de: L." + monto);
                        System.out.println("Presione Enter para volver al Menu...");
                        lea.nextLine();
                        break;


                    // VENTAS
                    case 2:
                        if (cajacerrada) {
                            System.out.println("No se puede realizar esta opcion. La caja esta cerrada.");
                            break;
                        }

                        totalAzucar = 0;
                        totalAvena = 0;
                        totalTrigo = 0;
                        totalMaiz = 0;
                        azucarKilosVenta = 0;
                        avenaKilosVenta = 0;
                        trigoKilosVenta = 0;
                        maizKilosVenta = 0;
                        if (stockMaiz > 0 || stockAzucar > 0 || stockAvena > 0 || stockTrigo > 0) {
                            do {
                                System.out.println();
                                System.out.println("==== VENTAS ====");
                                System.out.println();
                                System.out.println(" *** Tipos de Cliente ***");
                                System.out.println();
                                System.out.println("Cliente Tipo A - Puede comprar cualquier producto. ");
                                System.out.println("Cliente Tipo B - Solo puede comprar Azucar, Avena o Trigo");
                                System.out.println("Cliente Tipo C - Solo puede comprar Maiz");
                                System.out.println();
                                System.out.println("Ingrese A si es un Cliente Tipo A");
                                System.out.println("Ingrese B si es un Cliente Tipo B");
                                System.out.println("Ingrese C si es un Cliente Tipo C");
                                System.out.print("Ingrese el Tipo de Cliente que es dependiendo del producto: ");

                                tipocliente = lea.nextLine().toUpperCase();

                                if (!tipocliente.equals("A") && !tipocliente.equals("B") && !tipocliente.equals("C")) {
                                    System.out.println("Error. Opcion no valida, vuelva a intentar.");
                                }

                            } while (!tipocliente.equals("A") && !tipocliente.equals("B") && !tipocliente.equals("C"));

                            if (tipocliente.equals("A")) {
                                System.out.println();
                                System.out.println("Usted es: Cliente Tipo A");
                            } else if (tipocliente.equals("B")) {
                                System.out.println();
                                System.out.println("Usted es: Cliente Tipo B");
                            } else if (tipocliente.equals("C")) {
                                System.out.println();
                                System.out.println("Usted es: Cliente Tipo C");
                            }

                            String respuesta;

                            do {
                                boolean productInputValid = false;

                                do {
                                    productInputValid = true;
                                    try {
                                        System.out.println();
                                        System.out.println("==== PRODUCTOS ==== ");
                                        System.out.println("Codigo 1. Azucar - L.30");
                                        System.out.println("Codigo 2. Avena - L.25");
                                        System.out.println("Codigo 3. Trigo - L.32");
                                        System.out.println("Codigo 4. Maiz - L.20");
                                        System.out.print("Ingrese el codigo del producto: ");
                                        codigo = Integer.parseInt(lea.nextLine());


                                        boolean clientProductMatch = false;
                                        if (tipocliente.equals("A") && (codigo >= 1 && codigo <= 4)) {
                                            clientProductMatch = true;
                                        } else if (tipocliente.equals("B") && (codigo >= 1 && codigo <= 3)) {
                                            clientProductMatch = true;
                                        } else if (tipocliente.equals("C") && codigo == 4) {
                                            clientProductMatch = true;
                                        }

                                        if (!clientProductMatch) {
                                            System.out.println("Error. El tipo de cliente no puede comprar este producto. Intente de nuevo.");
                                            productInputValid = false;
                                        }

                                    } catch (NumberFormatException e) {
                                        System.out.println("Error. Codigo no valido. Por favor ingrese un numero.");
                                        productInputValid = false;
                                    }
                                } while (!productInputValid);

                                System.out.print("Ingrese la cantidad en kilogramos que comprara: ");
                                try {
                                    kilogramos = Double.parseDouble(lea.nextLine());

                                } catch (NumberFormatException e) {
                                    System.out.println("Error. Cantidad en kilogramos no valida. Compra cancelada para este producto.");
                                    kilogramos = 0;
                                }

                                //KILOGRAMOS EN VENTAS
                                if (kilogramos > 0) {
                                    boolean ventaValida = false;
                                    double gananciaVenta = 0;
                                    switch (codigo) {
                                        case 1:
                                            if (kilogramos <= stockAzucar) {
                                                producto = "Azucar";
                                                azucarKilosVenta += kilogramos;
                                                totalAzucar += kilogramos * precioAzucarVenta;
                                                stockAzucar -= kilogramos;
                                                ventaValida = true;
                                                gananciaVenta = kilogramos * (precioAzucarVenta - precioAzucarCompra);
                                                cantidadAzucarVendida += (int)kilogramos;
                                            } else {
                                                System.out.println("No hay suficiente stock de Azucar.");
                                            }
                                            break;
                                        case 2:
                                            if (kilogramos <= stockAvena) {
                                                producto = "Avena";
                                                avenaKilosVenta += kilogramos;
                                                totalAvena += kilogramos * precioAvenaVenta;
                                                stockAvena -= kilogramos;
                                                ventaValida = true;
                                                gananciaVenta = kilogramos * (precioAvenaVenta - precioAvenaBCompra);
                                                cantidadAvenaVendida += (int)kilogramos;
                                            } else {
                                                System.out.println("No hay suficiente stock de Avena.");
                                            }
                                            break;
                                        case 3:
                                            if (kilogramos <= stockTrigo) {
                                                producto = "Trigo";
                                                trigoKilosVenta += kilogramos;
                                                totalTrigo += kilogramos * precioTrigoVenta;
                                                stockTrigo -= kilogramos;
                                                ventaValida = true;
                                                gananciaVenta = kilogramos * (precioTrigoVenta - precioTrigoCompra);
                                                cantidadTrigoVendida += (int)kilogramos;
                                            } else {
                                                System.out.println("No hay suficiente stock de Trigo.");
                                            }
                                            break;
                                        case 4:
                                            if (kilogramos <= stockMaiz) {
                                                producto = "Maiz";
                                                maizKilosVenta += kilogramos;
                                                totalMaiz += kilogramos * precioMaizVenta;
                                                stockMaiz -= kilogramos;
                                                ventaValida = true;
                                                gananciaVenta = kilogramos * (precioMaizVenta - precioMaizCompra);
                                                cantidadMaizVendida += (int)kilogramos;
                                            } else {
                                                System.out.println("No hay suficiente stock de Maiz.");
                                            }
                                            break;
                                    }

                                    if (ventaValida && gananciaVenta > ventaMayorGanancia) {
                                        ventaMayorGanancia = gananciaVenta;
                                        productoVentaMayorGanancia = producto;
                                    }

                                    if (!ventaValida) {
                                        System.out.println("No se realizo la venta por falta de stock.");
                                    }
                                }

                                System.out.print("Desea Agregar otro producto? (si/no): ");
                                respuesta = lea.nextLine().toLowerCase();

                                while (!respuesta.equals("si") && !respuesta.equals("no")) {
                                    System.out.print("Respuesta NO valida. Ingrese 'si' o 'no' ");
                                    respuesta = lea.nextLine().toLowerCase();
                                }

                            } while (respuesta.equals("si"));

                            //FACTURACIÓN DE VENTAS
                            double subtotal = totalAzucar + totalAvena + totalTrigo + totalMaiz;
                            double descuentoAplicado = 0;
                            double montoConDescuento = 0;

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
                            totalventa = montoConDescuento * 1.07;

                            if (totalventa > 0) {
                                System.out.println();
                                System.out.println("==== FACTURA ====");
                              
                                if (azucarKilosVenta > 0) {
                                    System.out.println("Azucar (L.30/1kg): " + azucarKilosVenta + "kg" + "  - Total: L." + totalAzucar);
                                }
                                if (avenaKilosVenta > 0) {
                                    System.out.println("Avena (L.25/1kg): " + avenaKilosVenta + "kg" + " - Total: L." + totalAvena);
                                }
                                if (trigoKilosVenta > 0) {
                                    System.out.println("Trigo(L.32/1kg):" + trigoKilosVenta + "kg" + "- Total: L." + totalTrigo);
                                }
                                if (maizKilosVenta > 0) {
                                    System.out.println("Maiz(L.20/1kg):" + maizKilosVenta + "kg" + "- Total: L." + totalMaiz);
                                }
                               
                                System.out.println("Subtotal: L." + subtotal);
                                System.out.println("Descuento aplicado: L." + descuentoAplicado);
                                System.out.printf("Total (con ISV): L. %.2f\n", totalventa);
                                  System.out.println();
                                System.out.println( "Descuentos a lo que podria aplicar: ");
                                System.out.println("5% - Si su compra es mayor a L.1,000");
                                System.out.println("10% - Si su compra es mayor a L.5,000");
                                System.out.println("No aplica a descuento si su compra es mayor a L.1,000");
                                System.out.println();
                                System.out.println("===============");
                                monto += totalventa;
                                ventas++;
                                volumenVentas = volumenVentas + totalventa;
                            } else {
                                System.out.println("No hay productos que facturar.");
                            }
                        } else {
                            System.out.println("Stock Vacio");
                        }

                        System.out.println("Presione Enter para volver al Menu...");
                        lea.nextLine();
                        break;

                    // COMPRAS
                    case 3:
                        if (cajacerrada) {
                            System.out.println("No se puede realizar esta opcion. La caja esta cerrada.");
                            break;
                        }
                        if (monto > 0) {
                            do {
                                System.out.println();
                                System.out.println("==== COMPRAS ====");
                                System.out.println("*** Menu de Proveedores ***");
                                System.out.println("A. Proveedor A: Vende Azucar y Maiz.");
                                System.out.println("B. Proveedor B: Vende Avena (L.20) y Trigo.");
                                System.out.println("C. Proveedor C: Vende solamente Avena (L.22).");
                                System.out.println();
                                System.out.print("Ingrese la letra del proveedor (A, B o C): ");

                                proveedor = lea.nextLine().toUpperCase();

                                if (!proveedor.equals("A") && !proveedor.equals("B") && !proveedor.equals("C")) {
                                    System.out.println("Error. Opcion no valida. Ingrese A, B o C.");
                                }

                            } while (!proveedor.equals("A") && !proveedor.equals("B") && !proveedor.equals("C"));

                            // Menu de productos
                            System.out.println("==== Menu de Productos a Comprar ====");
                            System.out.println("Codigo 1. Azucar - L. " + precioAzucarCompra);
                            System.out.println("Codigo 2. Avena (Proveedor B) - L." + precioAvenaBCompra);
                            System.out.println("Codigo 3. Avena (Proveedor C) - L." +precioAvenaCCompra);
                            System.out.println("Codigo 4. Trigo - L." + precioTrigoCompra);
                            System.out.println("Codigo 5. Maiz - L." + precioMaizCompra);
                            System.out.println();

                            int comPro = 0;
                            boolean validaciondeproducto = false;

                            do {
                                validaciondeproducto = true;
                                System.out.print("Ingrese el codigo del producto que desea comprar: ");
                                try {
                                    comPro = Integer.parseInt(lea.nextLine());

                                    if (proveedor.equals("A") && (comPro == 1 || comPro == 5)) {
                                        compraValida = true;
                                        System.out.println("Ha indicado una compra de Proveedor A");
                                    } else if (proveedor.equals("B") && (comPro == 2 || comPro == 4)) {
                                        compraValida = true;
                                        System.out.println("Ha indicado una compra de Proveedor B");
                                    } else if (proveedor.equals("C") && comPro == 3) {
                                        compraValida = true;
                                        System.out.println("Ha indicado una compra de Proveedor C");
                                    } else {
                                        System.out.println("Error: El proveedor seleccionado no vende dicho producto. Intente de nuevo.");
                                        compraValida = false;
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("Error. Codigo de producto no valido. Por favor ingrese un numero.");
                                    compraValida = false;
                                }
                            } while (!compraValida);

                            // Kilogramos
                            System.out.print("Ingrese la cantidad que comprara en Kilogramos: ");
                            try {
                                kilos = Double.parseDouble(lea.nextLine());

                            } catch (NumberFormatException e) {
                                System.out.println("Error. Cantidad en kilogramos no valida. Compra cancelada para este producto.");
                                kilos = 0;
                            }

                            double precioUnitario = 0;
                            if (comPro == 1) {
                                nombreproductoCompra = "Azucar (Proveedor A)";
                                precioUnitario = precioAzucarCompra;
                            } else if (comPro == 2) {
                                nombreproductoCompra = "Avena (Proveedor B)";
                                precioUnitario = precioAvenaBCompra;
                            } else if (comPro == 3) {
                                nombreproductoCompra = "Avena (Proveedor C)";
                                precioUnitario = precioAvenaCCompra;
                            } else if (comPro == 4) {
                                nombreproductoCompra = "Trigo (Proveedor B)";
                                precioUnitario = precioTrigoCompra;
                            } else if (comPro == 5) {
                                nombreproductoCompra = "Maiz (Proveedor A)";
                                precioUnitario = precioMaizCompra;
                            }

                            compraTotal = kilos * precioUnitario;

                            if (monto >= compraTotal) {
                                monto -= compraTotal;

                                // Actualizacion de Kilos y de Stock
                                if (comPro == 1) {
                                    azucarKilosCompra += kilos;
                                    stockAzucar += kilos;
                                } else if (comPro == 2) {
                                    avenabKilosCompra += kilos;
                                    stockAvena += kilos;
                                } else if (comPro == 3) {
                                    avenacKilosCompra += kilos;
                                    stockAvena += kilos;
                                } else if (comPro == 4) {
                                    trigoKilosCompra += kilos;
                                    stockTrigo += kilos;
                                } else if (comPro == 5) {
                                    maizKilosCompra += kilos;
                                    stockMaiz += kilos;
                                }

                                if (kilos > 0) {
                                    System.out.println();
                                    System.out.println("==== FACTURA ====");
                                    System.out.println("Producto: " + nombreproductoCompra);
                                    System.out.println("Cantidad: " + kilos + " kg");
                                    System.out.println("Compra Total: L." + compraTotal);
                                    System.out.println("=================");
                                    compras++;
                                    volumenCompras = volumenCompras + compraTotal;
                                    if (compraTotal > compraMasCostosa) {
                                        compraMasCostosa = compraTotal;
                                        productoCompraMasCostosa = nombreproductoCompra;
                                    }
                                } else {
                                    System.out.println("No hay producto que facturar. ");
                                }
                            } else {
                                System.out.println("No hay suficiente dinero en caja para realizar esta compra.");
                            }

                        } else {
                            System.out.println("Caja Vacia, Ingrese un monto para poder comprar producto y almacenar stock.");
                        }
                        System.out.println("Presione Enter para volver al Menu...");
                        lea.nextLine();
                        break;
                    // REPORTES
                    case 4:
                        System.out.println();
                        System.out.println("====== REPORTES ======");
                        System.out.println("Dinero Actual en caja: " + monto);
                        System.out.println("Numero de Compras: " + compras);
                        System.out.println("Numero de Ventas: " + ventas);
                        System.out.println("Volumen total de Compras: " + volumenCompras);
                        System.out.println("Volumen total de Ventas: " + volumenVentas);
                        System.out.println("Margen de Ganancias: " + (volumenVentas - volumenCompras));
                        if (compras > 0) {
                            System.out.println("Valor Promedio de Compra: " + (volumenCompras / compras));
                        } else {
                            System.out.println("Valor Promedio de Compra: 0");
                        }
                        if (ventas > 0) {
                            System.out.println("Valor Promedio de Venta: " + (volumenVentas / ventas));
                        } else {
                            System.out.println("Valor Promedio de Venta: 0");
                        }

                        //
                        if (!productoVentaMayorGanancia.equals("")) {
                            System.out.println("Venta con Mayor Ganancia: " + productoVentaMayorGanancia + " - L." + String.format("%.2f", ventaMayorGanancia));
                        } else {
                            System.out.println("Venta con Mayor Ganancia: No se han hecho ventas todavia.");
                        }
                        //
                        if (!productoCompraMasCostosa.equals("")) {
                            System.out.println("Compra mas costosa: " + productoCompraMasCostosa + " - L." + String.format("%.2f", compraMasCostosa));
                        } else {
                            System.out.println("Compra mas costosa: No se han hecho compras todavia.");
                        }

                        if (cantidadAzucarVendida > maxVentasProducto) {
                            maxVentasProducto = cantidadAzucarVendida;
                            productoEstrella = "Azucar";
                        }
                        if (cantidadAvenaVendida > maxVentasProducto) {
                            maxVentasProducto = cantidadAvenaVendida;
                            productoEstrella = "Avena";
                        }
                        if (cantidadTrigoVendida > maxVentasProducto) {
                            maxVentasProducto = cantidadTrigoVendida;
                            productoEstrella = "Trigo";
                        }
                        if (cantidadMaizVendida > maxVentasProducto) {
                            maxVentasProducto = cantidadMaizVendida;
                            productoEstrella = "Maiz";
                        }
                        System.out.println("Producto Estrella: " + productoEstrella);
                        System.out.println("=====================");
                        System.out.println("Presione Enter para volver al Menu...");
                        lea.nextLine();
                        break;
                    // CIERRE DE CAJA

                    case 5:
                        if (cajacerrada) {
                            System.out.println("La caja ya esta cerrada. Debe abrirla para continuar.");
                            break;
                        }
                        System.out.println("CIERRE DE CAJA:");
                        System.out.println("Ganancia total del dia: L. " + gananciaTotal);
                        System.out.println("Efectivo en caja: L. " + monto);

                        double maxDeposito = monto * 0.60;
                        double deposito = 0;
                        do {
                            System.out.print("Ingrese la cantidad que desea depositar al banco (maximo L. " + maxDeposito + "): ");
                            try {
                                deposito = Double.parseDouble(lea.nextLine());
                                if (deposito < 0 || deposito > maxDeposito) {
                                    System.out.println("Cantidad invalida. Intente de nuevo.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Debe ingresar un numero valido.");
                                deposito = -1;
                            }
                        } while (deposito < 0 || deposito > maxDeposito);

                        monto -= deposito;
                        cajacerrada = true;

                        // CONTADORES REINICIADOS
                        volumenVentas = 0;
                        volumenCompras = 0;
                        gananciaTotal = 0;
                        cantidadAzucarVendida = 0;
                        cantidadAvenaVendida = 0;
                        cantidadTrigoVendida = 0;
                        cantidadMaizVendida = 0;
                        productoEstrella = "Ninguno";
                        maxVentasProducto = 0;
                        compraMasCostosa = 0;
                        productoCompraMasCostosa = "";
                        ventaMayorGanancia = 0;
                        productoVentaMayorGanancia = "";

                        System.out.println("Se depositaron L. " + deposito + " al banco.");
                        System.out.println("Efectivo restante en caja para el siguiente dia: L. " + monto);
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