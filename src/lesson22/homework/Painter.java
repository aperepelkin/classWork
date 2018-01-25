package lesson22.homework;

import lesson20.Point;

// TODO нужно с помощью данного интерфейса сделать рисование квадрата
// TODO сделать текстовую реализацию данного интерфейса, 
// т.е. при попытки нарисовать линию просто выводим на экран линия из точки ... в точку ... 
public interface Painter {
	// служит для отрисовки линий
	void drawline(Point from, Point to);
}
