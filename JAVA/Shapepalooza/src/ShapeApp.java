abstract class Shape
{	
	private int x;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	private int y;
	public abstract double calcArea();
	public abstract double calcPerim();
	public Shape()
	{
		x = 0;
		y = 0;
	}
	public Shape(int x, int y)
	{
		setX(x);
		setY(y);
	}
	public String getShapeType()
	{
		return "Shape";
	}
	@Override
	public String toString()
	{
		return String.format("%s %d %d", getShapeType(),x,y);
	}
}

class Circle extends Shape{
	private int radius;
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getRadius() {
		return radius;
	}
	@Override
	public double calcPerim() {
		return 2 * Math.PI * radius; 
	}
	@Override
	public double calcArea() {
		return Math.PI * radius * radius;
	}
	public Circle()
	{	
		radius = 0;
	}
	public Circle(int x,int y, int radius)
	{
		super(x,y);
		setRadius(radius);
	}
	
	@Override 
	public String toString() {
		return String.format("%s %d",super.toString(), radius);
	}
	
}

public class ShapeApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle defCirc = new Circle();
		Circle custCirc = new Circle(5,7,12);
		
		System.out.println(defCirc);
		System.out.println(custCirc);
	}

}
