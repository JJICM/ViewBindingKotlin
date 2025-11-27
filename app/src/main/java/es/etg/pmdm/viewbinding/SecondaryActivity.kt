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
import kotlin.toString

class SecondaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_secondary)

        val boton: Button = findViewById<Button>(R.id.btnNavegar2)
        boton.setOnClickListener { view ->
            navegarActividad(Intent(this, MainActivity::class.java))
        }

        val persona = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(MainActivity.EXTRA_PERSONA, Persona::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Persona>("persona")
        }

        findViewById<TextView>(R.id.txtViewNombre).text = persona!!.nombre
        findViewById<TextView>(R.id.txtViewApellidos).text = persona!!.apellidos
        findViewById<TextView>(R.id.txtViewNumero).text = persona!!.numero.toString()

    }
    fun navegarActividad(intent: Intent) {
        startActivity(intent)
        val mensaje = getText(R.string.msg_click_navegar)
        val toast = Toast.makeText(this, mensaje, Toast.LENGTH_LONG)
        toast.show()
    }
}