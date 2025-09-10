package com.example.exploracioncomponentes

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Layout principal vertical
        val layoutPrincipal = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(32)
        }

        // TextView
        val tvTitulo = TextView(this).apply {
            text = "Explorando Componentes"
            textSize = 22f
            gravity = Gravity.CENTER
        }

        // EditText
        val etNombre = EditText(this).apply {
            hint = "Escribe tu nombre aquí"
        }

        // Button
        val btnSaludar = Button(this).apply {
            text = "Saludar"
            setOnClickListener {
                val nombre = etNombre.text.toString()
                tvTitulo.text = "Hola $nombre 👋"
            }
        }

        // ImageView
        val imgEjemplo = ImageView(this).apply {
            setImageResource(R.mipmap.ic_launcher_round)
        }

        // CheckBox
        val chk1 = CheckBox(this).apply { text = "Opción 1" }
        val chk2 = CheckBox(this).apply { text = "Opción 2" }
        chk1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) Toast.makeText(this, "Opción 1 marcada", Toast.LENGTH_SHORT).show()
        }
        chk2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) Toast.makeText(this, "Opción 2 marcada", Toast.LENGTH_SHORT).show()
        }

        // RadioGroup con RadioButtons
        val radioGroup = RadioGroup(this)
        val rbSi = RadioButton(this).apply { text = "Sí" }
        val rbNo = RadioButton(this).apply { text = "No" }
        radioGroup.addView(rbSi)
        radioGroup.addView(rbNo)
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            val seleccionado = when (checkedId) {
                rbSi.id -> "Sí"
                rbNo.id -> "No"
                else -> ""
            }
            Toast.makeText(this, "Seleccionaste: $seleccionado", Toast.LENGTH_SHORT).show()
        }

        // Switch
        val switchOnOff = Switch(this).apply { text = "Encendido/Apagado" }
        switchOnOff.setOnCheckedChangeListener { _, isChecked ->
            val estado = if (isChecked) "Activado" else "Desactivado"
            Toast.makeText(this, "Switch: $estado", Toast.LENGTH_SHORT).show()
        }

        // SeekBar
        val seekBar = SeekBar(this)
        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(sb: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(applicationContext, "Valor: $progress", Toast.LENGTH_SHORT).show()
            }
            override fun onStartTrackingTouch(sb: SeekBar?) {}
            override fun onStopTrackingTouch(sb: SeekBar?) {}
        })

        // Spinner
        val opciones = arrayOf("Opción A", "Opción B", "Opción C")
        val spinner = Spinner(this).apply {
            adapter = ArrayAdapter(this@MainActivity, android.R.layout.simple_spinner_item, opciones).also {
                it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            }
        }
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: android.view.View?, position: Int, id: Long) {
                Toast.makeText(applicationContext, "Seleccionaste: ${opciones[position]}", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // ProgressBar
        val progressBar = ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal).apply {
            progress = 70
        }

        // Agregar todos los componentes al layout
        layoutPrincipal.addView(tvTitulo)
        layoutPrincipal.addView(etNombre)
        layoutPrincipal.addView(btnSaludar)
        layoutPrincipal.addView(imgEjemplo)
        layoutPrincipal.addView(chk1)
        layoutPrincipal.addView(chk2)
        layoutPrincipal.addView(radioGroup)
        layoutPrincipal.addView(switchOnOff)
        layoutPrincipal.addView(seekBar)
        layoutPrincipal.addView(spinner)
        layoutPrincipal.addView(progressBar)

        // Mostrar layout
        setContentView(layoutPrincipal)
    }
}
