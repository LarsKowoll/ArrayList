/**
 * @author Philip Zirfa�
 * @author Lars Kowoll
 */

public class ArrayListeZahl extends Number {

	public static void main(String[] args) {

	}

	public ArrayListeZahl() {

	}

	/**
	 * Pr�ft ob am Index 0 eine Zahl steht f�r ein Array
	 */
	public static boolean zahlAmAnfang(Object[] elemente) {
		boolean result = false;
		if (elemente[0] != null)
		{
			if (elemente[0] instanceof Number)
			{
				result = true;
			}
		}
		System.out.println(result);
		return result;

	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}
}
