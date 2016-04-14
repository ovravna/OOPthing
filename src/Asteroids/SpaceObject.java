package Asteroids;

//import java.util.*;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;


public class SpaceObject extends BaseSpaceObject{
    protected static List<SpaceObject> universe = new ArrayList<>();


    public SpaceObject(Point2D position, double mass, double... points) {
        super(points);
        this.position = position;
        this.mass = mass;
        this.speed = new Point2D(0, 0);
        universe.add(this);

    }

//    public void addToUniverse(SpaceObject... objects) {
//        for (SpaceObject object:objects) {
//            this.universe.add(object);
//        }
//    }

    public double getMass() {
        return mass;
    }

    public Point2D getSpeed() {
        return speed;
    }

    public void setSpeed(double vx, double vy) {
        this.speed = new Point2D(vx, vy);
    }

    public void accelerate(double ax, double ay) {
        double vx = ax+speed.getX();
        double vy = ay+speed.getY();
        speed = new Point2D(vx, vy);
    }

    public void applyForce(double fx, double fy) {
        if (mass == 0) throw new IllegalStateException("Object has no mass");

        double vx = fx/mass+speed.getX();
        double vy = fy/mass+speed.getY();
        speed = new Point2D(vx, vy);
    }

    public double distanceTo(SpaceObject object) {
        return position.distance(object.getPosition());
    }

    public boolean intersects(SpaceObject object) {
        for (double i : this.getPoints()) {
            for (double j : object.getPoints()) {
                System.out.println(i+" "+j);
            }

        }


        return intersect(this, object) != null;
    }

    public void doGravity() {
        if (universe.size() < 2) return;
        if (universe.size() == 2) {
            double F;
            double massProduct = universe.stream().mapToDouble(SpaceObject::getMass).reduce(1, (n, m) -> n*m);
            double distansePow = Math.pow(universe.get(0).distanceTo(universe.get(1)),2);
            F = G*massProduct/distansePow;

        }




    }

    public void tick() {
        position = position.add(speed);



    }


}




















