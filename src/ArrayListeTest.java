import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArrayListeTest {

	ArrayListe<String> liste;

	public ArrayListeTest() {
		liste = new ArrayListe<String>();
		liste.hinzufuegen("eins");
		liste.hinzufuegen("zwei");
		liste.hinzufuegen("drei");
		liste.hinzufuegen("vier");
		liste.hinzufuegen("fünf");
	}

//	@Test
//	void testMain() {
//		fail("Not yet implemented");
//	}

//	@Test
//	void testArrayListe() {
//		fail("Not yet implemented");
//	}

	@Test
	void testHinzufuegen() {
		liste.hinzufuegen("eins");
		liste.hinzufuegen("zwei");
		liste.hinzufuegen("drei");
		liste.hinzufuegen("vier");
		liste.hinzufuegen("fünf");
		liste.hinzufuegen("sechs");
		liste.hinzufuegen("sieben");
		liste.hinzufuegen("acht");
		liste.hinzufuegen("neun");
		liste.hinzufuegen("zehn");
		liste.hinzufuegen("elf");
		assertEquals(16, liste.getAnzahlElemente());
	}

	@Test
	void testGet() {
		assertEquals("eins", liste.get(0));
		assertEquals(null, liste.get(5));
	}

	@Test
	void testEntfernen() {
		liste.entfernen("vir");
		assertEquals(5, liste.getAnzahlElemente());
		liste.entfernen("vier");
		assertEquals(4, liste.getAnzahlElemente());
		assertEquals("fünf", liste.get(3));
		

	}

	@Test
	void testEntferneElementAnIndex() {
		liste.entferneElementAnIndex(2);
		assertEquals(4, liste.getAnzahlElemente());
		assertEquals("vier", liste.get(2));
	}

	@Test
	void testGetAnzahlElemente() {
		assertEquals(5, liste.getAnzahlElemente());
		liste.hinzufuegen("sechs");
		assertEquals(6, liste.getAnzahlElemente());
	}

	@Test
	void testToString() {
		assertEquals("eins\nzwei\ndrei\nvier\nfünf\n", liste.toString());

	}

	@Test
	void testGetKleinstesElement() {
		assertEquals("zwei", liste.getKleinstesElement());
	}

//	@Test
//	void testSetAnzahlElemente() {
//		fail("Not yet implemented");
//	}

}
