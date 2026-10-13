package ali.ghanbariyan.taskapp.ui.activity

import ali.ghanbariyan.taskapp.mvp.modelTaskApp.ModelMainActivity
import ali.ghanbariyan.taskapp.mvp.presenterTaskApp.PresenterMainActivity
import ali.ghanbariyan.taskapp.mvp.viewTaskApp.ViewMainActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var presenter: PresenterMainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = ViewMainActivity(this)
        setContentView(view.binding.root)

        presenter = PresenterMainActivity(ModelMainActivity(this), view)
        presenter.onCreate()
    }

    override fun onDestroy() {

        presenter.onDestroy()
        super.onDestroy()
    }
}