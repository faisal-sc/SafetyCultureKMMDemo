package utils

object OnboardingIntentProvider {
    val onboardingIntents = listOf(
        OnboardingIntent(
            isSelected = false,
            icon = "ic_safety.xml",
            text = "Increase workplace safety"
        ),
        OnboardingIntent(
            isSelected = false,
            icon = "ic_efficiency.xml",
            text = "Digitize & improve workplace efficiency"
        ),
        OnboardingIntent(
            isSelected = false,
            icon = "ic_quality.xml",
            text = "Ensure quality standards are met"
        ),
//        OnboardingIntent(
//            isSelected = false,
//            icon = "ic_training.xml",
//            text = "Provide training to your team"
//        )
    )
}

data class OnboardingIntent(var isSelected: Boolean, val icon: String, val text: String)
