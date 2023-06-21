package com.cocsi.domain.order

import com.cocsi.domain.product.Product

class Order(
    val id: Long,
    val userId: Long,
    val deliveryId: Long? = null,
    val products: Collection<Product>,
)
