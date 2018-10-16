import junit.framework.ComparisonCompactor;

public class ArrayListe<T extends Comparable<T>> {
	private int anzahlElemente;
	private static Object[] elemente;

	public static void main(String[] args) {
		ArrayListe<String> liste = new ArrayListe<String>();
		liste.hinzufuegen("eins");
		liste.hinzufuegen("zwei");
		liste.hinzufuegen("drei");
		liste.hinzufuegen("vier");
		liste.hinzufuegen("fünf");
		liste.entferneElementAnIndex(2);
		liste.toString();
		liste.getKleinstesElement();
		ArrayListeZahl.zahlAmAnfang(elemente);
	}

	public ArrayListe() {
		setAnzahlElemente(0);
		elemente = new Object[10];
	}

	public void hinzufuegen(T element) {
		try {
			for (int i = 0; i < elemente.length; i++) {
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

	public int getAnzahlElemente() {
		return anzahlElemente;
	}

	@Override
	public String toString() {
		String ausgabe = "";
		for (int i = 0; i < elemente.length; i++) {
			if (elemente[i] != null) {
				ausgabe += elemente[i];
			}
		}
		System.out.println(ausgabe);

		return ausgabe;
	}

	public T getKleinstesElement() {
		if (elemente.length == 0) {
			return null;
		}

		T kleinstesElement = (T) elemente[0];

		for (int i = 1; i < elemente.length; i++) {
			if (elemente[i] != null) {
				int j = kleinstesElement.compareTo((T) elemente[i]);
				if (j < 0) {
					kleinstesElement = (T) elemente[i];
				}
			}

		}
		String x = kleinstesElement.toString();
		System.out.println(x);

		return kleinstesElement;

	}

	private void verschieben(int index) {
		for (int i = index + 1; i < elemente.length; i++, index++) {
			elemente[index] = elemente[i];

			if (i == elemente.length - 1) {
				elemente[i] = null;
			}

		}

	}

	public void setAnzahlElemente(int anzahlElemente) {
		this.anzahlElemente = anzahlElemente;
	}

}
