package org.dam2.modeloEJ3;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

//Anotaciones Lombok
@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)

//Anotaciones JPA
@Entity
public class CuentaPersonal extends Cuenta {
	private boolean tarjetaCredito;

	@Override
	public void Retirar(float cantidad) {
		float suma = (float) getTitulares().stream().mapToDouble(Cliente::getMaxAval).sum();
		float limiteNegativo = -suma * 0.50f; // Límite negativo permitido.

		if ((getSaldo() - cantidad) >= limiteNegativo) { // Verifica que no excede el límite.
			setSaldo(getSaldo() - cantidad); // Realiza el retiro.
		} else {
			System.out.println("Saldo insuficiente para realizar esta operación.");
		}
	}

	@Override
	public void Transferencia(float cantidad, Cuenta destino) {
		float suma = (float) getTitulares().stream().mapToDouble(Cliente::getMaxAval).sum();
		float comision = Math.min(cantidad * 0.002f, 4);
		System.out.println("COMISION: " + comision);
		float totalADescontar = cantidad + comision;
		float limiteNegativo = -suma * 0.50f; // Límite negativo permitido.

		if ((getSaldo() - totalADescontar) >= limiteNegativo) { // Verifica que no excede el límite.
			setSaldo(getSaldo() - totalADescontar); // Descontar saldo
			destino.RecibirTransferencia(cantidad);
	        System.out.println("Transferencia realizada con éxito.");
		} else {
			System.out.println("Saldo insuficiente para realizar esta operación.");
		}
	}
}
