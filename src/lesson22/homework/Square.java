package lesson22.homework;

import lesson20.Point;

public class Square implements Figure {
	
	private Point bottomLeft;
	private Point bottomRight;
	private Point topRight;
	private Point topLeft;

	public Square(Point bottomLeft, Point topRight) 
			throws InvalidFigureException {
        // TODO определить создание квадрата по двум точкам,
        // TODO при этом если точки заданы не корректно сообщение об этом на экран
    	if(topRight.x - bottomLeft.x != topRight.y - bottomLeft.y) {
    		throw new InvalidFigureException(
    				topRight.x - bottomLeft.x,
    				topRight.y - bottomLeft.y);
    	}
    	this.bottomLeft = bottomLeft;
    	this.topRight = topRight;
    	this.bottomRight = new Point(topRight.x, bottomLeft.y);
    	this.topLeft = new Point(bottomLeft.x, topRight.y);
    }

    public Square(Point bottomLeft, Integer sideLength) {
    	this.bottomLeft = bottomLeft;
    	this.bottomRight = new Point(bottomLeft.x + sideLength, bottomLeft.y);
    }

    public Point getTopLeft() {
        // TODO возврат координаты верхнего левого угла
        return topLeft;
    }

    public Point getTopRigth() {
        // TODO возврат координаты верхнего правого угла
        return topRight;
    }

    public Point getBottomLeft() {
        // TODO возврат координаты нижнего левого угла
        return bottomLeft;
    }

    public Point getBottomRight() {
        // TODO возврат координаты нижнего правого угла
        return bottomRight;
    }

    public void setTopLeft(Point point) {
        // TODO изменение положения координаты левого верхнего угла
        // TODO весь квадрат должен сдвинуться относительно этого угла
    }

    public void setTopRight(Point point) {
        // TODO также как и для setTopLeft только для правого верхнего угла
    }

    public void setBottomLeft(Point point) {
        // TODO также как и для setTopLeft только для левого нижнего угла
    }

    public void setBottomRight(Point point) {
        // TODO также как и для setTopLeft только для правого нижнего угла
    }
    
	@Override
	public void draw(Painter painter) {
		painter.drawline(getBottomLeft(), getTopLeft());
		painter.drawline(getTopLeft(), getTopRigth());
		painter.drawline(getTopRigth(), getBottomRight());
		painter.drawline(getBottomRight(), getBottomLeft());
	}
}
