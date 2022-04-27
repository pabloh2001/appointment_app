package com.project.appointment;

import java.time.LocalTime;

public class Prueba {
    public static void main(String[] args) {
        LocalTime actual = LocalTime.of(10, 30);
        LocalTime next = LocalTime.of(9, 20);
        System.out.println(actual);
        if (actual.getHour() < next.getHour() && !actual.plusHours(1).equals(next) ){
            System.out.println("sumó");
            System.out.printf("Error, la diferencia debe ser de 1 hora.");
        }
        if (!actual.minusHours(1).equals(next)){
            System.out.println("restó");
            System.out.printf("Error, la diferencia debe ser de 1 hora.");
        }
        System.out.println("cita guardada");
    }
}
