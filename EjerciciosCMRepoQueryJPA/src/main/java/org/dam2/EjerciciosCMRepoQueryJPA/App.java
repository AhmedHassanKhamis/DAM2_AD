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
		query = "SELECT e.comisionE FROM Empleado e";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		16. Listar las comisiones que sean diferentes, ordenada por valor
		query = "SELECT distinct(e.comisionE) FROM Empleado e order by e.comisionE";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		17. Listar los diferentes salarios
		query = "SELECT distinct(e.salEmp) FROM Empleado e";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
				
//		18. Obtener el valor total a pagar que resulta de sumar a los empleados del departamento 3000 una
//		bonificación de $500.000, en orden alfabético del empleado
		query = "SELECT (e.salEmp + 500000), d.codDepto FROM Departamento d LEFT JOIN d.empleados e where d.codDepto = ?1 order by e.nomEmp";
		streamArray = departamentoDAO.executeQuery(query,"3000");
		streamArray.forEach(e -> System.out.println(e[0]+"->"+e[1]));
		
		
//		19. Obtener la lista de los empleados que ganan una comisión superior a su sueldo.
		query = "SELECT e FROM Empleado e where e.salEmp < e.comisionE";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		20. Listar los empleados cuya comisión es menor o igual que el 30% de su sueldo.
		query = "SELECT e FROM Empleado e where e.comisionE < (e.salEmp * 0.30)";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		21. Elabore un listado donde para cada fila, figure ‘Nombre’ y ‘Cargo’ antes del valor respectivo
//		para cada empleado
		query = "SELECT e.nomEmp, e.cargoE FROM Empleado e";
		streamArray = empleadoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println("Nombre: "+e[0]+", Cargo: "+e[1]));
		
//		22. Hallar el salario y la comisión de aquellos empleados cuyo número de documento de identidad
//		es superior al '19.709.802'
		query = "SELECT e.nIDEmp, e.salEmp, e.comisionE FROM Empleado e where e.nIDEmp > '19.709.802' and e.nIDEmp like '%.%.%'";
		streamArray = empleadoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+", "+e[1]+", "+e[2]));

		
//		23. Listar los empleados cuyo salario es menor o igual que el 40% de su comisión
		query = "SELECT e FROM Empleado e where e.salEmp <= (e.comisionE * 0.40)";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		24. Divida los empleados, generando un grupo cuyo nombre inicie por la letra J y termine en la letra
//		Z. Liste estos empleados y su cargo por orden alfabético.
		query = "SELECT e.nomEmp, e.cargoE FROM Empleado e where e.nomEmp like 'J%z %' order by e.cargoE";
		streamArray = empleadoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+", "+e[1]));

		
//		25. Listar el salario, la comisión, el salario total (salario + comisión), documento de identidad del
//		empleado y nombre, de aquellos empleados que tienen comisión superior a $1.000.000, ordenar el
//		informe por el número del documento de identidad
		query = "SELECT e.nIDEmp, e.nomEmp, e.salEmp, e.comisionE, (e.salEmp+e.comisionE) FROM Empleado e where e.comisionE > 1000000 order by e.nIDEmp";
		streamArray = empleadoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+", "+e[1]+", "+e[2]+", "+e[3]+", "+e[4]));
		
		
//		26. Obtener un listado similar al anterior, pero de aquellos empleados que NO tienen comisión
		query = "SELECT e.nIDEmp, e.nomEmp, e.salEmp, e.comisionE, (e.salEmp+e.comisionE) FROM Empleado e where e.comisionE = 0 order by e.nIDEmp";
		streamArray = empleadoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+", "+e[1]+", "+e[2]+", "+e[3]+", "+e[4]));
		
		
//		27. Hallar el nombre de los empleados que tienen un salario superior a $1.000.000, y tienen como
//		jefe al empleado con documento de identidad '31.840.269'
		query = "SELECT e.nomEmp FROM Empleado e where e.salEmp > 1000000 and jefeID = '31.840.269'";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		28. Hallar el conjunto complementario del resultado del ejercicio anterior.
		query = "SELECT e.nomEmp FROM Empleado e where jefeID != '31.840.269'";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		29. Hallar los empleados cuyo nombre no contiene la cadena “MA”
		query = "SELECT e.nomEmp FROM Empleado e where e.nomEmp not like '%Ma%'";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		30. Obtener los nombres de los departamentos que no sean “Ventas” ni “Investigación” NI
//		‘MANTENIMIENTO’, ordenados por ciudad.
		query = "SELECT DISTINCT(d.nombreDepto) FROM Departamento d where d.nombreDepto not in ('VENTAS','INVESTIGACIÓN')";
		departamentoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		31. Obtener el nombre y el departamento de los empleados con cargo 'Secretaria' o
