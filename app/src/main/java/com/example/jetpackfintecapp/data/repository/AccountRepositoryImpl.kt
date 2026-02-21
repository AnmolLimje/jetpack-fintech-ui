package com.example.jetpackfintecapp.data.repository

import com.example.jetpackfintecapp.data.mapper.toDomain
import com.example.jetpackfintecapp.data.mock.FakeAccountRemoteDataSource
import com.example.jetpackfintecapp.domain.model.Account
import com.example.jetpackfintecapp.domain.repository.AccountRepository

class AccountRepositoryImpl(
    private val remote: FakeAccountRemoteDataSource
) : AccountRepository {
    override suspend fun getAccounts(): List<Account> {
        return remote.fetchAccounts().map { it.toDomain() }
    }
}