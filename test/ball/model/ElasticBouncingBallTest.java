package ball.model;

import ball.Ball;
import ball.ui.BallWorld;
import org.junit.Test;

import static ball.BallTestHarness.*;

public class ElasticBouncingBallTest {
    @Test
    public void shouldGoDown() throws Exception {
        Ball elasticBouncingBall = BallFactory.elasticBouncingBall(0, 100, Ball.DEFAULT_RADIUS, Bouncing.DOWN, Elastic.SHRINK);

        elasticBouncingBall.update();

        assertCenterYCoordinateIs(oneStepDownFrom(100), elasticBouncingBall);
    }

    @Test
    public void shouldGoUpAfterHittingTheBottom() throws Exception {
        int theBottomEdge = BallWorld.BOX_HEIGHT - Ball.DEFAULT_RADIUS;
        Ball elasticBouncingBall = BallFactory.elasticBouncingBall(0, theBottomEdge, Ball.DEFAULT_RADIUS, Bouncing.DOWN, Elastic.SHRINK);

        elasticBouncingBall.update();

        assertCenterYCoordinateIs(oneStepUpFrom(theBottomEdge), elasticBouncingBall);
    }

    @Test
    public void shouldGoUp() throws Exception {
        Ball elasticBouncingBall = BallFactory.elasticBouncingBall(0, 100, Ball.DEFAULT_RADIUS, Bouncing.UP, Elastic.SHRINK);

        elasticBouncingBall.update();

        assertCenterYCoordinateIs(oneStepUpFrom(100), elasticBouncingBall);
    }

    @Test
    public void shouldGoDownAfterHittingTheTop() throws Exception {
        int theTopEdge = Ball.DEFAULT_RADIUS;
        Ball elasticBouncingBall = BallFactory.elasticBouncingBall(0, theTopEdge, Ball.DEFAULT_RADIUS, Bouncing.UP, Elastic.SHRINK);

        elasticBouncingBall.update();

        assertCenterYCoordinateIs(oneStepDownFrom(theTopEdge), elasticBouncingBall);
    }

    @Test
    public void shouldDecreaseRadius() {
        Ball elasticBouncingBall = BallFactory.elasticBouncingBall(0, 0, 20, Bouncing.UP, Elastic.SHRINK);

        elasticBouncingBall.update();

        assertRadiusIs(oneStepInwardsFrom(20), elasticBouncingBall);
    }

    @Test
    public void shouldIncreaseRadiusAfterFullyShrinking() throws Exception {
        Ball elasticBouncingBall = BallFactory.elasticBouncingBall(0, 0, 0, Bouncing.UP, Elastic.SHRINK);

        elasticBouncingBall.update();

        assertRadiusIs(oneStepOutwardsFrom(0), elasticBouncingBall);
    }

    @Test
    public void shouldIncreaseInSize() {
        Ball elasticBouncingBall = BallFactory.elasticBouncingBall(250, 100, 20, Bouncing.UP, Elastic.GROW);

        elasticBouncingBall.update();

        assertRadiusIs(oneStepOutwardsFrom(20), elasticBouncingBall);
    }

    @Test
    public void shouldDecreaseInSizeAfterFullyExpanding() throws Exception {
        Ball elasticBouncingBall = BallFactory.elasticBouncingBall(0, 0, Ball.DEFAULT_RADIUS, Bouncing.UP, Elastic.GROW);

        elasticBouncingBall.update();

        assertRadiusIs(oneStepInwardsFrom(Ball.DEFAULT_RADIUS), elasticBouncingBall);
    }


}
