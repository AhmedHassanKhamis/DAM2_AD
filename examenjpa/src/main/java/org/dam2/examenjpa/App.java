package org.dam2.examenjpa;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.dam2.modelo.Categoria;
import org.dam2.modelo.Cliente;
import org.dam2.modelo.Material;
import org.dam2.modelo.Pelicula;
import org.dam2.modelo.Registro;
import org.dam2.modelo.Residencia;
import org.dam2.modelo.Serie;
import org.dam2.utilidadeshibernate.GenericJPADAO;

import daw.com.Teclado;

public class App 
{
	private static GenericJPADAO<Cliente, String> clienteDAO;
	private static GenericJPADAO<Material, String> materialDAO;
	private static GenericJPADAO<Registro, Integer> registroDAO;

    public static void main( String[] args )
    {
        App app = new App();
        
        app.inicializar();
        app.cargarDatos();
//        app.visualizacion();
//        app.query1();
//        app.query2();
//        app.query3();
        app.query4();
        
    }

	private void query1() {
		// TODO Auto-generated method stub
		String query = "SELECT m FROM Material m where m in (select r.material from Registro r where fechaVisualizacion < r.material.fechaEstreno )";
		
//		String query = "SELECT m FROM Material m where m in (select r.material from Registro r where fechaVisualizacion > r.material.fechaEstreno.plusYears(2) )";

//		String query = "SELECT m FROM Material m where m in (select r.material from Registro r where fechaVisualizacion > DATEADD(r.material.fechaEstreno,YEAR(2)) )";

		List<Material> materiales = materialDAO.executeQuery(query).toList();
		materiales.stream().forEach(System.out::println);
	}
	

	private void query2() {
		// TODO Auto-generated method stub
		Stream<Object[]> arrayResult = (Stream<Object[]>) new ArrayList();
		String query = "SELECT r.material.nombre, r.codigoReferencia, COUNT(r.material) as vecesVisto FROM Registro r order by vecesVisto desc limit 1";

		arrayResult = (Stream<Object[]>) materialDAO.executeQuery(query);
		System.out.println(arrayResult);
		
	}

	private void query3() {
		// TODO Auto-generated method stub
		String query = "SELECT c from Cliente c where c not in (SELECT r.cliente FROM Registro r)";
		List<Cliente> clientes = clienteDAO.executeQuery(query).toList();
		clientes.forEach(c -> System.out.println(c.getNombre()));
		
	}

	private void query4() {
		// TODO Auto-generated method stub
		String query = "UPDATE Cliente c set c.cuota = (c.cuota + c.cuota * 0.1) where c in (Select C FROM Registro r where r.material.temporada != null)";
		clienteDAO.executeQuery(query);
		
		
	}

	private void visualizacion() {
		// TODO Auto-generated method stub
		List<Material> materiales;
		String nif = Teclado.leerString("Introduce nif del cliente:");
		Cliente cliente = clienteDAO.findById(nif).orElse(null);
		
		if (cliente != null) {
			if (cliente.isSuscrito()) {
				materiales = (List<Material>) materialDAO.findAll();
				materiales.stream()
				.filter(m -> m.getFechaEstreno().isBefore(LocalDate.now()))
				.forEach(m -> System.out.println("Referencia: "+ m.getCodigoReferencia() + ", nombre: " + m.getNombre()));
				
				String referencia = Teclado.leerString("Introduce numero de referencia del material a visualizar:");
				Material material = materialDAO.findById(referencia).orElse(null);
				
				if (material != null) {
					String query = "SELECT COUNT(r.material) FROM Registro r where r.cliente = ?1 AND r.material = ?2";
					long vecesVista =  (long) registroDAO.executeQuerySingleResult(query, cliente, material).orElse(0);
					System.out.println("Se ha visualizado anteriormente este CONTENIDO AUDIOVISUAL: "+ vecesVista + " veces");
					Registro registro = Registro.builder()
							.fechaVisualizacion(LocalDate.now())
							.cliente(cliente)
							.material(material)
							.build();
					registroDAO.save(registro);
					System.out.println("VISUALIZACION REALIZADA CON EXITO, DISFRUTE!");
					
				}else {
					System.out.println("CONTENIDO AUDIOVISUAL NO DISPONIBLE O INEXISTENTE!");
				}
			}else {
				System.out.println("SENTIMOS COMUNICARLE QUE NO ESTA SUSCRITO!");
			}
		}else {
			System.out.println("EL CLIENTE INTRODUCIDO NO EXISTE!");
		}
	}

