import java.util.Random;

public class Dice {
    /* Dice
     *
     * Static class, does not need to be instantiated.
     * Rolls dice based on pseudorandom algorithm.
     *
     * Arguments: String diceChance
     *            formatted in D&D style
     *            ex. "2d8" rolls 8 sided die twice
     *
     * Returns: int result of die rolls
     */

    private static Random generator = new Random(System.currentTimeMillis());

    public static int roll(String diceChance){
        String[] tokens = diceChance.split("d");
        int rolls = Integer.parseInt(tokens[0]);
        int chance = Integer.parseInt(tokens[1]);
        int result = 0;
        for(int i = 0; i < rolls; i++){
            result += singleRoll(chance);
        }
        return result;
    }

    private static int singleRoll(int limit){
        return generator.nextInt(limit) + 1;
    }
}
