package org.dam2.modeloEJ3;

import javax.persistence.PrePersist;

public class CuentaListener {
	@PrePersist
	private void prePersistFunction(Cuenta c) {
		c.setSaldo(0);
	}
}
