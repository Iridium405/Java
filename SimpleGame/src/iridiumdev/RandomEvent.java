package iridiumdev;

public class RandomEvent {

    private Fight fight;                // *walka z jednym lub wieloma przeciwnikami.
    private NpcMeeting npcMeeting;      // *spotkanie postaci niezależnej - kupca, lorda z misją itp.
    private Finding finding;            // *losowe znalezisko - np. mikstury w zepsutym wozie.
    private Situation situation;        // *losowa sytuacja mająca wpływ na postać np. deszcz kwasu,
                                        //  który zabiera postaci punkty życia.
                                        // *możliwy brak sytuacji losowej.

    private Dice randomEventDice = new Dice();

    public RandomEvent(Player player, int random) {
        switch(random){
            case 1:
                this.fight = new Fight(player, randomEventDice.throwDice(2));
                break;
            case 2:
                this.npcMeeting = new NpcMeeting();
                break;
            case 3:
                this.finding = new Finding();
                break;
            case 4:
                this.situation = new Situation();
                break;
            default:
                System.out.println("This time nothing happened.");
                break;
        }
    }



}
