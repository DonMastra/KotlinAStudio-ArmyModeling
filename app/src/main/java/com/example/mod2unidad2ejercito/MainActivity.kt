package com.example.mod2unidad2ejercito

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.mod2unidad2ejercito.entities.Barco
import com.example.mod2unidad2ejercito.entities.Portaavion
import com.example.mod2unidad2ejercito.entities.Submarino

class MainActivity : AppCompatActivity() {

    lateinit var textViewMover: TextView
    lateinit var textViewAbrirFuego: TextView
    lateinit var textViewLat1: EditText
    lateinit var textViewLong1: EditText
    lateinit var textViewLat2: EditText
    lateinit var textViewLong2: EditText
    //lateinit var radioButtonSelected: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewMover = findViewById(R.id.textViewResultMover)
        textViewAbrirFuego = findViewById(R.id.textViewResultAbrirFuego)
    }

    fun mover(view: View) : TextView{
        textViewLat1 = findViewById(R.id.editTextMoverLatitud)
        textViewLong1 = findViewById(R.id.editTextMoverLongitud)

        textViewMover.text = "Moviendo hacia las coordenadas: \n +" +
                "${textViewLat1.text} | ${textViewLong1.text}"
        return textViewMover
    }

    fun abrirFuego(view: View): TextView{
        textViewLat2 = findViewById(R.id.editTextAbrirFuegoLatitud)
        textViewLong2 = findViewById(R.id.editTextAbrirFuegoLongitud)

        /*if (radioButtonSelected.text == "AVIÓN" || radioButtonSelected.text == "TANQUE" || radioButtonSelected.text == "SUBMARINO") {
            textViewAbrirFuego.text = "¡Abriendo fuego en las coordenadas!: \n" +
                    " ${textViewLat2.text} | ${textViewLong2.text}"
        } else {
            textViewAbrirFuego.text = "No se puede abrir fuego con el vehículo seleccionado"
        }*/

        return textViewAbrirFuego
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.radioButtonPortaavion ->
                    if (checked) {
                        println("Chosed: Portaavión")
                    }
                R.id.radioButtonAvion ->
                    if (checked) {
                        println("Chosed: Avión")
                    }
                R.id.radioButtonBarco ->
                    if (checked) {
                        println("Chosed: Barco")
                    }
                R.id.radioButtonJeep ->
                    if (checked) {
                        println("Chosed: Jeep")
                    }
                R.id.radioButtonSubmarino ->
                    if (checked) {
                        println("Chosed: Submarino")
                    }
                R.id.radioButtonTanque ->
                    if (checked) {
                        println("Chosed: Tanque")
                    }
            }
        }
    }

}