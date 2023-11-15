package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import utils.OnboardingIntent

@OptIn(ExperimentalResourceApi::class)
@Composable
fun RowOnboardingIntent(
    data: OnboardingIntent,
    onClick: (OnboardingIntent) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.Start),
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
            .height(64.dp)
            .clip(shape = RoundedCornerShape(12.dp))
            .background(color = Color.White)
            .border(
                width = if (data.isSelected) 1.dp else 0.dp,
                color = if (data.isSelected) Color(0xFF564BE7) else Color.Transparent,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable {
                onClick.invoke(data)
            }
    ) {
        Image(
            painter = painterResource(data.icon),
            contentDescription = data.text,
            modifier = Modifier.width(56.dp)
        )
        Text(text = data.text)
    }
}