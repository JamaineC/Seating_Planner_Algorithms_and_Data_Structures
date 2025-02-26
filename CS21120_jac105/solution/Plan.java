package uk.ac.aber.cs21120.wedding.solution;

import uk.ac.aber.cs21120.wedding.interfaces.IPlan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Plan implements IPlan {

    int numberOfTables;
    int seatsPerTable;
     ArrayList<Set<String>> tables;
    public Plan(int numberOfTables, int seatsPerTable){
        this.numberOfTables = numberOfTables;
        this.seatsPerTable = seatsPerTable;
        tables = new ArrayList<>();
        for (int i = 0; i< numberOfTables; i++) {
            tables.add(new HashSet<>());
        }
    }
    @Override
    public int getSeatsPerTable() {
        return seatsPerTable;
    }

    @Override
    public int getNumberOfTables() {
        return numberOfTables;
    }

    @Override
    public void addGuestToTable(int table, String guest) throws IndexOutOfBoundsException {
        if (table > numberOfTables -1) throw new IndexOutOfBoundsException(); //if not within the index then throw exception
        if (!isGuestPlaced(guest)){ //if the guest does not exist
            if (getGuestsAtTable(table).size() < seatsPerTable){  // if table is not full
                tables.get(table).add(guest); //add guest to table
            }
        }
    }

    @Override
    public void removeGuestFromTable(String guest) {
        if (isGuestPlaced(guest)){  //if guest is placed
            int x = guestsTable(guest); //find table of guest
            tables.get(x).remove(guest);}  //remove guest from that table
    }

    @Override
    public boolean isGuestPlaced(String guest) {
        for (int i = 0; i < numberOfTables; i++){ //for every table
            if (tables.get(i).contains(guest)){ //if table contains guest
                return true;
            }
        }
        return false;
    }

    /**
     * returns the table number of which the guest is sat at
     * @param guest -  the guest of the table we are searching
     * @return an integer - the table at which guest is placed
     */
    public int guestsTable(String guest){
        Boolean check;
        int i = 0; // number of current table
        do {
            check = tables.get(i).contains(guest); //check if table contains guest
            i ++;
        } while (!check); // loop from do, if guest is not present
        return i-1; // return table the guest is at
    }

    @Override
    public Set<String> getGuestsAtTable(int t) throws IndexOutOfBoundsException {
        if (t> numberOfTables - 1) throw new IndexOutOfBoundsException(); // if table does not exist throw exception
        else {
            return tables.get(t); //return guests at table
        }
    }
}
