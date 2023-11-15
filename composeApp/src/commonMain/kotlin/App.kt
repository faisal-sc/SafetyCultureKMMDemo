import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import ui.SCTopBar

@Composable
fun App() {
    MaterialTheme {
        Scaffold(
            topBar = {
                SCTopBar()
            },
            backgroundColor = Color(0xFFE9EEF6),
        ) {
//            SignupScreen()
            OnboardingIntentScreen()
        }
    }
}

//@Composable
//fun ComposeNavigation() {
//
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "First"){
//        composable("First"){
//            FirstScreen()
//        }
//        composable("Second"){
//            SecondScreen()
//        }
//    }
//
//}
//
//
//// Pass above function in the MainActivity's setContent function :)
//setContent{
//    ComposeNavigation()
//}