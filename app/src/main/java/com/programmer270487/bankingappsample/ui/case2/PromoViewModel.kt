package com.programmer270487.bankingappsample.ui.case2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.programmer270487.bankingappsample.data.local.case1.DataItem
import com.programmer270487.bankingappsample.data.remote.case2.APIService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class PromoListState {
    object Loading : PromoListState()
    data class Success(val promos: List<DataItem>) : PromoListState()
    data class Error(val message: String) : PromoListState()
}

class PromoViewModel : ViewModel() {
    private val promoService = APIService.promoService

    private val _promoListState = MutableStateFlow<PromoListState>(PromoListState.Loading)
    val promoListState: StateFlow<PromoListState> = _promoListState

    fun loadPromos() {
        viewModelScope.launch {
            try {
                val promos = promoService.getPromos()
                if (promos.isNotEmpty()) {
                    _promoListState.value = PromoListState.Success(promos)
                } else {
                    _promoListState.value = PromoListState.Error("Gagal mengambil data promo")
                }
            } catch (e: Exception) {
                _promoListState.value = PromoListState.Error("Terjadi kesalahan: ${e.message}")
            }
        }
    }
}