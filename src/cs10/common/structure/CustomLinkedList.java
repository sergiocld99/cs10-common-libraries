package cs10.common.structure;

import java.util.LinkedList;

public class CustomLinkedList<E> extends LinkedList<E> {

    public E getFromLast(int offset){
        if (offset == 1) return getLast();
        else return get(size()-offset);
    }
}
