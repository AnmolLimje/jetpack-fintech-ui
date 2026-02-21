package com.example.jetpackfintecapp.data.mapper

import com.example.jetpackfintecapp.domain.model.Account
import com.example.jetpackfintecapp.domain.model.Card
import com.example.jetpackfintecapp.domain.model.Transaction

/**
 * Best practice for Clean Architecture: Use mappers to convert Data Transfer Objects (DTOs)
 * from the API to Domain Models that the UI and Business logic understand.
 */

// Example mapper for Account (assuming AccountDto exists in real project)
fun Account.toDto(): AccountDto {
    return AccountDto(id, name, address, balance, currency)
}
