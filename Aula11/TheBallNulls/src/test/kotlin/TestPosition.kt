import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TestPosition {
    @Test
    fun createPosition() {
        val p = Position(2,3)
        assertEquals(2,p.x,"Property x of Position")
        assertEquals(3,p.y,"Property y of Position")
    }
    @Test
    fun createMotion() {
        val m = Motion(2,-3)
        assertEquals(2,m.dx,"Property x of Motion")
        assertEquals(-3,m.dy,"Property y of Motion")
    }
    @Test
    fun plusOperation() {
        val res = Position(2,3) + Motion(4,-2)
        assertEquals(Position(6,1),res,"Plus operation ")
    }
    @Test
    fun reverseIfInt() {
        val res = 3.reverseIf(true)
        assertEquals(-3,res,"reverse 3")
        val res2 = 3.reverseIf(false)
        assertEquals(3,res2,"not reverse 3")
    }
    @Test
    fun reverseMotion() {
        val m = Motion(2,3).reverseIfCollide(Position(10,10),100,50,5)
        assertEquals(Motion(2,3),m,"Return equal motion")
        val m2 = Motion(2,3).reverseIfCollide(Position(10,10),12,14,5)
        assertEquals(Motion(-2,-3),m2,"Return reverse motion")
        val m3 = Motion(-2,-3).reverseIfCollide(Position(10,10),100,50,12)
        assertEquals(Motion(2,3),m3,"Return reverse motion")
    }
    @Test
    fun generateRandomMotion() {
        val m = randomMotion()
        //println(m)
        assertTrue(m.dx in VELOCITY_RANGE && m.dy in VELOCITY_RANGE,"random in range")
    }
}