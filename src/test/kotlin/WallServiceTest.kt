import org.junit.Test

import org.junit.Assert.*
import java.time.LocalTime

class WallServiceTest {


    @Test
    fun add_testIf() {
        val post = Post(id = 456, date = LocalTime.now())
        val expected = 6

        val result = WallService.add(post).id

        assertEquals(expected, result)
    }

    @Test
    fun add_testElse() {
        val post = Post(id = 455, date = LocalTime.now())
        val post2 = Post(id = 457, date = LocalTime.now(), ownerId = 564564)
        val expected = 5
        WallService.add(post2)

        val result = WallService.add(post).id

        assertEquals(expected, result)
    }

    @Test
    fun update_true() {
        val post = Post(id = 456, date = LocalTime.now())
        val post2 = Post(id = 1, date = LocalTime.now(), ownerId = 564564)
        WallService.add(post)

        val result = WallService.update(post2)

        assertTrue(result)

    }

    @Test
    fun update_false() {
        val post = Post(id = 456, date = LocalTime.now())
        val post2 = Post(id = 35, date = LocalTime.now(), ownerId = 564564)
        WallService.add(post)

        val result = WallService.update(post2)

        assertFalse(result)

    }

    @Test(expected = WallService.PostNotFoundException::class)
    fun shouldThrow_createComment() {
        val post = Post(id = 456, date = LocalTime.now())
        val comment = Comment(fromId = 431, text = "Hello")
        WallService.add(post)
        WallService.createComment(comment)

    }


}
