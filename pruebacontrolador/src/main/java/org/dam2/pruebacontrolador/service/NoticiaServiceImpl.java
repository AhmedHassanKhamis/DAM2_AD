package org.dam2.pruebacontrolador.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.dam2.pruebacontrolador.modelo.Categoria;
import org.dam2.pruebacontrolador.modelo.Noticia;
import org.dam2.pruebacontrolador.repository.NoticiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticiaServiceImpl implements INoticiaService {

	@Autowired
	NoticiaRepository noticiaDAO;

	@Override
	public boolean insert(Noticia noticia) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (!noticiaDAO.existsById(noticia.getTitulo())) {
			noticiaDAO.save(noticia);
			exito = true;
		}
		return exito;
	}

	@Override
	public boolean update(Noticia noticia) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (noticiaDAO.existsById(noticia.getTitulo())) {
			noticiaDAO.save(noticia);
			exito = true;
		}
		return exito;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		boolean exito = false;
		if (noticiaDAO.existsById(id)) {
			noticiaDAO.deleteById(id);
			exito = true;
		}
		return exito;
	}

	@Override
	public List<Noticia> findAll() {
		// TODO Auto-generated method stub
		return (List<Noticia>) noticiaDAO.findAll();
	}

	@Override
	public List<Noticia> findByTitulo(String titulo) {
		// TODO Auto-generated method stub
		return noticiaDAO.findByTitulo(titulo);
	}

	@Override
	public List<String> findNoticiasDelMes() {
		// TODO Auto-generated method stub
		List<String> noticiasMes = noticiaDAO.findNoticiasDelMes().map(n -> n.getTitulo() + "->" + n.getCuerpo())
				.toList();
//		List<String> noticiasMes = noticiaDAO.findNoticiasDelMes().map(n -> n[0] + "->" + n[1]).toList();

		return noticiasMes;
	}

	@Override
	public Optional<Noticia> findNoticiaMasComentada() {
		// TODO Auto-generated method stub
		return noticiaDAO.findNoticiaMasComentada();
	}

	@Override
	public List<Noticia> findNoticiasUsuariosMasPuntos() {
		// TODO Auto-generated method stub
		return noticiaDAO.findNoticiasUsuariosMasPuntos();
	}

	@Override
	public List<Noticia> findByCategoria(String categoria) {
		// TODO Auto-generated method stub
		Categoria categoriatipo;
		switch (categoria) {
		case "DEPORTES":
			categoriatipo = Categoria.DEPORTES;
			break;
		case "POLITICA":
			categoriatipo = Categoria.POLITICA;
			break;
		case "ECONOMIA":
			categoriatipo = Categoria.ECONOMIA;
			break;
		default:
			categoriatipo = Categoria.DEPORTES;
			break;
		}
		return noticiaDAO.findByCategoria(categoriatipo);
	}

	@Transactional
	@Override
	public Integer deleteNoticiasSinComentarios() {
		// TODO Auto-generated method stub
		return noticiaDAO.deleteNoticiasSinComentarios();
	}

}
