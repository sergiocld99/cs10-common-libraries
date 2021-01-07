package cs10.common.structure.circuit;

import cs10.common.Countable;
import cs10.common.structure.circuit.edge.BackwardEdge;
import cs10.common.structure.circuit.edge.Blocker;
import cs10.common.structure.circuit.edge.Edge;
import cs10.common.structure.circuit.edge.ForwardEdge;

import java.util.*;

public class Circuit<T extends Countable, U extends Blocker> {
    private final ArrayList<Node<T,U>> nodes;
    private final int beginIndex;

    public Circuit(int beginIndex, int endIndex){
        nodes = new ArrayList<>(endIndex-beginIndex+1);
        this.beginIndex = beginIndex;
    }

    protected void resetVisited(){
        for (Node<T,U> n : nodes)
            n.setVisited(false);
    }

    public void addNode(T data){
        nodes.add(data.getIndex(), new Node<>(data));
    }

    public void connect(int node1, int node2, U edgeElement, boolean doubleConnected){
        ForwardEdge<U,T> forward = new ForwardEdge<>(edgeElement, getNode(node2));
        getNode(node1).addEdge(forward);

        if (doubleConnected){
            BackwardEdge<U,T> backwards = new BackwardEdge<>(edgeElement, getNode(node1));
            getNode(node2).addEdge(backwards);
        }
    }

    public ArrayList<Node<T, U>> getNodes() {
        return nodes;
    }

    public List<Node<T,U>> findRoad(int begin, int end, boolean forward, boolean crossBlocked){
        LinkedList<Node<T,U>> result = new LinkedList<>();
        Node<T,U> endNode = getNode(end);
        boolean found = findRoad(getNode(begin), endNode, forward, crossBlocked, result);
        if (!found) throw new RuntimeException(endNode + " not found");
        resetVisited();
        return result;
    }

    private boolean findRoad(Node<T,U> actual, Node<T,U> end, boolean forward,
                          boolean crossBlocked, List<Node<T,U>> result){

        actual.setVisited(true);
        result.add(actual);
        if (actual.equals(end)) return true;

        Set<Edge<U,T>> edges = actual.getEdges(forward);

        for (Edge<U,T> e : edges){
            if (crossBlocked || !e.getData().block()){
                Node<T,U> next = e.getNext();
                if (next.isUnvisited()) {
                    List<Node<T,U>> aux = new LinkedList<>();
                    boolean found = findRoad(next, end, forward, crossBlocked, aux);
                    if (found){
                        result.addAll(aux);
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public Set<Node<T,U>> explore(int begin, boolean crossBlocked){
        Set<Node<T,U>> result = new HashSet<>();
        explore(getNode(begin), crossBlocked, result);
        resetVisited();
        return result;
    }

    private void explore(Node<T,U> actual, boolean crossBlocked, Set<Node<T,U>> result){
        Set<Edge<U, T>> edges = actual.getAllEdges();
        actual.setVisited(true);
        result.add(actual);

        for (Edge<U,T> e : edges){
            if (e.getData().block() == crossBlocked && e.getNext().isUnvisited())
                explore(e.getNext(), crossBlocked, result);
        }
    }

    public Node<T,U> getNode(int index){
        return nodes.get(index-beginIndex);
    }

    public Node<T,U> getNode(T data){
        return nodes.get(data.getIndex());
    }
}
