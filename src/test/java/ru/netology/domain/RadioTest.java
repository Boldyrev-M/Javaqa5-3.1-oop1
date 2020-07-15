package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {

    @Test
    void setStation() {
        Radio radioSet = new Radio();

        radioSet.setStation(-1);
        radioSet.setStation(555);
        radioSet.setStation(5);
        assertEquals(5, radioSet.getStation());
    }


    @Test
    void increaseVolume() {
        Radio radioSet = new Radio();
        radioSet.increaseVolume();
        radioSet.increaseVolume();
        radioSet.increaseVolume();
        assertEquals(3, radioSet.getVolume());

        radioSet.setVolume(10);
        radioSet.increaseVolume();
        assertEquals(10, radioSet.getVolume());

    }

    @Test
    void decreaseVolume() {
        Radio radioSet = new Radio();
        radioSet.setVolume(10);
        radioSet.decreaseVolume();
        radioSet.decreaseVolume();
        radioSet.decreaseVolume();
        assertEquals(7, radioSet.getVolume());

        radioSet.setVolume(0);
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