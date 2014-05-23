package doubleLinkedList;


/**
 * 
 * @author Gsus Cryst
 * Info: Doppelt verkettete Liste
 */
public class DoubleLinkedList {

	/**
	 * Leeres Anfangselement der Liste
	 */
	private final DLElement head = new DLElement(null);
	
	/**
	 * Leeres Endelement der Liste
	 */
	private final DLElement tail = new DLElement(null);
	
	/**
	 * Position in der Liste
	 */
	private DLElement pointer = head;
	
	/**
	 * Erzeugt eine leere Liste
	 */
	public DoubleLinkedList() {
		head.setNextElem(tail);
		tail.setPrevElem(head);
	}
	
	/**
	 * Gibt <code>true</code> zurück, wenn die Liste leer ist,
	 * sonst <code>false</code>.
	 * 
	 * @return <code>true</code> oder <code>false</code>
	 */
	public boolean isEmpty() {
		if (head.getNextElem() == tail) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Gibt <code>true</code> zurück, wenn <code>pointer</code> auf <code>head</code> zeigt,
	 * sonst <code>false</code>.
	 * 
	 * @return <code>true</code> oder <code>false</code>
	 */
	public boolean isInFrontOf() {
		if (pointer.getPrevElem() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Gibt <code>true</code> zurück, wenn <code>pointer</code> auf <code>tail</code> zeigt,
	 * sonst <code>false</code>.
	 * 
	 * @return <code>true</code> oder <code>false</code>
	 */
	public boolean isBehind() {
		if (pointer.getNextElem() == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * <code>pointer</code> zeigt auf das nächste Element in der Liste und
	 * gibt den Inhalt aus.
	 * 
	 * @return <code>String</code> Inhalt des Elements oder Fehlermeldung
	 */
	public String getNext() {
		if (!isBehind()) {
			if (pointer.getNextElem() != tail) {
				pointer = pointer.getNextElem();
				return pointer.getInhalt();
			}
			return "Es existiert kein Folgeelement.";
		}
		return "Sie sind hinter der Liste.";
	}
	
	/**
	 * <code>pointer</code> zeigt auf das vorherige Element in der Liste und
	 * gibt den Inhalt aus.
	 * 
	 * @return <code>String</code> Inhalt des Elements oder Fehlermeldung
	 */
	public String getPrevious() {
		if (!isInFrontOf()) {
			if (pointer.getPrevElem() != head) {
				pointer = pointer.getPrevElem();
				return pointer.getInhalt();
			}
			return "Es existiert kein Vorgängerelement.";
		}
		return "Sie sind vor der Liste.";
	}
	
	/**
	 * <code>pointer</code> steht nicht vor der Liste.
	 * Ein neues Element wurde vor <code>pointer</code> eingefügt.
	 * 
	 * @param s <code>inhalt</code> des Elements
	 * @return <code>String</code> Inhalt des Elements oder Fehlermeldung
	 */
	public String setPrevious(String s) {
		if (!isInFrontOf()) {
			DLElement newE = new DLElement(s);
			newE.setNextElem(pointer);
			newE.setPrevElem(pointer.getPrevElem());
			pointer.getPrevElem().setNextElem(newE);
			pointer.setPrevElem(newE);
			return s;
		}
		return "Du bist vor der Liste.";
	}
	
	/**
	 * <code>pointer</code> steht nicht hinter der Liste.
	 * Ein neues Element wurde nach <code>pointer</code> eingefügt.
	 * 
	 * @param s <code>inhalt</code> des Elements
	 * @return <code>String</code> Inhalt des Elements oder Fehlermeldung
	 */
	public String setNext(String s) {
		if (!isBehind()) {
			DLElement newE = new DLElement(s);
			newE.setPrevElem(pointer);
			newE.setNextElem(pointer.getNextElem());
			pointer.getNextElem().setPrevElem(newE);
			pointer.setNextElem(newE);
			return s;
		}
		return "Du bist hinter der Liste.";
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
			String s = pointer.getPrevElem().getInhalt();
			pointer.removePrevElem();
			return s;
		}
		return "Du bist vor der Liste.";
	}
	
	/**
	 * Gibt das Attribut <code>head</code> zurück.
	 * 
	 * @return <code>head</code>
	 */
	public DLElement getHead() {
		return head;
	}
	
	/**
	 * Gibt das Attribut <code>tail</code> zurück.
	 * 
	 * @return <code>tail</code>
	 */
	public DLElement getTail() {
		return tail;
	}
	
	/**
	 * Gibt das Attribut <code>pointer</code> zurück.
	 * 
	 * @return <code>pointer</code>
	 */
	public DLElement getPointer() {
		return pointer;
	}
	
	@Override
	public String toString() {
		String str = "|";
		if (head.getNextElem() != tail) {
			DLElement help = head.getNextElem();
			if (pointer.getInhalt() == null) {
				str += "*|";
			}
			while (help.getInhalt() != null) {
				if (help.getInhalt().equals(pointer.getInhalt())) {
					str += help.getInhalt() + "*|";
				} else {
					str += help.getInhalt() + "|";
				}
				help = help.getNextElem();
			}
		} else {
			return "Die Liste ist leer.";
		}
		return str;
	}
}
