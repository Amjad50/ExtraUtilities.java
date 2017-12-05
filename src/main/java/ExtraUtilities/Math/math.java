package ExtraUtilities.Math;

public class math{

	public static double round(double input, int decimalPlaces){
		double multiplier = Math.pow(10, decimalPlaces);
		input *= multiplier;
		input = Math.round(input);
		return input / multiplier;
	}
}
