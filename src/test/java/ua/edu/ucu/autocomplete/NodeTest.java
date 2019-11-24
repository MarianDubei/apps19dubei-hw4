package ua.edu.ucu.autocomplete;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.tries.Node;

public class NodeTest {

    private Node node;

    @Before
    public void init() {
        node = new Node('a');
        node.setNext('b', new Node('b'));
    }

    @Test
    public void testValues() {
        node.setValue('c');
        assertEquals('c', node.getValue());
    }

    @Test
    public void testNext() {
        assertEquals('b', node.getNext('b').getValue());
        assertEquals(null, node.getNext('d'));
    }

    @Test
    public void testFlags() {
        assertEquals(false, node.getFlag());
        node.setFlag(true);
        assertEquals(true, node.getFlag());
    }
}
