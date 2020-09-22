package ru.netology.domain;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data


public class Radio {
    private int maxStation = 9;
    private final int maxVolume = 100;
    private int station = 0;
    private int volume = 0;
    private boolean on;


    public Radio(int maxStation) {
        if (maxStation < 0) return;
       // if (maxStation > 1000) return;
        this.maxStation = maxStation;
    }
    public void increaseVolume() {
        if (volume < maxVolume) volume++;
    }

    public void decreaseVolume() {
        if (volume > 0) volume--;
    }
    public void nextStation() {
        if (getStation() == maxStation) {
            setStation(0);
        } else {
            setStation(getStation() + 1);
        }
    }

    public void prevStation() {
        if (station == 0) {
            station = maxStation;
        } else {
            station--;
        }
    }
    public void setStation(int station) {
        if (station < 0) return;
        if (station > maxStation) return;
        this.station = station;
    }

}
