package oncogene;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

public class OncogeneTest
{
	private OncogeneDetector instance = new OncogeneDetector();
	
	ArrayList<String> healthySequences = new ArrayList<String>(
		Arrays.asList(
			new String[] {"TGCATCC", "AAATTTGGGCCC", "ATGCGCTA", "GGGTACGGAG", "TTAATTGGG"}
		)
	);

	ArrayList<String> cancerSequences = new ArrayList<String>(
		Arrays.asList(
			new String[] {"ATTTGCAGG", "TGCAAATTA", "AAAGGGCCCTTT", "TGCGATACGTAGGACCA", "ACTCATTAGTGC", "AAACGCTAGACACACAAG", "GGGGGGGGGGGG"}
		)
	);

	ArrayList<String> sequencesWithInvalidElement = new ArrayList<String>(
		Arrays.asList(
			new String[] {"ATTTGGG", "TGCGATTTA", "TGCGGHACCA", "ACTCATTAGTGC"}
		)
	);

	@Test
	public void testOncogeneDetectorWithTGC()
	{
		assertTrue(instance.isOncogene(healthySequences, cancerSequences, "TGC"));
	}

	@Test
	public void testOncogeneDetectorWithGGG()
	{
		assertFalse(instance.isOncogene(healthySequences, cancerSequences, "GGG"));
	}

	@Test
	public void testOncogeneDetectorWithEmptyCandiate()
	{
		assertFalse(instance.isOncogene(healthySequences, cancerSequences, ""));
	}
	
	// The following are extra credit tests, comment out the @Ignore to run them.
	//@Ignore
	@Test(expected = NullPointerException.class)
	public void level0ExtraCreditTestOncogeneDetectorWithNullHealthySequence()
	{
		instance.isOncogene(null, cancerSequences, "TGC");
	}
	
	//@Ignore
	@Test(expected = NullPointerException.class)
	public void level0ExtraCreditTestOncogeneDetectorWithNullCancerSequence()
	{
		instance.isOncogene(healthySequences, null, "TGC");
	}
	
	//@Ignore
	@Test
	public void level1ExtraCreditTestOncogeneDetectorWithEmptyHealthySequence()
	{
		try {
			instance.isOncogene(new ArrayList<>(), cancerSequences, "TGC");
			fail("IllegalArgumentException not thrown as expected");
		} catch (IllegalArgumentException e) {
			assertEquals("healthySequences must contain at least one element", e.getMessage());
		}
	}
	
	//@Ignore
	@Test
	public void level1ExtraCreditTestOncogeneDetectorWithEmptyCancerSequence()
	{
		try {
			instance.isOncogene(healthySequences, new ArrayList<>(), "TGC");
			fail("IllegalArgumentException not thrown as expected");
		} catch (IllegalArgumentException e) {
			assertEquals("cancerSequences must contain at least one element", e.getMessage());
		}
	}
	
	//@Ignore
	@Test
	public void level2ExtraCreditTestOncogeneDetectorWithInvalidCandidate()
	{
		try {
			instance.isOncogene(healthySequences, cancerSequences, "ABC");
			fail("IllegalArgumentException not thrown as expected");
		} catch (IllegalArgumentException e) {
			assertEquals("candidate must contain only the letters A, C, G or T", e.getMessage());
		}
	}
	
	
	//@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void level3ExtraCreditTestOncogeneDetectorWithInvalidHealthySequence()
	{
		instance.isOncogene(sequencesWithInvalidElement, cancerSequences, "TGC");
	}
	
	//@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void level3ExtraCreditTestOncogeneDetectorWithInvalidCancerSequence()
	{
		instance.isOncogene(healthySequences, sequencesWithInvalidElement, "TGC");
	}
}
