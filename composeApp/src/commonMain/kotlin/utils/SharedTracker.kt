package utils

const val SCREEN_NAME = "signup"

data class SignupTracker(
    val view_screen: String = SCREEN_NAME,
    val platform_name: String = getPlatform().name
)

fun trackViewScreen() {
    val event = SignupTracker()
    println("Track event: $event}")
}