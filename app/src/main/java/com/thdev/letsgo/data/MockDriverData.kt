package com.thdev.letsgo.data

data class DriverOption(
    val id: Int,
    val name: String,
    val description: String,
    val vehicle: String,
    val review: Review,
    val value: Double
)

data class Review(
    val rating: Int,
    val comment: String
)