package linkedList;


/**
 * 
 * @author Gsus Cryst
 * Info: Einfach verkettete Liste
 */
public class LinkedList {
	
	/**
	 * Leeres Anfangselement der Liste
	 */
	private final LElement head = new LElement(null);
	
	/**
	 * Position in der Liste
	 */
	private LElement pointer = head;
	
	/**
	 * Gibt <code>true</code> zurück, wenn die Liste leer ist,
	 * sonst <code>false</code>.
	 * 
	 * @return <code>true</code> oder <code>false</code>
	 */
	public boolean isEmpty() {
		if (head.getNextElem() == null) {
			return true;
		}
		return false;
	}

	/**
	 * Gibt <code>true</code> zurück, wenn <code>pointer</code> 
	 * auf <code>head</code> zeigt, 
	 * sonst <code>false</code>.
	 * 
	 * @return <code>true</code> oder <code>false</code>
	 */
	public boolean isInFrontOf() {
		if (pointer.getInhalt() == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * Gibt <code>true</code> zurück, wenn <code>pointer</code> 
	 * hinter dem letzten Element steht,
	 * sonst <code>false</code>.
	 * 
	 * @return <code>true</code> oder <code>false</code>
	 */
	public boolean isBehind() {
		if (pointer == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * <code>pointer</code> zeigt auf das nächste Element in der Liste und
	 * gibt den Inhalt aus.
	 * 
	 * @return <code>String</code> Inhalt des Elements oder Fehlermeldung
	 */
	public String getNext() {
		if (pointer.getNextElem() != null) {
			pointer = pointer.getNextElem();
			return pointer.getInhalt();
		} else {
			return "Es existiert kein Folgeelement.";
		}
	}
	
	/**
	 * <code>pointer</code> zeigt auf das vorherige Element in der Liste und
	 * gibt den Inhalt aus.
	 * 
	 * @return <code>String</code> Inhalt des Elements oder Fehlermeldung
	 */
	public String getPrevious() {
		if (!isInFrontOf()) {
			if (pointer.getPrevElem(this).getInhalt() != null) {
				pointer = pointer.getPrevElem(this);
				return pointer.getInhalt();
			} else {
				return "Es existiert kein Vorgängerelement.";
			}
		}
		return "Sie sind vor der Liste.";
	}
	
	/**
	 * <code>pointer</code> steht nicht hinter der Liste.
	 * Ein neues Element wurde nach <code>pointer</code> eingefügt.
	 * 
	 * @param s <code>inhalt</code> des Elements
	 * @return <code>String</code> für JUnit
	 */
	public String setNext(String s) {
		if (!isBehind()) {
			LElement newE = new LElement(s);
			newE.setNextElem(pointer.getNextElem());
			pointer.setNextElem(newE);
			return s;
		}
		return "Du bist hinter der Liste.";
	}
	
	/**
	 * <code>pointer</code> steht nicht vor der Liste.
	 * Ein neues Element wurde vor <code>pointer</code> eingefügt.
	 * 
	 * @param s <code>inhalt</code> des Elements
	 * @return <code>String</code> für JUnit
	 */
	public String setPrevious(String s) {
		if (!isInFrontOf()) {
			pointer.setPrevElem(this, new LElement(s));
			return s;
		}
		return "Du bist am Anfang der Liste.";
	}
	
	/**
	 * Entfernt das Element nach <code>pointer</code>
	 * 
	 * @return <code>String</code> für JUnit
	 */
	public String removeNext() {
		if (!isBehind()) {
			String s = pointer.getNextElem().getInhalt();
			pointer.removeNextElem();
			return s;
		}
		return "Du bist hinter der Liste.";
	}
	
	/**
	 * Entfernt das Element vor <code>pointer</code>
	 * 
	 * @return <code>String</code> für JUnit
	 */
	public String removePrev() {
		if (!isInFrontOf()) {
			String s = pointer.getPrevElem(this).getInhalt();
			pointer.removePrevElem(this);
			return s;
		}
		return "Du bist vor der Liste.";
	}
	
	/**
	 * Gibt das Attribut <code>head</code> zurück.
	 * 
	 * @return <code>head</code>
	 */
	public LElement getHead() {
		return head;
	}
	
	/**
	 * Gibt das Attribut <code>pointer</code> zurück.
	 * 
	 * @return <code>pointer</code>
	 */
	public LElement getPointer() {
		return pointer;
	}
	
	/**
	 * Gibt die Anzahl der Elemente als Integer zurück
	 * 
	 * @return <code>count</code>
	 */
	public int size() {
		LElement help = head;
		int count = 0;
		while (help.getNextElem() != null) {
			count++;
			help = help.getNextElem();
		}
		return count;
	}
	
	@Override
	public String toString() {
		String str = "|";
		if (!isEmpty()) {
			LElement help = head.getNextElem();
			if (pointer.getInhalt() == null) {
				str += "*|";
			}
			for (int i = 0; i < size(); i++) {
				if (help.getInhalt() != null) {
					if (help.getInhalt().equals(pointer.getInhalt())) {
						str += help.getInhalt() + "*|";
					} else {
						str += help.getInhalt() + "|";
					}
					help = help.getNextElem();
				}
			}
		} else {
			return "Die Liste ist leer.";
		}
		return str;
	}
}
