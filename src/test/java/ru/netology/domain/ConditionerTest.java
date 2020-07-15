package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConditionerTest {


    @Test
    public void shouldChangeTemperature() {
        // initialize
        Conditioner conditioner = new Conditioner();
        conditioner.setMinTemperature(16);
        conditioner.setMaxTemperature(25);

        conditioner.setCurrentTemperature(20);
// проверка изменения температуры
        assertEquals(20, conditioner.getCurrentTemperature());
        conditioner.increaseCurrentTemperature();
        assertEquals(21, conditioner.getCurrentTemperature());

// проверка граничных условий
        // max temp
        conditioner.setCurrentTemperature(conditioner.getMaxTemperature());
        conditioner.increaseCurrentTemperature();
        assertEquals(conditioner.getMaxTemperature(), conditioner.getCurrentTemperature());

        // min temp
        conditioner.setCurrentTemperature(conditioner.getMinTemperature());
        conditioner.decreaseCurrentTemperature();
        assertEquals(conditioner.getMinTemperature(), conditioner.getCurrentTemperature());

    }
}

