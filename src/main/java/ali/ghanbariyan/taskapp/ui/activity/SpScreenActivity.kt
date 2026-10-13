package ali.ghanbariyan.taskapp.ui.activity

import ali.ghanbariyan.taskapp.databinding.SplashscreenBinding
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SpScreenActivity : AppCompatActivity() {

    private lateinit var binding: SplashscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)



        Handler(mainLooper).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)


            finish()

        }, 1000)

    }
}