package uk.ac.aber.cs21120.wedding.solution;

import uk.ac.aber.cs21120.wedding.interfaces.IPlan;
import uk.ac.aber.cs21120.wedding.interfaces.IRules;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Rules implements IRules {
    HashMap<String, Set<String>> friends = new HashMap<>();
    HashMap<String, Set<String>> enemies = new HashMap<>();
    @Override
    public void addMustBeTogether(String a, String b) {
    if (friends.get(a) != null) { //if person a exists in the hashMap
        friends.get(a).add(b); //adds b to a's mates hashSet
    }
    else {
        Set<String> mates = new HashSet<>(); // create a new hashSet for mates.
        mates.add(b); //add b to mates
        friends.put(a, mates); //adds a as a key to the hashMap and sets the value as the hashSet Mates
    }
        if (friends.get(b) != null) { //if person b exists in the hashMap
            friends.get(b).add(a); //adds a to b's mates hashSet
        }
        else {
            Set<String> mates = new HashSet<>(); // create a new hashSet for mates.
            mates.add(a); //add a to mates
            friends.put(b, mates); //adds b as a key to the hashMap and sets the value as the hashSet Mates
        }


    }

    @Override
    public void addMustBeApart(String a, String b) {
        if (enemies.get(a) != null) { //if person a exists in the hashMap
            enemies.get(a).add(b); //adds b to a's opps hashSet
        }

        else {
            Set<String> opps = new HashSet<>(); // create a new hashSet for opps.
            opps.add(b); //add b to opps
            enemies.put(a, opps); //adds a as a key to the hashMap and sets the value as the hashSet opps
        }
        if (enemies.get(b) != null) { //if person b exists in the hashMap
            enemies.get(b).add(a); //adds a to b's opps hashSet
        }
        else {
            Set<String> opps = new HashSet<>(); // create a new hashSet for opps.
            opps.add(a); //add a to opps
            enemies.put(b, opps); //adds b as a key to the hashMap and sets the value as the hashSet opps
        }

    }

    @Override
    public boolean isPlanOK(IPlan p) {
        for (int i = 0; i<p.getNumberOfTables(); i++){ //for every table there is
          for(String guest: p.getGuestsAtTable(i)){ // for each guest at table
              if (enemies.get(guest) != null) { // if guest has enemies
                  for (String onTable : p.getGuestsAtTable(i)) { //compare against other people on table
                      if (enemies.get(guest).contains(onTable)) return false; // return false if they are enemies
                  }
              }

              if(friends.get(guest) != null) {
                  if (p.getGuestsAtTable(i).size() == p.getSeatsPerTable()) { //if table is full
                      Set<String> friendsOfGuest = friends.get(guest);
                      for (String friend : friendsOfGuest) { // for each friend of guest
                          if (!p.getGuestsAtTable(i).contains(friend)) {
                              return false;
                          }
                      }
                  }
              }

            }


          }

        return true;
    }

}
