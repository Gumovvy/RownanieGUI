package com.rownanieguimenu.gumovvy;

public class RownanieKwadratowe {
	private double zmiennaA, zmiennaB, zmiennaC;
	private String rozwiazanie = "";

	public RownanieKwadratowe(double zmiennaA, double zmiennaB, double zmiennaC) {
		this.zmiennaA = zmiennaA;
		this.zmiennaB = zmiennaB;
		this.zmiennaC = zmiennaC;
	}

	String rozwiazanie() {
		double delta = Math.pow(zmiennaB, 2) - 4 * zmiennaA * zmiennaC;
		if (delta > 0) {
			double x1 = (-zmiennaB - Math.sqrt(delta)) / 2 * zmiennaA;
			double x2 = (-zmiennaB + Math.sqrt(delta)) / 2 * zmiennaA;
			rozwiazanie = "Rozwi¹zanie ma dwa pierwiastki, x1: " + Math.round(x1) + " oraz " + Math.round(x2);

		} else if (delta == 0) {
			double x1 = (-zmiennaB) / (2 * zmiennaA);
			rozwiazanie = "Rozwi¹zanie ma jeden pierwiastek, x1: " + Math.round(x1);
		} else if (delta < 0) {

			rozwiazanie = "Rozwi¹zanie nie ma pieriastkow";
		}

		return rozwiazanie;
	}

	public static void main(String[] args) {
		//RownanieKwadratowe row = new RownanieKwadratowe(1, 4, -4);
		//System.out.println(row.rozwiazanie());

	}

}
