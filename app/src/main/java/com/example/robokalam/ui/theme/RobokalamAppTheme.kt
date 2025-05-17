import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun RobokalamAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = lightColorScheme(
            primary = Color(0xFF03A9F4),
            onPrimary = Color.White,
            background = Color.White,
            onBackground = Color.Black
        ),
        content = content
    )
}
