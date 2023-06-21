package com.mikechoe.cocsi.domain.event

import java.time.LocalDateTime

interface CloudEvent<T> : Event {
    val id: String

    val type: String

    val name: String

    val publishTime: LocalDateTime?

    val data: T?
}
