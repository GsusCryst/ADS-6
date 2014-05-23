import linkedList.LinkedList;
import doubleLinkedList.DoubleLinkedList;
import queue.Queue;
import stack.Stack;

/**
 * 
 * @author Gsus Cryst
 * Info: Menu zur Benutzung von 
 * <code>LinkedList</code>, 
 * <code>DoubleLinkedList</code>,
 * <code>Queue</code> und <code>Stack</code>
 */
public class Main {

	/**
	 * Statische <code>boolean</code>, damit das Programm am laufen bleibt
	 */
	private static boolean inProgress;
	
	/**
	 * Hauptfehlermeldung
	 */
	private static final String MAIN_ERROR = 
			"Error! No such command or wrong number of parameters!";
	
	/**
	 * Startet Programm und bearbeitet Ein/Ausgabe auf der Konsole.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		inProgress = true;
		while (inProgress) {
			startMenu();
			String prompt = Terminal.askString("> ");
			String[] input = prompt.split(" ");
			if (input.length == 1) {
				switch (castInt(input[0])) {
				case 1:
					linkedList();
					break;
				case 2:
					doubleLinkedList();
					break;
				case 3:
					System.out.println("Sie müssen die "
							+ "Länge der Queue festlegen.");
					break;
				case 4:
					stack();
					break;
				case 5:
					System.exit(0);
				default:
					System.err.println(MAIN_ERROR);
					break;
				}
			} else if (input.length == 2) {
				if (castInt(input[0]) == 3) {
					if (castInt(input[1]) > 0) {
						queue(castInt(input[1]));
					} else {
						System.err.println(MAIN_ERROR);
					}
				}
			}
		}
	}
	
	/**
	 * Gibt ein Startmenu auf der Konsole aus.
	 */
	private static void startMenu() {
		System.out.println("Wählen sie Ihre Liste!");
		System.out.println("1 - Einfach verkettete Liste");
		System.out.println("2 - Doppelt verkettete Liste");
		System.out.println("3 \"Länge\"- Queue");
		System.out.println("4 - Stack");
		System.out.println("5 - Beenden");
	}
	
	/**
	 * Parset einen <code>String</code> zu einem 
	 * <code>Integer</code> und gibt diesen zurück.
	 * 
	 * @param s <code>String</code> der in <code>Integer</code> 
	 * geparset werden soll
	 * @return 0 oder geparseten <code>String</code>-Wert
	 */
	private static int castInt(String s) {
		int i = -1;
		try {
			i = Integer.parseInt(s);
		} catch (Exception e) {
			System.out.print("");
		}
		return i;
	}
	
	/**
	 * Bearbeitet Ein/Ausgabe bei einer <code>linkedList</code>.
	 */
	private static void linkedList() {
		LinkedList l = new LinkedList();
		while (inProgress) {
			lLMenu();
			String prompt = Terminal.askString("> ");
			String[] input = prompt.split(" ");
			switch (input.length) {
			case 1:
				switch(castInt(input[0])) {
				case 3:
					System.out.println(l.getNext());
					break;
				case 4:
					System.out.println(l.getPrevious());
					break;
				case 5:
					l.removeNext();
					break;
				case 6:
					l.removePrev();
					break;
				case 7:
					System.out.println(l.toString());
					break;
				case 8:
					return;
				default:
					System.err.println(MAIN_ERROR);
					break;
				}
			case 2:
				switch(castInt(input[0])) {
				case 1:
					l.setNext(input[1]);
					break;
				case 2:
					l.setPrevious(input[1]);
					break;
				default:
					System.err.println(MAIN_ERROR);
					break;
				}
			default:
				System.err.println(MAIN_ERROR);
				break;
			}
		}
	}

	/**
	 * Menu bei einer <code>linkedList</code>.
	 */
	private static void lLMenu() {
		System.out.println("Einfach verkettete Liste");
		System.out.println("1 \"String\" - Setze nächstes Element");
		System.out.println("2 \"String\" - Setze vorheriges Element");
		System.out.println("3 - Gib nächstes Element");
		System.out.println("4 - Gib vorheriges Element");
		System.out.println("5 - Entferne nächstes Element");
		System.out.println("6 - Entferne vorheriges Element");
		System.out.println("7 - Gib Liste aus");
		System.out.println("8 - Beenden");
	}
	
