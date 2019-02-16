interface Shape{
	public void draw();
}

class Square implements Shape{
	@Override
	public void draw() {
		System.out.println("Square");
		
	}
	
}

class Rectangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Rectangle");
		
	}
	
}

class Triangle implements Shape{

	@Override
	public void draw() {
		System.out.println("Triangle");
		
	}
	
}

class Circle implements Shape{

	@Override
	public void draw() {
		System.out.println("Circle");
		
	}
	
}

abstract class AbstractFactorys{
	
	abstract Shape getShape(String shape);
}

class ShapeFactory extends AbstractFactorys{

	@Override
	Shape getShape(String shape) {
		
		if(shape.equalsIgnoreCase("CIRCLE")) {
			return new Circle();
		}
		else if(shape.equalsIgnoreCase("SQUARE")) {
			return new Square();
		}
		else if(shape.equalsIgnoreCase("RECTANGLE")) {
			return new Rectangle();
		}
		else if(shape.equalsIgnoreCase("TRIANGLE")) {
			return new Triangle();
		}
		else {
			return null;
		}
	}
	
}

public class AbstractFactory {
	
	public static void main(String[] args) {
		
		AbstractFactorys shapeFactory = new ShapeFactory();
		
		Shape circle = shapeFactory.getShape("Circle");
		Shape square = shapeFactory.getShape("square");
		Shape rectangle = shapeFactory.getShape("RectangLE");
		Shape triangle = shapeFactory.getShape("Triangle");
		
		circle.draw();
		rectangle.draw();
		square.draw();
	}

}
