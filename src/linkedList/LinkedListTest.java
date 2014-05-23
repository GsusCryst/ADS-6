package linkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest extends LinkedList {

	@Test
	public void test() {
		//erzeuge Liste
		new LinkedList();
		
		//Standardeinstellungen überprüfen
		assertEquals(null, getHead().getInhalt());
		assertEquals(null, getHead().getInhalt());
		assertEquals(getHead(), getPointer());
		assertTrue(isEmpty());
		assertTrue(isInFrontOf());
		assertFalse(isBehind());
		assertEquals("Es existiert kein Folgeelement.", getNext());
		assertEquals("Sie sind vor der Liste.", getPrevious());
		assertEquals("Die Liste ist leer.", toString());
		
		//Element einfügen, Ausgabe und Pointer verschieben
		assertEquals("Welt", setNext("Welt"));
		assertFalse(isEmpty());
		assertTrue(isInFrontOf());
		assertEquals("|*|Welt|", toString());
		assertEquals("Welt", getNext());
		assertEquals("Es existiert kein Vorgängerelement.", getPrevious());
		
		//Weiteres Element einfügen, Ausgabe, Pointer verschieben
		assertEquals("Hallo", setPrevious("Hallo"));
		assertFalse(isEmpty());
		assertFalse(isInFrontOf());
		assertEquals("|Hallo|Welt*|", toString());
		assertEquals("Es existiert kein Folgeelement.", getNext());
		assertEquals("Hallo", getPrevious());
		
		//Element entfernen
		assertEquals("Welt", removeNext());
		assertEquals("|Hallo*|", toString());
		
		//Element entfernen
		assertEquals("Welt", setPrevious("Welt"));
		assertEquals("Welt", removePrev());
	}
}
