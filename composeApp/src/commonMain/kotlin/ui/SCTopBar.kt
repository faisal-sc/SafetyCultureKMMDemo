package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun SCTopBar() = TopAppBar(
    title = {
        Image(
            painter = painterResource("ic_safetyculture_logo.xml"),
            contentDescription = "Logo",
            contentScale = ContentScale.Inside,
            modifier = Modifier.fillMaxSize()
        )
    },
    backgroundColor = Color.White
)