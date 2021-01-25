package com.example.mod2unidad2ejercito

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.mod2unidad2ejercito.entities.*

class MainActivity : AppCompatActivity() {

    // => variables inicializadas en métodos mover() & abrirFuego()
    lateinit var textViewMover: TextView
    lateinit var textViewAbrirFuego: TextView
    lateinit var textViewLat1: EditText
    lateinit var textViewLong1: EditText
    lateinit var textViewLat2: EditText
    lateinit var textViewLong2: EditText
    lateinit var radioButtonAvion: RadioButton
    lateinit var radioButtonTanque: RadioButton
    lateinit var radioButtonSubmarino: RadioButton

    // => instancias utilizadas en el onCreate()
    val ejercito = Ejercito()
    val avion = Avion()
    val barco = Barco()
    val jeep = Jeep()
    val portaavion = Portaavion()
    val submarino = Submarino()
    val tanque = Tanque()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ejercito.flota.add(barco.id)
        ejercito.flota.add(portaavion.id)
        ejercito.flota.add(submarino.id)
        ejercito.divisionTerrestre.add(jeep)
        ejercito.divisionTerrestre.add(tanque)
        ejercito.divisionAerea.add(avion)

        mostrarFlota()
        mostrarDivTerrestre()
        mostrarDivAerea()

        // => views que muestran resultado en pantalla
        textViewMover = findViewById(R.id.textViewResultMover)
        textViewAbrirFuego = findViewById(R.id.textViewResultAbrirFuego)
    }

    /*
    Métodos que muestran listados por consola
     */
    fun mostrarFlota(){
        for (veh in ejercito.flota){
            println(veh)
        }
    }
    fun mostrarDivTerrestre(){
        for (veh in ejercito.divisionTerrestre){
            println(veh)
        }
    }
    fun mostrarDivAerea(){
        for (veh in ejercito.divisionAerea){
            println(veh)
        }
    }

    /*
    Toma valores del EditText y los muestra por medio de textViewMover que se devuelve a la vista en el onCreate()
    */
    @SuppressLint("SetTextI18n") //Elimina resaltado de Lint
    fun mover(view: View) : TextView{
        textViewLat1 = findViewById(R.id.editTextMoverLatitud)
        textViewLong1 = findViewById(R.id.editTextMoverLongitud)

        textViewMover.text = "Moviendo hacia las coordenadas: \n" +
                "${textViewLat1.text} | ${textViewLong1.text}"
        return textViewMover
    }

    /*
    Toma valores del EditText y los muestra por medio de textViewMover que se devuelve a la vista en el onCreate()
    */
    @SuppressLint("SetTextI18n") //Elimina resaltado de Lint
    fun abrirFuego(view: View): TextView{
        textViewLat2 = findViewById(R.id.editTextAbrirFuegoLatitud)
        textViewLong2 = findViewById(R.id.editTextAbrirFuegoLongitud)
        radioButtonAvion = findViewById(R.id.radioButtonAvion)
        radioButtonTanque = findViewById(R.id.radioButtonTanque)
        radioButtonSubmarino = findViewById(R.id.radioButtonSubmarino)

        if (radioButtonAvion.isChecked || radioButtonTanque.isChecked || radioButtonSubmarino.isChecked) {
            textViewAbrirFuego.text = "¡Abriendo fuego en las coordenadas!: \n" +
                " ${textViewLat2.text} | ${textViewLong2.text}"
        } else {
            textViewAbrirFuego.text = "No se puede abrir fuego con el vehículo seleccionado"
        }
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