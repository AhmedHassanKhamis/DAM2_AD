package org.dam2.ciclistas;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder@Data@NoArgsConstructor@AllArgsConstructor

public class Corredor {

    @CsvBindByPosition(position = 0)
    private String dni;
    @CsvBindByPosition(position = 1)
    private String nombre;
    @CsvBindByPosition(position = 2)
    @CsvDate("yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    @CsvBindByPosition(position = 3)
    private boolean profesional;

}
