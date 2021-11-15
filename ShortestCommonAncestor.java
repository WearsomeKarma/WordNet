import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;

public class ShortestCommonAncestor {
    Digraph digraph;
    int distance;
    int ancestor;

    // constructor takes a rooted DAG as argument
    public ShortestCommonAncestor(Digraph G) {
        if (G == null)
            throw new IllegalArgumentException("Diagraph missing");
        digraph = new Digraph(G);
    }

    // length of shortest ancestral path between v and w
    public int length(int v, int w) {
        BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(digraph, w);
        findBoth(vPath, wPath);
        return distance;
    }

    // a shortest common ancestor of vertices v and w
    public int ancestor(int v, int w) {
        BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(digraph, v);
        BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(digraph, w);
        findBoth(vPath, wPath);
        return ancestor;
    }

    // length of shortest ancestral path of vertex subsets A and B
    public int lengthSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(digraph, subsetA);
        BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(digraph, subsetB);
        findBoth(vPath, wPath);
        return distance;
    }

    // a shortest common ancestor of vertex subsets A and B
    public int ancestorSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        BreadthFirstDirectedPaths vPath = new BreadthFirstDirectedPaths(digraph, subsetA);
        BreadthFirstDirectedPaths wPath = new BreadthFirstDirectedPaths(digraph, subsetB);
        findBoth(vPath, wPath);
        return ancestor;
    }


    private void findBoth(BreadthFirstDirectedPaths vPath, BreadthFirstDirectedPaths wPath) {
        int shortestDistance = Integer.MAX_VALUE;
        int tempAncestor = -1;
        for (int targetVertex = 0; targetVertex < digraph.V(); targetVertex++) {
            boolean hasVpath = vPath.hasPathTo(targetVertex);
            boolean hasWpath = wPath.hasPathTo(targetVertex);
            boolean vPathLengthSmaller = vPath.distTo(targetVertex) < shortestDistance;
            boolean wPathLengthSmaller = wPath.distTo(targetVertex) < shortestDistance;
            boolean allTrue = false;
            if (hasVpath && vPathLengthSmaller && hasWpath && wPathLengthSmaller)
                allTrue = true;
            if (allTrue) {
                int sum = vPath.distTo(targetVertex) + wPath.distTo(targetVertex);
                if (sum < shortestDistance) {
                    shortestDistance = vPath.distTo(targetVertex) + wPath.distTo(targetVertex);
                    tempAncestor = targetVertex;
                }
            }
        }
        ancestor = tempAncestor;
        distance = shortestDistance;
    }

    // unit testing (required)
    public static void main(String[] args) {
    }

}
