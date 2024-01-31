public class Hero {
    private String name;
    private int hitPoints;
    //hp

    Hero(String name){
        this.name = name;
        this.hitPoints = 100;
    }

    public String getName() {
        return name;
    }
    public int getHitPoints(){
        return hitPoints;
    }

    public String toString(){
        return "Hero" + "{name='" + name + "', " + "hitPoints=" + hitPoints + "}";
    }

    public void attack(Hero opponent){
        double hit = Math.random();
        if(hit >= .5){
            opponent.hitPoints -= 10;
        }
        else if(hit < .5){
            hitPoints -= 10;
        }
    }

    void senzuBean(boolean value,Hero opponent){
        if(value){
            opponent.hitPoints = 100;
            this.hitPoints = 100;
        }
        else{
            this.hitPoints = 100;
        }
    }

    void fightUntilTheDeathHelper(Hero opponent){
        attack(opponent);
    }

    String fightUntilTheDeath(Hero opponent){
        senzuBean(true,opponent);

        while(hitPoints > 0 && opponent.hitPoints > 0){
            fightUntilTheDeathHelper(opponent);
        }

        String toReturn = name + ": " + hitPoints + "\n" + opponent.name + ": " + opponent.hitPoints;
        return toReturn;
    }

    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] winNLosses = new int[2];
        winNLosses[0] = 0;
        winNLosses[1] = 0;
        int i = 0;
        while(i < n) {
            if (opponent.hitPoints > 0 && hitPoints > 0) {
                attack(opponent);
            }
            if (opponent.hitPoints == 0) {
                winNLosses[0] += 1;
                i++;
            }
            if (hitPoints == 0) {
                winNLosses[1] += 1;
                i++;
            }
        }
        return winNLosses;
    }

    String nFightsToTheDeath(Hero opponent, int n){
        int[] winsNLosses = nFightsToTheDeathHelper(opponent, n);

        String winMessage = "";
        if(winsNLosses[0]>winsNLosses[1]){
            winMessage = name + " wins!";
        }
        else if(winsNLosses[1]>winsNLosses[0]){
            winMessage = opponent.name + " wins!";
        }
        return name + ": " + winsNLosses[0] + " wins\n" + opponent.name + ": " + winsNLosses[1] + " wins" + winMessage;
    }

    void dramaticFightToTheDeath(Hero opponent){
        while(hitPoints > 0 && opponent.hitPoints > 0){
            while(opponent.hitPoints > 0 && hitPoints > 0){
                attack(opponent);
                System.out.println(name + ": " + hitPoints + opponent.name + ": " + opponent.hitPoints);
            }
            if(opponent.hitPoints == 0){
                System.out.println(name + " wins!");
            }
            if(hitPoints == 0){
                System.out.println(opponent.name + " wins!");
            }
        }
    }

}
