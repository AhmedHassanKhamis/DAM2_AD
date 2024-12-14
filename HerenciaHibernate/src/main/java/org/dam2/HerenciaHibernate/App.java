package org.dam2.HerenciaHibernate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.dam2.modelo.AsistenciaMedica;
import org.dam2.modelo.Coberturas;
import org.dam2.modelo.Enfermedades;
import org.dam2.modelo.Seguro;
import org.dam2.modelo.Sexo;
import org.dam2.utilidadeshibernate.GenericJPADAO;

/**
 * Hello world!
 *
 */
public class App {
	private GenericJPADAO<Seguro, Integer> seguroDAO;
	private GenericJPADAO<AsistenciaMedica, Integer> asistenciaMedicaDAO;

	public static void main(String[] args) {
		App app = new App();
		app.InicializarDAO();
		app.CargarDatos();
		app.Querys();

	}

	public void Querys() {
		String query;
		Stream<Object[]> streamArray;

//    	• Lanza una consulta que nos retorne todos los seguros que hay en la base de datos.Haz que se
//    	muestren en la pantalla.

		query = "SELECT s FROM Seguro s";
		seguroDAO.executeQuery(query).forEach(System.out::println);

//    	• Lanza una consulta que nos retorne solo las columnas NIF y Nombre de todos los seguros
//    	que hay en la base de datos. Haz que se muestren en pantalla.

		query = "SELECT s.nif, s.nombre FROM Seguro s";
		streamArray = seguroDAO.executeQuery(query);
		streamArray.forEach(s -> System.out.println(s[0] + "->" + s[1]));

//    	• Lanza una consulta que nos retorne sólo el NIF para el seguro con nombre “Marcos Tortosa
//    	Oltra”.

		query = "SELECT s.nif FROM Seguro s where s.nombre = ?1 and s.ape1 = ?2 and s.ape2 = ?3 ";
		seguroDAO.executeQuery(query, "Miguel", "Sutil", "Martin").forEach(System.out::println);

//    	• Crea una consulta que retornará aquellas AsistenciaMedica con importe mayor o igual a
//    	10.000 €.

		query = "SELECT a FROM AsistenciaMedica a where a.importe > ?1 ";
		asistenciaMedicaDAO.executeQuery(query, 100f).forEach(System.out::println);

//    	• Lanza una consulta que retorne el idAsistenciaMedica de todas las asistencias médicas cuyo
//    	saldo esté entre 2.000 y 5.000 euros. Usa parámetros por posición para los valores 2000 y
//    	5000. Haz que se muestren en pantalla.

		query = "SELECT a.idAsistenciaMedica FROM AsistenciaMedica a where a.importe > ?1 and a.importe < ?2 ";
		asistenciaMedicaDAO.executeQuery(query, 150f, 250f).forEach(System.out::println);

//    	• Lanza una consulta que calcule la suma de todos los importes de todas las asistencias
//    	médicas. Haz que se muestren en pantalla.

		query = "SELECT sum(a.importe) FROM AsistenciaMedica a";
		asistenciaMedicaDAO.executeQuery(query).forEach(System.out::println);

//    	• Lanza una consulta que calcule el saldo medio de todas las asistencias médicas. Haz que se
//    	muestren en pantalla.

		query = "SELECT avg(a.importe) FROM AsistenciaMedica a";
		asistenciaMedicaDAO.executeQuery(query).forEach(System.out::println);

//    	• Lanza una consulta que calcule cuantos seguros hay. Haz que se muestren en pantalla.

		query = "SELECT count(s) FROM Seguro s";
		seguroDAO.executeQuery(query).forEach(System.out::println);

//    	• Lanza una consulta que muestre para cada seguro cuántas asistencias médicas posee. Haz
//    	que se muestren en pantalla.

		query = "SELECT size(s.asistencias) FROM Seguro s";
		seguroDAO.executeQuery(query).forEach(System.out::println);

//    	• Lanza una consulta que obtenga todos los objetos Seguro en la parte del FROM pero que en
//    	la parte del SELECT retorne el nombre de la alergia que padecen (algunos valdrán null) .
//    	Haz que se muestren en pantalla.

		query = "SELECT s.enfermedades.nombreAlergia FROM Seguro s";
		seguroDAO.executeQuery(query).forEach(System.out::println);

//    	• Lanza una consulta que retorne todos los seguros. Haz que se muestre en pantalla el
//    	idAsistenciaMedica de cada asistencia médica (No debes lanzar otra consulta). Comprueba
//    	cuántas consultas lanza Hibernate internamente.

		query = "SELECT s.idSeguro, a.idAsistenciaMedica FROM Seguro s " + "LEFT JOIN s.asistencias a";
		streamArray = seguroDAO.executeQuery(query);
		streamArray.forEach(o -> System.out.println(o[0] + "," + o[1]));

	}

