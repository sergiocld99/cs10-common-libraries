package cs10.common.structure.circuit.edge;

import cs10.common.Countable;
import cs10.common.structure.circuit.Node;

public class ForwardEdge<T extends Blocker, U extends Countable> extends Edge<T,U> {
    private String label;

    public ForwardEdge(T data, Node<U, T> next) {
        super(data, next);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Forward " + super.toString();
    }
}
