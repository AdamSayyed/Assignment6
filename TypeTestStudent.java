import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TypeTestStudent {

	@Test
	public void testGetName() {
		assertEquals("SMOOTHIE", TYPE.SMOOTHIE.toString());
		assertEquals("COFFEE", TYPE.COFFEE.toString());
		assertEquals("ALCOHOL", TYPE.ALCOHOL.toString());
	}
}
