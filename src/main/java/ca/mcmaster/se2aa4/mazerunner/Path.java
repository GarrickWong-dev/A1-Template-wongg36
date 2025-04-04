package ca.mcmaster.se2aa4.mazerunner;

public class Path extends Observer{ 
    private String path = ""; 

    //Construction for no -i field
    public Path(Subject marker) {
        this.subject = marker;
        subject.attach(this);
        

    }

    //Construction for -i field
    public Path(String path){
        this.path = path;
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

    public String unfactorPath(){
        String unfactored = "";
        for (int i = 0; i < this.path.length(); i++){
            if (Character.isDigit(this.path.charAt(i))){
                if(i == this.path.length()-1){
                    break;
                }
                String num = "";
                while (Character.isDigit(this.path.charAt(i))){
                    num = num + this.path.charAt(i);
                    i++;
                }
                int count = Integer.parseInt(num);
                for (int j = 0; j < count; j++){
                    unfactored = unfactored + path.substring(i, i+1);
                }
            }
            else{
                unfactored = unfactored + this.path.substring(i, i+1);
            }
        }
        return unfactored;
    }
}