package app.lawnchair.lawnicons.ui.component

import android.content.Intent
import android.net.Uri
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LinkButton(
    text: String,
    url: String
) {
    val context = LocalContext.current
    val onClick = {
        val website = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, website)
        context.startActivity(intent)
    }

    OutlinedButton(
        onClick = onClick
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
fun LinkButtonPreview() {
    LinkButton(text = "Example", url = "https://example.com")
}
