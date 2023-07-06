package oop.boxing_match;

public class BoxingMatch {
    private Fighter fighter_blue, fighter_red;

    public BoxingMatch(Fighter fighter_blue, Fighter fighter_red) {
        this.fighter_blue = fighter_blue;
        this.fighter_red = fighter_red;
    }

    protected String fight(){
        while(!(this.fighter_red.getHealth() <= 0 || this.fighter_blue.getHealth() <= 0)){
            this.fighter_blue.attack(this.fighter_red);
            this.fighter_red.attack(this.fighter_blue);
        }
        if(this.fighter_blue.getHealth() <= 0){
            return "The winner is " +  this.fighter_red.getName();
        }
        else{
            return "The winner is " + this.fighter_blue.getName();
        }
    }


}
