package org.hbrs.se1.ws26.exercises.uebung2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Marcus Meyer / mmeye12s
 * @created 13.10.26
 */

public class ContainerTest {

    private Container container;
    private Member m1;
    private Member m2;

    @BeforeEach
    void setUp() {
        container = new Container();
        m1 = new ConcreteMember();
        m2 = new ConcreteMember();
    }

    // Test 1: Container ist leer
    @Test
    void testInitialSize() {
        assertEquals(0, container.size());
    }

    // Test 2: erstes Member hinzufügen
    @Test
    void testAddFirstMember() throws ContainerException {
        container.addMember(m1);
        assertEquals(1, container.size());
    }

    // Test 3: zwei Member hinzufügen
    @Test
    void testAddSecondMember() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);
        assertEquals(2, container.size());
    }

    // Test 4: IDs prüfen
    @Test
    void testDump() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);

        assertDoesNotThrow(() -> container.dump());
        assertEquals(2, container.size());
    }

    // Test 5: Ein Member doppelt hinzufügen -> Fehler
    @Test
    void testDuplicateMember() throws ContainerException {
        container.addMember(m1);
        assertThrows(ContainerException.class, () -> container.addMember(m1));
    }

    // Test 6: Array Größe bleibt nach Fehlschlag (T5) unverändert
    @Test
    void testArrySize() throws ContainerException {
        container.addMember(m1);
        assertThrows(ContainerException.class, () -> container.addMember(m1));
        assertEquals(1, container.size());
    }

    // Test 7: Verschiedene Member besitzen unterschiedliche IDs
    @Test
    void testDifferentIDs() {
        assertNotEquals(m1.getID(), m2.getID());
    }

    // Test 8: Member aus Array löschen
    @Test
    void testDeleteMember() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);
        String result = container.deleteMember(m1.getID());
        assertTrue(result.contains("erfolgreich"));
        assertEquals(1, container.size());
    }

    // Test 9: Nicht vorhandenes Member löschen
    @Test
     void testDeleteNonexistingMember() {
        String result = container.deleteMember(m1.getID());
        assertTrue(result.contains("nicht in der Liste"));
        assertEquals(0, container.size());
    }

    // Test 10: Liste vollständig leeren
    @Test
    void testDeleteAllMembers() throws ContainerException {
        container.addMember(m1);
        container.addMember(m2);

        assertEquals(2, container.size());

        container.deleteMember(m1.getID());
        container.deleteMember(m2.getID());

        assertEquals(0, container.size());
    }

}
