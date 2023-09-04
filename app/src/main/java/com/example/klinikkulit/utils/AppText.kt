package com.example.klinikkulit.utils

import android.annotation.SuppressLint
import android.util.Size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import com.example.klinikkulit.ui.theme.lato

@Composable
fun AppText(text: String, fontWeight: FontWeight = FontWeight.Normal,
            fontSize: TextUnit, color: Color = MaterialTheme.colorScheme.background,
            @SuppressLint("ModifierParameter") modifier: Modifier = Modifier,
            textDecoration: TextDecoration = TextDecoration.None,
            lineHeight: TextUnit = TextUnit.Unspecified) {
    Text(text, fontFamily = lato, fontWeight = fontWeight,
        fontSize = fontSize, color = color, modifier = modifier,
        textDecoration = textDecoration, lineHeight = lineHeight)
}