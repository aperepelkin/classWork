package lesson20.homework;

import lesson20.Point;

public class Task01 {

    public static void main(String[] args) {
        Square s1 = new Square(new Point(0,0), new Point(10, 10));
        //TODO при печати на экран должно быть выведено сообщение в виде:
        // Квадрат
        /*
            (0,10) --- (10,10)
            |                |
            |                |
            |                |
            (0,0)  ---  (10,0)
         */
        System.out.println(s1);
    }
}
