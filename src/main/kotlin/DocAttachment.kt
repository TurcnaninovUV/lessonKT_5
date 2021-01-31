data class DocAttachment(
        override val type: String,
        val doc: Doc? = null)
    : Attachment {


}