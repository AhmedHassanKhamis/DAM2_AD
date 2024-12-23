package org.dam2.EjerciciosCMRepoQueryJPA;


import java.util.stream.Stream;

import org.dam2.modelo.Departamento;
import org.dam2.modelo.Empleado;
import org.dam2.utilidadeshibernate.GenericJPADAO;

/**
 * Hello world!
 *
 */
public class App 
{
	private GenericJPADAO <Empleado,String> empleadoDAO ;
	private GenericJPADAO <Departamento, String> departamentoDAO ;
    public static void main( String[] args )
    {
    	App app = new App();
    	
    	app.Inicializar();
    	app.CargarDatos();
    	app.querys();
    	
    	
    }
    
    public void querys() {
    	String query;
		Stream<Object[]> streamArray;
		Stream<Empleado> streamArrayEmpleado;
		Stream<Departamento[]> streamArrayDepartamento;
		
		
		
//		1. Obtener los datos completos de los empleados.
		query = "SELECT e FROM Empleado e";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
//		2. Obtener los datos completos de los departamentos
		query = "SELECT d FROM Departamento d";
		departamentoDAO.executeQuery(query).forEach(System.out::println);
//		3. Obtener los datos de los empleados con cargo 'Secretaria'.
		query = "SELECT e FROM Empleado e where e.cargoE = ?1";
		empleadoDAO.executeQuery(query,"Secretaria").forEach(System.out::println);
//		4. Obtener el nombre y salario de los empleados.
		query = "SELECT e.nomEmp, e.salEmp FROM Empleado e";
		streamArray = empleadoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+"->"+e[1]));
//		5. Obtener los datos de los empleados vendedores, ordenado por nombre.
		query = "SELECT e FROM Empleado e where e.cargoE = ?1 order by e.nomEmp";
		empleadoDAO.executeQuery(query,"Vendedor").forEach(System.out::println);
//		6. Listar el nombre de los departamentos
		query = "SELECT DISTINCT(d.nombreDepto) FROM Departamento d";
		departamentoDAO.executeQuery(query).forEach(System.out::println);
//		7. Listar el nombre de los departamentos, ordenado por nombre
		query = "SELECT DISTINCT(d.nombreDepto) FROM Departamento d ORDER BY d.nombreDepto";
		departamentoDAO.executeQuery(query).forEach(System.out::println);
//		8. Listar el nombre de los departamentos, ordenado por ciudad
		query = "SELECT DISTINCT(d.nombreDepto),d.ciudad FROM Departamento d ORDER BY d.ciudad";
		streamArray = departamentoDAO.executeQuery(query);
		streamArray.forEach(d -> System.out.println(d[0]+"->"+d[1]));
//		9. Listar el nombre de los departamentos, ordenado por ciudad, en orden inverso
		query = "SELECT DISTINCT(d.nombreDepto),d.ciudad FROM Departamento d ORDER BY d.ciudad desc";
		streamArray = departamentoDAO.executeQuery(query);
		streamArray.forEach(d -> System.out.println(d[0]+"->"+d[1]));
//		10. Obtener el nombre y cargo de todos los empleados, ordenado por salario
		query = "SELECT e.nomEmp,e.cargoE,e.salEmp FROM Empleado e order by e.salEmp";
		streamArray = empleadoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+"->"+e[1]+",salario:"+e[2]));
//		11. Obtener el nombre y cargo de todos los empleados, ordenado por cargo y por salario
		query = "SELECT e.nomEmp,e.cargoE,e.salEmp FROM Empleado e order by e.cargoE, e.salEmp";
		streamArray = empleadoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+"->"+e[1]+",salario:"+e[2]));
//		12. Obtener el nombre y cargo de todos los empleados, en orden inverso por cargo
		query = "SELECT e.nomEmp,e.cargoE FROM Empleado e order by e.cargoE desc";
		streamArray = empleadoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+"->"+e[1]));
//		13. Listar los salarios y comisiones de los empleados del departamento 2000
		query = "SELECT e.salEmp, e.comisionE, d.codDepto FROM Departamento d LEFT JOIN d.empleados e where d.codDepto = ?1";
		streamArray = departamentoDAO.executeQuery(query,"2000");
		streamArray.forEach(e -> System.out.println(e[0]+"->"+e[1]));
//		14. Listar los salarios y comisiones de los empleados del departamento 2000, ordenado por
//		comisión
		query = "SELECT e.salEmp, e.comisionE, d.codDepto FROM Departamento d LEFT JOIN d.empleados e where d.codDepto = ?1 order by e.comisionE";
		streamArray = departamentoDAO.executeQuery(query,"2000");
		streamArray.forEach(e -> System.out.println(e[0]+"->"+e[1]));
