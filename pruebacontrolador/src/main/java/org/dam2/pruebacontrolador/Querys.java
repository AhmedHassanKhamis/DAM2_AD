package org.dam2.pruebacontrolador;

import org.dam2.pruebacontrolador.service.IComentarioService;
import org.dam2.pruebacontrolador.service.INoticiaService;
import org.dam2.pruebacontrolador.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 2)
public class Querys implements CommandLineRunner {

	
	@Autowired IUsuarioService usuarioService;
	@Autowired INoticiaService noticiaService;
	@Autowired IComentarioService comentarioService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		query 1
		System.out.println("QUERY 1");
		System.out.println(noticiaService.findNoticiaMasComentada().get());
		
		
//		query 2
		System.out.println("QUERY 2");
		noticiaService.findNoticiasUsuariosMasPuntos().forEach(System.out::println);
		
		
//		query 3 
		System.out.println("QUERY 3");
		noticiaService.findNoticiasDelMes().forEach(System.out::println);
		
	}

}
