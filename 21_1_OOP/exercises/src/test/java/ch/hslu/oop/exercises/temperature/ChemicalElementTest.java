package ch.hslu.oop.exercises.temperature;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChemicalElementTest {
    @Test
    void getStateAtTemperature() {
        assertEquals("Blei ist bei 20,00°C fest.", new Lead().getStateAtTemperature(new Temperature(20f)));
    }

    @Test
    void LeadReturnsSymbol() {
        var lead = new Lead();

        assertEquals(lead.toString(), "Pb");
    }

    @Test
    void MercuryReturnsSymbolWithGiftig() {
        var mercury = new Mercury();

        assertEquals(mercury.toString(), "Hg GIFTIG!");
    }

    @Test
    void NitrogenReturnsSymbol() {
        var nitrogen = new Nitrogen();

        assertEquals(nitrogen.toString(), "N");
    }
}