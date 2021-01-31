object WallService {

    private var arrayAttach = emptyArray<Attachment>()

    fun addArrayAttach(attach: Attachment) {
        arrayAttach += attach
    }

    private var posts = emptyArray<Post>()

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


