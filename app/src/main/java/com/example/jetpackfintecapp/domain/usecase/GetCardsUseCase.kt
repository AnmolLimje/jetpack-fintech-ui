package com.example.jetpackfintecapp.domain.usecase

import com.example.jetpackfintecapp.domain.model.Card
import com.example.jetpackfintecapp.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow

class GetCardsUseCase(
    private val repository: CardRepository
) {
    operator fun invoke(): Flow<List<Card>> {
        return repository.getCards()
    }
}
