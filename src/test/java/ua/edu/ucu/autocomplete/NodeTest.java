package ua.edu.ucu.autocomplete;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.tries.Node;

public class NodeTest {

    private Node node;

    @Before
    public void init() {
        node = new Node('a', null);
        node.setNext('b', new Node('b', node));
    }

    @Test
    public void testFlags() {
        assertEquals(false, node.getFlag());
        node.setFlag(true);
        assertEquals(true, node.getFlag());
    }
}
