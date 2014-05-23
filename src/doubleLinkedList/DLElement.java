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
	 * Erzeugt ein leeres Element mit dem übergebenen 
	 * <code>String</code> Parameter.
	 * 
	 * @param s <code>String</oode> wird zum Attribut 
	 * <code>inhalt</code> des Elements
	 */
	public DLElement(String s) {
		this.inhalt = s;
	}

	/**
	 * Gibt das Attribut <code>inhalt</code> zurück.
	 * 
	 * @return <code>inhalt</code>
	 */
	public String getInhalt() {
		return inhalt;
	}

	/**
	 * Gibt das Attribut <code>next</code> zurück.
	 * 
	 * @return <code>next</code>
	 */
	public DLElement getNextElem() {
		return next;
	}
	
	/**
	 * Gibt das Attribut <code>prev</code> zurück.
	 * 
	 * @return <code>prev</code>
	 */
	public DLElement getPrevElem() {
		return prev;
	}

	/**
	 * Setzt das Attribut <code>prev</code> auf den übergebenen Parameter.
	 * 
	 * @param prev Neuer Inhalt für <code>prev</code>
	 */
	public void setPrevElem(DLElement prev) {
		this.prev = prev;
	}

	/**
	 * Setzt das Attribut <code>next</code> auf den übergebenen Parameter.
	 * 
	 * @param next Neuer Inhalt für <code>next</code>
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
	 * durch dessen Vorgänger.
	 */
	public void removePrevElem() {
		prev = prev.getPrevElem();
	}


}
