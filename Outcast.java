import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Outcast {
    WordNet wordnet;

    // constructor takes a WordNet object
    public Outcast(WordNet wordnet) {
        this.wordnet = wordnet;
    }

    // given an array of WordNet nouns, return an outcast
    public String outcast(String[] nouns) {
        if (nouns.length <= 0)
            throw new IllegalArgumentException("array empty");
        if (nouns.length == 1)
            return nouns[0];
        String outcast = "";
        int outcastDis = distanceSummation(nouns[0], nouns);
        for (String s : nouns) {
            int curSummation = distanceSummation(s, nouns);
            if (curSummation > outcastDis) {
                outcastDis = curSummation;
                outcast = s;
            }
        }
        return outcast;
    }

    int distanceSummation(String noun, String[] nouns) {
        int summation = 0;
        for (String s : nouns) {
            summation += wordnet.distance(noun, s);
        }
        return summation;
    }

    // test client (see below)
    public static void main(String[] args) {
        WordNet wordnet = new WordNet(args[0], args[1]);
        Outcast outcast = new Outcast(wordnet);
        In in = new In(args[0]);
        String[] nouns = in.readAllStrings();
        StdOut.println(args[0] + "'s: " + outcast.outcast(nouns));
    }

}
