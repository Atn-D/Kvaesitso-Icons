package de.kvaesitso.icons.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import de.kvaesitso.icons.repository.OssLibraryRepository
import javax.inject.Inject

@HiltViewModel
class AcknowledgementsViewModel @Inject constructor(ossLibraryRepository: OssLibraryRepository) :
    ViewModel() {
    val ossLibraries = ossLibraryRepository.ossLibraries
}
