import java.util.ArrayList;

public class Chicken extends Creature{
 public Chicken(Graph.Node room,String n,String d){
     super(room,n,d);
 }

    public void move(Creature b){
       ArrayList<String> n = CurrentRoom.getNeighborNamesList();
        CurrentRoom.removeCreature(b);
        CurrentRoom =  CurrentRoom.getRandomNeighbor();
        CurrentRoom.addCreature(b);
 }
    public void act(){

    }


}
