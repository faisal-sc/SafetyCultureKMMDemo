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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.InputField
import utils.PasswordValidator
import utils.trackViewScreen

@Composable
fun SignupScreen() {
    LaunchedEffect(Unit) {
        trackViewScreen()
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
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = "Create your account",
                style = TextStyle(
                    fontSize = 28.sp,
                    lineHeight = 36.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF081833),

                    )
            )
            Text(
                text = "Your free SafetyCulture account includes up to 10 team members, unlimited inspections, issues and more.",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(400),
                    color = Color(0xFF5E6C84),
                )
            )
        }
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
                print("Clicked Create account! email = $email")
                // Validate password
                passwordError = PasswordValidator.validate(input = password)
            }) {
            Text("Create account")
        }
    }
}