	/**
	 * Bearbeitet Ein/Ausgabe bei einer <code>doubleLinkedList</code>.
	 */
	private static void doubleLinkedList() {
		DoubleLinkedList l = new DoubleLinkedList();
		while (inProgress) {
			lLMenu();
			String prompt = Terminal.askString("> ");
			String[] input = prompt.split(" ");
			switch (input.length) {
			case 1:
				switch(castInt(input[0])) {
				case 3:
					l.getNext();
					break;
				case 4:
					l.getPrevious();
					break;
				case 5:
					l.removeNext();
					break;
				case 6:
					l.removePrev();
					break;
				case 7:
					System.out.println(l.toString());
					break;
				case 8:
					return;
				default:
					System.err.println(MAIN_ERROR);
					break;
				}
			case 2:
				switch(castInt(input[0])) {
				case 1:
					l.setNext(input[1]);
					break;
				case 2:
					l.setPrevious(input[1]);
					break;
				default:
					System.err.println(MAIN_ERROR);
					break;
				}
			default:
				System.err.println(MAIN_ERROR);
				break;
			}
		}
	}
	
	/**
	 * Bearbeitet Ein/Ausgabe bei einer <code>Queue</code>.
	 */
	private static void queue(int length) {
		Queue q = new Queue(length);
		while (inProgress) {
			qMenu();
			String prompt = Terminal.askString("> ");
			String[] input = prompt.split(" ");
			switch (input.length) {
			case 1:
				switch(castInt(input[0])) {
				case 2:
					System.out.println(q.dequeue());
					break;
				case 3:
					if (q.isEmpty()) {
						System.out.println("Queue ist leer!");
					} else {
						System.out.println("Queue enthält Elemente");
					}
					break;
				case 4:
					System.out.println(q.toString());
					break;
				case 5:
					return;
				default:
					System.err.println(MAIN_ERROR);
					break;
				}
			case 2:
				switch(castInt(input[0])) {
				case 1:
					q.enqueue(input[1]);
					break;
				default:
					System.err.println(MAIN_ERROR);
					break;
				}
			default:
				System.err.println(MAIN_ERROR);
				break;
			}
		}
	}
	
	/**
	 * Menu bei einer <code>Queue</code>.
	 */
	private static void qMenu() {
		System.out.println("Queue");
		System.out.println("1 \"String\" - Füge Element hinzu");
		System.out.println("2 - Entferne und zeige Element");
		System.out.println("3 - Ist Queue leer");
		System.out.println("4 - Gib Queue aus");
		System.out.println("5 - Beenden");
	}
	
	/**
	 * Bearbeitet Ein/Ausgabe bei einem <code>Stack</code>.
	 */
	private static void stack() {
		Stack s = new Stack();
		while (inProgress) {
			sMenu();
			String prompt = Terminal.askString("> ");
			String[] input = prompt.split(" ");
			switch (input.length) {
			case 1:
				switch(castInt(input[0])) {
				case 2:
					System.out.println(s.pop());
					break;
				case 3:
					System.out.println(s.top());
					break;
				case 4:
					if (s.isEmpty()) {
						System.out.println("Stack ist leer!");
					} else {
						System.out.println("Stack enthält Elemente");
					}
					break;
				case 5:
					System.out.println(s.toString());
					break;
				case 6:
					return;
				default:
					System.err.println(MAIN_ERROR);
					break;
				}
			case 2:
				switch(castInt(input[0])) {
				case 1:
					s.push(input[1]);
					break;
				default:
					System.err.println(MAIN_ERROR);
					break;
				}
			default:
				System.err.println(MAIN_ERROR);
				break;
			}
		}
	}
	
	/**
	 * Menu bei einem<code>Stack</code>.
	 */
	private static void sMenu() {
		System.out.println("Stack");
		System.out.println("1 \"String\" - Lege auf Stack");
		System.out.println("2 - Entferne Element");
		System.out.println("3 - Zeige Element");
		System.out.println("4 - Ist Stack leer");
		System.out.println("5 - Gib Stack aus");
		System.out.println("6 - Beenden");
	}

}
