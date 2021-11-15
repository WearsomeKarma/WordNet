import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;

public class WordNet {
    private ArrayList<String[]> synset_Points;
    private ArrayList<Integer[]> hypernym_Edges;
    private HashMap<String, Bag<Integer>> noun_To_Synset_Lookup_Table;
    private final Digraph wordNet;
    private ShortestCommonAncestor sca;


    // constructor takes the name of the two input files
    public WordNet(String synsets, String hypernyms) {
        if (synsets == null)
            throw new IllegalArgumentException("Synsets filename is null.");
        if (hypernyms == null)
            throw new IllegalArgumentException("Hypernyms filename is null.");

        synset_Points = new ArrayList<>();
        hypernym_Edges = new ArrayList<>();
        noun_To_Synset_Lookup_Table = new HashMap<>();

        read_Synsets(synsets);

        wordNet = new Digraph(synset_Points.size());
        sca = new ShortestCommonAncestor(wordNet);
        read_Hypernyms(hypernyms);
    }

    private void read_Synsets(String synsets) {
        In stream_Synset = new In(synsets);

        String s;
        while ((s = stream_Synset.readLine()) != null) {
            String[] csv_Values = s.split(",");

            if (csv_Values.length != 3)
                throw new IllegalArgumentException(
                        "The CSV line is invalid and does not have exactly 3 entries. VALUE: " + s);

            int synset_Index = Integer.parseInt(csv_Values[0]);

            if (synset_Index != synset_Points.size())
                throw new IllegalArgumentException(
                        "Synset ID is invalid. Was " + synset_Index + ", should be: "
                                + synset_Points.size());

            String[] nouns = csv_Values[1].split(" ");

            synset_Points.add(nouns);

            record_Nouns(nouns, synset_Index);
        }
    }

    private void record_Nouns(String[] nouns, int synset_Point) {
        for (String noun : nouns) {
            if (!noun_To_Synset_Lookup_Table.containsKey(noun)) {
                noun_To_Synset_Lookup_Table.put(noun, new Bag<>());
            }

            noun_To_Synset_Lookup_Table.get(noun).add(synset_Point);
        }
    }

    private void read_Hypernyms(String hypernyms) {
        In stream_Hypernym = new In(hypernyms);

        String s;
        while ((s = stream_Hypernym.readLine()) != null) {
            String[] csv_Values = s.split(",");

            if (csv_Values.length < 1)
                throw new IllegalArgumentException("Invalid hypernym entry. Entry was empty line.");

            int value = Integer.parseInt(csv_Values[0]);

            if (value != hypernym_Edges.size())
                throw new IllegalArgumentException(
                        "Illegal ID for hypernym edge. Was: " + value + ", expected: "
                                + hypernym_Edges.size());

            Integer[] edges = new Integer[csv_Values.length - 1];

            for (int i = 0; i < edges.length; i++) {
                edges[i] = Integer.parseInt(csv_Values[i + 1]);
                wordNet.addEdge(value, edges[i]);
            }

            hypernym_Edges.add(edges);
        }
    }// the set of all WordNet nouns

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
                                noun_To_Synset_Lookup_Table.get(noun2));
    }


    public static void main(String[] args)
    {
        if (args.length < 2)
        {
            StdOut.println("Two file names are required as arguments.");
            return;
        }
        StdOut.println("TEST: WordNet.ctor(synsets.txt, hypernyms.txt):");
        WordNet wordNet = new WordNet(args[0], args[1]);
        StdOut.println("TEST: WordNet.nouns()\nNOUNS: ");
        for(String noun : wordNet.nouns())
            StdOut.print(noun + " ");
        StdOut.println();
        if (args.length < 3)
        {
            StdOut.println("An additional noun argument is required for additional tests.");
            return;
        }
        StdOut.println("TEST: WordNet.isNoun(noun)");
        boolean isNoun = wordNet.isNoun(args[2]);
        StdOut.println("IS_NOUN(" + args[2] + "): " + isNoun);
        if (args.length < 4)
        {
            StdOut.println("An additional noun argument is required for additional tests.");
            return;
        }
        StdOut.println("TEST: WordNet.sca(noun1, noun2)");
        String sca = wordNet.sca(args[2], args[3]);
        StdOut.println("SCA(" + args[2] + ", " + args[3] + "): " + sca);
        StdOut.println("TEST: WordNet.distance(noun1, noun2)");
        int distance = wordNet.distance(args[2], args[3]);
        StdOut.println("DISTANCE(" + args[2] + ", " + args[3] + ")");
    }
}
