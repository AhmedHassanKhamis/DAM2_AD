package org.dam2.pruebacontrolador.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.dam2.pruebacontrolador.modelo.Noticia;
import org.dam2.pruebacontrolador.service.TituloCuerpo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository

public interface NoticiaRepository extends CrudRepository<Noticia, String> {
	
	public List<Noticia> findByTitulo(String titulo);
	

	@Query("SELECT n.titulo as titulo, n.cuerpo as cuerpo FROM Noticia n where MONTH(n.fecha) = MONTH(CURRENT_DATE) AND YEAR(n.fecha) = YEAR(CURRENT_DATE) ")
	public Stream<TituloCuerpo> findNoticiasDelMes();
//	public Stream<Object[]> findNoticiasDelMes();

	
	
	@Query("SELECT c.noticia FROM Comentario c GROUP BY c.noticia ORDER BY COUNT(c) DESC LIMIT 1")
	public Optional<Noticia> findNoticiaMasComentada();
	


}
