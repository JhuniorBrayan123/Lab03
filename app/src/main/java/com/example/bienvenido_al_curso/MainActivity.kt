package com.example.bienvenido_al_curso

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bienvenido_al_curso.ui.theme.Bienvenido_al_CursoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                GreetingCard()
            }
        }
    }
}

@Composable
fun GreetingCard() {
    // 🔹 AGREGAR ESTADO para el TextField
    var nombreIngresado by remember { mutableStateOf("") }
    var mostrarMensaje by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Bienvenidos al curso !",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Mostrar saludo personalizado si se presionó el botón
        if (mostrarMensaje && nombreIngresado.isNotBlank()) {
            Text(
                text = "¡Hola, $nombreIngresado!",
                fontSize = 20.sp,
                color = Color(0xFF03DAC5),
                fontWeight = FontWeight.Bold
            )
        } else {
            Text(
                text = "Hola, muchaches!",
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 TextField CORREGIDO - ahora funciona
        TextField(
            value = nombreIngresado,                    // ← Conectado al estado
            onValueChange = {
                nombreIngresado = it
            },   // ← Actualiza el estado
            label = { Text(text = "Ingresa tu nombre") },
            placeholder = { Text("Jhunior") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🔹 Fila con dos botones
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    // 🔹 FUNCIONALIDAD AGREGADA
                    mostrarMensaje = true
                },
                modifier = Modifier
                    .height(55.dp)
                    .weight(1f)
                    .padding(end = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF03DAC5),      // color principal
                    contentColor = Color(0xFF000000)         // texto negro
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Muchas felicidades",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }

            Button(
                onClick = {
                    // 🔹 FUNCIONALIDAD AGREGADA
                    nombreIngresado = ""
                    mostrarMensaje = false
                },
                modifier = Modifier
                    .height(55.dp)
                    .weight(1f)
                    .padding(start = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFF44336),      // rojo
                    contentColor = Color.White
                ),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    "Cancelar",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = R.drawable.jhunior),
            contentDescription = "Course Image",
            modifier = Modifier.size(100.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewGreetingCard() {
    GreetingCard()
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
