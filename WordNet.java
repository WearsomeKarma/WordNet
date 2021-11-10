import edu.princeton.cs.algs4.Bag;

import java.util.ArrayList;
import java.util.HashMap;

public class WordNet {
    private ArrayList<Bag<String>> synset_Points;
    private ArrayList<Bag<Integer>> hypernym_Edges;
    private HashMap<String, Bag<Integer>> noun_To_Synset_Lookup_Table;

    ShortestCommonAncestor sca;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        sca = new ShortestCommonAncestor(wordNet);
    }

    // the set of all WordNet nouns
    public Iterable<String> nouns() {
        return noun_To_Synset_Lookup_Table.keySet();
    }

    // is the word a WordNet noun?
    public boolean isNoun(String word) {
        if (word == null)
            throw new IllegalArgumentException("word is null");
        return noun_To_Synset_Lookup_Table.containsKey(word);
    }

    // a synset (second field of synsets.txt) that is a shortest common ancestor
    // of noun1 and noun2 (defined below)
    public String sca(String noun1, String noun2) {
        int n = sca.ancestorSubset(noun_To_Synset_Lookup_Table.get(noun1),
                                   noun_To_Synset_Lookup_Table.get(noun2));
        return synset_Points.get(n).toString();
    }

    // distance between noun1 and noun2 (defined below)
    public int distance(String noun1, String noun2) {
        return sca.lengthSubset(noun_To_Synset_Lookup_Table.get(noun1),
                                noun_To_Synset_Lookup_Table.get(noun2);
    }

    public static void main(String[] args) {

    }
}
