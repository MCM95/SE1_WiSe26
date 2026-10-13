package org.hbrs.se1.ws26.exercises.uebung2;

/**
 * @author Marcus Meyer / mmeye12s
 * @created 13.10.26
 */
public class ConcreteMember implements Member{

    private static int nextID = 1;
    private final int id;

    public ConcreteMember() {
        this.id = nextID++;
    }


    @Override
    public Integer getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Member (ID = " + this.id + ")";
    }
}
