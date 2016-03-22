package ball.model;

import ball.Ball;
import ball.Behavior;

public class BallFactory {

    public static Ball[] all() {
        return new Ball[]{
                bouncingBall(75, 50, Bouncing.DOWN),
                elasticBall(250, 100, Ball.DEFAULT_RADIUS, Elastic.SHRINK),
                elasticBouncingBall(250, 100, Ball.DEFAULT_RADIUS, Bouncing.DOWN, Elastic.SHRINK)
        };
    }

    public static Ball bouncingBall(int centerX, int centerY, int direction) {
        Ball bouncingBall = new BallImpl(centerX, centerY);
        Behavior bouncing = new Bouncing(direction);
        bouncingBall.applies(bouncing);
        return bouncingBall;
    }

    public static Ball elasticBall(int centerX, int centerY, int radius, int direction) {
        Ball elasticBall = new BallImpl(centerX, centerY, radius);
        Behavior elastic = new Elastic(direction);
        elasticBall.applies(elastic);
        return elasticBall;
    }

    public static Ball elasticBouncingBall(int centerX, int centerY, int radius, int yDirection, int zDirection) {
        Ball elasticBouncingBall = new BallImpl(centerX, centerY, radius);
        Behavior bouncing = new Bouncing(yDirection);
        Behavior elastic = new Elastic(zDirection);
        elasticBouncingBall.applies(bouncing);
        elasticBouncingBall.applies(elastic);
        return elasticBouncingBall;
    }
}
