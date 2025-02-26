package uk.ac.aber.cs21120.wedding.solution;

import uk.ac.aber.cs21120.wedding.interfaces.IPlan;
import uk.ac.aber.cs21120.wedding.interfaces.IRules;
import uk.ac.aber.cs21120.wedding.interfaces.ISolver;

public class Solver implements ISolver {
    String[] guests;
    IPlan plan;
    IRules rules;

    public Solver(String[] guests, IPlan plan, IRules rules) {
        this.guests = guests;
        this.plan = plan;
        this.rules = rules;
    }

    @Override
    public boolean solve() {


        for (int i = 0; i < plan.getNumberOfTables(); i++) //for every table there is
        {
            for (int j = plan.getGuestsAtTable(i).size(); j < plan.getSeatsPerTable(); j++) //for each unfilled seat
            {
                for (String guest : guests) //for each guest in the guest list
                {
                    if (!plan.isGuestPlaced(guest)) //if guest is not placed
                    {
                        plan.addGuestToTable(i, guest); //add guest to current table
                        if (rules.isPlanOK(plan)) // if seating plan is valid
                        {
                            boolean result;
                            result = solve();
                            if (result) {  // recursively tries to solve
                                return true;
                            }
                        }

                            plan.removeGuestFromTable(guest); //remove guest from table and plan
                        }
                    }
                    return false; //couldn't fit any guest in seat, so we backtrack.
                }
            }
            return true;  //managed to fill all seats
        }
}

