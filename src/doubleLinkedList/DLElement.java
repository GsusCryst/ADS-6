package doubleLinkedList;


/**
 * 
 * @author Gsus Cryst
 * Info: Element einer doppelt geketteten List.
 */
public class DLElement {

	/**
	 * Inhalt des Elements
	 */
	private String inhalt;
	
	/**
	 * Element nach diesem Element
	 */
	private DLElement next = null;
	
	/**
	 * Element vor diesem Element
	 */
	private DLElement prev = null;
	
	/**
	 * Erzeugt ein leeres Element mit dem �bergebenen 
	 * <code>String</code> Parameter.
	 * 
	 * @param s <code>String</oode> wird zum Attribut 
	 * <code>inhalt</code> des Elements
	 */
	public DLElement(String s) {
		this.inhalt = s;
	}

	/**
	 * Gibt das Attribut <code>inhalt</code> zur�ck.
	 * 
	 * @return <code>inhalt</code>
	 */
	public String getInhalt() {
		return inhalt;
	}

	/**
	 * Gibt das Attribut <code>next</code> zur�ck.
	 * 
	 * @return <code>next</code>
	 */
	public DLElement getNextElem() {
		return next;
	}
	
	/**
	 * Gibt das Attribut <code>prev</code> zur�ck.
	 * 
	 * @return <code>prev</code>
	 */
	public DLElement getPrevElem() {
		return prev;
	}

	/**
	 * Setzt das Attribut <code>prev</code> auf den �bergebenen Parameter.
	 * 
	 * @param prev Neuer Inhalt f�r <code>prev</code>
	 */
	public void setPrevElem(DLElement prev) {
		this.prev = prev;
	}

	/**
	 * Setzt das Attribut <code>next</code> auf den �bergebenen Parameter.
	 * 
	 * @param next Neuer Inhalt f�r <code>next</code>
	 */
	public void setNextElem(DLElement next) {
		this.next = next;
	}
	
	/**
	 * Entfernt das Element <code>next</code> und ersetzt es
	 * durch dessen Nachfolger.
	 */
	public void removeNextElem() {
		next = next.getNextElem();
	}
	
	/**
	 * Entfernt das Element <code>prev</code> und ersetzt es
	 * durch dessen Vorg�nger.
	 */
	public void removePrevElem() {
		prev = prev.getPrevElem();
	}


}
