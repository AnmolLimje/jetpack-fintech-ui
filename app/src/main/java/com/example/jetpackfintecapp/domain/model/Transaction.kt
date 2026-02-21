package com.example.jetpackfintecapp.domain.model

data class Transaction(
    val id: String,
    val title: String,
    val date: String,
    val amount: Double,
    val currency: String,
    val type: TransactionType
)

enum class TransactionType {
    INCOME, EXPENSE
}