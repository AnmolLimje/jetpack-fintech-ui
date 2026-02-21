package com.example.jetpackfintecapp.presentation.transfers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TransfersScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text("Transfers", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("Search", color = Color.Gray) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color.Gray) },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = Color(0xFFF5F5F5),
                focusedContainerColor = Color(0xFFF5F5F5),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        LazyRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            item {
                RecipientItem("Send", null, isAdd = true)
            }
            items(listOf("Anna L.", "Percy K.", "Kirk")) { name ->
                RecipientItem(name, null)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            TransferCategoryItem("Popular payments", Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            TransferCategoryItem("Bank of recipient", Modifier.weight(1f))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            TransferCategoryItem("Between my cards", Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            TransferCategoryItem("Recipient", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(32.dp))

        Text("TRANSACTIONS", fontWeight = FontWeight.Bold, color = Color.Gray, fontSize = 12.sp)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text("Mark Rivero", fontWeight = FontWeight.Bold)
                Text("Today, 10:40", color = Color.Gray, fontSize = 12.sp)
            }
        }
    }
}

@Composable
fun RecipientItem(name: String, imageUrl: String?, isAdd: Boolean = false) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .clip(CircleShape)
                .background(if (isAdd) Color(0xFF9162FF) else Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            if (isAdd) {
                Icon(Icons.Default.Add, contentDescription = null, tint = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(name, fontSize = 11.sp)
    }
}

@Composable
fun TransferCategoryItem(label: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.height(100.dp),
        shape = RoundedCornerShape(16.dp),
        color = Color(0xFFF5F5F5)
    ) {
        Box(modifier = Modifier.padding(16.dp)) {
            Icon(
                Icons.Default.Add, 
                contentDescription = null, 
                modifier = Modifier.align(Alignment.TopStart)
            )
            Text(
                text = label,
                modifier = Modifier.align(Alignment.BottomStart),
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
