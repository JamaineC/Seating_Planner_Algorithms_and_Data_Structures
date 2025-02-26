package uk.ac.aber.cs21120.wedding.test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.ac.aber.cs21120.wedding.solution.Plan;

public class guestsTableTest {
    /**
     * Make sure that the table of the guest is retured
     */
    @Test
    public void testGuestsTable(){
        Plan p = new Plan(5,10);
        p.addGuestToTable(3, "Jamaine");
        Assertions.assertEquals(3, p.guestsTable("Jamaine"));
    }
}
