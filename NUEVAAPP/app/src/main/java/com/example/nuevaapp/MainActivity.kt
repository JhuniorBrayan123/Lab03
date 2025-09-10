package com.example.nuevaapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExploracionComponentesApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploracionComponentesApp() {
    var nombre by remember { mutableStateOf("") }
    var check1 by remember { mutableStateOf(false) }
    var check2 by remember { mutableStateOf(false) }
    var radioSeleccion by remember { mutableStateOf("Sí") }
    var switchState by remember { mutableStateOf(false) }
    var sliderValue by remember { mutableStateOf(0f) }
    var spinnerExpanded by remember { mutableStateOf(false) }
    var spinnerSeleccion by remember { mutableStateOf("Opción A") }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Exploración de Componentes") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Text
            Text(text = "Bienvenido a la app", style = MaterialTheme.typography.titleLarge)

            // EditText
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Escribe tu nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            // Button
            Button(onClick = { /* Accion */ }) {
                Text("Saludar")
            }

            // Image
            Image(
                painter = painterResource(id = android.R.drawable.ic_menu_gallery),
                contentDescription = "Ejemplo",
                modifier = Modifier.size(100.dp)
            )

            // CheckBox
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = check1, onCheckedChange = { check1 = it })
                Text("Opción 1")
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(checked = check2, onCheckedChange = { check2 = it })
                Text("Opción 2")
            }

            // RadioButton
            Row {
                RadioButton(selected = radioSeleccion == "Sí", onClick = { radioSeleccion = "Sí" })
                Text("Sí")
                Spacer(Modifier.width(16.dp))
                RadioButton(selected = radioSeleccion == "No", onClick = { radioSeleccion = "No" })
                Text("No")
            }

            // Switch
            Row(verticalAlignment = Alignment.CenterVertically) {
                Switch(checked = switchState, onCheckedChange = { switchState = it })
                Text(if (switchState) "Activado" else "Desactivado")
            }

            // Slider (SeekBar)
            Column {
                Text("Nivel: ${(sliderValue * 100).toInt()}%")
                Slider(value = sliderValue, onValueChange = { sliderValue = it })
            }

            // Spinner (DropdownMenu)
            Box {
                Button(onClick = { spinnerExpanded = true }) {
                    Text(spinnerSeleccion)
                }
                DropdownMenu(
                    expanded = spinnerExpanded,
                    onDismissRequest = { spinnerExpanded = false }
                ) {
                    listOf("Opción A", "Opción B", "Opción C").forEach { opcion ->
                        DropdownMenuItem(
                            text = { Text(opcion) },
                            onClick = {
                                spinnerSeleccion = opcion
                                spinnerExpanded = false
                            }
                        )
                    }
                }
            }

            // ProgressBar
            LinearProgressIndicator(progress = sliderValue, modifier = Modifier.fillMaxWidth())
        }
    }
}
