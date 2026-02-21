package com.example.jetpackfintecapp.data.repository

import com.example.jetpackfintecapp.data.mock.FakeCardRemoteDataSource
import com.example.jetpackfintecapp.domain.model.Card
import com.example.jetpackfintecapp.domain.repository.CardRepository
import kotlinx.coroutines.flow.Flow

class CardRepositoryImpl(
    private val remote: FakeCardRemoteDataSource
) : CardRepository {
    override fun getCards(): Flow<List<Card>> {
        return remote.fetchCards()
    }
}
