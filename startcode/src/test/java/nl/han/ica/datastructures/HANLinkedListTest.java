package nl.han.ica.datastructures;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HANLinkedListTest {

    private HANLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new HANLinkedList<>();
    }

    @Test
    void addFirst() {
        list.addFirst(10);
        assertEquals(1, list.getSize());
        assertEquals(10, list.getFirst());

        list.addFirst(20);
        assertEquals(2, list.getSize());
        assertEquals(20, list.getFirst());
        assertEquals(10, list.get(1));
    }

    @Test
    void clear() {
        list.addFirst(10);
        list.addFirst(20);
        assertEquals(2, list.getSize());

        list.clear();
        assertEquals(0, list.getSize());
        assertNull(list.getFirst());
        assertNull(list.get(0));
    }

    @Test
    void insert() {
        // insert in lege lijst op index 0
        list.insert(0, 10);
        assertEquals(1, list.getSize());
        assertEquals(10, list.get(0));

        // insert aan het einde
        list.insert(1, 30);
        assertEquals(30, list.get(1));

        // Test insert in het midden
        list.insert(1, 20);
        assertEquals(3, list.getSize());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));


    }

    @Test
    void delete() {
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10); // [10, 20, 30]

        // Test verwijderen uit het midden
        list.delete(1); // Verwijdert 20 -> [10, 30]
        assertEquals(2, list.getSize());
        assertEquals(30, list.get(1));

        // Test verwijderen aan het begin (pos == 0)
        list.delete(0);
        assertEquals(1, list.getSize());
        assertEquals(30, list.getFirst());

    }

    @Test
    void get() {
        assertNull(list.get(0)); // Lege lijst geeft null

        list.addFirst(10);
        assertEquals(10, list.get(0));
        assertNull(list.get(1)); // Out of bounds geeft null
        assertNull(list.get(-1));
    }

    @Test
    void removeFirst() {
        // removeFirst op lege lijst mag niet crashen
        assertDoesNotThrow(() -> list.removeFirst());

        list.addFirst(20);
        list.addFirst(10); // [10, 20]

        list.removeFirst(); // Verwijdert 10 -> [20]
        assertEquals(1, list.getSize());
        assertEquals(20, list.getFirst());

        list.removeFirst(); // Verwijdert 20 -> []
        assertEquals(0, list.getSize());
        assertNull(list.getFirst());
    }

    @Test
    void getFirst() {
        assertNull(list.getFirst()); // Lege lijst geeft null

        list.addFirst(42);
        assertEquals(42, list.getFirst());
    }

    @Test
    void getSize() {
        assertEquals(0, list.getSize());

        list.addFirst(1);
        assertEquals(1, list.getSize());

        list.addFirst(2);
        assertEquals(2, list.getSize());

        list.removeFirst();
        assertEquals(1, list.getSize());
    }
}
