package com.example.jetpackfintecapp.domain.repository

import com.example.jetpackfintecapp.domain.model.Card
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    fun getCards(): Flow<List<Card>>
}
