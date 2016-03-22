package ball.model;

import ball.Behavior;
import ball.ui.BallWorld;

public class Bouncing implements Behavior {
    static final int DOWN = 1;
    static final int UP = -1;
    public static final int MOVEMENT_SPEED = 12;

    public Bouncing(int direction) {
        this.direction = direction;
    }

    private int direction;

    @Override
    public void update(BallImpl ball) {
        direction = reverseDirectionIfNecessary(ball);
        ball.setY(move(ball));
    }

    private int reverseDirectionIfNecessary(BallImpl ball) {
        if (movingTooHigh(ball) || movingTooLow(ball)) {
            return switchDirection();
        }
        return direction;
    }

    private boolean movingTooLow(BallImpl ball) {
        return ball.getY() + ball.getRadius() >= BallWorld.BOX_HEIGHT && movingDown();
    }

    private boolean movingTooHigh(BallImpl ball) {
        return ball.getY() - ball.getRadius() <= 0 && movingUp();
    }

    private int switchDirection() {
        return movingDown() ? UP : DOWN;
    }

    private int move(BallImpl ball) {
        return ball.getY() + (MOVEMENT_SPEED * direction);
    }

    private boolean movingDown() {
        return direction == DOWN;
    }

    private boolean movingUp() {
        return direction == UP;
    }
}
