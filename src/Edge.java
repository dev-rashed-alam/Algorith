public class Edge implements Comparable<Edge> {

    int src, dest, weight;

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}