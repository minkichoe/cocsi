interface CloudEvent<T> : Event {
    val id: String

    val type: String

    val name: String

    val publisheTime: LocalDateTime?

    val data: T?
}
