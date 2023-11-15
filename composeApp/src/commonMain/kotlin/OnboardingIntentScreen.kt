import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.RowOnboardingIntent
import ui.ScreenHeader
import utils.OnboardingIntent
import utils.OnboardingIntentProvider

@Composable
fun OnboardingIntentScreen() {
    val onboardingIntents = remember { mutableStateListOf<OnboardingIntent>() }
    LaunchedEffect(Unit) {
        onboardingIntents.addAll(OnboardingIntentProvider.onboardingIntents)
    }

    // List
    Column(
        modifier = Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ScreenHeader(
            heading = "What's your purpose for using SafetyCulture?",
            subheading = "We’ll use this to help get you started.",
        )
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            onboardingIntents.forEachIndexed { index, onboardingIntent ->
                RowOnboardingIntent(
                    data = onboardingIntent,
                    onClick = { clickedItem ->
                        onboardingIntents[index] = clickedItem.copy(
                            isSelected = !clickedItem.isSelected
                        )
                    }
                )
            }
        }
        Button(
            modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = RoundedCornerShape(12.dp),
            onClick = {
                print("Clicked Finish Setup!")
            }) {
            Text("Finish setup")
        }
    }
}