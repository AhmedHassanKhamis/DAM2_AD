package org.dam2.ejercicioJson2;

import java.util.Arrays;

public enum TipoFormacion {
	NOPRESENCIAL {
		public String toString() {
			return "No Presencial";
		}

		public String toString2() {
			return "NoPresencial";
		}
	},
	PRESENCIAL {
		public String toString() {
			return "Presencial";
		}
	};

	public static TipoFormacion crearTipoFormacion(String value) {
		return Arrays.stream(TipoFormacion.values()).filter(t -> t.toString().equalsIgnoreCase(value)).findFirst()
				.orElse(NOPRESENCIAL);
	}

}
