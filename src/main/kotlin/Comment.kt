class Comment(
        val id: Int? = null,
        val fromId: Int,
        val date: Int? = null,
        val text: String? = null,
        val replyToUser: Int? = null,
        val replyToComment: Int? = null,
) {

}