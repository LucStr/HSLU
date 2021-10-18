package ch.hslu.ad.sw01.d2;

import org.junit.jupiter.api.Test;

import javax.management.openmbean.KeyAlreadyExistsException;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    @Test
    void testEmptySearchThrow(){
        var tree = new BinarySearchTree<Integer, String>();

        assertThrows(IllegalArgumentException.class, () -> {
            tree.search(1);
        });
    }

    @Test
    void hasKeyIsFalseOnEmptyCollection(){
        assertFalse(new BinarySearchTree<Integer, String>().hasKey(1));
    }

    @Test
    void searchReturnsValueIfKeyGiven(){
        var tree = new BinarySearchTree<Integer, String>();

        tree.add(1, "Test");

        assertEquals("Test", tree.search(1));
    }

    @Test
    void searchReturnsValueIfMultipleValues(){
        var tree = new BinarySearchTree<Integer, String>();

        tree.add(1, "Test");
        tree.add(2, "This");
        tree.add(3, "Is");
        tree.add(4, "Maybe");
        tree.add(5, "Test");
        tree.add(6, "Peter");
        tree.add(7, "Test");

        assertEquals("Peter", tree.search(6));
    }

    @Test
    void cannotFindKeyAfterRemoved(){
        var tree = new BinarySearchTree<Integer, String>();

        tree.add(1, "Test");
        tree.add(2, "This");
        tree.add(3, "Is");
        tree.add(4, "Maybe");
        tree.add(5, "Test");
        tree.add(6, "Peter");
        tree.add(7, "Test");

        assertTrue(tree.hasKey(4));

        tree.remove(4);

        assertFalse(tree.hasKey(4));
    }

    @Test
    void canRemoveRoot(){
        var tree = new BinarySearchTree<Integer, String>();

        tree.add(1, "Test");

        tree.remove(1);

        assertFalse(tree.hasKey(1));
    }

    @Test
    void addThrowsIfKeyAlreadyExists(){
        var tree = new BinarySearchTree<Integer, String>();

        tree.add(1, "Test");

        assertThrows(KeyAlreadyExistsException.class, () ->{
            tree.add(1, "Test2");
        });
    }

    @Test
    void addOrUpdateUpdatesIfKeyAlreadyExists(){
        var tree = new BinarySearchTree<Integer, String>();

        tree.add(1, "Test");
        assertEquals("Test", tree.search(1));
        tree.addOrUpdate(1, "Test2");
        assertEquals("Test2", tree.search(1));
    }

    @Test
    void canAddASingleItem(){
        var tree = new BinarySearchTree<Integer, String>();

        tree.add(1, "Peter");
    }

    @Test
    void canAddASingleItemAndSearchForIt(){
        var tree = new BinarySearchTree<Integer, String>();

        tree.add(1, "Peter");

        assertEquals("Peter", tree.search(1));
    }

    @Test
    void canAddMultipleItems(){
        var tree = new BinarySearchTree<Integer, String>();

        tree.add(1, "ASD");
        tree.add(2, "ASD2");
    }
}