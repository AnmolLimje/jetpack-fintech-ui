package com.example.jetpackfintecapp.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackfintecapp.domain.model.Transaction
import com.example.jetpackfintecapp.domain.model.TransactionType
import com.example.jetpackfintecapp.ui.components.BankCard

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val cards by viewModel.cardsState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Surface(
                    modifier = Modifier.size(40.dp),
                    shape = CircleShape,
                    color = Color(0xFF9162FF)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text("JT", color = Color.White, fontWeight = FontWeight.Bold)
                    }
                }
                Spacer(modifier = Modifier.width(12.dp))
                Text("Hello, James", style = MaterialTheme.typography.titleMedium)
            }
            IconButton(onClick = { /* TODO */ }) {
                Icon(Icons.Default.Notifications, contentDescription = "Notifications")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Total Balance
        Text("Total balance", color = Color.Gray, fontSize = 14.sp)
        Text("$8 600", fontSize = 36.sp, fontWeight = FontWeight.ExtraBold)

        Spacer(modifier = Modifier.height(24.dp))

        // Cards Section
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("CARDS", fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 12.sp)
            TextButton(onClick = { /* TODO */ }) {
                Text("Add +", color = Color(0xFF9162FF), fontWeight = FontWeight.Bold)
            }
        }
        
        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            items(cards) { card ->
                BankCard(card = card)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Finance Section
        Text("FINANCE", fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 12.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            FinanceItem("My bonuses", Icons.Default.Star, Color(0xFFE8EAF6), Color(0xFF3F51B5))
            FinanceItem("Analysis", Icons.Default.ShoppingCart, Color(0xFFE0F2F1), Color(0xFF009688))
            FinanceItem("Payment", Icons.Default.Star, Color(0xFFFFF3E0), Color(0xFFFF9800))
            FinanceItem("Invest", Icons.Default.Star, Color(0xFFFCE4EC), Color(0xFFE91E63))
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Last Transactions
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("LAST TRANSACTIONS", fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 12.sp)
            TextButton(onClick = { /* TODO */ }) {
                Text("See all >", color = Color(0xFF9162FF))
            }
        }
        
        TransactionItem(
            Transaction("1", "Supermarket", "Today, 15:40", -40.0, "USD", TransactionType.EXPENSE)
        )
        TransactionItem(
            Transaction("2", "Kapital Bank", "Today, 12:00", 20.0, "USD", TransactionType.INCOME)
        )
    }
}

@Composable
fun FinanceItem(label: String, icon: ImageVector, bgColor: Color, iconColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(bgColor, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(icon, contentDescription = label, tint = iconColor)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(label, fontSize = 11.sp, color = Color.Gray)
    }
}

@Composable
fun TransactionItem(transaction: Transaction) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFFF5F5F5), RoundedCornerShape(12.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.ShoppingCart, contentDescription = null)
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(transaction.title, fontWeight = FontWeight.Bold)
            Text(transaction.date, color = Color.Gray, fontSize = 12.sp)
        }
        val amountPrefix = if (transaction.type == TransactionType.EXPENSE) "-" else "+"
        val amountColor = if (transaction.type == TransactionType.EXPENSE) Color.Black else Color(0xFF4CAF50)
        Text(
            text = "$amountPrefix$${Math.abs(transaction.amount)}$",
            fontWeight = FontWeight.Bold,
            color = amountColor
        )
    }
}
