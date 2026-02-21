package com.example.jetpackfintecapp.data.mapper

import com.example.jetpackfintecapp.domain.model.Account

/**
 * Best practice for Clean Architecture: AccountDto represents the data 
 * structure from the API. It is decoupled from the Domain Account model.
 */
data class AccountDto(
    val id: String,
    val name: String,
    val address: String,
    val balance: Double,
    val currency: String
)

fun AccountDto.toDomain(): Account {
    return Account(
        id = id,
        name = name,
        address = address,
        balance = balance,
        currency = currency
    )
}
