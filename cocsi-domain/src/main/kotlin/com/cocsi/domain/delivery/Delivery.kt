package com.cocsi.domain.delivery

class Delivery(
    val id: Long,
    val address: String,
    val state: State,
) {
    enum class State {
        DELIVERY_STATE_UNSPECIFIED,
        NOT_STARTED,
        IN_PROGRESS,
        COMPLETED,
        CANCELLED,
        ;
    }
}
