package com.example.jetpackfintecapp.presentation.onboarding

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackfintecapp.core.ui.FintechButton
import com.example.jetpackfintecapp.presentation.components.TextWithLink

@Composable
fun OnboardingScreen(
    onGetStartedClick: () -> Unit,
    onSignInClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = "Smart banking in your phone",
            style = MaterialTheme.typography.headlineLarge,
            fontWeight = FontWeight.Bold,
            lineHeight = 44.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Set and easily track your transfers",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(64.dp))
        
        FintechButton(
            text = "Get started",
            onClick = onGetStartedClick
        )
        
        Spacer(modifier = Modifier.height(24.dp))

        TextWithLink(
            onSignInClick
        )
        Spacer(modifier = Modifier.height(32.dp))
    }
}
