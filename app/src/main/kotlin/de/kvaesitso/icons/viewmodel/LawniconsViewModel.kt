package de.kvaesitso.icons.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import de.kvaesitso.icons.repository.IconRepository
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class LawniconsViewModel @Inject constructor(private val iconRepository: IconRepository) :
    ViewModel() {

    val iconInfoModel = iconRepository.iconInfoModel

    fun searchIcons(query: String) {
        viewModelScope.launch {
            iconRepository.search(query)
        }
    }
}
