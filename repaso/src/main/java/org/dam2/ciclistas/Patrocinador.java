package org.dam2.ciclistas;

import com.opencsv.bean.CsvBindByPosition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Patrocinador {

    @CsvBindByPosition(position = 0)
    private String nombre;
    @CsvBindByPosition(position = 1)
    private String nacionalidad;
    @CsvBindByPosition(position = 2)
    private float donacion;

}
