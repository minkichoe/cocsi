package com.cocsi.domain.product

class Item(
    val id: Long,
    val itemId: Long,
    val category: Category,
) {
    enum class Category {
        ITEM_CATEGORY_UNSPECIFIED,
        DRINK,
        ;
    }
}
