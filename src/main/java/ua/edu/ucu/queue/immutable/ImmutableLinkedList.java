package ua.edu.ucu.queue.immutable;


public final class ImmutableLinkedList implements ImmutableList {
    private Node listHead;

    public ImmutableLinkedList() {
        listHead = null;
    }

    public ImmutableLinkedList(Object[] elements) {
        if (elements.length != 0) {
            setHead(new Node(elements[0]));
            Node node = getHead();
            for (int i = 1; i < elements.length; i++) {
                node.setNext(new Node(elements[i]));
                node = node.getNext();
            }
        } else { listHead = null; }
    }

    private void setHead(Node node) {
        listHead = node;
    }

    private Node getHead() {
        return listHead;
    }

    private Node copyNode(Node node) {
        return new Node(node.getValue());
    }

    private Node getNode(int index) {
        Node node = getHead();
        int cnt = 0;
        while (cnt < index) {
            node = node.getNext();
            cnt++;
        }
        return node;
    }

    private void checkIndexBounds(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndexBoundsAuxiliary(int index) {
        if (isEmpty() || index == size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void isNull(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }
    }

    private ImmutableLinkedList listCopy(int flag,
                                         int index,
                                         Object[] c,
                                         Object e) {
        checkIndexBounds(index);
        ImmutableLinkedList newLinkedList = new ImmutableLinkedList();
        Node originNode = getHead();
        newLinkedList.setHead(new Node(null));
        Node newNode = newLinkedList.getHead();

        // copying all elements before the index
        int cnt = 0;
        while (cnt < index) {
            newNode.setNext(copyNode(originNode));
            newNode = newNode.getNext();
            originNode = originNode.getNext();
            cnt++;
        }

        // manipulation with elements on index according to the flag
        if (flag == -1) { // remove
            originNode = originNode.getNext();
        } else if (flag == 0) { // set
            newNode.setNext(new Node(e));
            newNode = newNode.getNext();
            originNode = originNode.getNext();
        } else if (flag == 1) { // add
            for (Object element : c) {
                newNode.setNext(new Node(element));
                newNode = newNode.getNext();
            }
        }

        // copying all elements after the index
        while (originNode != null) {
            newNode.setNext(copyNode(originNode));
            newNode = newNode.getNext();
            originNode = originNode.getNext();
        }
        // removing null head
        newLinkedList.setHead(newLinkedList.getHead().getNext());
        return newLinkedList;
    }

    @Override
    public ImmutableLinkedList add(Object e) {
        return add(size(), e);
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        isNull(c);
        return listCopy(1, index, c, null);
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        checkIndexBoundsAuxiliary(index);
        return listCopy(-1, index, null, null);
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        isNull(e);
        return listCopy(0, index, null, e);
    }

    @Override
    public Object get(int index) {
        checkIndexBounds(index);
        checkIndexBoundsAuxiliary(index);
        return getNode(index).getValue();
    }

    @Override
    public int indexOf(Object e) {
        isNull(e);
        Node node = getHead();
        int index = 0;
        while (node != null) {
            if (node.getValue().equals(e)) {
                return index;
            } else {
                index++;
                node = node.getNext();
            }
        }
        return -1;
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int cnt = 0;
        Node node = getHead();
        while (node != null) {
            node = node.getNext();
            cnt++;
        }
        return cnt;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        return listHead == null;
    }

    @Override
    public Object[] toArray() {
        Object[] newList = new Object[size()];
        Node node = listHead;
        int index = 0;
        while (node != null) {
            newList[index] = node.getValue();
            node = node.getNext();
            index++;
        }
        return newList;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(size() - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(size() - 1);
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }
        StringBuilder buf = new StringBuilder();
        Node node = listHead;
        while (node.getNext() != null) {
            buf.append(node.getValue().toString()).append(", ");
            node = node.getNext();
        }
        buf.append(node.getValue().toString());
        return buf.toString();
    }
}
