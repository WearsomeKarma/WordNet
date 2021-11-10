import edu.princeton.cs.algs4.Bag;

import java.util.ArrayList;

public class WordNet {
    private ArrayList<Bag<String>> synset_Points;
    private ArrayList<Bag<Integer>> hypernym_Edges;
    private HashMap<String, Bag<Integer>> noun_To_Synset_Lookup_Table;

    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms)
    {
        
    }
        
    // the set of all WordNet nouns
    public Iterable<String> nouns()
    {
        
    }
        
    // is the word a WordNet noun?
    public boolean isNoun(String word)
    {
        
    }
        
    // a synset (second field of synsets.txt) that is a shortest common ancestor
    // of noun1 and noun2 (defined below)
    public String sca(String noun1, String noun2)
    {

    }

    // distance between noun1 and noun2 (defined below)
    public int distance(String noun1, String noun2)
    {
        
    }
    
    public static void main(String[] args) 
    {

    }
}
