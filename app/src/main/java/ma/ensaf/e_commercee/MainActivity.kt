package ma.ensaf.e_commercee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.id_language)

// Définissez une valeur par défaut vide pour désélectionner l'élément
        spinner.setSelection(0,false)
    }
}