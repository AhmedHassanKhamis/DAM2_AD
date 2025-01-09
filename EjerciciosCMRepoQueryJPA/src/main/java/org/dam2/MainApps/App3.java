package org.dam2.MainApps;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.dam2.modeloEJ3.Cliente;
import org.dam2.modeloEJ3.Cuenta;
import org.dam2.modeloEJ3.CuentaEmpresa;
import org.dam2.modeloEJ3.CuentaPersonal;
import org.dam2.modeloEJ3.Local;
import org.dam2.modeloEJ3.Telefono;
import org.dam2.utilidadeshibernate.GenericJPADAO;

import daw.com.Teclado;

public class App3 {
//	################################################################
//						NO SE HIZO CONTROL DE DATOS
//	################################################################
	
	private GenericJPADAO<Cliente, String> clienteDAO;
	private GenericJPADAO<Cuenta, Integer> cuentaDAO;
	private GenericJPADAO<CuentaEmpresa, Integer> cuentaEmpresaDAO;

	private List<Cuenta> cuentas;
	private Stream<Object[]> streamArray;

	public static void main(String[] args) {
		App3 app = new App3();

		app.inicializar();
		app.cargarDatos();
		app.ejecutar();
		
		
	}

	private void ejecutar() {
		int opcion;
		do {
			opcion = menu();
			switch (opcion) {
			case 0:
				crearCuenta();
				break;
			case 1:
				ingresar();
				break;
			case 2:
				retirar();
				break;
			case 3:
				transferencia();
				break;
			case 4:
				consultarSaldoCuenta();
				break;
			case 5:
				consultarSumaSaldos();
				break;	
			case 6:
				consultarMaxSaldo();
				break;
			case 7:
				consultarMayorTeleco();
				break;
			case 8:
				consultarEmpresasNegativos();
				break;
			case 9:
				System.out.println("GRACIAS POR UTILIZAR NUESTRO SISTEMA.");
				break;
			}
		} while (opcion != 9);
	}
	
	private List<Telefono> CrearTelefonos() {
		List<Telefono> telefonos = new ArrayList<Telefono>();
		do {
			System.out.println("TELEFONO--------------");
			telefonos.add(Telefono.builder()
					.numero(Teclado.leerInt("Numero:"))
					.compania(Teclado.leerString("Compañia: "))
					.build());
		} while (Teclado.leerString("Nuevo Telefono?(S/N)").equalsIgnoreCase("s"));
		return telefonos;
	}
	
	private List<Cliente> CrearClientes() {
		List<Cliente> clientes = new ArrayList<Cliente>();
		do {
			System.out.println("TITULAR--------------");
			clientes.add(Cliente.builder()
					.nif(Teclado.leerString("NIF: "))
					.nombre(Teclado.leerString("Nombre: "))
					.maxAval(Teclado.leerInt("Aval maximo: "))
					.telefonos(CrearTelefonos())
					.build());
		} while (Teclado.leerString("Nuevo Titular?(S/N)").equalsIgnoreCase("s"));
		return clientes;
	}
	
	private void crearCuenta() {
		List<Cliente> titulares = CrearClientes();
		System.out.println("CUENTA--------------");
		int numero = Teclado.leerInt("Numero de cuenta: ");
		String tipo = Teclado.leerString("Que tipo de cuenta desea personal o de empresa?(p/e)");
		if (tipo.equalsIgnoreCase("p")) {
			boolean tarjeta = Teclado.leerString("se emitio tarjeta?(s/n)").equalsIgnoreCase("s")?true:false;
			cuentaDAO.save(CuentaPersonal.builder()
					.numero(numero)
					.titulares(titulares)
					.tarjetaCredito(tarjeta)
					.build());
		} else if(tipo.equalsIgnoreCase("e")) {
			String nombreEmpresa = Teclado.leerString("Nombre Empresa: ");
			String cif = Teclado.leerString("CIF EMPRESA: ");
			Local local = Teclado.leerString("Propio o Alquilado?(P/A)").equalsIgnoreCase("P")?Local.PROPIO:Local.ALQUILADO;
			cuentaDAO.save(CuentaEmpresa.builder()
					.numero(numero)
					.titulares(titulares)
					.nombreEmpresa(nombreEmpresa)
					.cif(cif)
					.local(local)
					.build());
		}else {
			System.out.println("opcion incorrecta!");
		}
	}

	private void ingresar() {
		int numCuenta = Teclado.leerInt("Numero de cuenta: ");
		Cuenta cuenta = cuentaDAO.findById(numCuenta).orElse(null);
		if (cuenta != null) {
			int cantidad = Teclado.leerInt("Cantidad: ");
			cuenta.ingresar((float)cantidad);
			cuentaDAO.update(cuenta);
			System.out.println("operacion realizada con exito!");
			System.out.println("saldo actual: "+ cuenta.getSaldo());
		}else {
			System.out.println("La cuenta ingresada no existe!");
		}
		
	}

	private void retirar() {
		int numCuenta = Teclado.leerInt("Numero de cuenta: ");
		Cuenta cuenta = cuentaDAO.findById(numCuenta).orElse(null);
		if (cuenta != null) {
			int cantidad = Teclado.leerInt("Cantidad: ");
			cuenta.retirar((float)cantidad);
			cuentaDAO.update(cuenta);
			System.out.println("saldo actual: "+ cuenta.getSaldo());
		}else {
			System.out.println("La cuenta ingresada no existe!");
		}
		
	}

