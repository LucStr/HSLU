package ch.hslu.oop.exercises.car;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

class MotorTest {

    @Test
    void rpmIsZeroAfterCreation() {
        var motor = new Motor();

        assertEquals(0, motor.getRPM());
    }

    @Test
    void rpmIsStaticValueWhenTurnedOn(){
        var motor = new Motor();

        motor.switchOn();

        assertEquals(Motor.RPM_WHEN_ON, motor.getRPM());
    }

    @Test
    void changeEventIsTriggerForRpmWhenTurnedOn(){
        var motor = new Motor();
        AtomicInteger calls = new AtomicInteger();
        motor.addPropertyChangeListener(e -> {
            if(e.getPropertyName() == "rpm"){
                calls.getAndIncrement();
            }
        });

        motor.switchOn();
        assertEquals(1, calls.get());
    }

    @Test
    void changeEventIsTriggerForMotorStateWhenTurnedOn(){
        var motor = new Motor();
        AtomicInteger calls = new AtomicInteger();
        motor.addPropertyChangeListener(e -> {
            if(e.getPropertyName() == "motorState"){
                calls.getAndIncrement();
            }
        });

        motor.switchOn();
        assertEquals(1, calls.get());
    }

    @Test
    void changeEventIsTriggerForRpmWhenTurnedOff(){
        var motor = new Motor();
        motor.switchOn();

        AtomicInteger calls = new AtomicInteger();
        motor.addPropertyChangeListener(e -> {
            if(e.getPropertyName() == "rpm"){
                calls.getAndIncrement();
            }
        });

        motor.switchOff();
        assertEquals(1, calls.get());
    }

    @Test
    void changeEventIsTriggerForMotorStateWhenTurnedOff(){
        var motor = new Motor();
        motor.switchOn();

        AtomicInteger calls = new AtomicInteger();
        motor.addPropertyChangeListener(e -> {
            if(e.getPropertyName() == "motorState"){
                calls.getAndIncrement();
            }
        });

        motor.switchOff();
        assertEquals(1, calls.get());
    }

    @Test
    void changeEventIsTriggerForRpmOnlyOnceWhenTurnedOnMultipleTimes(){
        var motor = new Motor();
        AtomicInteger calls = new AtomicInteger();
        motor.addPropertyChangeListener(e -> {
            if(e.getPropertyName() == "rpm"){
                calls.getAndIncrement();
            }
        });

        motor.switchOn();
        motor.switchOn();
        motor.switchOn();
        assertEquals(1, calls.get());
    }

    @Test
    void motorIsSwitchedOnAfterBeingSwitchedOn() {
        var motor = new Motor();
        motor.switchOn();

        assertTrue(motor.isSwitchedOn());
    }

    @Test
    void motorIsNotSwitchedOffAfterBeingSwitchedOn() {
        var motor = new Motor();
        motor.switchOn();

        assertTrue(!motor.isSwitchedOff());
    }
}