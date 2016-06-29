package annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AssetSerieValidator implements ConstraintValidator<AssetSerie, String> {

	@Override
	public void initialize(AssetSerie arg0) {
	}

	@Override
	public boolean isValid(String assetSerie, ConstraintValidatorContext ctx) {
		if (assetSerie == null) {
			return false;
		}

		// validate phone numbers of format "1234567890"
		
		return ("".equals(assetSerie) || assetSerie.matches("\\d+\\/? ? ?\\d{2}[/.-]?\\d{2}[/.-]?\\d{4}"));
		
		
//		if ("".equals(assetSerie) || assetSerie.matches("\\d+\\/? ? ?\\d{2}[/.-]?\\d{2}[/.-]?\\d{4}")) {
//			return true;
//		}
//
//		return false;

	}

}
