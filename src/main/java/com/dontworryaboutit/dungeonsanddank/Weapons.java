package com.dontworryaboutit.dungeonsanddank;

import definitions.Definitions;
import java.util.ArrayList;
import java.util.Arrays;

public class Weapons extends Items{
    private int handed;
    private int availability;
    private String dmg;
    private int critMult;
    private ArrayList<Integer> critOn;
    private int range;
    private int type;
    private boolean lethal;

    private Weapons(String name, int cost, int handed, String dmgS, String dmgM, boolean is_S, int critMult, int critOn, int range, double weight, int type, int availability, boolean lethal){
        super(name, cost, is_S?(weight/2.0):weight);
        this.handed = handed;
        this.availability = availability;
        this.dmg = is_S?dmgS:dmgM;
        this.critMult = critMult;
        this.critOn = new ArrayList<Integer>();
        for(int i = 20; i >= critOn; i--){
            this.critOn.add(i);
        }
        this.range = range;
        this.type = type;
        this.lethal = lethal;
    }

    public int getAvailability(){
        return availability;
    }
    public String getDmg(){
        return dmg;
    }
    public int getCritMult(){
        return critMult;
    }
    public ArrayList<Integer> getCritOn(){
        return critOn;
    }
    public int getRange(){
        return range;
    }
    public int getType(){
        return type;
    }
    public boolean isLethal(){
        return lethal;
    }

    /* Weapons constructors */

    public static Weapons newGauntlet(boolean small){
        return new Weapons("Gauntlet", 2, 1,"1d2", "1d3", small, 2, 20, 0, 1, BLUDGEONING, COMMON, true);
    }
    public static Weapons newUnarmed(boolean small){
        return new Weapons("Unarmed", 0, 0,"1d2", "1d3", small, 2, 20, 0, 0, BLUDGEONING, NONEXISTANT, false);
    }
    public static Weapons newDagger(boolean small){
        return new Weapons("Unarmed", 2, 1,"1d3", "1d4", small, 2, 19, 10, 1, PorS, COMMON, true);
    }
    public static Weapons newPunchingDagger(boolean small){
        return new Weapons("Punching Dagger", 2, 1,"1d3", "1d4", small, 3, 20, 0, 1, PIERCING, COMMON, true);
    }
    public static Weapons newSpikedGauntlet(boolean small){
        return new Weapons("Spiked Gauntlet", 5, 1,"1d3", "1d4", small, 2, 20, 0, 1, PIERCING, COMMON, true);
    }
    public static Weapons newLightMace(boolean small){
        return new Weapons("Light Mace", 5, 1,"1d4", "1d6", small, 2, 20, 0, 4, BLUDGEONING, COMMON, true);
    }
    public static Weapons newSickle(boolean small){
        return new Weapons("Sickle", 6, 1,"1d4", "1d6", small, 2, 20, 0, 2, SLASHING, COMMON, true);
    }
    public static Weapons newClub(boolean small){
        return new Weapons("Club", 0, 1,"1d4", "1d6", small, 2, 20, 10, 3, BLUDGEONING, COMMON, true);
    }
}
