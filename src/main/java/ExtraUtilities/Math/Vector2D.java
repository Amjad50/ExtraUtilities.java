package ExtraUtilities.Math;

public class Vector2D {

	public static final int RADIANS = 0, DEGREES = 1;

	private double x, y, size, angle;
	private boolean usingDegrees = true;

	/**
	 * Empty constructor.<br>
	 *
	 * <b>x</b> and <b>y</b> properties will be equal to zero.<br>
	 * The default angle measurement type is Degrees.
	 */
	public Vector2D(){
		this.x = 0;
		this.y = 0;
		recalculate();
	}

	/**
	 * constructor with values <b>x</b> and <b>y</b>.<br>
	 * The default angle measurement type is Degrees.
	 *
	 * @param x <b>x</b> position on the grid.
	 * @param y <b>y</b> position on the grid.
	 */
	public Vector2D(double x, double y){
		this.x = x;
		this.y = y;
		recalculate();
	}

	/**
	 * constructor with values <b>x</b> and <b>y</b> and angle measurement type.
	 *
	 * @param x <b>x</b> position on the grid.
	 * @param y <b>y</b> position on the grid.
	 * @param DegreesOrRadians Degrees ore Radians for the angle measurement type.
	 */
	public Vector2D(double x, double y, int DegreesOrRadians){
		this.x = x;
		this.y = y;
		this.recalculate();
		this.setAngleType(DegreesOrRadians);
	}

	/**
	 * Setting the preferable angle measurement type.
	 * @param type Degrees or Radians for angle measurement type.
	 */
	public void setAngleType(int type){
		if (type == 0) {usingDegrees = false; return;}
		usingDegrees = true;
	}

	/**
	 *
	 * @param other Other <code>Vector</code> to add to this vector.
	 * @return A new <code>Vector</code> with the sum of this vector and other vector.
	 */
	public Vector2D add(Vector2D other){
		return new Vector2D(this.x + other.x, this.y + other.y);
	}

	public Vector2D sub(Vector2D other){
		return new Vector2D(this.x - other.x, this.y - other.y);
	}

	public double dotProduct(Vector2D other){
		return (this.x * other.x) + (this.y * other.y);
	}

	public double angleBetween(Vector2D other){
		if (usingDegrees) return math.round(Math.toDegrees(Math.acos(this.dotProduct(other) / (this.size * other.size))), 5);
		else return math.round(Math.acos(this.dotProduct(other) / (this.size * other.size)), 7);
	}

	public boolean areOrthogonal(Vector2D other){
		return dotProduct(other) == 0;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
		recalculate();
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
		recalculate();
	}

	public double getSize() {
		return size;
	}

	public double getAngle() {
		return angle;
	}

	@Override
	public String toString() {
		return "Vector2D{" +
				"x=" + x +
				", y=" + y +
				", size=" + size +
				", angle=" + angle +
				'}';
	}

	private void recalculate(){
		this.size = Math.hypot(this.x, this.y);

		if (usingDegrees){
			if (this.x > 0) this.angle = Math.toDegrees(Math.atan(this.y / this.x));
			if (this.x < 0) this.angle = Math.toDegrees(Math.atan(this.y / this.x) + Math.PI);
			if (this.x == 0) this.angle = this.angleBetween(new Vector2D(1, 0, DEGREES));
			this.angle = math.round(this.angle, 5);
		}

		if (!usingDegrees){
			if (this.x > 0) this.angle = Math.atan(this.y / this.x);
			if (this.x < 0) this.angle = Math.atan(this.y / this.x) + Math.PI;
			if (this.x == 0) this.angle = angleBetween(new Vector2D(1, 0, RADIANS));
			this.angle = math.round(this.angle, 7);
		}

		if (this.angle > 180){
			this.angle = -360 + this.angle;
		}
	}
}
