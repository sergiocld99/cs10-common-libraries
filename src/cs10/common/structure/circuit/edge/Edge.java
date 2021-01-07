package cs10.common.structure.circuit.edge;

import cs10.common.Countable;
import cs10.common.structure.circuit.Node;

public abstract class Edge<T extends Blocker, U extends Countable> {
    private final T data;
    private final Node<U,T> next;

    public Edge(T data, Node<U,T> next) {
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node<U,T> getNext() {
        return next;
    }

    @Override
    public String toString() {
        return "Edge with " + data + " to " + next;
    }
}
