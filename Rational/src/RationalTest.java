import static org.junit.Assert.*;
import org.junit.Test;

public class RationalTest {
	
	@Test
	public void testConstructor() {
		try {
			new Rational();
			new Rational(1,2);
			new Rational(-10, -5);
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testAdd() throws Rational.Illegal {
		Rational r1 = new Rational(10, 20);
		Rational r2 = new Rational(2, 3);
		r1.add(r2);
		Rational r3 = new Rational(7, 6);
		assertEquals(r3, r1);
	}
	
	@Test
	public void testSubtract() throws Rational.Illegal {
		Rational r1 = new Rational(10, 20);
		Rational r2 = new Rational(2, 3);
		r1.subtract(r2);
		Rational r3 = new Rational(-1, 6);
		assertEquals(r3, r1);
	}
	
	@Test
	public void testMultiply() throws Rational.Illegal {
		Rational r1 = new Rational(10, 20);
		Rational r2 = new Rational(2, 3);
		r1.multiply(r2);
		Rational r3 = new Rational(1, 3);
		assertEquals(r3, r1);
	}
	
	@Test
	public void testDivide() throws Rational.Illegal {
		Rational r1 = new Rational(10, 20);
		Rational r2 = new Rational(2, 3);
		r1.divide(r2);
		Rational r3 = new Rational(3, 4);
		assertEquals(r3, r1);
	}

	@Test
	public void testEquals() throws Rational.Illegal {
		Rational r1 = new Rational(10, 20);
		Rational r2 = new Rational(2, 3);
		assertFalse(r1.equals(r2));
		Rational r3 = new Rational(2, 3);
		assertTrue(r2.equals(r3));
		assertEquals(r2, r3);
	}
	
	@Test
	public void testCompareTo() throws Rational.Illegal {
		Rational r1 = new Rational(10, 20);
		Rational r2 = new Rational(2, 3);
		Rational r3 = new Rational(2, 3);
		assertTrue(r1.compareTo(r2) == -1);
		assertTrue(r2.compareTo(r1) == 1);
		assertTrue(r2.compareTo(r3) == 0);
	}

}
