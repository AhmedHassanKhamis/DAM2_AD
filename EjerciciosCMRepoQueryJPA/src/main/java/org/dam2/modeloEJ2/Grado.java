package org.dam2.modeloEJ2;

public enum Grado {
	ESO(1), BACHILLERATO(2), FPMEDIO(3), FPSUPERIOR(4);

	private int curso;

	Grado(int curso) {
		this.curso = curso;
	}

	public int getCurso() {
		return curso;
	}
}