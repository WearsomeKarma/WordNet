Programming Assignment 6: WordNet

/* *****************************************************************************
 *  Please take a moment now to fill out the mid-semester survey:
 *  https://forms.gle/diTbj5r4o4xXbJm89
 *
 *  If you're working with a partner, please do this separately.
 *  
 *  Type your initials below to confirm that you've completed the survey.
 **************************************************************************** */



/* *****************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in synsets.txt. Why did you make this choice?
 **************************************************************************** */
We used:
ArrayList<String[]>  synset_Points  - This corresponds a set of nouns (synset) to a vertex index.
                                    * We made this choice since each vertex (synset) is associated
                                    * to a unique integer we can use an array based indexing to
                                    * find vertices in constant time. Additionally, since we will not
                                    * be inserting/removing synsets we only benefit from constant time
                                    * accessing and the occasional array resizing is negligble.
                                    * Additionally we do not know how many vertices to expect.
                                    * synset.txt does not give us the number of vertices before hand.
HashMap<String, Bag<Integer>> noun_To_Synset_Lookup_Table
                                    - This is a lookup symbol table that gives each vertex index where
                                    - a noun is found. In otherwords, each synset which a noun appears in.
                                    * We need a way to find the shortest common ancestor between
                                    * any two nouns, and since nouns can appear in multiple synsets
                                    * we must consider each synset which both comparing nouns appear
                                    * as sources for ShortestCommonAncestor. A HashMap helps us
                                    * find synsets in constant time.
Digraph wordNet                     - A directional graph that represents the WordNet.
                                    * Required to represent the WordNet.
ShortestCommonAncestor sca          - Our implementation of ShortestCommonAncestor which uses BFS. 


/* *****************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in hypernyms.txt. Why did you make this choice?
 **************************************************************************** */
ArrayList<Integer[]> hypernym_Edges - This corresponds a set of edges from a synset to adjacent vertices.
                                    * Same reasoning for using an ArrayList for the synsets. We don't know
                                    * how many hypernyms to expect for each synset so we use an ArrayList.
                                    * We don't worry about insertion/deletion so we only benefit from constant
                                    * time accessing.
HashMap<String, Bag<Integer>> noun_To_Synset_Lookup_Table
                                    - This is a lookup symbol table that gives each vertex index where
                                      a noun is found. In otherwords, each synset which a noun appears in.
                                      * Same reasoning as above.


/* *****************************************************************************
 *  Describe concisely the algorithm you use in the constructor of
 *  ShortestCommonAncestor to check if the digraph is a rooted DAG.
 *  What is the order of growth of the worst-case running times of
 *  your algorithm? Express your answer as a function of the
 *  number of vertices V and the number of edges E in the digraph.
 *  (Do not use other parameters.) Use Big Theta notation to simplify
 *  your answer.
 **************************************************************************** */

Description:



Order of growth of running time:


/* *****************************************************************************
 *  Describe concisely your algorithm to compute the shortest common ancestor
 *  in ShortestCommonAncestor. For each method, give the order of growth of
 *  the best- and worst-case running times. Express your answers as functions
 *  of the number of vertices V and the number of edges E in the digraph.
 *  (Do not use other parameters.) Use Big Theta notation to simplify your
 *  answers.
 *
 *  If you use hashing, assume the uniform hashing assumption so that put()
 *  and get() take constant time per operation.
 *
 *  Be careful! If you use a BreadthFirstDirectedPaths object, don't forget
 *  to count the time needed to initialize the marked[], edgeTo[], and
 *  distTo[] arrays.
 **************************************************************************** */

Description:


                                 running time
method                  best case            worst case
--------------------------------------------------------
length()

ancestor()

lengthSubset()

ancestorSubset()



/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */
 Isolated synsets are not considered.
 We don't check for proper rooting.

/* *****************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 **************************************************************************** */


/* *****************************************************************************
 *  Describe any serious problems you encountered.                    
 **************************************************************************** */


/* *****************************************************************************
 *  If you worked with a partner, assert below that you followed
 *  the protocol as described on the assignment page. Give one
 *  sentence explaining what each of you contributed.
 **************************************************************************** */




/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **************************************************************************** */
