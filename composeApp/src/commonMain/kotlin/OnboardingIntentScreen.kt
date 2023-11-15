import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ui.RowOnboardingIntent
import ui.ScreenHeader
import utils.OnboardingIntentProvider
import utils.PasswordValidator

@Composable
fun OnboardingIntentScreen() {
    val items = OnboardingIntentProvider.onboardingIntents

    // List
    Column(
        modifier = Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ScreenHeader(
            heading = "What is your main purpose for using SafetyCulture?",
            subheading = "We’ll use this to help get you started.",
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items.forEach {
                RowOnboardingIntent(data = it)
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