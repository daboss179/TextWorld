public abstract class Creature {
    Graph.Node CurrentRoom;
    String name;
    String description;

    public Creature(Graph.Node room,String n,String d) {
        this.CurrentRoom = room;
        this.name = n;
        this.description = d;
    }
    public abstract void move(Creature b);
    public abstract void act();
    public String getName(){
        return this.name;
    }
    public void setName(String s){
        this.name = s;
    }
    public Graph.Node getCurrentRoom(){
        return this.CurrentRoom;
    }
    public void setCurrentRoom(Graph.Node g){
        this.CurrentRoom = g;
    }

}
