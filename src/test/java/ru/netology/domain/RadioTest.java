package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
//    Требования к работе с радиостанциями:
//
//  + Можно задавать количество радиостанций при создании объекта (по умолчанию - 10)
//  + Номер текущей радиостанции изменяется в пределах от 0 до количества радиостанций,
//          указанных при создании (см. п.1)
//  + Если текущая радиостанция - максимальная, и клиент нажал на кнопку next (следующая)
//          на пульте, то текущей должна стать 0-ая
//  + Если текущая радиостанция - 0, и клиент нажал на кнопку prev (предыдущая) на пульте
//          то текущей должна стать максимальная
//  + Клиент должен иметь возможность выставлять номер радиостанции с цифрового пульта
//          (вводя числа 0 - количество станций)

    @Test
    void setStation() {

        Radio radioSet17 = new Radio(17);
        assertEquals(17, radioSet17.getMaxStation());
        radioSet17.setStation(-1);
        radioSet17.setStation(555);
        radioSet17.setStation(4); // set correct number
        assertEquals(4, radioSet17.getStation());
        radioSet17.setStation(20); // trying to set over max number
        assertEquals(4, radioSet17.getStation());
        radioSet17.setStation(-3); // trying to set number below zero
        assertEquals(4, radioSet17.getStation());

        Radio radioSetDefault = new Radio();
        assertEquals(9, radioSetDefault.getMaxStation());

    }


    @Test
    void increaseVolume() {
        Radio radioSet = new Radio();
        radioSet.setVolume(15);
        radioSet.increaseVolume();
        assertEquals(16, radioSet.getVolume());

        radioSet.setVolume(radioSet.getMaxVolume()-1);
        radioSet.increaseVolume();
        radioSet.increaseVolume();
        radioSet.increaseVolume();
        radioSet.decreaseVolume();
        assertEquals(99, radioSet.getVolume());

        radioSet.setVolume(100);
        radioSet.increaseVolume();
        assertEquals(100, radioSet.getVolume());

    }

    @Test
    void decreaseVolume() {
        Radio radioSet = new Radio();
        radioSet.setVolume(10);
        radioSet.decreaseVolume();
        radioSet.decreaseVolume();
        radioSet.decreaseVolume();
        assertEquals(7, radioSet.getVolume());

        radioSet.setVolume(2);
        radioSet.decreaseVolume();
        radioSet.decreaseVolume();
        radioSet.decreaseVolume();
        assertEquals(0, radioSet.getVolume());
    }


    @Test
    void nextStation() {
        Radio radioSet = new Radio();
        radioSet.setStation(radioSet.getMaxStation()-1);
        radioSet.nextStation();
        radioSet.nextStation();
        radioSet.nextStation();
        radioSet.nextStation();
        assertEquals(2, radioSet.getStation());
    }

    @Test
    void prevStation() {
        Radio radioSet = new Radio();
        radioSet.setStation(2);
        radioSet.prevStation();
        radioSet.prevStation();
        radioSet.prevStation();
        radioSet.prevStation();
        assertEquals(radioSet.getMaxStation()-1,radioSet.getStation());
    }
}