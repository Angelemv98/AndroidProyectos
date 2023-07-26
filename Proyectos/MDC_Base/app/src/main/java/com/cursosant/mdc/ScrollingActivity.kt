package com.cursosant.mdc

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.URLUtil
import android.widget.Toast
import androidx.core.view.isGone
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.cursosant.mdc.databinding.ActivityScrollingBinding
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.snackbar.Snackbar

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_scrolling)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.fab.setOnClickListener {
            if (binding.bottAppBar.fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) {
                binding.bottAppBar.fabAlignmentMode =
                    BottomAppBar.FAB_ALIGNMENT_MODE_END
            } else {
                binding.bottAppBar.fabAlignmentMode =
                    BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
            }
        }
        //Mensaje snackbar
        binding.bottAppBar.setNavigationOnClickListener {
            Snackbar.make(binding.root, R.string.msjExitoso, Snackbar.LENGTH_SHORT)
                .setAnchorView(binding.fab)
                .show()
        }

        //Para acceder a los elementos dentro del include se debe agregar un id en el content
        binding.contentScrolling.btnSkip.setOnClickListener {
            binding.contentScrolling.cvAD.visibility = View.GONE
        }
        binding.contentScrolling.btncomprar.setOnClickListener {
            //Para el snackbar con acciones se requiere el string y la accion que realizara en este caso un toast
            Snackbar.make(it, R.string.card_buying, Snackbar.LENGTH_SHORT)
                .setAnchorView(binding.fab)
                .setAction(R.string.card_to_go) {
                    Toast.makeText(this, R.string.card_historial, Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        //Carga de imagen por defecto
        loadImage()

        //Checkbox, habilitar el edit text de password

        //Se activa el campo password si el checkbox esta activado. Se llama directo el inputtext
        binding.contentScrolling.cbEnabled.setOnClickListener {
            binding.contentScrolling.tilPassword.isEnabled =
                !binding.contentScrolling.tilPassword.isEnabled
        }
        //Detectar foco en un objeto
        binding.contentScrolling.etUrl.onFocusChangeListener =
            View.OnFocusChangeListener { _, focused ->
                //Se inicia el string que puede ser nulo
                var errorStr: String? = null
                val url = binding.contentScrolling.etUrl.text.toString()
                //Si deja de estar enfocado en el campo
                if (!focused) {
                    //Si el campo no esta vacio entonces
                    if (url.isNotEmpty()) {
                        //Si la url no es valida entonces
                        if (!URLUtil.isValidUrl(url)) {
                            //Seteo de error de url no valida
                            errorStr = getString(R.string.unvalid_url)
                        } else {
                            //Carga la imagen y quita el requerido del helper text
                            binding.contentScrolling.tilUrl.helperText = ""
                            loadImage(url)
                        }
                    } else {
                        //Setea el error de que no puede estar vacio
                        //Para mostrar un error de campo se puede usar directamente el text input layout
                        loadImage("https://th.bing.com/th/id/OIP.H0e4bvWEEstM0hbS7CvrEQHaER?pid=ImgDet&rs=1")
                        errorStr = getString(R.string.card_required)
                    }
                }
                //Setea el error al ultimo si es que esta lleno se muestra
                binding.contentScrolling.tilUrl.error = errorStr
            }

        //Para hacer uso del toggle button en las propidades del toggle button debemos agregar la propiedad app:singleSelection="true"

        binding.contentScrolling.togglebutton.addOnButtonCheckedListener { _, checkedId, isChecked ->
            //Se verifica que si esta seleccionado entonces cambia la seleccion de acuerdo al boton
            if (isChecked) {
                binding.contentScrolling.root.setBackgroundColor(
                    when (checkedId) {
                        R.id.btnRed -> Color.RED
                        R.id.btnBlue -> Color.BLUE
                        R.id.btnGreen -> Color.GREEN
                        else -> Color.WHITE
                    }
                )
            }

        }

        binding.contentScrolling.msSwitch.setOnCheckedChangeListener { boton, isChecked ->
            if (isChecked) {
                boton.text = getText(R.string.show_bar)
                binding.bottAppBar.visibility = View.VISIBLE
                binding.fab.visibility = View.VISIBLE

            } else {
                boton.text = getText(R.string.card_Hide_bar )
                binding.bottAppBar.visibility = View.GONE
                binding.fab.visibility = View.GONE
            }

        }
        binding.contentScrolling.sliderVol.addOnChangeListener { slider, value, fromUser ->
            binding.contentScrolling.tvsubtittle.text = "El volumen es: $value"


        }
        binding.contentScrolling.chipEmail.setOnCheckedChangeListener { chip, isChecked ->
            if (isChecked){
                Toast.makeText(this, "${chip.text}", Toast.LENGTH_SHORT).show()
            }
        }
        binding.contentScrolling.chipEmail.setOnCloseIconClickListener {
            binding.contentScrolling.chipEmail.visibility = View.GONE
        }

        //Viejo metodo de casamiento a la vista con programacion
//        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
//            if (findViewById<BottomAppBar>(R.id.bottAppBar).fabAlignmentMode == BottomAppBar.FAB_ALIGNMENT_MODE_CENTER) {
//                findViewById<BottomAppBar>(R.id.bottAppBar).fabAlignmentMode =
//                    BottomAppBar.FAB_ALIGNMENT_MODE_END
//            } else {
//                findViewById<BottomAppBar>(R.id.bottAppBar).fabAlignmentMode =
//                    BottomAppBar.FAB_ALIGNMENT_MODE_CENTER
//            }
//        }
    }

    //Uso de libreria Glide
    private fun loadImage(url: String = "https://exputer.com/wp-content/uploads/2023/05/Forza-Motorsport.jpg") {
        Glide.with(this)
            .load(url)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .centerCrop()
            .into(binding.contentScrolling.ImgCover)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
