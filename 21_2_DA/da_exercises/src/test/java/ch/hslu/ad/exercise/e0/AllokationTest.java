package ch.hslu.ad.exercise.e0;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

final class AllokationTest {
    @Test
    void testEquals() {
        var a = new Allokation(1000, 10);
        var b = new Allokation(1000, 10);

        assertTrue(a.equals(b));
    }

    @Test
    void testNotEquals() {
        var a = new Allokation(1000, 10);
        var b = new Allokation(1000, 100);

        assertFalse(a.equals(b));
    }

    @Test
    void testHashCode() {
        assertEquals(new Allokation(1000, 10).hashCode(), new Allokation(1000, 10).hashCode());
    }

    @Test
    void testNotHashCode() {
        assertNotEquals(new Allokation(1000, 10).hashCode(), new Allokation(1000, 100).hashCode());
    }

    @Test
    void compareTo() {
        var list = new ArrayList<Allokation>();

        list.add(new Allokation(1000, 10));
        list.add(new Allokation(500, 1000));
        list.add(new Allokation(1000, 1000));
        list.add(new Allokation(2500, 1000));

        list.sort(Allokation::compareTo);

        assertEquals(list.get(0).getAddress(), 500);
        assertEquals(list.get(3).getAddress(), 2500);
    }

    @Test
    void testGetAddress() {
        assertEquals(new Allokation(1000, 10).getAddress(), 1000);
    }

    @Test
    void testGetSize() {
        assertEquals(new Allokation(1000, 10).getSize(), 10);
    }

    @Test
    void equalsContract(){
        EqualsVerifier.forClass(Allokation.class).verify();
    }
}