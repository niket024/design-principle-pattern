package creational.factory;

//Here Pointer class cannot be initiated without the help of factory method.
class Pointer {
	private double x, y;

	private Pointer(double x, double y) {
		this.x = x;
		this.y = y;
	}

	static class PointerFacory {
		public static Pointer newCartesianPoint(double x, double y) {
			return new Pointer(x, y);
		}

		public static Pointer newPolarPoint(double rho, double theta) {
			return new Pointer(rho * Math.cos(theta), rho * Math.sin(theta));
		}

	}
}

public class PointFactroyDemo {
	public static void main(String[] args) {
		Pointer pointer = Pointer.PointerFacory.newCartesianPoint(2.3, 3.3);
		Pointer pointer1 = Pointer.PointerFacory.newPolarPoint(0.4, 34.3);
	}
}
