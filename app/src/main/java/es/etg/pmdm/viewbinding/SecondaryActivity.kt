package es.etg.pmdm.viewbinding

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import es.etg.pmdm.viewbinding.databinding.ActivityMainBinding
import es.etg.pmdm.viewbinding.databinding.ActivitySecondaryBinding
import kotlin.toString

class SecondaryActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSONA = "persona"

    }

    private lateinit var binding: ActivitySecondaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val boton: Button = binding.btnVolver
        boton.setOnClickListener { view ->
            navegarActividad(Intent(this, MainActivity::class.java))
        }

        val persona = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_PERSONA, Persona::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Persona>(EXTRA_PERSONA)
        }

        binding.txtViewNombre.text = persona?.nombre
        binding.txtViewApellidos.text = persona?.apellidos
        binding.txtViewNumero.text = persona?.numero.toString()

    }
    fun navegarActividad(intent: Intent) {
        startActivity(intent)
        val mensaje = getText(R.string.msg_click_navegar)
        val toast = Toast.makeText(this, mensaje, Toast.LENGTH_LONG)
        toast.show()
    }
}