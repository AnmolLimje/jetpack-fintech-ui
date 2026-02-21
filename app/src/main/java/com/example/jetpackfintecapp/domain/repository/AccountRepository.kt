package com.example.jetpackfintecapp.domain.repository

import com.example.jetpackfintecapp.domain.model.Account

interface AccountRepository {
    suspend fun getAccounts(): List<Account>
}