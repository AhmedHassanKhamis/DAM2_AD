package org.dam2.modeloEJ3;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
public class CuentaEmpresa extends Cuenta{
	
	private String nombreEmpresa;
	private String cif;
	@Enumerated(EnumType.STRING)
	private Local local;

	@Override
	public void Retirar(float cantidad) {
		float suma = (float) getTitulares().stream().mapToDouble(Cliente::getMaxAval).sum();
	    float limiteNegativo = -suma * 2.0f; // Límite negativo permitido para empresas

	    if ((getSaldo() - cantidad) >= limiteNegativo) { // Verifica si el saldo cumple la condición
	        setSaldo(getSaldo() - cantidad); // Descuenta la cantidad del saldo
	        System.out.println("Retiro realizado con éxito.");
	    } else {
	        System.out.println("Saldo insuficiente para realizar el retiro.");
	    }
	}

	@Override
	public void Transferencia(float cantidad, Cuenta destino) {
		float suma = (float) getTitulares().stream().mapToDouble(Cliente::getMaxAval).sum();
		float comision = Math.min(cantidad * 0.001f, 6);
		float totalADescontar = cantidad + comision;
		float limiteNegativo = -suma * 2.0f; // Límite negativo permitido.

		if ((getSaldo() - totalADescontar) >= limiteNegativo) { // Verifica que no excede el límite.
			setSaldo(getSaldo() - totalADescontar); // Descontar saldo
			destino.RecibirTransferencia(cantidad);
	        System.out.println("Transferencia realizada con éxito.");
		} else {
			System.out.println("Saldo insuficiente para realizar esta operación.");
		}
	}

}
