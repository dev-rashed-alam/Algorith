import java.util.Scanner;

public class KruskalAlgorithm {

    int vert, edg;
    Edge edgArray[];

    KruskalAlgorithm(int vertices, int edges) {
        this.vert = vertices;
        this.edg = edges;
        edgArray = new Edge[this.edg];
        for (int i = 0; i < edges; i++) {
            edgArray[i] = new Edge();
            System.out.println(i);
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
    }
}
