package org.dam2.ejercicioCorredores;

import java.time.LocalDate;
import java.util.Set;

import org.dam2.ejercicioCorredores.modelo.Carrera;
import org.dam2.ejercicioCorredores.modelo.Corredor;
import org.dam2.ejercicioCorredores.modelo.CorredorCarrera;
import org.dam2.ejercicioCorredores.modelo.PuntoDeControl;
import org.dam2.ejercicioCorredores.servicio.ICarreraServicio;
import org.dam2.ejercicioCorredores.servicio.ICorredorCarreraServicio;
import org.dam2.ejercicioCorredores.servicio.ICorredorServicio;
import org.dam2.ejercicioCorredores.servicio.IPuntoDeControlServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(value = 1)
public class cargarDatos implements CommandLineRunner {

	@Autowired ICorredorCarreraServicio corredorCarreraServicio;
	@Autowired ICarreraServicio carreraServicio;
	@Autowired ICorredorServicio corredorServicio;
	@Autowired IPuntoDeControlServicio puntoControlServicio;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		 // Crear corredores
        Corredor corredor1 = Corredor.builder()
                .dni("12345678A")
                .nombreCorredor("Juan Perez")
                .sexo(true)
                .build();
        
        Corredor corredor2 = Corredor.builder()
                .dni("87654321B")
                .nombreCorredor("Maria López")
                .sexo(false)
                .build();
        
        
        // Crear puntos de control para la carrera 1
        PuntoDeControl pc1_carrera1 = PuntoDeControl.builder()
                .km(5.0f)
                .juez("Juez1")
                .build();
        
        PuntoDeControl pc2_carrera1 = PuntoDeControl.builder()
                .km(10.0f)
                .juez("Juez2")
                .build();

        // Crear puntos de control para la carrera 2
        PuntoDeControl pc1_carrera2 = PuntoDeControl.builder()
                .km(3.0f)
                .juez("Juez3")
                .build();
        
        PuntoDeControl pc2_carrera2 = PuntoDeControl.builder()
                .km(8.0f)
                .juez("Juez4")
                .build();

        // Crear carreras
        Carrera carrera1 = Carrera.builder()
                .nombreCarrera("Maratón Primavera")
                .cupo(100)
                .fechaCelebracion(LocalDate.of(2025, 3, 15))
                .puntosDeControl(Set.of(pc1_carrera1, pc2_carrera1))
                .build();
        
        Carrera carrera2 = Carrera.builder()
                .nombreCarrera("Carrera Nocturna")
                .cupo(50)
                .fechaCelebracion(LocalDate.of(2025, 5, 20))
                .puntosDeControl(Set.of(pc1_carrera2, pc2_carrera2))
                .build();

        // Inscribir corredores en las carreras
        CorredorCarrera inscripcion1 = CorredorCarrera.builder()
                .corredor(corredor1)
                .carrera(carrera1)
                .build();
        
        CorredorCarrera inscripcion2 = CorredorCarrera.builder()
                .corredor(corredor2)
                .carrera(carrera2)
                .build();
        
        CorredorCarrera inscripcion3 = CorredorCarrera.builder()
                .corredor(corredor1)
                .carrera(carrera2)
                .build();
        
        CorredorCarrera inscripcion4 = CorredorCarrera.builder()
                .corredor(corredor2)
                .carrera(carrera1)
                .build();
        
        corredorServicio.insert(corredor1);
        corredorServicio.insert(corredor2);
        
     
        puntoControlServicio.insert(pc1_carrera1);
        puntoControlServicio.insert(pc2_carrera1);
        puntoControlServicio.insert(pc1_carrera2);
        puntoControlServicio.insert(pc2_carrera2);
        
        carreraServicio.insert(carrera1);
        carreraServicio.insert(carrera2);
        
        
        corredorCarreraServicio.insert(inscripcion1);
        corredorCarreraServicio.insert(inscripcion2);
        corredorCarreraServicio.insert(inscripcion3);
        corredorCarreraServicio.insert(inscripcion4);



	}

}
