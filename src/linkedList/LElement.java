package linkedList;


/**
 * 
 * @author Gsus Cryst
 * Info: Element einer einfach verketteten Liste
 */
public class LElement {
	
	/**
	 * Inhalt des Elements
	 */
	private String inhalt;
	
	/**
	 * Element nach diesem Element
	 */
	private LElement next;
	
	/**
	 * Erzeugt ein leeres Element mit dem �bergebenen 
	 * <code>String</code> Parameter.
	 * 
	 * @param s <code>String</code> wird zum Attribut <code>inhalt</code> 
	 * des Elements
	 */
	public LElement(String s) {
		inhalt = s;
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
	public LElement getNextElem() {
		return next;
	}

	/**
	 * Setzt das Attribut <code>next</code> auf den �bergebenen Parameter.
	 * 
	 * @param next Neuer Inhalt f�r <code>next</code>
	 */
	public void setNextElem(LElement next) {
		this.next = next;
	}
	
	/**
	 * Entfernt das Element <code>next</code> und ersetzt es
	 * durch dessen Nachfolger.
	 */
	public void removeNextElem() {
		if (next != null) {
			next = next.getNextElem();
		} else {
			System.out.println("Element hat keinen Nachfolger.");
		}
	}
	
	/**
	 * Setzt den Vorg�nger dieses Elements.
	 * 
	 * @param prev Der Vorg�nger <code>prev</code>
	 * @return neue <code>LinkedList</code>
	 */
	public void setPrevElem(LinkedList l, LElement prev) {
		LElement start = l.getHead();
		for (int i = 0; i < l.size(); i++) {
			if (start.getNextElem().getInhalt().equals(inhalt)) {
				prev.setNextElem(this);
				start.setNextElem(prev);
				return;
			} else {
				start = start.getNextElem();
			}
		}
	}
	
	/**
	 * Gibt den Vorg�nger dieses Elements zur�ck oder <code>null</code>
	 * sollte das Element am Anfang der Liste stehen.
	 * 
	 * @return <code>null</code> oder <code>prev</code>
	 */
	public LElement getPrevElem(LinkedList l) {
		LElement start = l.getHead();
		if (start.getNextElem() != null) {
			for (int i = 0; i < l.size(); i++) {
				if (start.getNextElem().getInhalt().equals(inhalt)) {
					return start;
				} else {
					start = start.getNextElem();
				}
			}
		}
		return this;
	}
	
	/**
	 * Entfernt das vorherige Element und ersetzt es
	 * durch dessen Vorg�nger.
	 */
	public void removePrevElem(LinkedList l) {
		LElement start = l.getHead();
		for (int i = 0; i < l.size(); i++) {
			if (start.getNextElem().getInhalt().equals(inhalt)) {
				LElement help = start.getPrevElem(l);
				help.setNextElem(this);
				return;
			} else {
				start = start.getNextElem();
			}
		}
	}

}
