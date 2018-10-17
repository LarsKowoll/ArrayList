/**
 * @author Philip Zirfaﬂ
 * @author Lars Kowoll
 * 
 * @version 1.0
 */

import junit.framework.ComparisonCompactor;

public class ArrayListe<T extends Comparable<T>> {
	private int anzahlElemente;
	private static Object[] elemente;

	public static void main(String[] args) {
		ArrayListe<String> liste = new ArrayListe<String>();
		ArrayListeZahl.zahlAmAnfang(elemente);
	}

	public ArrayListe(int laengeDesArrays) {
		setAnzahlElemente(0);
		elemente = new Object[laengeDesArrays];
	}
	
	public ArrayListe() {
		setAnzahlElemente(0);
		elemente = new Object[10];
	}

	public void hinzufuegen(T element) {
		try {

			for (int i = 0; i < elemente.length; i++) {
				if (istVoll()) {
					Object[] tmp = new Object[elemente.length * 2];
					System.arraycopy(elemente, 0, tmp, 0, elemente.length);
					elemente = tmp;
				}

				if (elemente[i] == null) {

					elemente[i] = element;
					anzahlElemente++;
					break;
				}

			}
		} catch (IndexOutOfBoundsException e) {
			System.out.print("IndexOutOfBoundsException caught \n");
		}

	}

/**
 * 
 * @param index
 * @return
 */
	public T get(int index) {
		if (index >= 0 && index <= elemente.length) {
			return (T) elemente[index];
		}

		return null;

	}

	public void entfernen(T element) {
		try {
			for (int i = 0; i < elemente.length - 1; i++) {
				if (elemente[i].equals(element)) {
					elemente[i] = null;
					verschieben(i);
					anzahlElemente--;
					break;
				}
			}
		} catch (NullPointerException e) {
			System.out.print("NullPointerException caught \n");
		}

	}

	public void entferneElementAnIndex(int index) {
		if (index < elemente.length) {
			elemente[index] = null;
			verschieben(index);
			anzahlElemente--;
		}
	}
	
/**
 * @return ‹bergibt wie viele Elemente im Array sind
 */
	public int getAnzahlElemente() {
		return anzahlElemente;
	}

/**
 *  @return ‹bergibt den Inhalt des Arrays als String
 */
	@Override
	public String toString() {
		String ausgabe = "";
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] != null) {
				ausgabe += elemente[i] + "\n";
			}
		}
		System.out.println(ausgabe);

		return ausgabe;
	}
/**
 * @return Gibt das kleinste Element zur¸ck
 */
	public T getKleinstesElement() {
		if (elemente.length == 0) {
			return null;
		}

		T kleinstesElement = (T) elemente[0]; //Startpunkt

		for (int i = 1; i < elemente.length; i++) {
			if (elemente[i] != null) {
				int j = kleinstesElement.compareTo((T) elemente[i]);
				if (j < 0) { //Wenn die Methode compareTo eine Zahl kleiner als 0 zur¸ckliefert ist das neu ¸bergebene Element kleiner
					kleinstesElement = (T) elemente[i];
				}
			}

		}
		return kleinstesElement;

	}

/**
 *  Verschiebt das gesamte Array, damit keine "null" L¸cken im Array entstehen
 *  
 * @param index
 */
	private void verschieben(int index) {
		for (int i = index + 1; i < elemente.length; i++, index++) {
			elemente[index] = elemente[i];

			if (i == elemente.length - 1) {
				elemente[i] = null;
			}

		}

	}

	private void setAnzahlElemente(int anzahlElemente) {
		this.anzahlElemente = anzahlElemente;
	}
/**
 * 
 * @return true, wenn die Liste voll ist
 */
	private boolean istVoll() {
		return (elemente[elemente.length - 1] != null);

	}

}
