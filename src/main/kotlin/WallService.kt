import java.lang.RuntimeException

object WallService {

    private var arrayAttach = emptyArray<Attachment>()
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun createComment(comment: Comment) {
        var flag = false
        posts.forEach { element ->
            if (element.id == comment.fromId) {
                comments += comment
                flag = true
            }
        }
        if (!flag) throw PostNotFoundException("нет поста с данным ID")

    }


    class PostNotFoundException(massage: String) : RuntimeException(massage) {
    }


    fun addArrayAttach(attach: Attachment) {
        arrayAttach += attach
    }

    fun add(post: Post): Post {
        val newId = if (posts.isEmpty()) 1 else posts.last().id!! + 1
        posts += post.copy(id = newId, date = post.date, attachment = arrayAttach)
        return posts.last()

    }

    fun update(post: Post): Boolean {
        for ((index, element) in posts.withIndex()) {
            if (element.id == post.id) {
                posts[index] = post.copy(id = post.id, date = post.date)
                return true
            }
        }
        return false
    }
}


