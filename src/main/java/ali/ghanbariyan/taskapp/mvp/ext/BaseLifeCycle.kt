package ali.ghanbariyan.taskapp.mvp.ext

interface BaseLifeCycle {

    fun onCreate()
    fun onDestroy() {}
    fun onStop() {}
}