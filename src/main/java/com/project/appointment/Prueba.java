package com.project.appointment;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import java.time.LocalTime;

public class Prueba {
    public static void main(String[] args) {
        LocalTime actual = LocalTime.of(20, 4);
        LocalTime next = LocalTime.of(23, 0);
        if (next.getMinute() < LocalTime.now().getMinute()){
            System.out.println("forma correcta");
        }
    }
}
