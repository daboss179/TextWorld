import java.util.ArrayList;

public class Wumpus extends Creature{

    public Wumpus(Graph.Node room,String n,String d){
        super(room,n,d);
    }
    public void move(Creature creature){
     ArrayList<Graph.Node> a = creature.CurrentRoom.getNeighborList();
     for(int i = 0; i < a.size(); i++){
        if(a.get(i).hasPlayer()){
            creature.setCurrentRoom(a.get(i));
        }
     }
    }
    public void act(){

    }

}
