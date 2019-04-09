
import javafx.print.PageLayout;

import java.util.Scanner;

public class Main {

    private static String roomName;

    public static void main(String[] args) {


       Graph g = new Graph();
        g.addNode("hall","a long dank hallway");
        g.addNode("closet", "a dark, dark closet");
        g.addNode("dungeon","a magical place");

        g.addDirectedEdge("hall","dungeon");
        g.addUndirectedEdge("hall","closet");
        Player bob = new Player( "Bob", "Smart player",g.getNode("hall"));
        ChickenArmy(15);

         Graph.Node current = g.getNode("hall");
        String response = "";
        Scanner s = new Scanner(System.in);

         //Display all the commands they cantype so they know what to do  *//*
        do{
            System.out.println("You are in the " + current.getName());
            System.out.print("What do you want to do? >");
            response = s.nextLine();
            run(response, current);

        }while (!response.equals("quit"));



    }

    private static void ChickenArmy(int num) {
        for(int i = 0; i < num; i++){
            Chicken c = new Chicken(getRandomRoom(), "name", "cool description");

        }
    }

    private static Graph.Node getRandomRoom() {
    // int i = (int)(Math.random()*g.g)
    return null;
    }

    public static void  run(String response , Graph.Node current){
        if(response.startsWith("go ")){/* they typed "go <roomname>" go to the room*/
            roomName = response.substring(3);
            current = current.go(roomName);

        } else if(response.startsWith("look")/* They typed "look" display all neighbors */){
            current.look();


        } else if(response.startsWith("room ")/* they typed add room <roomname> then add a new neighbor to there current room */){
            String roomName = response.substring(5);
            current.room(roomName,"A cool place to be");
        } else if(response.equals("quit")/* they type quit, then quit*/){


        } else {
         System.out.println("(!)Command not found(!) please use one of these commands: ");
         System.out.println(" go <roomname> , Look , room <roomname> , quit");

            /*display  all the commands they Can type so they know what to do*/
        }



    }

}

