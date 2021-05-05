import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TestBall {
    @Test
    fun createBall() {
        val ball = Ball(Position(10,10),Motion(2,3),5)
        val txt = ball.toString()
        assertEquals("Ball(position=Position(x=10, y=10), motion=Motion(dx=2, dy=3), radius=5)",txt,"Create Ball")
    }
    @Test
    fun moveBall() {
        val ball = Ball(Position(10,10),Motion(2,3),5)
        val b = ball.move(100,50)
        assertEquals(Position(12,13),b.position,"verify ball position")
        assertEquals(ball.motion,b.motion,"verify ball motion")
    }
    @Test
    fun moveBallCollide() {
        val ball = Ball(Position(10,10),Motion(2,3),5)
        val b = ball.move(100,12)
        assertEquals(Position(12,13),b.position,"verify ball position")
        assertEquals(Motion(2,-3),b.motion,"verify ball motion")
    }
    @Test
    fun processKeyBall_KeyR() {
        val ball = Ball(Position(10,10),Motion(2,3),5)
        val b = ball.processKey('R')
        assertEquals(6,b.radius)
        val b2 = ball.copy( radius = RADIUS_LIMITS.last )
        val b3 = b2.processKey('R')
        assertEquals(b2.radius,b3.radius)
    }
}