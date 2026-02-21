package com.example.jetpackfintecapp.data.mock

import com.example.jetpackfintecapp.data.mapper.AccountDto
import kotlinx.coroutines.delay

class FakeAccountRemoteDataSource {
    suspend fun fetchAccounts(): List<AccountDto> {
        delay(800) // simulate network
        return listOf(
            AccountDto("1","Anmol","", 2230.0, "USD"),
            AccountDto("2","John","Raipur", 100.0, "USD"),
        )
    }
}