package seminar07;

public class ComplexNumber implements Number {
	
	private double real;
	private double imaginary;
	
	public ComplexNumber(double realPart, double imaginaryPart) {
		this.real = realPart;
		this.imaginary = imaginaryPart;
	}

	public ComplexNumber(double realPart) {
		this(realPart, 0.0);
	}
	
	public double getReal() {
		return real;
	}
	
	public double getImaginary() {
		return imaginary;
	}

	@Override
	public ComplexNumber add(Number b) {
		ComplexNumber n = (ComplexNumber) b;
		return new ComplexNumber(real + n.real, 
				imaginary + n.imaginary);
	}

	@Override
	public Number sub(Number b) {
		ComplexNumber n = (ComplexNumber) b;
		return new ComplexNumber(real - n.real, 
				imaginary - n.imaginary);
	}

	@Override
	public Number mul(Number b) {
		ComplexNumber n = (ComplexNumber) b;
		return new ComplexNumber(real * n.real - imaginary * n.imaginary,
								 imaginary * n.real + real * n.imaginary);
	}

	@Override
	public Number div(Number b) {
		ComplexNumber n = (ComplexNumber) b;
		double divisor = n.imaginary * n.imaginary + n.real * n.real;
		return new ComplexNumber((real * n.real + imaginary * n.imaginary) / divisor,
							     (imaginary * n.real - real * n.imaginary) / divisor);
	}
	
	@Override
	public String toString() {
		return "" + real + (imaginary == 0.0 ? "" : " + " + imaginary + "i");
	}

}
