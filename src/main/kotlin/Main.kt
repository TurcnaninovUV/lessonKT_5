import java.time.LocalTime

fun main() {
    val post1 = Post(id = 4554, date = LocalTime.now())
    val post2 = Post(id = 4554, date = LocalTime.now(), ownerId = 564564)

    WallService.add(post1)
    WallService.update(post2)

}

