package com.example.rohanroll
import android.R
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rohanroll.databinding.ActivityMainBinding // Replace with your actual package name

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding // ViewBinding instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val diceOptions = arrayOf("4", "6", "8", "10", "12", "20")

        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, diceOptions)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.diceSpinner.adapter = adapter

        binding.rollButton.setOnClickListener {
            rollDice()
        }

        binding.rollTwiceButton.setOnClickListener {
            rollDiceTwice()
        }
    }

    private fun rollDice() {
        val selectedRadioButtonId = binding.diceRadioGroup.checkedRadioButtonId
        val selectedDice: Int = when (selectedRadioButtonId) {
            binding.radio4.id -> 4
            binding.radio6.id -> 6
            // Add more cases for other dice options
            else -> 6
        }

        val randomResult = (1..selectedDice).random()
        binding.resultTextView.text = randomResult.toString()
    }

    private fun rollDiceTwice() {
        val selectedDice = binding.diceSpinner.selectedItem.toString().toInt()

        val randomResult1 = (1..selectedDice).random()
        val randomResult2 = (1..selectedDice).random()

        binding.resultTextView.text = "Result 1: $randomResult1\nResult 2: $randomResult2"
    }
}
