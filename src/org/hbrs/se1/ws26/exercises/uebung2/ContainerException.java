package org.hbrs.se1.ws26.exercises.uebung2;

/**
 * @author Marcus Meyer / mmeye12s
 * @created 13.10.26
 */
public class ContainerException extends Exception{

    public ContainerException(int ID){
        super("Das Member-Objekt mit der ID " + ID + " ist bereits vorhanden!");
    }
}