	private void transferencia() {
		int numOrigen = Teclado.leerInt("Numero de origen: ");
		Cuenta cuentaOrigen = cuentaDAO.findById(numOrigen).orElse(null);
		int numDestino = Teclado.leerInt("Numero de destino: ");
		Cuenta cuentaDestino = cuentaDAO.findById(numDestino).orElse(null);
		if (cuentaOrigen != null && cuentaDestino != null) {
			int cantidad = Teclado.leerInt("Cantidad: ");
			cuentaOrigen.transferencia(cantidad, cuentaDestino);
			cuentaDAO.update(cuentaDestino);
			cuentaDAO.update(cuentaOrigen);
			System.out.println("Saldo: "+ cuentaOrigen.getSaldo());
		}else {
			System.out.println("Una de las cuentas ingresadas no existe!");
		}
		
		
	}

	private void consultarSaldoCuenta() {
		int numCuenta = Teclado.leerInt("Numero de cuenta: ");
		Cuenta cuenta = cuentaDAO.findById(numCuenta).orElse(null);
		if (cuenta != null) {
			System.out.println(cuenta);
			System.out.println("FECHA ACTUAL: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm")));
		}else {
			System.out.println("La cuenta ingresada no existe!");
		}
	}

	private void consultarSumaSaldos() {
		String query = "select c.numero, c.saldo from Cuenta c";
		streamArray = cuentaDAO.executeQuery(query);
		streamArray.forEach(c -> System.out.println("NUM: "+c[0]+", SALDO: "+c[1]));
		query = "select sum(c.saldo) from Cuenta c";
		cuentaDAO.executeQuery(query).forEach(c -> System.out.println("total: " +c ));
		
	}

	private void consultarMaxSaldo() {
		 String query = "SELECT t.nombre, t.nif, SUM(c.saldo) AS totalSaldo FROM Cuenta c JOIN c.titulares t GROUP BY t.nombre, t.nif ORDER BY totalSaldo DESC";

			    streamArray = cuentaDAO.executeQuery(query);
			    if (streamArray != null) {
			        Object[] clienteConMaxSaldo = streamArray.findFirst().orElse(null); // Toma el primero (con saldo máximo)
			        if (clienteConMaxSaldo != null) {
			            System.out.println("CLIENTE CON MÁS DINERO:");
			            System.out.println("Nombre: " + clienteConMaxSaldo[0]);
			            System.out.println("NIF: " + clienteConMaxSaldo[1]);
			            System.out.println("Saldo Total: " + clienteConMaxSaldo[2]);
			        } else {
			            System.out.println("No hay datos de clientes disponibles.");
			        }
			    } else {
			        System.out.println("No se pudo ejecutar la consulta.");
			    }
		
	}

	private void consultarMayorTeleco() {
	    String query = "SELECT t.compania, COUNT(t.compania) AS total FROM Cliente c JOIN c.telefonos t GROUP BY t.compania ORDER BY total DESC ";
	    streamArray = clienteDAO.executeQuery(query);
	    if (streamArray != null) {
	        Object[] companiaMayor = streamArray.findFirst().orElse(null); // Obtiene la compañía con mayor conteo
	        if (companiaMayor != null) {
	            System.out.println("COMPAÑÍA DE TELECOMUNICACIONES CON MÁS CLIENTES:");
	            System.out.println("Compañía: " + companiaMayor[0]);
	            System.out.println("Número de Clientes: " + companiaMayor[1]);
	        } else {
	            System.out.println("No hay datos de compañías disponibles.");
	        }
	    } else {
	        System.out.println("No se pudo ejecutar la consulta.");
	    }
	}

	private void consultarEmpresasNegativos() {
	    String query = "SELECT c.numero, c.nombreEmpresa, c.saldo FROM CuentaEmpresa c WHERE c.saldo < 0 ORDER BY c.saldo ASC ";

	    streamArray = cuentaEmpresaDAO.executeQuery(query);
	    if (streamArray != null) {
	        System.out.println("CUENTAS EMPRESARIALES CON SALDO NEGATIVO:");
	        streamArray.forEach(c -> System.out.println("Número de Cuenta: " + c[0] + " Nombre de Empresa: " + c[1] + " Saldo: " + c[2] + "---------------------------"));
	    } else {
	        System.out.println("No se pudieron obtener las cuentas empresariales con saldo negativo.");
	    }
	}


	private int menu() {
		int opcion;
		do {
			System.out.println("---------MENU--------");
			System.out.println("0.Crear una cuenta bancaria (personal o de empresa).");
			System.out.println("1.Ingresar dinero.");
			System.out.println("2.Retirar dinero.");
			System.out.println("3.Realizar transferencia.");
			System.out.println("4.Consultar saldo de una cuenta");
			System.out.println("5.Consultar saldo de la entidad financiera");
			System.out.println("6.Consultar los datos del cliente que tenga más dinero en el banco.");
			System.out.println("7.Consultar la compañía de telecomunicaciones que más clientes tiene en la sucursal.");
			System.out.println("8.Listar las cuentas empresariales con saldo negativo ordenadas de menor a mayor");
			System.out.println("9.Salir del programa.");

			opcion = Teclado.leerInt("introduce el numero de una opcion:(0-9)");
			if (opcion < 0 || opcion > 9)
				System.out.println("Opcion incorrecta!!");
		} while (opcion < 0 || opcion > 9);
		return opcion;
	}

	private void cargarDatos() {
		// TODO Auto-generated method stub
		cuentas = (List<Cuenta>) cuentaDAO.findAll();
	}


	public void inicializar() {
		clienteDAO = new GenericJPADAO (Cliente.class,"hibernate");
		cuentaDAO = new GenericJPADAO (Cuenta.class,"hibernate");
		cuentaEmpresaDAO = new GenericJPADAO (CuentaEmpresa.class,"hibernate");
    }
	
}
