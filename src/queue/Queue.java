package queue;


/**
 * 
 * @author Gsus Cryst
 * Info: First-In-First-Out-Prinzip (FIFO)
 */
public class Queue {

	/**
	 * Konstante Arraylist mit <code>String</code>-Elementen
	 */
	private final String[] list;
	
	/**
	 * Zeiger auf das zuerst eingefügte Element
	 */
	private int front;

	/**
	 * Zeiger aus das leere Element(<code>null</code>) 
	 * oder <code>front</code> nach dem 
	 * letzten gefüllten Element
	 */
	private int back;

	/**
	 * Erzeugt eine leere Queue mit dem Array <code>list</code> 
	 * der Länge <code>elements</code>.
	 * 
	 * @param elements Länge des Arrays <code>list</code>
	 */
	public Queue(int elements) {
		list = new String[elements];
		front = 0;
		back = 0;
	}
	
	/**
	 * Liefert den Wert <code>true</code>, wenn die Queue leer ist,
	 * sonst <code>false</code>.
	 * 
	 * @return <code>true</code> oder <code>false</code>
	 */
	public boolean isEmpty() {
		if (list[front] == null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Liefert den Wert <code>true</code>, wenn die Queue voll ist,
	 * sonst <code>false</code>.
	 * 
	 * @return <code>true</code> oder <code>false</code>
	 */
	public boolean isFull() {
		if (list[back] != null) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Die Queue ist erzeugt.
	 * Der Parameter <code>String</code> wird als letztes Element
	 * in die Queue eingefügt.
	 * 
	 * @param s <code>String</code> der in die Queue eingefügt wird
	 */
	public void enqueue(String s) {
		if (isEmpty()) {
			list[front] = s;
			setBack();
		} else {
			if (!isFull()) {
				list[back] = s;
				setBack();
			}
		}
	}
	
	/**
	 * Die Queue ist nicht leer.
	 * Der <code>String</code>, des vordersten Elements, an der
	 * Position <code>front</code> wird ausgegeben und aus dem
	 * Queue entfernt.
	 * 
	 * @return <code>String</code> Inhalt des Elements oder Fehlermeldung
	 */
	public String dequeue() {
		if (!isEmpty()) {
			String s = list[front];
			list[front] = null;
			setFront();
			if (list[back] != null) {
				setBack();
			}
			return s;
		}
		return "Die Queue ist leer.";
	}
	
	/**
	 * Setzt das Attribut <code>front</code> eine Position weiter.
	 */
	private void setFront() {
		if (front == list.length-1) {
			front = 0;
		} else {
			front++;
		}
	}
	
	/**
	 * Setzt das Attribut <code>back</code> eine Position weiter.
	 */
	private void setBack() {
		if (back == list.length-1) {
			if (front != 0) {
				back = 0;
			}
		} else {
			if (back != front-1) {
				back++;
			}
		}
	}

	/**
	 * Gibt das Attribut <code>list</code> zurück.
	 * 
	 * @return <code>list</code>
	 */
	public String[] getList() {
		return list;
	}
	
	@Override
	public String toString() {
		String str = "|";
		if (front >= back) {
			for (int i = front; i < list.length; i++) {
				if (list[i] == null) {
					break;
				}
				str += list[i] + "|" ;
			}
			for (int i = 0; i < back+1; i++) {
				if (list[i] == null) {
					break;
				}
				str += list[i] + "|" ;
			}
		} else {
			for (int i = front; i < back+1; i++) {
				if (list[i] == null) {
					break;
				}
				str += list[i] + "|" ;
			}
		}
		return str;
	}

}
