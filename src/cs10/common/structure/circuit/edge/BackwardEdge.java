package cs10.common.structure.circuit.edge;

import cs10.common.Countable;
import cs10.common.structure.circuit.Node;

public class BackwardEdge<T extends Blocker, U extends Countable> extends Edge<T,U> {

    public BackwardEdge(T data, Node<U, T> next) {
        super(data, next);
    }

    @Override
    public String toString() {
        return "Backward " + super.toString();
    }
}
