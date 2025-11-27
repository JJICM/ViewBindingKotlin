package es.etg.pmdm.viewbinding

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSONA = "persona"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val boton: Button = findViewById<Button>(R.id.btnNavegar)
        boton.setOnClickListener { view ->

            val nombre = findViewById<EditText>(R.id.editTxtNombre).text.toString()
            val apellidos = findViewById<EditText>(R.id.editTxtApellidos).text.toString()
            val numero = findViewById<EditText>(R.id.editTxtNumero).text.toString().toInt()

            val persona: Persona = Persona(nombre, apellidos, numero)
            val intent = Intent(this, SecondaryActivity::class.java)
            intent.putExtra(EXTRA_PERSONA, persona)
            navegarActividad(intent)
        }

    }
    fun navegarActividad(intent: Intent) {
        startActivity(intent)
        val mensaje = getText(R.string.msg_click_navegar)
        val toast = Toast.makeText(this, mensaje, Toast.LENGTH_LONG)
        toast.show()
    }
}