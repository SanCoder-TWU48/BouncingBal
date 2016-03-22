package ball.model;

import ball.Ball;
import ball.Behavior;

import java.awt.*;
import java.util.*;
import java.util.List;

public class BallImpl implements Ball {
    protected int x;
    protected int y;
    protected int radius;
    private List<Behavior> behaviours;

    protected BallImpl(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        behaviours = new ArrayList<>();
    }

    protected BallImpl(int x, int y) {
        this(x, y, DEFAULT_RADIUS);
    }

    // DO NOT CHANGE
    @Override
    public int radius() {
        return radius;
    }

    // DO NOT CHANGE
    @Override
    public Point center() {
        return new Point(x, y);
    }

    @Override
    public void update() {
        for (Behavior behaviour : behaviours) {
            behaviour.update(this);
        }
    }

    int getY() {
        return y;
    }

    int getRadius() {
        return radius;
    }

    void setY(int y) {
        this.y = y;
    }

    void setRadius(int radius) {
         this.radius = radius;
    }

    public void applies(Behavior behaviour) {
        behaviours.add(behaviour);
    }
}
