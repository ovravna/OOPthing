package Asteroids;

//import java.util.*;

import javafx.geometry.Point2D;

public class AsteroidsMain {
    public static void main(String[] args) {
        SpaceObject kake = new SpaceObject(Point2D.ZERO, 100, 0,0, 1, 1);

        System.out.println(kake.getPoints());

        System.out.println(kake.position);


        SpaceObject bolle = new SpaceObject(Point2D.ZERO, 10, 0, 0, 1, 1);

        SpaceObject deig = new SpaceObject(new Point2D(3, 3), 10, 0, 0, 1, 1);

        System.out.println(kake.intersects(deig));



//        SpaceObject obj = new SpaceObject(new Point2D(0, 0), 10);
//        for (int i = 0;i < 10;i++) {
//            obj.applyForce(i, i-3);
//            obj.tick();
//            System.out.println(obj.speed);
//        }
//
//        for (int i = 0;i < 5;i++) {
//            obj.tick();
//            System.out.println(obj.speed);
//        }
//        System.out.println(obj.G);




    }
}
