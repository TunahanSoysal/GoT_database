import java.util.*;

public class WeightedGraph {
    private final Map<String, Node> nodes = new HashMap<>();
    private final Map<Node, List<Edge>> adjacencyList = new HashMap<>();

    private static class Node {
        private final String label;

        public Node(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public static class Edge {
        private final Node from;
        private final Node to;
        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " -> " + to+" weight:"+weight;
        }
    }

    public void addNode(String label) {
        Node node = new Node(label);

        nodes.putIfAbsent(label,node);
        adjacencyList.putIfAbsent(node,new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight) {
        Node fromNode = nodes.get(from);
        if (fromNode == null) throw new IllegalArgumentException();

        Node toNode = nodes.get(to);
        if (toNode == null) throw new IllegalArgumentException();

        adjacencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
        adjacencyList.get(toNode).add(new Edge(toNode, fromNode, weight));
    }

    public void print() {
        for (Node node : nodes.values()) {
            System.out.println(node + ": " + adjacencyList.get(node));
        }
    }

    public  void printClosestCharacters(String search,int tresHold1){
        Node searchNode = nodes.get(search);
        for (Node src: nodes.values()){
            for (int i = 0;i<adjacencyList.get(src).size();i++){
                if (adjacencyList.get(src).get(i).from.equals(searchNode) && adjacencyList.get(src).get(i).weight>tresHold1){
                    System.out.println(adjacencyList.get(src).get(i));
                }
            }
        }
    }

    public  void printFarthestCharacters(String search,int tresHold2){
        Node searchNode = nodes.get(search);
        for (Node src: nodes.values()){
            for (int i = 0;i<adjacencyList.get(src).size();i++){
                if (adjacencyList.get(src).get(i).from.equals(searchNode) && adjacencyList.get(src).get(i).weight<tresHold2){
                    System.out.println(adjacencyList.get(src).get(i));
                }
            }
        }
    }

    public boolean isConnected(String char1,String char2){
        Node firstChar = nodes.get(char1);
        Node secondChar = nodes.get(char2);
        for (Node src: nodes.values()){
            for (int i = 0;i<adjacencyList.get(src).size();i++){
                if (adjacencyList.get(src).get(i).from==firstChar&&adjacencyList.get(src).get(i).to==secondChar){
                    return true;
                }
            }
        }
        return false;
    }

    public void delete(String char1,String char2){
        Node firstChar = nodes.get(char1);
        Node secondChar = nodes.get(char2);
        for (Node src: nodes.values()){
            for (int i = 0;i<adjacencyList.get(src).size();i++){
                if (adjacencyList.get(src).get(i).from==firstChar&&adjacencyList.get(src).get(i).to==secondChar){
                    adjacencyList.get(src).remove(i);

                }
            }
        }
    }

    public void change(String char1,String char2,int weight){
        Node firstChar = nodes.get(char1);
        Node secondChar = nodes.get(char2);
        for (Node src: nodes.values()){
            for (int i = 0;i<adjacencyList.get(src).size();i++){
                if (adjacencyList.get(src).get(i).from==firstChar&&adjacencyList.get(src).get(i).to==secondChar){
                    adjacencyList.get(src).get(i).weight=weight;
                }
            }
        }
    }
    public void searchByWeight(int weight){
        for (Node src: nodes.values()){
            for (int i = 0;i<adjacencyList.get(src).size();i++){
                if (adjacencyList.get(src).get(i).weight==weight){
                    System.out.println(adjacencyList.get(src).get(i));
                }
            }
        }
    }
    public void printAllFroms(String char1){
        Node searchNode = nodes.get(char1);
        for (Node src: nodes.values()){
            for (int i = 0;i<adjacencyList.get(src).size();i++){
                if (adjacencyList.get(src).get(i).to.equals(searchNode)){
                    System.out.println(adjacencyList.get(src).get(i).from.label);
                }
            }
        }
    }

    
}