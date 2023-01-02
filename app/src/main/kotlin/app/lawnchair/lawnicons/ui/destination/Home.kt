package app.lawnchair.lawnicons.ui.destination

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import app.lawnchair.lawnicons.R
import app.lawnchair.lawnicons.ui.component.IconPreviewGrid
import app.lawnchair.lawnicons.ui.component.SearchBar
import app.lawnchair.lawnicons.ui.component.SearchBarBase
import app.lawnchair.lawnicons.ui.component.SimpleListRow
import app.lawnchair.lawnicons.viewmodel.LawniconsViewModel

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
                SimpleListRow(label = stringResource(R.string.icon_popup_hint))
                IconPreviewGrid(iconInfo = it.iconInfo)
            }
        } else {
            SearchBarBase()
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
