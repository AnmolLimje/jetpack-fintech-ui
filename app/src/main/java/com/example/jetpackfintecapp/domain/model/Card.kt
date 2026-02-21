
package com.example.jetpackfintecapp.domain.model

data class Card(
    val id: String,
    val name: String,
    val number: String,
    val expiryDate: String,
    val cvv: String,
    val balance: Double,
    val currency: String
)
