package stack;

import linkedList.LinkedList;

/**
 * 
 * @author Gsus Cryst
 * Info: Last-In-First-Out-Prinzip (LIFO)
 */
public class Stack extends LinkedList {
	
	/**
	 * Ein leerer Stack wird erzeugt
	 */
	public Stack() {
		new LinkedList();
	}
	
	/**
	 * Der Stack ist erzeugt.
	 * Der übergebene <code>String</code> liegt auf dem Stack.
	 * 
	 * @param s <code>String</code> wird auf den Stack gelegt
	 */
	public void push(String s) {
		setNext(s);
	}
	
	/**
	 * Der Stack ist nicht leer.
	 * Der zuletzt eingefügte <code>String</code> wird zurückgegeben und
	 * aus dem Stack entfernt.
	 * 
	 * @return <code>String</code> Inhalt des Elements oder Fehlermeldung
	 */
	public String pop() {
		if (!isEmpty()) {
			String s = getPointer().getNextElem().getInhalt();
			removeNext();
			return s;
		}
		return "Der Stack ist leer.";
	}
	
	/**
	 * Der Stack ist nicht leer.
	 * Gibt das oberste Stackelement zurück.
	 * 
	 * @return  <code>String</code> Inhalt des Elements oder Fehlermeldung
	 */
	public String top() {
		if (!isEmpty()) {
			return getPointer().getNextElem().getInhalt();
		}
		return "Der Stack ist leer.";
	}
}