//		'Vendedor', que no trabajan en el departamento de “PRODUCCION”, cuyo salario es superior a
//		$1.000.000, ordenados por fecha de incorporación.
		query = "SELECT e.nomEmp, d.nombreDepto FROM Departamento d LEFT JOIN d.empleados e where d.nombreDepto != 'PRODUCCIÓN' and e.cargoE in ('Secretaria','Vendedor') and e.salEmp > 1000000 order by e.fecIncorporacion";
		streamArray = departamentoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+", "+e[1]));
		
//		32. Obtener información de los empleados cuyo nombre tiene exactamente 11 caracteres
		query = "SELECT e FROM Empleado e where LENGTH(e.nomEmp) = 11";
		empleadoDAO.executeQuery(query).forEach(System.out::println);

		
		
//		33. Obtener información de los empleados cuyo nombre tiene al menos 11 caracteres
		query = "SELECT e FROM Empleado e where LENGTH(e.nomEmp) >= 11";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		34. Listar los datos de los empleados cuyo nombre inicia por la letra 'M', su salario es mayor a
//		$800.000 o reciben comisión y trabajan para el departamento de 'VENTAS'
		query = "SELECT e FROM Departamento d LEFT JOIN d.empleados e where e.nomEmp like 'M%' and e.salEmp > 800000 and d.nombreDepto = 'VENTAS' and e.comisionE > 0";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		35. Obtener los nombres, salarios y comisiones de los empleados que reciben un salario situado
//		entre la mitad de la comisión la propia comisión
		query = "SELECT e.nomEmp, e.salEmp, e.comisionE FROM Empleado e where e.salEmp between (e.comisionE * 0.50) and e.comisionE";
		streamArray = departamentoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+", "+e[1]+", "+e[2]));
		
		
//		36. Suponga que la empresa va a aplicar un reajuste salarial del 7%. Listar los nombres de los
//		empleados, su salario actual y su nuevo salario, indicando para cada uno de ellos si tiene o no
//		comisión
		query = "SELECT e.nomEmp, e.salEmp, (e.salEmp + e.salEmp *0.07), e.comisionE FROM Empleado e ";
		streamArray = departamentoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+", "+e[1]+", "+e[2]+", comision: "+((e[3].toString().equals("0.0"))?"no":"si")));
		
		
//		37. Obtener la información disponible del empleado cuyo número de documento de identidad sea:
//		'31.178.144', '16.759.060', '1.751.219', '768.782', '737.689', '19.709.802', '31.174.099', '1.130.782'
		query = "SELECT e FROM Empleado e where e.nIDEmp in ('31.178.144', '16.759.060', '1.751.219', '768.782', '737.689', '19.709.802', '31.174.099', '1.130.782')";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		38. Entregar un listado de todos los empleados ordenado por su departamento, y alfabético dentro
//		del departamento.
		query = "SELECT e FROM Departamento d LEFT JOIN d.empleados e GROUP BY d.nombreDepto, e.nomEmp ORDER BY d.nombreDepto, e.nomEmp";
		departamentoDAO.executeQuery(query).forEach(System.out::println);
		
		
		
//		39. Entregar el salario más alto de la empresa.
		query = "SELECT max(e.salEmp) FROM Empleado e ";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
//		40. Entregar el total a pagar por comisiones, y el número de empleados que las reciben.
		query = "SELECT sum(e.comisionE),count(e) From Empleado e";
		streamArray = empleadoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+", "+e[1]));		
		
		
//		41. Entregar el nombre del último empleado de la lista por orden alfabético.
		query = "SELECT e.nomEmp From Empleado e order by e.nomEmp desc";
		System.out.println(empleadoDAO.executeQuery(query).findFirst().get());
		
		
//		42. Hallar el salario más alto, el más bajo y la diferencia entre ellos.
		query = "SELECT MAX(e.salEmp), MIN(e.salEmp), (MAX(e.salEmp) - MIN(e.salEmp)) FROM Empleado e";
		streamArray = empleadoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println("Salario más alto: " + e[0] + ", Salario más bajo: " + e[1] + ", Diferencia: " + e[2]));
		
		
		
//		43. Conocido el resultado anterior, entregar el nombre de los empleados que reciben el salario más
//		alto y más bajo. Cuanto suman estos salarios?
		query = "SELECT e.nomEmp FROM Empleado e WHERE e.salEmp = (SELECT MAX(e2.salEmp) FROM Empleado e2) OR e.salEmp = (SELECT MIN(e2.salEmp) FROM Empleado e2)";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		query = "SELECT SUM(e.salEmp) FROM Empleado e WHERE e.salEmp = (SELECT MAX(e2.salEmp) FROM Empleado e2) OR e.salEmp = (SELECT MIN(e2.salEmp) FROM Empleado e2)";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		
		
		
