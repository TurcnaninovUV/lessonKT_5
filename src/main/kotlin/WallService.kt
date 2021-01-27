object WallService {
    private var posts = mutableMapOf<Any, Post>()

    fun add(post: Post): Post? {
        posts[post.id] = post
        return posts[post.id]

    }

    fun update(post: Post): Boolean {
        if (posts.containsKey(post.id)) {
            posts.replace(post.id, post.copy(id = post.id, date = post.date))
            return true
        }
        return false
    }

}
