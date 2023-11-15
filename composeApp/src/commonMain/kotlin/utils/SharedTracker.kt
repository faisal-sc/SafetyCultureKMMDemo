package utils

const val SCREEN_NAME_SIGNUP = "signup"
const val SCREEN_NAME_ONBOARDING_INTENT = "onboarding_intent"

const val ACTION_CREATE_ACCOUNT = "create_account"
const val ACTION_FINISH_SETUP = "finish_setup"

fun trackViewSignupScreen() {
    val event = Event(view_screen = SCREEN_NAME_SIGNUP)
    println("$event}")
}

fun trackViewOnboardingIntentScreen() {
    val event = Event(view_screen = SCREEN_NAME_ONBOARDING_INTENT)
    println("$event}")
}

fun trackOnboardingIntentSelection(onboardingIntent: OnboardingIntent) {
    val event = ClickEvent(
        action = ACTION_FINISH_SETUP,
        onboarding_intent = onboardingIntent.text
    )
    println("$event}")
}

data class Event(
    val view_screen: String,
    val platform_name: String = getPlatform().name
)

data class ClickEvent(
    val action: String,
    val onboarding_intent: String
)