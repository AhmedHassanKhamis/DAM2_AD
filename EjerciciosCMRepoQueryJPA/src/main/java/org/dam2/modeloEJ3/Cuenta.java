package org.dam2.modeloEJ3;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

//Anotaciones Lombok
@SuperBuilder 
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@EntityListeners(CuentaListener.class)
public abstract class Cuenta implements Serializable{
	@EqualsAndHashCode.Include
	@Id
	private int numero;
	private float saldo;
	
    @ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER) // Relación perezosa por defecto
    @JoinTable(
        name = "REL_CUENTAS_CLIENTES",
        joinColumns = {@JoinColumn(name = "FK_CUENTA", nullable = false)},
        inverseJoinColumns = {@JoinColumn(name="FK_CLIENTE", nullable = false)}
    )
    @Singular
	private List<Cliente> titulares;
    
    public void ingresar(float cantidad) {
    	saldo += cantidad;    	
    }
    
    public abstract void retirar(float cantidad);
    
    public abstract void transferencia(float cantidad, Cuenta destino);
    
    public void recibirTransferencia(float cantidad) {
        setSaldo(getSaldo() + cantidad); // Incrementa el saldo con la cantidad recibida
    }

}
