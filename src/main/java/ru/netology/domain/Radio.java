package ru.netology.domain;

public class Radio {
    private int maxStation;
    private final int maxVolume = 100;
    private int station = 0;
    private int volume = 0;
    private boolean on;

    public Radio() {
        maxStation = 9;
    }

    public Radio(int maxStation) {
       // if (maxStation < 0) return;
       // if (maxStation > 1000) return;
        this.maxStation = maxStation;
    }

    public int getStation() {
        return station;
    }

    public int getMaxStation() {
        return maxStation;
    }

    public void setStation(int station) {
        if (station < 0) return;
        if (station > maxStation) return;
        this.station = station;
    }

    public int getVolume() {
        return volume;
    }

    public void increaseVolume() {
        if (volume < maxVolume) volume++;
    }

    public void decreaseVolume() {
        if (volume > 0) volume--;

    }

    public void setVolume(int volume) {
        this.volume = volume;
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

    public int getMaxVolume() {
        return maxVolume;
    }
}
