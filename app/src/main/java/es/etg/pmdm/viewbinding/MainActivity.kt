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
import es.etg.pmdm.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_PERSONA = "persona"

    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val boton: Button = binding.btnNavegar
        boton.setOnClickListener { view ->

            val nombre = binding.editTxtNombre.text.toString()
            val apellidos = binding.editTxtApellidos.text.toString()
            val numero = binding.editTxtNumero.text.toString().toInt()

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