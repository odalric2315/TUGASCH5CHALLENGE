package com.percobaan.mysprgames

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.percobaan.mysprgames.databinding.ActivitySecondBinding
import com.percobaan.mysprgames.databinding.CustomDialogBinding

private val ImageButton.view: Any
    get() = Unit

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
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

        binding.stone1.setOnClickListener {
            if (!state1) {
                state1 = true
                selected1 = it
                option1 = binding.stone1.view.toString()
                binding.stone1.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.paper1.setOnClickListener {
            if (!state1) {
                state1 = true
                selected1 = it
                option1 = binding.paper1.view.toString()
                binding.paper1.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.scissors1.setOnClickListener {
            if (!state1) {
                state1 = true
                selected1 = it
                option1 = binding.scissors1.view.toString()
                binding.scissors1.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.stone2.setOnClickListener {
            if (!state2) {
                state2 = true
                selected2 = it
                option2 = binding.stone2.view.toString()
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
                option2 = binding.paper2.view.toString()
                binding.paper2.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.scissors2.setOnClickListener {
            if (!state2) {
                state2 = true
                selected2 = it
                option2 = binding.scissors2.view.toString()
                binding.scissors2.background = getDrawable(R.drawable.bg_pilihan)
            } else {
                Toast.makeText(this, "Can't Select", Toast.LENGTH_SHORT).show()
            }
        }
        binding.refresh.setOnClickListener {
            resetState()
        }

    }

    private fun resetState() {
        option1 = ""
        option2 = ""
        state1 = false
        state2 = false
        selected1.background = getDrawable(R.drawable.bg_refresh)
        selected2.background = getDrawable(R.drawable.bg_refresh)
    }

    private fun checkOption(option1: String, option2: String) {
        binding.versus.visibility = View.GONE
//        binding.result.visibility = View.VISIBLE
//        if (option1 == option2) {
//            binding.result.text = getString(R.string.equals)
//        } else if (option1 == "stone" && option2 == "scissor") {
//            binding.result.text = getString(R.string.player1win)
//        } else if (option1 == "scissor" && option2 == "stone") {
//            binding.result.text = getString(R.string.comwin)
//        } else if (option1 == "paper" && option2 == "stone") {
//            binding.result.text = getString(R.string.player1win)
//        } else if (option1 == "stone" && option2 == "paper") {
//            binding.result.text = getString(R.string.comwin)
//        } else if (option1 == "scissor" && option2 == "paper") {
//            binding.result.text = getString(R.string.player1win)
//        } else if (option1 == "paper" && option2 == "scissor") {
//            binding.result.text = getString(R.string.comwin)
//        }
    }
    private fun showCustomDialog(title: String){
        val builder = AlertDialog.Builder(this)
        val view = CustomDialogBinding.inflate(layoutInflater)
        builder.setView(view.root)
        val dialog = builder.create()
        view.tvhasil.text = title
        view.btnmain.setOnClickListener {
            val name = view.tvpemenang.text.toString()
            Toast.makeText(this, "$name Menang", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }
        dialog.show()
    }
}