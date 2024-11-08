package org.dam2.ciclistas;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import lombok.*;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Equipo {

    @CsvBindByPosition(position = 0)
    private String nombre;
    @CsvCustomBindByPosition(position = 1, converter = PatrocinadorAdapter.class)
    private Patrocinador patrocinador;
    @CsvBindAndSplitByPosition(
            position = 2,
            splitOn = Separadores.SEPARADOR_CORREDORES,
            writeDelimiter = Separadores.SEPARADOR_CORREDORES,
            elementType = Corredor.class,
            converter = CorredorAdapter.class
    )
    private List<Corredor> corredores;


}
