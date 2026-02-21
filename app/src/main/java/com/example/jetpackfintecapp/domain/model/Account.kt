package com.example.jetpackfintecapp.domain.model

data class Account(
    val id: String,
    val name: String,
    val address: String,
    val balance: Double,
    val currency: String
)