import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    //private List<Node> nodes;
    private HashMap<String, Node> nodes;
    private ArrayList<Player> players;
    public Graph(){
        nodes = new HashMap<String, Node>();
    }


    public int size(){
        int i = 0;
        for (String name : nodes.keySet()) {
            i++;
        }
        return i;
    }

    public void addNode(String name, String Description) {
        Node a =  new Node(name, Description);
        nodes.put(name, a);
    }

    public void addDirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
    }

    public void addUndirectedEdge(String name1, String name2) {
        Node n1 = getNode(name1);
        Node n2 = getNode(name2);
        n1.addNeighbor(n2);
        n2.addNeighbor(n1);
    }

    public Node getNode(String name) {

        Node a = nodes.get(name);

        return a;


    }
    public String getDescription(Node a){
        return a.getDescription();
    }
    public void setDescription(Node a, String Description) {
        a.setDescription(Description);
    }



    public class Node{
        public ArrayList<Item>items;
        public ArrayList<Player>Players = new ArrayList<Player>();
        public ArrayList<Creature>Creatures = new ArrayList<Creature>();
        private String name;
        // private ArrayList<Node> neighbors;
        private HashMap<String, Node> neighbors;
        private String description;

        private Node(String name ,String Description) {
            neighbors = new HashMap<String, Node>();
            this.name = name;
            this.description = Description;

        }
        public ArrayList<Player> getPlayers(){
            return Players;
        }
        public void addPlayer(Player p){
            Players.add(p);
        }
        public void removePlayer(Player p){
            Players.remove(p);
        }
        public void addCreature(Creature a){
            Creatures.add(a);
        }
        public ArrayList<Creature> getCreatures(){
       return Creatures;
        }
        public void removeCreature(Creature a){
            Creatures.remove(a);
        }

        public ArrayList<Item> getItems() {
            return items;
        }
        public String displayItems(){
            String b = "";
            for(Item a: items){
                b += a.getName();
            }
            return b;
        }
        public void additem(String name){
            Item a = new Item(name, "");
            items.add(a);
        }
        public void additem(Item item){
            items.add(item);
        }
        public Item removeItem(String name){
            for(Item a:items){
                if(a.getName().equals(name)){
                    items.remove(a);
                    return a;
                }
            }
            return null;
        }
        public boolean destroyItem(String name){
            for(Item a:items){
                if(a.getName().equals(name)){
                    items.remove(a);
                    return true;
                }
            }
            return false;
        }


        private String getDescription(){
            return description;
        }
        private void setDescription(String Description){
            description = Description;
        }
        private void addNeighbor(Node n){

            //add this node as a neighbor
            neighbors.put(getName(),n);
        }

        public Node go(String roomname) {
            Graph.Node nodeA = getNode(roomname);
            if (nodeA != null) {
                return nodeA;
            }
            return null;
        }

        public boolean hasPlayer(){
            if(players.equals(null)){
                return false;
            }
            return true;
        }

        public Player getPlayer(String name){

            if (players!=null){
                for(int i = 0; i < players.size();i++){
                    if(players.get(i).getName().equals(name)){
                        return players.get(i);
                    }
                }
            }
            return null;


        }

        public void look(){
            String b = "";
            for(Item a: items){
                b += a.getName();
            }
            System.out.println(b);
        }

        public boolean take (String name){
            for(Item a : items){
                if(a.getName().equals(name)){
                    items.remove(a);
                    System.out.println("You picked up"+name);
                    return true;
                }

            }
            return false;
        }
        public boolean drop (String name){
            Item b = removeItem(name);
            if(!b.equals(null)){
                items.add(b);

                System.out.println(name+"was dropped");
                return true;
            }else {
                System.out.println(name + "could not be dropped");
                return false;
            }
        }
        public void room(String name, String Description){
            Node a = new Node(name, Description);


        }
        public void quit(){
            System.exit(0);

        }
        public String getNeighborNames(){
            //Return a list of all neighbors
            String b = "";
            for (String name : neighbors.keySet()) {
                b+= " "+name;
            }
            return b;
        }
        public Node getRandomNeighbor(){
            ArrayList<Node> NeighboringRoom = new ArrayList<Node>(neighbors.values());
        int a = (int)(Math.random()*NeighboringRoom.size());
        Node b = NeighboringRoom.get(a);
       return b;
        }
        public ArrayList<String> getNeighborNamesList(){
            //Return a list of all neighbors
            ArrayList<String> b = new ArrayList<String>();
            for (String name : neighbors.keySet()) {
                b.add(name);
            }
            return b;
        }
        public ArrayList<Node> getNeighborList(){
            //Return a list of all neighbors
            ArrayList<Node> b = new ArrayList<Node>();
            for (String name : neighbors.keySet()) {
               Node a = getNode(name);
                b.add(a);
            }
            return b;
        }
        public String getNeighborNamesAndDescription(){
            //Return a list of all neighbors
            String b = "";
            for (String name : neighbors.keySet()) {
                b+= " "+name+"-"+getDescription();
            }
            return b;
        }

        public Node getNeighbor(String name) {
            Node n;
            return neighbors.get(name);
            // looks through the whole array and finds the node with that name and returns it
            //reutrn null otherwise


        }
        public String getName() {
            return name;
        }

    }

}



