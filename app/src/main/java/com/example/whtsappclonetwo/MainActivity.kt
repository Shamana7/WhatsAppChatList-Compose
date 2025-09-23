package com.example.whtsappclonetwo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsAppChatListScreen()
        }
    }
}

// Data Model
data class ChatItem(val name: String, val time: String)

// Sample Data
val chatList = listOf(
    ChatItem("Amaresh Patil", "08:45 AM"),
    ChatItem("Kathiravan", "Yesterday"),
    ChatItem("Nisarga ", "Mon"),
    ChatItem("Aditya Agrawal", "Sun"),
    ChatItem("Shamana Shetty", "Sun"),
    ChatItem("prajwal patil", "Sun"),
    ChatItem("Mumma", "Sat"),
    ChatItem("Sawbhagya aunty", "sat"),
    ChatItem("Anil kumar", "Sat"),
    ChatItem("Kirthana 2", "Sat"),
    ChatItem("Riha roy", "Sat"),
    ChatItem("Ajji", "Fri"),
    ChatItem("Family group", "Fri"),
    ChatItem("Roohi Shetty", "Fri"),
    ChatItem("Hemanth sir", "Fri")
)

// Chat List Screen
@Composable
fun WhatsAppChatListScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(chatList) { chat ->
            ChatListItem(chat)
            Divider()
        }
    }
}

// Single Chat Item UI
@Composable
fun ChatListItem(chat: ChatItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Profile Picture",
            modifier = Modifier.size(48.dp),
            tint = Color.Gray
        )

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = chat.name, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(
                text = "Last message preview...",
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Text(text = chat.time, fontSize = 12.sp, color = Color.Gray)
    }
}
