package org.dam2.ciclistas;

import com.opencsv.bean.CsvBindAndSplitByPosition;
import com.opencsv.bean.CsvBindByPosition;
import lombok.*;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Vuelta {

    @EqualsAndHashCode.Include
    @CsvBindByPosition(position = 0)
    private String nombre;
    @CsvBindByPosition(position = 1)
    private float premio;
    @CsvBindByPosition(position = 2)
    private String director;
    @CsvBindByPosition(position = 3)
    private int etapas;
    @EqualsAndHashCode.Include
    @CsvBindByPosition(position = 4)
    private int año;
    @CsvBindAndSplitByPosition(
            position = 5,
            splitOn = Separadores.SEPARADOR_EQUIPOS,
            writeDelimiter = Separadores.SEPARADOR_EQUIPOS,
            elementType = Equipo.class,
            converter = EquipoAdapter.class
    )
    private List<Equipo> equipos;

}
