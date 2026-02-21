package com.example.jetpackfintecapp.data.remote

import com.example.jetpackfintecapp.domain.model.Card
import com.example.jetpackfintecapp.domain.model.Transaction

/**
 * Best practice for Fintech: This interface defines the backend communication.
 * When real APIs are ready, you'll implement this with Retrofit.
 */
interface FintechApi {
    suspend fun getCards(): List<Card>
    suspend fun getTransactions(): List<Transaction>
}
