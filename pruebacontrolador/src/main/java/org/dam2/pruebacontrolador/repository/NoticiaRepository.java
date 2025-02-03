package org.dam2.pruebacontrolador.repository;

import java.util.List;
import java.util.Optional;

import org.dam2.pruebacontrolador.modelo.Noticia;
import org.dam2.pruebacontrolador.service.TituloYCuerpo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface NoticiaRepository extends CrudRepository<Noticia, String> {
	
	public List<Noticia> findByTitulo(String titulo);
	
	@Query("SELECT n.titulo, n.cuerpo FROM Noticia n where MONTH(n.fecha) = MONTH(CURRENT_DATE) AND YEAR(n.fecha) = YEAR(CURRENT_DATE) ")
	public List<TituloYCuerpo> findNoticiasDelMes();

}
