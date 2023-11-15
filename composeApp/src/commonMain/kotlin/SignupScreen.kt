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
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.InputField
import ui.ScreenHeader
import utils.PasswordValidator
import utils.Screen
import utils.trackViewSignupScreen

@Composable
fun SignupScreen(navigator: MutableState<String>) {
    LaunchedEffect(Unit) {
        trackViewSignupScreen()
    }

    // Props
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf(false) }
    var mobile by remember { mutableStateOf("") }

    // UI
    Column(
        modifier = Modifier.padding(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        ScreenHeader(
            heading = "Create your account",
            subheading = "Your free SafetyCulture account includes up to 10 team members, unlimited inspections, issues and more.",
        )
        // Email
        InputField.Default(
            label = "Email",
            value = email,
            onValueChange = { email = it }
        )
        // Password
        InputField.Password(
            text = "Password",
            value = password,
            onValueChange = {
                password = it
            },
            isError = passwordError,
        )
        // Mobile
        InputField.Default(
            label = "Mobile",
            value = mobile,
            onValueChange = { mobile = it },
        )
        // Create account button
        Button(
            modifier = Modifier.fillMaxWidth().height(48.dp),
            shape = RoundedCornerShape(12.dp),
            onClick = {
                // Validate password
                passwordError = PasswordValidator.validate(input = password)
                if (!passwordError) {
                    navigator.value = Screen.OnboardingIntent.name
                }
            }) {
            Text("Create account")
        }
    }
}