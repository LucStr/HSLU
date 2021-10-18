package ch.hslu.ad.sw01.d3;

import ch.hslu.ad.sw01.e0.Allokation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TombstoneHashtableTest {
    @Test
    void testCanFullyFillTombstoneableHashtable(){
        var table = new TombstoneHashtable<Allokation>();

        for (var i = 0; i < 10; i++){
            table.addItem(new Allokation(10 + i, 10));
        }
    }

    @Test
    void testReceiveItemAfterAdding() {
        var table = new TombstoneHashtable<Allokation>();
        var a = new Allokation(10, 10);

        table.addItem(a);

        assertEquals(a, table.getItem(a.hashCode()));
    }

    @Test
    void testReceiveItemAfterAddingWithDifferentAddress() {
        var table = new TombstoneHashtable<Allokation>();
        var a = new Allokation(10, 10);

        table.addItem(a);

        assertEquals(new Allokation(10, 10), table.getItem(a.hashCode()));
    }

    @Test
    void testMultipleIndexThrows() {
        var table = new TombstoneHashtable<Allokation>();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            for (var i = 0; i < 11; i++){
                table.addItem(new Allokation(10 + i, 10));
            }
        });
    }

    @Test
    void testRemoveWorks(){
        var table = new TombstoneHashtable<Allokation>();
        var a = new Allokation(10, 10);

        table.addItem(a);

        assertEquals(a, table.getItem(a.hashCode()));

        assertTrue(table.removeItem(a));

        assertNull(table.getItem(a.hashCode()));
    }

    @Test
    void testReturnsFalseIfNotToRemove(){
        var table = new TombstoneHashtable<Allokation>();

        assertFalse(table.removeItem(new Allokation(10, 10)));
    }

}