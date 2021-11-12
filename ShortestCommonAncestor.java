import edu.princeton.cs.algs4.Digraph;

public class ShortestCommonAncestor {
    Diagraph diagraph;
    int distance;
    int ancestor;
    // constructor takes a rooted DAG as argument
    public ShortestCommonAncestor(Digraph G) {
        if(G == null)
            throw new IllegalArgumentException("Diagraph missing");
        diagraph = new Diagraph(G);
    }

    // length of shortest ancestral path between v and w
    public int length(int v, int w) {
        findBoth(v, w);
        return distance;
    }

    // a shortest common ancestor of vertices v and w
    public int ancestor(int v, int w) {
        findBoth(v,w);
        return ancestor;
    }

    // length of shortest ancestral path of vertex subsets A and B
    public int lengthSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        findBoth(subsetA, subsetB);
        return distance;
    }

    // a shortest common ancestor of vertex subsets A and B
    public int ancestorSubset(Iterable<Integer> subsetA, Iterable<Integer> subsetB) {
        findBoth(subsetA, subsetB);
        return ancestor;
    }

    private void findBoth(int v, int w)
    {
        if(v == null || w == null)
            throw new IllegalArgumentException("v/w is missing");
        BreathFirstDirectedPaths vPath = new BreathFirstDirectedPaths(diagraph, v);
        BreathFirstDirectedPaths wPath = new BreathFirstDirectedPaths(diagraph, w);
        int shortVDis = Integer.MAX_VALUE;
        int shortWDis = Integer.MAX_VALUE;
        int tempAncestor = -1;
        for(int targetVertex = 0; targetVertex < diagraph.V(); targetVertex++)
        {
            if(vPath.hasPathTo(targetVertex) && vPath.distTo(targetVertex) < shortVDis
                    && wPath.hasPathTo(targetVertex) && wPath.distTo(targetVertex) < shortWDis)
            {
                shortVDis = vPath.distTo(targetVertex);
                shortWDis = wPath.distTo(targetVertex);
                tempAncestor = targetVertex;
            }
        }
        ancestor = tempAncestor;
        distance = shortVDis + shortWDis;
    }

    // unit testing (required)
    public static void main(String[] args) {
    }

}