	private void cargarDatos() {
		// TODO Auto-generated method stub
		
		Residencia residencia1 = Residencia.builder()
				.ip("200.200.100.2")
				.calle("Chile")
				.portal(16)
				.localidad("Colmenar Viejo")
				.codigoPostal(28023)
				.build();
		

		Residencia residencia2 = Residencia.builder()
				.ip("90.90.100.2")
				.calle("Solana")
				.portal(1)
				.localidad("Jaén")
				.codigoPostal(14003)
				.build();
		

		Residencia residencia3 = Residencia.builder()
				.ip("80.80.30.120")
				.calle("Antracita")
				.portal(23)
				.localidad("Madrid")
				.codigoPostal(28003)
				.build();
		

		Residencia residencia4 = Residencia.builder()
				.ip("120.120.120.120")
				.calle("Lugo")
				.portal(14)
				.localidad("Tres Cantos")
				.codigoPostal(28791)
				.build();
		
		
		Cliente cliente1 = Cliente.builder()
				.nif("00001A")
				.nombre("Miguel")
				.cuota(20)
				.suscrito(true)
				.residencias(List.of(residencia1,residencia2))
				.build();
		
		Cliente cliente2 = Cliente.builder()
				.nif("00030B")
				.nombre("Rosa")
				.cuota(10)
				.suscrito(true)
				.residencia(residencia3)
				.build();
		
		Cliente cliente3 = Cliente.builder()
				.nif("000111")
				.nombre("Andrés")
				.cuota(20)
				.suscrito(false)
				.residencia(residencia4)
				.build();
		
		Serie serie1 = Serie.builder()
				.codigoReferencia("00001")
				.nombre("The Crown")
				.director("Peter Morgan")
				.fechaEstreno(LocalDate.of(2021, 02, 02))
				.categoria(Categoria.ACCION)
				.temporada(3)
				.capitulo(1)
				.build();
		
		Serie serie2 = Serie.builder()
				.codigoReferencia("00003")
				.nombre("Elite")
				.director("Silvia Quer")
				.fechaEstreno(LocalDate.of(2018, 10, 05))
				.categoria(Categoria.TERROR)
				.temporada(4)
				.capitulo(3)
				.build();
		
		Pelicula pelicula1 = Pelicula.builder()
				.codigoReferencia("00002")
				.nombre("Matrix IV")
				.director("Lana Wach")
				.fechaEstreno(LocalDate.of(2021, 12, 22))
				.categoria(Categoria.AVENTURA)
				.actorPrincipal("Keanu Reeves")
				.build();
		
		Pelicula pelicula2 = Pelicula.builder()
				.codigoReferencia("00004")
				.nombre("Spiderman")
				.director("Jon Watts")
				.fechaEstreno(LocalDate.of(2025, 06, 26))
				.categoria(Categoria.AVENTURA)
				.actorPrincipal("Zendaya")
				.build();
		
		
		Registro registro1 = Registro.builder()
				.fechaVisualizacion(LocalDate.of(2022, 01, 12))
				.material(serie1)
				.cliente(cliente1)
				.build();
		
		Registro registro2 = Registro.builder()
				.fechaVisualizacion(LocalDate.of(2021, 12, 02))
				.material(serie1)
				.cliente(cliente2)
				.build();
		
		Registro registro3 = Registro.builder()
				.fechaVisualizacion(LocalDate.of(2022, 01, 14))
				.material(pelicula1)
				.cliente(cliente1)
				.build();
		
		Registro registro4 = Registro.builder()
				.fechaVisualizacion(LocalDate.of(2021, 04, 02))
				.material(serie2)
				.cliente(cliente1)
				.build();
		
		List<Cliente> clientes = new ArrayList<Cliente>();
		clientes.addAll(List.of(cliente1,cliente2,cliente3));
		clientes.stream().forEach(clienteDAO::save);
		
		List<Material> materiales = new ArrayList<Material>();
		materiales.addAll(List.of(serie1,serie2,pelicula1,pelicula2));
		materiales.stream().forEach(materialDAO::save);
		
		List<Registro> registros = new ArrayList<Registro>();
		registros.addAll(List.of(registro1,registro2,registro3,registro4));
		registros.stream().forEach(registroDAO::save);
	}

	private void inicializar() {
		// TODO Auto-generated method stub
		clienteDAO = new GenericJPADAO<Cliente, String>(Cliente.class, "examenjpa");
		materialDAO = new GenericJPADAO<Material, String>(Material.class, "examenjpa");
		registroDAO = new GenericJPADAO<Registro, Integer>(Registro.class, "examenjpa");
		
	}
}
