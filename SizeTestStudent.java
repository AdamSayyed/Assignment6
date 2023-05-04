import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SizeTestStudent {

	@Test
	public void testSizeValues() {
		Size small = Size.SMALL;
		Size medium = Size.MEDIUM;
		Size large = Size.LARGE;

		assertEquals("SMALL", small.toString());
		assertEquals("MEDIUM", medium.toString());
		assertEquals("LARGE", large.toString());
	}

}
