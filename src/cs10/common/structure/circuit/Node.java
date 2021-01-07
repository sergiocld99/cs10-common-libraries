package cs10.common.structure.circuit;

import cs10.common.Countable;
import cs10.common.structure.circuit.edge.BackwardEdge;
import cs10.common.structure.circuit.edge.Blocker;
import cs10.common.structure.circuit.edge.Edge;
import cs10.common.structure.circuit.edge.ForwardEdge;

import java.util.HashSet;
import java.util.Set;

public class Node<T extends Countable, U extends Blocker> {
    private final T data;
    private final Set<ForwardEdge<U,T>> forwardEdges = new HashSet<>();
    private final Set<BackwardEdge<U,T>> backwardEdges = new HashSet<>();
    private boolean visited;

    public Node(T data) {
        this.data = data;
    }

    public void addEdge(ForwardEdge<U,T> edge){
        forwardEdges.add(edge);
    }

    public void addEdge(BackwardEdge<U,T> edge){
        backwardEdges.add(edge);
    }

    public T getData() {
        return data;
    }

    public Set<BackwardEdge<U, T>> getBackwardEdges() {
        return backwardEdges;
    }

    public Set<ForwardEdge<U, T>> getForwardEdges() {
        return forwardEdges;
    }

    public Set<Edge<U,T>> getEdges(boolean forward){
        if (forward) return new HashSet<>(forwardEdges);
        else return new HashSet<>(backwardEdges);
    }

    public Set<Edge<U,T>> getAllEdges(){
        Set<Edge<U,T>> result = new HashSet<>(forwardEdges);
        result.addAll(backwardEdges);
        return result;
    }

    public ForwardEdge<U,T> getForwardEdgeTo(Node<T,U> node){
        for (ForwardEdge<U,T> e : forwardEdges){
            if (e.getNext().equals(node)) return e;
        }

        throw new IllegalArgumentException(node + " not found");
    }

    public ForwardEdge<U,T> getNotLabeledForwardEdge(){
        for (ForwardEdge<U,T> e : forwardEdges){
            if (e.getLabel() == null) return e;
        }

        return null;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isUnvisited() {
        return !visited;
    }

    @Override
    public String toString() {
        return "Node " + data;
    }
}
