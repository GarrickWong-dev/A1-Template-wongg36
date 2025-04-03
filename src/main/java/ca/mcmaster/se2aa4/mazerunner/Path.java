package ca.mcmaster.se2aa4.mazerunner;

public class Path extends Observer{
    private String path = ""; 

    public Path(Subject marker) {
        this.subject = marker;
        subject.attach(this);
        

    }

    @Override
    public void update(){
        switch (subject.getState()){
            case 1 -> this.path = this.path+"F";
            case 2 -> this.path = this.path+"L";
            case 3 -> this.path = this.path+"R";
            case 4 -> this.path = factorPath();
        }
    }

    public String getPath(){
        return this.path;
    }

    public String factorPath(){
        String factored = "";
        int count = 1;
        // if (this.path.charAt(0)!=this.path.charAt(1)){
        //     factored = factored + this.path.charAt(0);
        // }
        for (int i = 1; i < this.path.length(); i++){
            if (this.path.charAt(i) == this.path.charAt(i-1)){
                count += 1;
            }else{
                if (count > 1){
                    factored = factored + String.valueOf(count);
                }
                factored = factored + this.path.charAt(i-1);
                count = 1;
            }
            //Last Letter
            if (i == this.path.length()-1){
                    if (count > 1){
                        factored = factored + String.valueOf(count);
                    }
                    factored = factored + this.path.charAt(i);
                }
            
        }
        return factored;
    }
}