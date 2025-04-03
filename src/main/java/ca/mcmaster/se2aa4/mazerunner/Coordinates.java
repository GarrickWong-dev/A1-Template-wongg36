package ca.mcmaster.se2aa4.mazerunner;

public class Coordinates{
    private int x;
    private int y;

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public boolean equals(Coordinates coords){
        if (this.x == coords.getX() && this.y == coords.getY()){
            return true;
        }else{
            return false;
        }
    }

    public void printCoords(){
        System.out.println(this.x + " " +this.y);
    }
}