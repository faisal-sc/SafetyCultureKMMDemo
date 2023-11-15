import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import ui.SCTopBar
import utils.Screen

@Composable
fun App() {
    // Init Navigation
    var navigator = mutableStateOf("")
    LaunchedEffect(Unit) {
        navigator.value = Screen.Signup.name
    }
    // UI
    MaterialTheme {
        Scaffold(
            topBar = {
                SCTopBar()
            },
            backgroundColor = Color(0xFFE9EEF6),
        ) {
            when (navigator.value) {
                Screen.OnboardingIntent.name -> OnboardingIntentScreen()
                else -> SignupScreen(navigator)
            }
        }
    }
}
