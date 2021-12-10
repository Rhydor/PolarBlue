package com.app.polarblue

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //Setup
        val bundle = intent.extras
        val displayName = bundle?.getString("displayName")

        setup(displayName ?: "")

        //Guardado de datos
        val prefs = getSharedPreferences(getString(R.string.prefs_file_data_user), Context.MODE_PRIVATE).edit()
        prefs.putString("displayName", displayName)
        prefs.apply()
    }

    private fun setup(displayName: String){
        title = "Inicio"

        /*textName.text = "Bienvenido: $displayName"
        buttonLogOut.setOnClickListener {
            val prefs = getSharedPreferences(getString(R.string.prefs_file_data_user), Context.MODE_PRIVATE).edit()
            prefs.clear()
            prefs.apply()

            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }*/

        buttonAddAlbum.setOnClickListener {
            val addAlbumIntent = Intent( this, NewAlbumActivity::class.java)
            startActivity(addAlbumIntent)
        }
    }
}