
import java.util.ArrayList;

public class Player {
    String name, description;
    ArrayList<Item> items;
    Graph.Node currentRoom;
    Player(String name, String description, Graph.Node currentRoom ){
        this.name = name;
        this.description = description;
        this.currentRoom = currentRoom;
    }
    public void addItem(Item item){
        items.add(item);
    }
    public  Item removeItem(String name){
        for(Item i:items){
            if (i.equals(name)){
                items.remove(i);
                return i;
            }
        }
        return null;
    }
    public  boolean destroyItem(String name){
        for(Item i:items){
            if (i.equals(name)){
                items.remove(i);
                return true;
            }
        }
        return false;
    }
    public ArrayList<Item> getItems(){
        return items;
    }
    public void displayInventory(){
        for(Item i:items){
            System.out.println(i.getName()+i.getDescription());
        }
    }
    public Graph.Node getCurrentRoom(){
        return currentRoom;
    }
    public void setCurrentRoom(Graph.Node newRoom){
        currentRoom = newRoom;
    }
    public boolean moveToRoom(String name){
        if (!currentRoom.go(name).equals(null)){
            return true;
        }
        return false;
    }

}


