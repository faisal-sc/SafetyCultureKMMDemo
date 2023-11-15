package utils

object OnboardingIntentProvider {
    val onboardingIntents = listOf(
        OnboardingIntent(icon = "ic_safety.xml", text = "Increase workplace safety"),
        OnboardingIntent(icon = "ic_efficiency.xml", text = "Digitize & improve workplace efficiency"),
        OnboardingIntent(icon = "ic_quality.xml", text = "Ensure quality standards are met"),
        OnboardingIntent(icon = "ic_training.xml", text = "Provide training to your team")
    )
}

data class OnboardingIntent(val icon: String, val text: String)
