package ali.ghanbariyan.taskapp.mvp.viewTaskApp

import ali.ghanbariyan.taskapp.adapter.RecyclerTaskAdapter
import ali.ghanbariyan.taskapp.databinding.ActivityMainBinding
import ali.ghanbariyan.taskapp.databinding.CustomDialogBinding
import ali.ghanbariyan.taskapp.db.entity.TaskEntity
import ali.ghanbariyan.taskapp.mvp.ext.OnBindData
import android.R.color
import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ViewMainActivity(contextInstance: Context) : FrameLayout(contextInstance) {

    val binding = ActivityMainBinding.inflate(LayoutInflater.from(context))
    lateinit var adapter: RecyclerTaskAdapter

    fun showDialog(onBindData: OnBindData) {
        binding.fab.setOnClickListener {

            val view = CustomDialogBinding.inflate(LayoutInflater.from(context))

            val dialog = Dialog(context)
            dialog.setContentView(view.root)
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawable(color.transparent.toDrawable())
            dialog.create()
            dialog.show()


            view.btnCancel.setOnClickListener {
                dialog.dismiss()

            }

            view.btnSave.setOnClickListener {
                val text = view.edtTask.text.toString()

                if (text.isNotEmpty()) {
                    onBindData.saveData(TaskEntity(title = text, state = false))

                    Toast.makeText(
                        context,
                        "وظیفه با موفقیت ذخیره شد",
                        Toast.LENGTH_SHORT
                    ).show()

                    dialog.dismiss()

                } else {

                    Toast.makeText(
                        context,
                        context.getString(ali.ghanbariyan.taskapp.R.string.add_task_txt_edt),
                        Toast.LENGTH_SHORT
                    ).show()

                }

            }

        }

    }

    fun initRecycler(tasks: ArrayList<TaskEntity>, onBindData: OnBindData) {

        adapter = RecyclerTaskAdapter(tasks, onBindData)
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = adapter

    }

    fun showTasks(tasks: List<TaskEntity>) {
        val data = arrayListOf<TaskEntity>()
        tasks.forEach { data.add(it) }
        adapter.dataUpdate(data)
    }

    fun setData(onBindData: OnBindData) {

        onBindData.requestData(false)

        binding.radioBtnFalse.setOnClickListener {
            binding.stateTxt.text = "کارهای انجام نشده"
            onBindData.requestData(false)


        }

        binding.radioBtnTrue.setOnClickListener {
            binding.stateTxt.text = "کارهای انجام شده"
            onBindData.requestData(true)
        }


    }
}