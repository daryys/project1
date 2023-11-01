package ru.example.project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import ru.example.project1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.itemFlowerFirst.root.setOnClickListener {
            Toast.makeText(this@MainActivity, "First", Toast.LENGTH_SHORT).show()
        }

        binding.itemFlowerSecond.apply {
            ivImage.setImageDrawable(
                ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.ic_plant_yellow
                )
            )
            tvName.text = getString(R.string.tulip)
            root.setOnClickListener {
                Toast.makeText(this@MainActivity, "Second", Toast.LENGTH_SHORT).show()
            }
        }

        binding.itemFlowerThird.apply {
            ivImage.setImageDrawable(
                ContextCompat.getDrawable(
                    this@MainActivity,
                    R.drawable.ic_plants_cactus
                )
            )
            tvName.text = getString(R.string.cactus)
            root.setOnClickListener {
                Toast.makeText(this@MainActivity, "Third", Toast.LENGTH_SHORT).show()
            }
        }

    }
}