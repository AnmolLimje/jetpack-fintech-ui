package com.example.jetpackfintecapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackfintecapp.domain.model.Card
import com.example.jetpackfintecapp.domain.usecase.GetCardsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getCardsUseCase: GetCardsUseCase
) : ViewModel() {

    private val _cardsState = MutableStateFlow<List<Card>>(emptyList())
    val cardsState: StateFlow<List<Card>> = _cardsState.asStateFlow()

    init {
        loadCards()
    }

    private fun loadCards() {
        viewModelScope.launch {
            getCardsUseCase().collect { cards ->
                _cardsState.value = cards
            }
        }
    }
}
