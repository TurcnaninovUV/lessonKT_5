import org.junit.Test

import org.junit.Assert.*
import java.time.LocalTime

class WallServiceTest {

    @Test
    fun add_oneTest() {
        val post = Post(id = 456, date = LocalTime.now())
        val expected = 456

        val result = WallService.add(post)?.id

        assertEquals(expected, result)
    }

    @Test
    fun update_true() {
        val post = Post(id = 456, date = LocalTime.now())
        val post2 = Post(id = 456, date = LocalTime.now(), ownerId = 564564)
        WallService.add(post)

        val result = WallService.update(post2)

        assertTrue(result)

    }

    @Test
    fun update_false() {
        val post = Post(id = 456, date = LocalTime.now())
        val post2 = Post(id = 457, date = LocalTime.now(), ownerId = 564564)
        WallService.add(post)

        val result = WallService.update(post2)

        assertFalse(result)

    }
}