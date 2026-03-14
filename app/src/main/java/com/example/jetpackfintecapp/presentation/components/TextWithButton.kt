package com.example.jetpackfintecapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TextWithLink(
    onSignInClick: () -> Unit,
    info: String = "Already have an account?",
    link: String = "Sign in"
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(5.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(info, color = Color.Gray)
        TextButton(
            onClick = onSignInClick,
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(link, color = Color(0xFF9162FF), fontWeight = FontWeight.Bold)
        }
    }
}