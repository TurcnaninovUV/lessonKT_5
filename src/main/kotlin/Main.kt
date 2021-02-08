import java.time.LocalTime

fun main() {
    val attachment = VideoAttachment("video")
    WallService.addArrayAttach(attachment)

    val post1 = Post(id = 4554, date = LocalTime.now())
    val post2 = Post(id = 4554, date = LocalTime.now(), ownerId = 564564)

    WallService.add(post1)
    WallService.add(post2)
    WallService.update(post2)

    val post = Post(id = 1, date = LocalTime.now())
    val expected = Comment(fromId = 57, text = "Hello")
    WallService.add(post)
    WallService.createComment(expected)
}

