package com.example.jetpackfintecapp.domain.usecase

import com.example.jetpackfintecapp.domain.repository.AccountRepository

class GetAccountsUseCase(
    private val repository: AccountRepository
) {
    suspend operator fun invoke() = repository.getAccounts()
}