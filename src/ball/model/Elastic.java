package ball.model;

import ball.Ball;
import ball.Behavior;

public class Elastic implements Behavior {
    public static final int GROWTH_RATE = 2;

    static final int GROW = 1;
    static final int SHRINK = -1;

    private int direction;

    public Elastic(int direction) {
        this.direction = direction;
    }

    @Override
    public void update(BallImpl ball) {
        direction = reverseGrowthDirectionIfNecessary(ball);
        ball.setRadius(next(ball));
    }

    private int reverseGrowthDirectionIfNecessary(BallImpl ball) {
        if (growingTooBig(ball) || shrinkingTooSmall(ball)) {
            return switchDirection();
        }

        return this.direction;
    }

    private boolean shrinkingTooSmall(BallImpl ball) {
        return ball.getRadius() <= 0 && shrinking();
    }

    private boolean growingTooBig(BallImpl ball) {
        return ball.getRadius() >= Ball.DEFAULT_RADIUS && growing();
    }

    private int switchDirection() {
        return growing() ? SHRINK : GROW;
    }

    private int next(BallImpl ball) {
        return ball.getRadius() + (GROWTH_RATE * direction);
    }

    private boolean shrinking() {
        return direction == SHRINK;
    }

    private boolean growing() {
        return direction == GROW;
    }
}