	public void InicializarDAO() {
		seguroDAO = new GenericJPADAO(Seguro.class, "hibernate");
		asistenciaMedicaDAO = new GenericJPADAO(AsistenciaMedica.class, "hibernate");
	}

	public void CargarDatos() {
		List<Seguro> seguros = new ArrayList<>();

		AsistenciaMedica a1, a2, a3, a4;
		Seguro s1, s2, s3;

		a1 = AsistenciaMedica.builder().breveDescripcion("a1").explicacion("la primera").fechaYHora(LocalDateTime.now())
				.importe(100).lugar("Maestranza").tipoAsistencia("normal").build();

		a2 = AsistenciaMedica.builder().breveDescripcion("a2").explicacion("la segunda")
				.fechaYHora(LocalDateTime.now().minusDays(3)).importe(200).lugar("Maestranza").tipoAsistencia("urgente")
				.build();

		a3 = AsistenciaMedica.builder().breveDescripcion("a3").explicacion("la tercera")
				.fechaYHora(LocalDateTime.now().minusMonths(2)).importe(100).lugar("La Paz").tipoAsistencia("normal")
				.build();

		a4 = AsistenciaMedica.builder().breveDescripcion("a4").explicacion("la cuarta").fechaYHora(LocalDateTime.now())
				.importe(130).lugar("Maestranza").tipoAsistencia("revision").build();

		s1 = Seguro.builder().ape1("Sutil").ape2("Martin").casado(false)
				.coberturas(Coberturas.builder().dental(false).fecundacionInVitro(false).oftalmologia(true).build())
				.edad(45).embarazada(false)
				.enfermedades(Enfermedades.builder().alergia(true).nombreAlergia("Al trabajo").build())
				.fechaCreacion(LocalDate.now().minusWeeks(45)).nif("001").nombre("Miguel").nunHijos(2).sexo(Sexo.HOMBRE)
				.asistencia(a1).asistencia(a2).build();

		s2 = Seguro.builder().ape1("Cordero").ape2("Gonzalez").casado(false)
				.coberturas(Coberturas.builder().dental(true).fecundacionInVitro(false).oftalmologia(true).build())
				.edad(48).embarazada(false)
				.enfermedades(Enfermedades.builder().alergia(true).nombreAlergia("renitis").estomacal(true).build())
				.fechaCreacion(LocalDate.now().minusWeeks(5)).nif("002").nombre("Rosa").nunHijos(2).sexo(Sexo.MUJER)
				.asistencia(a3).asistencia(a4).build();

		s3 = Seguro.builder().ape1("Sanchez").ape2("Gonzalez").casado(true)
				.coberturas(Coberturas.builder().dental(true).fecundacionInVitro(false).oftalmologia(true).build())
				.edad(68).embarazada(false)
				.enfermedades(
						Enfermedades.builder().alergia(true).nombreAlergia("polen olivo").estomacal(false).build())
				.fechaCreacion(LocalDate.now().minusWeeks(5)).nif("003").nombre("Juan").nunHijos(3).sexo(Sexo.HOMBRE)
				.build();

		seguros.add(s1);
		seguros.add(s2);
		seguros.add(s3);

		seguros.stream().forEach(seguroDAO::save);
	}
}
