package org.hbrs.se1.ws26.exercises.uebung2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Marcus Meyer / mmeye12s
 * @created 13.10.26
 */
public class Container {

    // Objekte von Typ Member zur Laufzeit abspeichern über Klasse "ConcreteMember"
    private final List<Member> members = new ArrayList<>();

    public void addMember(Member member) throws ContainerException {
        for (Member existing : members) {
            if (Objects.equals(existing.getID(), member.getID())) {
                throw new ContainerException(existing.getID());
            }
        }
        members.add(member);
    }

    public String deleteMember(int ID) {
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);

            if (member.getID() == ID) {
                members.remove(i);
                return "Member mit der ID " + ID + " erfolgreich gelöscht.";
            }
        }

        return "Das Member-Objekt mit der ID " + ID + " befindet sich nicht in der Liste!";
    }

    public void dump() {
        for (Member member : members) {
            System.out.println(member.toString());
        }
    }

    public int size() {
        return members.size();
    }
}
