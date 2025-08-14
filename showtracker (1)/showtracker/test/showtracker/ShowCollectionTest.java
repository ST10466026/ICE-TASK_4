package showtracker;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShowCollectionTest {
    private ShowCollection app;

    @Before
    public void setUp() {
        app = new ShowCollection();
        app.addShowDirect(new Show("S001", "Breaking Bad", 16, 62));
    }

    @Test
    public void testFindShow() {
        Show result = app.getShowById("S001");
        assertNotNull("Show should be found.", result);
        assertEquals("Breaking Bad", result.showName);
        assertEquals(16, result.showAge);
        assertEquals(62, result.showEpisodes);
    }

    @Test
    public void testFindShow_NotFound() {
        Show result = app.getShowById("S999");
        assertNull("Show should not be found.", result);
    }

    @Test
    public void testModifyShow() {
        boolean updated = app.modifyShowById("S001", "Better Call Saul", 15, 50);
        assertTrue("Show should be updated.", updated);
        Show updatedShow = app.getShowById("S001");
        assertEquals("Better Call Saul", updatedShow.showName);
        assertEquals(15, updatedShow.showAge);
        assertEquals(50, updatedShow.showEpisodes);
    }

    @Test
    public void testRemoveShow() {
        boolean deleted = app.removeShowById("S001");
        assertTrue("Show should be deleted.", deleted);
        assertNull("Deleted show should not exist.", app.getShowById("S001"));
    }

    @Test
    public void testRemoveShow_NotFound() {
        boolean deleted = app.removeShowById("S999");
        assertFalse("Show should not be deleted because it does not exist.", deleted);
    }

    @Test
    public void testValidAge() {
        assertTrue("Age should be valid.", app.validAge(15));
        assertTrue("Lower bound age should be valid.", app.validAge(2));
        assertTrue("Upper bound age should be valid.", app.validAge(18));
    }

    @Test
    public void testInvalidAge() {
        assertFalse("Age below 2 should be invalid.", app.validAge(1));
        assertFalse("Age above 18 should be invalid.", app.validAge(19));
    }
}
