package com.percobaan.mysprgames

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.*
import com.percobaan.mysprgames.databinding.ActivitySecondBinding
import com.percobaan.mysprgames.databinding.CustomDialogBinding

val ImageButton.view: Any
    get() = Unit


class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private lateinit var name: String
    private lateinit var option1: String
    private lateinit var option2: String
    private var state1: Boolean = false
    private var state2: Boolean = false
    private lateinit var selected1: View
    private lateinit var selected2: View

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent
        val bundle = intent.getBundleExtra("bundle")
        val name = intent.getStringExtra("name")
        binding.player1.text = intent?.getStringExtra("name")

        binding.stone1.setOnClickListener {
            if (!state1) {
                state1 = true
                selected1 = it
                option1 = getString(R.string.batu)
//                option1 = binding.stone1.view.toString()
                binding.stone1.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.paper1.setOnClickListener {
            if (!state1) {
                state1 = true
                selected1 = it
                option1 = getString(R.string.kertas)
//                option1 = binding.paper1.view.toString()
                binding.paper1.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.scissors1.setOnClickListener {
            if (!state1) {
                state1 = true
                selected1 = it
                option1 = getString(R.string.gunting)
//                option1 = binding.scissors1.view.toString()
                binding.scissors1.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.stone2.setOnClickListener {
            if (!state2) {
                state2 = true
                selected2 = it
                option2 = getString(R.string.batu)
//                option2 = binding.stone2.view.toString()
                binding.stone2.background = getDrawable(R.drawable.bg_pilihan)
                checkOption(option1, option2)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.paper2.setOnClickListener {
            if (!state2) {
                state2 = true
                selected2 = it
                option2 = getString(R.string.kertas)
//                option2 = binding.paper2.view.toString()
                binding.paper2.background = getDrawable(R.drawable.bg_pilihan)
                checkOption(option1, option2)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.scissors2.setOnClickListener {
            if (!state2) {
                state2 = true
                selected2 = it
                option2 = getString(R.string.gunting)
//                option2 = binding.scissors2.view.toString()
                binding.scissors2.background = getDrawable(R.drawable.bg_pilihan)
                checkOption(option1, option2)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.refresh.setOnClickListener {
            resetState()
        }
        binding.exit.setOnClickListener{
            val Intent = Intent(this, LP3Fragment::class.java)
            startActivity(Intent)
        }

    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun resetState() {
        option1 = ""
        option2 = ""
        state1 = false
        state2 = false
        selected1.background = getDrawable(this,R.drawable.bg_refresh)
        selected2.background = getDrawable(this,R.drawable.bg_refresh)
    }

    private fun checkOption(option1: String, option2: String) {
        binding.versus.visibility = View.GONE
        if (option1 == option2){
            showCustomDialog("Draw!")
        } else {
            if ((option1 == getString(R.string.batu) && option2 == getString(R.string.gunting)) ||
                (option1 == getString(R.string.kertas) && option2 == getString(R.string.batu)) ||
                (option1 == getString(R.string.gunting) && option2 == getString(R.string.kertas))
            ) {
                val name = String
                showCustomDialog("$name Win!")
            } else {
                showCustomDialog("Pemain 2 Win!")
            }
        }
    }
    private fun showCustomDialog(title: String){
        val builder = AlertDialog.Builder(this)
        val view = CustomDialogBinding.inflate(layoutInflater)
        builder.setView(view.root)
        val dialog = builder.create()
        view.tvhasil.text = title
        view.btnkembali.setOnClickListener {
            toMenu()
            dialog.dismiss()
        }
        view.btnmain.setOnClickListener {
//            val name = view.tvpemenang.text.toString()
//            Toast.makeText(this, "$name Menang", Toast.LENGTH_LONG).show()
            resetState()
            dialog.dismiss()
        }
       dialog.show()
    }

    private fun toMenu(){
        val intent = Intent(this,LP3Fragment::class.java)
        startActivity(intent)
    }
}