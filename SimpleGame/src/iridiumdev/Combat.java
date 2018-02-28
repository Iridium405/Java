package iridiumdev;

public class Combat {
    /*
    Procesy walki
     */
    public int levelUp(int level, int experience) {
        switch (level){
            case 1:
                if (experience >=100 && experience <200) {
                    return level++;
                }
            case 2:
                if (experience >=200 && experience <300) {
                    return level++;
                }
            case 3:
                if (experience >=300 && experience <500) {
                    return level++;
                }
            case 4:
                if (experience >=500 && experience <800) {
                    return level++;
                }
        }
        return level;
    }

}
