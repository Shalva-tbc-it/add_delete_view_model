package com.example.addremoveviewmodel.add_remove.data_model

import java.util.UUID

data class Item(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val image: String
)
