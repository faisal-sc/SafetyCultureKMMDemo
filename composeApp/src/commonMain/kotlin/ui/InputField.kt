package ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import utils.PasswordValidator

object InputField {

    @Composable
    fun Default(
        label: String,
        value: String,
        onValueChange: (String) -> Unit,
    ) = OutlinedTextFieldBackground(Color.White) {
        OutlinedTextField(
            label = { Text(label) },
            value = value,
            onValueChange = { onValueChange(it) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            shape = RoundedCornerShape(12.dp)
        )
    }

    @Composable
    fun Password(
        text: String,
        value: String,
        onValueChange: (String) -> Unit,
        isError: Boolean,
    ) = Column {
        OutlinedTextFieldBackground(color = Color.White) {
            OutlinedTextField(
                label = { Text(text) },
                value = value,
                onValueChange = { onValueChange(it) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                isError = isError,
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                shape = RoundedCornerShape(12.dp)
            )
        }
        // Password validation
        if (isError) {
            Text(
                text = "Password must be ${PasswordValidator.MIN_LENGTH} character long.",
                color = MaterialTheme.colors.error,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 0.dp)
            )
        }
    }
}

@Composable
fun OutlinedTextFieldBackground(
    color: Color,
    content: @Composable () -> Unit
) {
    // This box just wraps the background and the OutlinedTextField
    Box {
        // This box works as background
        Box(
            modifier = Modifier
                .matchParentSize()
                .padding(top = 8.dp) // adding some space to the label
                .background(
                    color,
                    // rounded corner to match with the OutlinedTextField
                    shape = RoundedCornerShape(12.dp)
                )
        )
        content()
    }
}