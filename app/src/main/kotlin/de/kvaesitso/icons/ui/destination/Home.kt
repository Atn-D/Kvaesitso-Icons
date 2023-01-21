package de.kvaesitso.icons.ui.destination

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import de.kvaesitso.icons.ui.component.IconPreviewGrid
import de.kvaesitso.icons.ui.component.SearchBar
import de.kvaesitso.icons.ui.component.SearchBarBase
import de.kvaesitso.icons.viewmodel.LawniconsViewModel

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun Home(
    lawniconsViewModel: LawniconsViewModel = hiltViewModel(),
    navController: NavController,
) {
    val iconInfoModel by lawniconsViewModel.iconInfoModel.collectAsState()
    var searchTerm by remember { mutableStateOf(value = "") }
    Crossfade(
        targetState = iconInfoModel != null,
        modifier = Modifier.statusBarsPadding(),
    ) { targetState ->
        if (targetState) {
            iconInfoModel?.let {
                SearchBar(
                    value = searchTerm,
                    iconCount = it.iconCount,
                    navController = navController,
                    onValueChange = { newValue ->
                        searchTerm = newValue
                        lawniconsViewModel.searchIcons(newValue)
                    },
                )
                IconPreviewGrid(iconInfo = it.iconInfo)
            }
        } else {
            SearchBarBase()
        }
    }
}
