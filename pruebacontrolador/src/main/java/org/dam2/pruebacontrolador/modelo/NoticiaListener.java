package org.dam2.pruebacontrolador.modelo;

import org.dam2.pruebacontrolador.SpringContext;
import org.dam2.pruebacontrolador.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class NoticiaListener {

	private IUsuarioService usuarioServicio;

	@PrePersist
	public void prePersistFunction(Noticia n) {
		if (usuarioServicio == null) {
			usuarioServicio = SpringContext.getBean(IUsuarioService.class);
		}

		Usuario autor = n.getAutor();
		autor.addPuntos(n.getCategoria().ordinal() + 1);
		usuarioServicio.update(autor);
	}

}
