data class VideoAttachment(
        override val type: String,
        val photo: Video? = null

) : Attachment {

}

