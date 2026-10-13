package ali.ghanbariyan.taskapp.mvp.presenterTaskApp

import ali.ghanbariyan.taskapp.db.entity.TaskEntity
import ali.ghanbariyan.taskapp.mvp.ext.BaseLifeCycle
import ali.ghanbariyan.taskapp.mvp.ext.OnBindData
import ali.ghanbariyan.taskapp.mvp.modelTaskApp.ModelMainActivity
import ali.ghanbariyan.taskapp.mvp.viewTaskApp.ViewMainActivity

class PresenterMainActivity(
    private val model: ModelMainActivity,
    private val view: ViewMainActivity
) : BaseLifeCycle {

    override fun onCreate() {
        setNewTask()
        setDataInitRecycler()
        dataHandel()
    }

    private fun setNewTask() {

        view.showDialog(
            object : OnBindData {
                override fun saveData(taskEntity: TaskEntity) {
                    model.setData(taskEntity)
                }
            }
        )

    }

    private fun setDataInitRecycler() {
        view.initRecycler(
            arrayListOf(),
            object : OnBindData {
                override fun editData(taskEntity: TaskEntity) {
                    model.editData(taskEntity)
                }

                override fun deleteData(taskEntity: TaskEntity) {
                    model.deleteData(taskEntity)
                }
            }
        )
    }

    private fun dataHandel() {

        view.setData(
            object : OnBindData {
                override fun requestData(state: Boolean) {
                    model.getTasks(
                        state,
                        object : OnBindData {
                            override fun getData(taskEntity: List<TaskEntity>) {
                                view.showTasks(taskEntity)
                            }
                        }
                    )
                }
            }
        )

    }

    override fun onDestroy() {

    }

}