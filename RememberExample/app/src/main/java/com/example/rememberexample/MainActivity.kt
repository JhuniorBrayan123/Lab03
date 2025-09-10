package com.example.rememberexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rememberexample.ui.theme.RememberExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RememberExampleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CounterApp()
                }
            }
        }
    }
}

@Composable
fun CounterApp() {
    // Estado: recordar un número
    var count by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(), //ocupa pant
        horizontalAlignment = Alignment.CenterHorizontally, //centra elementos horizonta
        verticalArrangement = Arrangement.Center //centra vertica
    ) {
        Text(text = "Contador: $count", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { count++ }) {
            Text("Incrementar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { count = 0 }) {
            Text("Reiniciar")
        }
    }
}
