package relran;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OurLinkedListTest {
    OurLinkedList<Integer> integer = new OurLinkedList<>();
    Integer [] array = {2,4,6,-6,10};

    @BeforeEach
    void setUp() {
        for(int a : array){
            integer.add(a);
        }
    }

    @Test
    void testGet() {
        assertEquals(4,integer.get(1));
    }

    @Test
    void testAdd() {
        assertEquals(5,integer.size());
    }
}