//		query = "SELECT e.salEmp,e.comisionE,d.codDepto FROM Departamento d LEFT JOIN d.empleados e where d.codDepto = 2000 order by e.comisionE ";
//		streamArray = departamentoDAO.executeQuery(query); 
//		streamArray.forEach(e -> System.out.println(e[0]+""+e[1]));
//		15. Listar todas las comisiones
//		16. Listar las comisiones que sean diferentes, ordenada por valor
//		17. Listar los diferentes salarios
//		18. Obtener el valor total a pagar que resulta de sumar a los empleados del departamento 3000 una
//		bonificación de $500.000, en orden alfabético del empleado
//		19. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
//		20. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
//		21. Elabore un listado donde para cada fila, figure ‘Nombre’ y ‘Cargo’ antes del valor respectivo
//		para cada empleado
//		22. Hallar el salario y la comisión de aquellos empleados cuyo número de documento de identidad
//		es superior al '19.709.802'
//		23. Listar los empleados cuyo salario es menor o igual que el 40% de su comisión
//		24. Divida los empleados, generando un grupo cuyo nombre inicie por la letra J y termine en la letra
//		Z. Liste estos empleados y su cargo por orden alfabético.
//		25. Listar el salario, la comisión, el salario total (salario + comisión), documento de identidad del
//		empleado y nombre, de aquellos empleados que tienen comisión superior a $1.000.000, ordenar el
//		informe por el número del documento de identidad
//		26. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión
//		27. Hallar el nombre de los empleados que tienen un salario superior a $1.000.000, y tienen como
//		jefe al empleado con documento de identidad '31.840.269'
//		28. Hallar el conjunto complementario del resultado del ejercicio anterior.
//		29. Hallar los empleados cuyo nombre no contiene la cadena “MA”
//		30. Obtener los nombres de los departamentos que no sean “Ventas” ni “Investigación” NI
//		‘MANTENIMIENTO’, ordenados por ciudad.
//		31. Obtener el nombre y el departamento de los empleados con cargo 'Secretaria' o
//		'Vendedor', que no trabajan en el departamento de “PRODUCCION”, cuyo salario es superior a
//		$1.000.000, ordenados por fecha de incorporación.
//		32. Obtener información de los empleados cuyo nombre tiene exactamente 11 caracteres
//		33. Obtener información de los empleados cuyo nombre tiene al menos 11 caracteres
//		34. Listar los datos de los empleados cuyo nombre inicia por la letra 'M', su salario es mayor a
//		$800.000 o reciben comisión y trabajan para el departamento de 'VENTAS'
//		35. Obtener los nombres, salarios y comisiones de los empleados que reciben un salario situado
//		entre la mitad de la comisión la propia comisión
//		36. Suponga que la empresa va a aplicar un reajuste salarial del 7%. Listar los nombres de los
//		empleados, su salario actual y su nuevo salario, indicando para cada uno de ellos si tiene o no
//		comisión
//		37. Obtener la información disponible del empleado cuyo número de documento de identidad sea:
//		'31.178.144', '16.759.060', '1.751.219', '768.782', '737.689', '19.709.802', '31.174.099', '1.130.782'
//		38. Entregar un listado de todos los empleados ordenado por su departamento, y alfabético dentro
//		del departamento.
//		39. Entregar el salario más alto de la empresa.
//		40. Entregar el total a pagar por comisiones, y el número de empleados que las reciben.
//		41. Entregar el nombre del último empleado de la lista por orden alfabético.
//		42. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
//		43. Conocido el resultado anterior, entregar el nombre de los empleados que reciben el salario más
//		alto y más bajo. Cuanto suman estos salarios?
//		44. Entregar el número de empleados de sexo femenino y de sexo masculino, por departamento.
//		45. Hallar el salario promedio por departamento.
//		46. Hallar el salario promedio por departamento, considerando aquellos empleados cuyo salario
//		supera $900.000, y aquellos con salarios inferiores a $575.000. Entregar el código y el nombre del
//		departamento.
//		47. Entregar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa.
//		Ordenarlo por departamento.
//		48. Hallar los departamentos que tienen más de tres (3) empleados. Entregar el número de
//		empleados de esos departamentos.
//		49. Obtener la lista de empleados jefes, que tienen al menos un empleado a su cargo. Ordene el
//		informe inversamente por el nombre.
//		50. Hallar los departamentos que no tienen empleados
//		51. Entregar un reporte con el numero de cargos en cada departamento y cual es el promedio de
//		salario de cada uno. Indique el nombre del departamento en el resultado.
//		52. Entregar el nombre del departamento cuya suma de salarios sea la más alta, indicando el valor
//		de la suma.
//		53. Entregar un reporte con el código y nombre de cada jefe, junto al número de empleados que
//		dirige. Puede haber empleados que no tengan supervisores, para esto se indicará solamente el
//		numero de ellos dejando los valores restantes en NULL.
		
    }
    public void CargarDatos() {
    	Departamento deptEmpty;
    	
    	deptEmpty = departamentoDAO.findById("null").orElse(null);
    	if(deptEmpty == null) {
    		deptEmpty = Departamento.builder()
    				.codDepto("null")
    				.nombreDepto("SIN Departamento")
    				.ciudad("SIN Ciudad")
    				.build();
    	departamentoDAO.save(deptEmpty);
    	}
    }
    
    public void Inicializar() {
    	empleadoDAO = new GenericJPADAO (Empleado.class,"hibernate");
    	departamentoDAO = new GenericJPADAO (Departamento.class,"hibernate");
    }
}
