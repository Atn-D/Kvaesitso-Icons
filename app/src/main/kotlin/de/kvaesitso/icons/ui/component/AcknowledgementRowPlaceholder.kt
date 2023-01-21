package de.kvaesitso.icons.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.placeholder.PlaceholderHighlight
import com.google.accompanist.placeholder.material.fade
import com.google.accompanist.placeholder.material.placeholder
import de.kvaesitso.icons.ui.util.Elevation
import de.kvaesitso.icons.ui.util.surfaceColorAtElevation

@Composable
fun AcknowledgementRowPlaceholder(
    first: Boolean = false,
    last: Boolean = false,
    divider: Boolean = true,
) {
    Row {
        ListRow(
            divider = divider,
            background = true,
            first = first,
            last = last,
            label = {
                Box(
                    modifier = Modifier
                        .width(96.dp)
                        .height(18.dp)
                        .placeholder(
                            visible = true,
                            highlight = PlaceholderHighlight.fade(),
                            color = MaterialTheme.colorScheme.surfaceColorAtElevation(
                                Elevation.Level4,
                            ),
                        ),
                )
            },
        )
    }
}
