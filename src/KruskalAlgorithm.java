import java.util.Arrays;
import java.util.Scanner;

public class KruskalAlgorithm {

    int vert;
    int edg;
    Edge[] edgArray;

    KruskalAlgorithm(int vertices, int edges) {
        this.vert = vertices;
        this.edg = edges;
        edgArray = new Edge[this.edg];
        for (int i = 0; i < edges; ++i) {
            edgArray[i] = new Edge();
        }
    }

    void applyKruskal() {
        Edge[] finalResult = new Edge[vert];
        int newEdge = 0;
        int index = 0;
        for (index = 0; index < vert; ++index) {
            finalResult[index] = new Edge();
        }

        Arrays.sort(edgArray);

        Subset[] subsetArray = new Subset[vert];

        for (index = 0; index < vert; ++index) {
            subsetArray[index] = new Subset();
        }

        for (int vertex = 0; vertex < vert; ++vertex) {
            subsetArray[vertex].parent = vertex;
            subsetArray[vertex].value = 0;
        }
        index = 0;

        while (newEdge < vert - 1) {
            Edge nextEdge = new Edge();
            nextEdge = edgArray[index++];

            int nextSource = findSetOfElement(subsetArray, nextEdge.src);
            int nextDestination = findSetOfElement(subsetArray, nextEdge.dest);

            if (nextSource != nextDestination) {
                finalResult[newEdge++] = nextEdge;
                performUnion(subsetArray, nextSource, nextDestination);
            }
        }
        for (index = 0; index < newEdge; ++index) {
            System.out.println("Source point - " + finalResult[index].src + " - Destination Point " + finalResult[index].dest + " - Weight " + finalResult[index].weight);
        }
    }

    int findSetOfElement(Subset[] subsetArray, int i) {
        if (subsetArray[i].parent != i){
            subsetArray[i].parent = findSetOfElement(subsetArray, subsetArray[i].parent);
        }
        return subsetArray[i].parent;
    }

    void performUnion(Subset[] subsetArray, int sourceRoot, int destinationRoot) {

        int nextSourceRoot = findSetOfElement(subsetArray, sourceRoot);
        int nextDestinationRoot = findSetOfElement(subsetArray, destinationRoot);

        if (subsetArray[nextSourceRoot].value < subsetArray[nextDestinationRoot].value) {
            subsetArray[nextSourceRoot].parent = nextDestinationRoot;
        } else if (subsetArray[nextSourceRoot].value > subsetArray[nextDestinationRoot].value) {
            subsetArray[nextDestinationRoot].parent = nextSourceRoot;
        } else {
            subsetArray[nextDestinationRoot].parent = nextSourceRoot;
            subsetArray[nextSourceRoot].value++;
        }
    }


    public static void main(String[] args) {
        int v, e;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter total number of vertices");
        v = scanner.nextInt();
        System.out.println("Enter total number of edges");
        e = scanner.nextInt();
        KruskalAlgorithm kruskalAlgorithm = new KruskalAlgorithm(v, e);
        for (int i = 0; i < e; i++) {
            System.out.println("Enter source value for edge[" + i + "]");
            kruskalAlgorithm.edgArray[i].src = scanner.nextInt();

            System.out.println("Enter destination value for edge[" + i + "]");
            kruskalAlgorithm.edgArray[i].dest = scanner.nextInt();

            System.out.println("Enter weight for edge[" + i + "]");
            kruskalAlgorithm.edgArray[i].weight = scanner.nextInt();
        }
        kruskalAlgorithm.applyKruskal();
    }
}
