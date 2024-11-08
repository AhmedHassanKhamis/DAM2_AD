package org.dam2.ciclistas;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        escribirCsv();

        List<Vuelta> vueltas = leerCsv();
        System.out.println(vueltas);
//        for (Vuelta vuelta : vueltas) {
//            System.out.println(vuelta);
//        }

    }

    public static void escribirCsv() {
        List<Vuelta> vueltas = new ArrayList<>();

        Corredor corredor1 = Corredor
                .builder()
                .dni("001")
                .nombre("Ahmed")
                .fechaNacimiento(LocalDate.parse("2001-01-01"))
                .profesional(true)
                .build();


        Corredor corredor2 = Corredor
                .builder()
                .dni("002")
                .nombre("Dylan")
                .fechaNacimiento(LocalDate.parse("2002-02-02"))
                .profesional(true)
                .build();

        Equipo equipo1 = Equipo
                .builder()
                .nombre("Esparragos")
                .patrocinador(
                        Patrocinador
                                .builder()
                                .nombre("Nestlé")
                                .nacionalidad("España")
                                .donacion(50000f)
                                .build()
                )
                .corredores(List.of(corredor1, corredor2))
                .build();

        Vuelta vuelta1 = Vuelta
                .builder()
                .nombre("Perroton")
                .año(2024)
                .premio(5000f)
                .director("Pedro Sanchez")
                .etapas(4)
                .equipos(List.of(equipo1))
                .build();

        vueltas.add(vuelta1);

        try {
            Writer w = new FileWriter("vueltasantonio.csv");
            StatefulBeanToCsv beans = new StatefulBeanToCsvBuilder(w)
                    .withSeparator(Separadores.SEPARADOR_ELEMENTOS_VUELTAS.charAt(0))
                    .withApplyQuotesToAll(false)
                    .build();
            beans.write(vueltas);
            w.close();
            System.out.println("Fichero escrito.");
        } catch (IOException | CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
            throw new RuntimeException(e);
        }

    }

    public static List<Vuelta> leerCsv() {
        List<Vuelta> list;
        try {
            list = new CsvToBeanBuilder(new FileReader("vueltasantonio.csv"))
                    .withSeparator(Separadores.SEPARADOR_ELEMENTOS_VUELTAS.charAt(0))
                    .withType(Vuelta.class)
                    .build()
                    .parse();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

}
