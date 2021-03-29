package ch.hslu.exercises.temperature;

import ch.hslu.oop.exercises.temperature.Lead;
import ch.hslu.oop.exercises.temperature.Mercury;
import ch.hslu.oop.exercises.temperature.Nitrogen;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class ChemicalElementsTest {
    @Test
    void LeadReturnsSymbol(){
        var lead = new Lead();

        assertEquals(lead.toString(), "Pb");
    }

    @Test
    void MercuryReturnsSymbolWithGiftig(){
        var mercury = new Mercury();

        assertEquals(mercury.toString(), "Hg GIFTIG!");
    }

    @Test
    void NitrogenReturnsSymbol(){
        var nitrogen = new Nitrogen();

        assertEquals(nitrogen.toString(), "N");
    }
}
