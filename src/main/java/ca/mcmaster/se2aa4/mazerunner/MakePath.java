package ca.mcmaster.se2aa4.mazerunner;
import java.util.ArrayList;

public abstract class MakePath extends Movement{
    protected MakePath(ArrayList<ArrayList<String>> maze){
        super(maze);
    }

    protected void factorPath(){
        int count = 1;
        String factored = "";
        for (int i = 0; i < this.path.length()-1; i++){
            if (this.path.charAt(i) == this.path.charAt(i+1)){
                count = count + 1;
                if (i == this.path.length()-2){
                    if (count > 1){
                    factored = factored + String.valueOf(count);
                }
                factored = factored + this.path.substring(i,i+1);
                }
            }else{
                if (count > 1){
                    factored = factored + String.valueOf(count);
                    count = 1;
                }
                factored = factored + this.path.substring(i,i+1);
            }
        }
        if (this.path.charAt(this.path.length()-2) == this.path.charAt(this.path.length()-1)){
            factored = factored + String.valueOf(count);
            factored = factored + this.path.substring(this.path.length()-1);
        }else{
            factored = factored + this.path.substring(this.path.length()-1);
        }
        this.path = factored;
    }    

    protected abstract void findPath(ArrayList<ArrayList<String>> maze);
}