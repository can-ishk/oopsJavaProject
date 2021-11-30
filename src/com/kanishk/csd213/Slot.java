package com.kanishk.csd213;
import java.util.HashMap;
//@Author KanishkChathley
public class Slot{
    private HashMap<String,Integer> SportMap = new HashMap<String, Integer>(){{
        put("Badminton",1);
        put("Table Tennis",2);
        put("Squash",3);
        put("Gym",4);
        put("Chess",5);
    }};
    private HashMap<String,Integer> DayMap = new HashMap<String, Integer>(){{
        put("MWF",1);
        put("TTS",2);
        put("TSM",3);

    }};
    private HashMap<String,Integer> TimeMap = new HashMap<String, Integer>(){{
        put("6-7AM",1);
        put("7-8AM",2);
        put("8-9AM",3);
        put("5-6PM",4);
        put("6-7PM",5);
        put("7-8PM",6);
    }};

    private int id;
    private String Sport;
    private String Day;
    private String Time;

    Slot(String sport, String day, String time){
        this.Sport = sport;
        this.Day = day;
        this.Time = time;
        System.out.println(allotID());
        this.id = this.allotID();
    }

    int allotID(){
        return (Integer.parseInt(SportMap.get(this.Sport).toString() + DayMap.get(this.Day).toString()
                + TimeMap.get(this.Time).toString()));
    }

    //Getter
    int getID(){
        return id;
    }


}