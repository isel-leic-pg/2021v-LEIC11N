import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TestExample {
    @Test
    fun test1() {
        val txt = "IS"+"EL"
        assertEquals("ISEL",txt,"Strings iguais")
    }
    @Test
    fun test2() {
        val res = 23 in 10..30
        assertTrue(res,"Range contains")
    }
}