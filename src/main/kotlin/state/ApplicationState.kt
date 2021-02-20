package state

import androidx.compose.runtime.*
import androidx.compose.ui.unit.IntSize

/**
 * 应用状态
 *
 * @author Jarvis Semou
 */
class ApplicationState{

    /** 存储正在显示的界面 */
    var showingPanel by mutableStateOf<Panel>(Panel.WATTING_PANEL)

    companion object{
        /** 版本 */
        const val VERSION:String="v1.0"

        /** 窗口标题 */
        const val WINDOW_TITLE="AAI  ---- Jarvis Semou $VERSION"

        /** 窗口初始化大小 */
        val INIT_WINDOW_SIZE = IntSize(800,600)
    }


}

/** 界面枚举 */
sealed class Panel{
    /** 主页面 */
    object MAIN_PANEL: Panel()
    /** 任务执行界面 */
    object PROCESSING_PANEL: Panel()
    /** 等待界面 */
    object WATTING_PANEL: Panel()
}