//		44. Entregar el número de empleados de sexo femenino y de sexo masculino, por departamento.
		query = "SELECT d.nombreDepto,count(e.sexEmp) FROM Departamento d LEFT JOIN d.empleados e WHERE e.sexEmp = 'M' group by d.nombreDepto";
		streamArray = empleadoDAO.executeQuery(query);
		System.out.println("Hombres---------------");
		streamArray.forEach(e -> System.out.println(e[0]+", "+e[1]));		
		
		
		query = "SELECT d.nombreDepto,count(e.sexEmp) FROM Departamento d LEFT JOIN d.empleados e WHERE e.sexEmp = 'F' group by d.nombreDepto";
		streamArray = empleadoDAO.executeQuery(query);
		System.out.println("Mujeres---------------");
		streamArray.forEach(e -> System.out.println(e[0]+", "+e[1]));		

		
		
//		45. Hallar el salario promedio por departamento.
		query = "SELECT AVG(e.salEmp) FROM Departamento d LEFT JOIN d.empleados e group by d.codDepto";
		departamentoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		46. Hallar el salario promedio por departamento, considerando aquellos empleados cuyo salario
//		supera $900.000, y aquellos con salarios inferiores a $575.000. Entregar el código y el nombre del
//		departamento.
		query = "SELECT d.codDepto, d.nombreDepto, AVG(e.salEmp) FROM Departamento d LEFT JOIN d.empleados e where e.salEmp < 575000 or e.salEmp > 900000 group by d.codDepto ";
		streamArray =departamentoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println(e[0]+", "+e[1]+", "+e[2]));		

		
//		47. Entregar la lista de los empleados cuyo salario es mayor o igual que el promedio de la empresa.
//		Ordenarlo por departamento.
		query = "SELECT e FROM Departamento d LEFT JOIN d.empleados e where e.salEmp >= (select AVG(e.salEmp) FROM Empleado e) order by d";
		departamentoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		48. Hallar los departamentos que tienen más de tres (3) empleados. Entregar el número de
//		empleados de esos departamentos.
		query = "SELECT SIZE(d.empleados) FROM Departamento d where SIZE(d.empleados) > 3";
		departamentoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		49. Obtener la lista de empleados jefes, que tienen al menos un empleado a su cargo. Ordene el
//		informe inversamente por el nombre.


//		ESTA ESTA ESTA ESETA FJSDKHBNFUIDOAJSBNFUIDSBA U ~~~~~~~~~~~##################### ESTA MAL
		query = "SELECT e FROM Empleado e WHERE e.jefe IS NOT NULL ORDER BY e.nomEmp DESC";
		empleadoDAO.executeQuery(query).forEach(System.out::println);
		 
		
//		50. Hallar los departamentos que no tienen empleados
		query = "SELECT d FROM Departamento d where SIZE(d.empleados) = 0";
		departamentoDAO.executeQuery(query).forEach(System.out::println);
		
		
//		51. Entregar un reporte con el numero de cargos en cada departamento y cual es el promedio de
//		salario de cada uno. Indique el nombre del departamento en el resultado.
		query = "SELECT d.nombreDepto, COUNT(e.cargoE), AVG(e.salEmp) FROM Departamento d LEFT JOIN d.empleados e GROUP BY d.nombreDepto";
		streamArray = departamentoDAO.executeQuery(query);
		streamArray.forEach(e -> System.out.println("Departamento: " + e[0] + ", Número de cargos: " + e[1] + ", Promedio de salario: " + e[2]));
		
		
		
//		52. Entregar el nombre del departamento cuya suma de salarios sea la más alta, indicando el valor
//		de la suma.
		query = "SELECT d.nombreDepto, SUM(e.salEmp) FROM Departamento d LEFT JOIN d.empleados e GROUP BY d.nombreDepto ORDER BY SUM(e.salEmp) DESC";
		streamArray = departamentoDAO.executeQuery(query);
		streamArray.findFirst().ifPresent(e -> System.out.println(e[0]+", "+e[1]));		

		
//		53. Entregar un reporte con el código y nombre de cada jefe, junto al número de empleados que
//		dirige. Puede haber empleados que no tengan supervisores, para esto se indicará solamente el
//		numero de ellos dejando los valores restantes en NULL.

//		ESTA ESTA ESTA ESETA FJSDKHBNFUIDOAJSBNFUIDSBA U ~~~~~~~~~~~##################### ESTA MAL
		query = "SELECT e.jefe, e.nomEmp, COUNT(e2) FROM Empleado e LEFT JOIN Empleado e2 ON e.nIDEmp = e2.jefe GROUP BY e.jefe, e.nomEmp";
		streamArray = departamentoDAO.executeQuery(query);
		streamArray.findFirst().ifPresent(e -> System.out.println(e[0]+", "+e[1]));	
		
		
		
		
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
