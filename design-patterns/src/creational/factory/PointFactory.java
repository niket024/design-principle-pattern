package creational.factory;

enum CoordinateSystem {
	CARTESIAN, POLAR
}

class Point {
	private double x, y;

	protected Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point(double a, double b, // names do not communicate intent
			CoordinateSystem cs) {
		switch (cs) {
		case CARTESIAN:
			this.x = a;
			this.y = b;
			break;
		case POLAR:
			this.x = a * Math.cos(b);
			this.y = a * Math.sin(b);
			break;
		}
	}

	// steps to add a new system
	// 1. augment CoordinateSystem
	// 2. change ctor

	// singleton field
	public static final Point ORIGIN = new Point(0, 0);

	// factory method
	public static Point newCartesianPoint(double x, double y) {
		return new Point(x, y);
	}

	public static Point newPolarPoint(double rho, double theta) {
		return new Point(rho * Math.cos(theta), rho * Math.sin(theta));
	}

	public static class Factory {
		public static Point newCartesianPoint(double x, double y) {
			return new Point(x, y);
		}
	}
}

class PointFactory {
	public static Point newCartesianPoint(double x, double y) {
		return new Point(x, y);
	}
}

class FactoryDemo {
	public static void main(String[] args) {
		
		//1st way which is violating the clean coding principles, writing logic in constructor
		Point point = new Point(2, 3, CoordinateSystem.CARTESIAN);
		
		Point origin = Point.ORIGIN;
		
		//creating separate factory class but here constructor cannot be private
		Point point2 = PointFactory.newCartesianPoint(0.6, 5.6);
		
		//creating inner static factory class but here constructor can be private
		Point point1 = Point.Factory.newCartesianPoint(1, 2);
	}
}
