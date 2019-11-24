package ua.edu.ucu.autocomplete;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.queue.immutable.ImmutableLinkedList;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList list1;
    private ImmutableLinkedList list2;
    private ImmutableLinkedList list3;

    @Before
    public void setUp() {
        list1 = new ImmutableLinkedList();
        list2 = new ImmutableLinkedList(new Object[]{1, 3, 5, 7});
        list3 = new ImmutableLinkedList(new Object[]{7, 8});
    }

    @Test
    public void testAdd() {
        assertArrayEquals(new Object[]{1, 3, 5, 7, 9}, list2.add(9).toArray());
    }

    @Test
    public void testAddToEmpty() {
        assertArrayEquals(new Object[]{1}, list1.add(1).toArray());
    }

    @Test
    public void testAddWithIndex() {
        assertArrayEquals(new Object[]{1, 2, 3, 5, 7}, list2.add(1, 2).toArray());
    }

    @Test
    public void testAddAll() {
        assertArrayEquals(new Object[]{3, 6}, list1.addAll(new Object[]{3, 6}).toArray());
    }

    @Test
    public void testAddAllWithIndex() {
        assertArrayEquals(new Object[]{1, 3, 5, 4, 5, 7}, list2.addAll(3, new Object[]{4, 5}).toArray());
    }

    @Test
    public void testGet() {
        assertEquals(5, list2.get(2));
    }

    @Test
    public void testRemove() {
        assertArrayEquals(new Object[]{1, 3, 7}, list2.remove(2).toArray());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveFromEmpty() {
        list1.remove(0);
    }

    @Test
    public void testRemoveLastElement() {
        assertArrayEquals(new Object[]{}, list3.remove(1).remove(0).toArray());
    }

    @Test
    public void testSet() {
        assertArrayEquals(new Object[]{1, 3, 3, 7}, list2.set(2, 3).toArray());
    }

    @Test
    public void testSize() {
        assertEquals(4, list2.size());
    }

    @Test
    public void testClear() {
        assertArrayEquals(new Object[]{}, list2.clear().toArray());
    }

    @Test
    public void testIndexOf() {
        assertEquals(1, list2.indexOf(3));
    }

    @Test
    public void testIndexOfNotFound() {
        assertEquals(-1, list2.indexOf(10));
    }

    @Test
    public void testIsEmpty() {
        assertEquals(true, list1.isEmpty());
    }

    @Test
    public void testToArray() {
        assertArrayEquals(new Object[]{1, 3, 5, 7}, list2.toArray());
    }

    @Test
    public void testToString() {
        assertEquals("1, 3, 5, 7", list2.toString());
    }

    @Test
    public void testToStringEmpty() {
        assertEquals("", list1.toString());
    }

    @Test
    public void testAddFirst() {
        assertArrayEquals(new Object[]{6, 7, 8}, list3.addFirst(6).toArray());
    }

    @Test
    public void testAddLast() {
        assertArrayEquals(new Object[]{7, 8, 9}, list3.addLast(9).toArray());
    }

    @Test
    public void testGetFirst() {
        assertEquals(7, list3.getFirst());
    }

    @Test
    public void testGetLast() {
        assertEquals(8, list3.getLast());
    }

    @Test
    public void testRemveFirst() {
        assertArrayEquals(new Object[]{8}, list3.removeFirst().toArray());
    }

    @Test
    public void testRemoveLast() {
        assertArrayEquals(new Object[]{7}, list3.removeLast().toArray());
    }
}
