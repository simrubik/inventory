package annotation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class AssetSerieValidatorTest {

	public AssetSerieValidator validator;

	@Before
	public void init() {
		System.out.println("ceva");
		validator = new AssetSerieValidator();
	}

//	@Ignore
	@Test
	public void isValid_validSerie() {
		boolean valid = validator.isValid("1234  12/04/2016", null);
		Assert.assertEquals(true, valid);
	}

	@Test
	public void isValid_invalidSerie() {
		boolean valid = validator.isValid("1234  12/04/201gg6", null);
		Assert.assertEquals(false, valid);
	}
}
