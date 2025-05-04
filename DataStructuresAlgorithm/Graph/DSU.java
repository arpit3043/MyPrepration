package Graph;

// Java program for Union by Size with Path
// Compression
import java.util.Arrays;

class UnionFind {
    private int[] Parent;
    private int[] Size;
    public UnionFind(int n) {
        // Initialize Parent array
        Parent = new int[n];
        for (int i = 0; i < n; i++) {
            Parent[i] = i;
        }

        // Initialize Size array with 1s
        Size = new int[n];
        Arrays.fill(Size, 1);
    }

    // Function to find the representative (or the root
    // node) for the set that includes i
    public int find(int i) {
        int root = Parent[i];
        if (Parent[root] != root) {
            return Parent[i] = find(root);
        }
        return root;
    }

    // Unites the set that includes i and the set that
    // includes j by size
    public void unionBySize(int i, int j) {
        // Find the representatives (or the root nodes) for
        // the set that includes i
        int irep = find(i);
        // And do the same for the set that includes j
        int jrep = find(j);
        // Elements are in the same set, no need to unite
        // anything.
        if (irep == jrep) {
            return;
        }
        // Get the size of i’s tree
        int isize = Size[irep];
        // Get the size of j’s tree
        int jsize = Size[jrep];
        // If i’s size is less than j’s size
        if (isize < jsize) {
            // Then move i under j
            Parent[irep] = jrep;

            // Increment j's size by i's size
            Size[jrep] += Size[irep];
        }
        // Else if j’s size is less than i’s size
        else {
            // Then move j under i
            Parent[jrep] = irep;

            // Increment i's size by j's size
            Size[irep] += Size[jrep];
        }
    }
}

public class DSU {
    public static void main(String[] args){
        // Example usage
        int n = 5;
        UnionFind unionFind = new UnionFind(n);

        // Perform union operations
        unionFind.unionBySize(0, 1);
        unionFind.unionBySize(2, 3);
        unionFind.unionBySize(0, 4);

        // Print the representative of each element after
        // unions
        for (int i = 0; i < n; i++) {
            System.out.println("Element " + i
                               + ": Representative = "
                               + unionFind.find(i));
        }
    }
}
