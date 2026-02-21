package com.example.jetpackfintecapp.data.mock

import com.example.jetpackfintecapp.domain.model.Card
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeCardRemoteDataSource {
    fun fetchCards(): Flow<List<Card>> = flow {
        delay(1000) // Simulate network delay
        emit(
            listOf(
                Card("1", "Salary", "**** 6917", "12/26", "123", 2230.0, "USD"),
                Card("2", "Credit card", "**** 4433", "05/25", "456", 5230.0, "USD"),
                Card("3", "Credit card", "**** 1780", "08/27", "789", 98.0, "USD")
            )
        )
    }
}