package org.dam2.ciclistas;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.AbstractCsvConverter;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.List;

public class EquipoAdapter extends AbstractCsvConverter {
    @Override
    public Object convertToRead(String value) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        StringReader reader = new StringReader(value);

        CSVParser csvp = new CSVParserBuilder()
                .withSeparator(Separadores.SEPARADOR_ELEMENTOS_EQUIPO.charAt(0))
                .build();
        CSVReader csvr = new CSVReaderBuilder(reader)
                .withCSVParser(csvp)
                .build();

        return new CsvToBeanBuilder<Equipo>(csvr)
                .withType(Equipo.class)
                .build()
                .stream()
                .findFirst()
                .orElseGet(Equipo::new);
    }

    @Override
    public String convertToWrite(Object value) throws CsvDataTypeMismatchException {
        Writer writer = new StringWriter();
        try {
            StatefulBeanToCsv beans = new StatefulBeanToCsvBuilder(writer)
                    .withSeparator(Separadores.SEPARADOR_ELEMENTOS_EQUIPO.charAt(0))
                    .withApplyQuotesToAll(false)
                    .withLineEnd("")
                    .build();
            beans.write(List.of(value));
            writer.close();
        } catch (CsvRequiredFieldEmptyException | IOException e) {
            throw new RuntimeException(e);
        }
        return writer.toString();
    }
}
