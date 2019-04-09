import java.util.ArrayList;

public class Wumpus extends Creature{

    public Wumpus(Graph.Node room,String n,String d){
        super(room,n,d);
    }
    public void move(Creature creature){
     ArrayList<String> a = creature.CurrentRoom.getNeighborNamesList();
     for(int i = 0; i < a.size(); i++){
        // if(a[i] );
     }
    }
    public void act(){

    }

}
