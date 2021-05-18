package misc.list;

import java.util.ArrayList;

import java.util.*;

public class ListComparison {

  public static void main(String[] args) {
    List<String> solrCandidates = new ArrayList<>();
    solrCandidates.add("1 Chair");
    solrCandidates.add("2 Table Chair");
    solrCandidates.add("3 Sofa Chair");
    solrCandidates.add("4 Recline Chair");
    solrCandidates.add("5 Table Chair");
    solrCandidates.add("6 Chair top");
    solrCandidates.add("7 Chair bottom");
    solrCandidates.add("8 Chair right");
    solrCandidates.add("9 Chair left");

    System.out.println("Solr Candidates: "+solrCandidates);
    List<String> rerankerCandidates = new ArrayList<>();
    rerankerCandidates.addAll(solrCandidates);

    System.out.println("Reranker Candidates: "+rerankerCandidates);

    Collections.shuffle(rerankerCandidates);
    rerankerCandidates.add("Test 1 , Test 2");

    System.out.println("Reranker Candidates After Shuffling: "+rerankerCandidates);

    rerankerCandidates.removeAll(solrCandidates);

    System.out.println("Reranker Candidates after removing all Solr Candidates"+ rerankerCandidates);
  }


}
