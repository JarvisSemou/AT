package state

import androidx.compose.runtime.*
import androidx.compose.ui.unit.IntSize

/**
 * 应用状态
 *
 */
class ApplicationState {

    /** 存储正在显示的界面 */
    var showingPanel by mutableStateOf<Panel>(DEFAULT_PANEL)

    companion object {
        /** 调试状态，true 为调试中，false 反之，默认为 false */
        const val DEBUG = true

        /** 版本 */
        const val VERSION: String = "v1.0"

        /** 窗口标题 */
        const val WINDOW_TITLE = "AT $VERSION ---- Jarvis Semou"

        /** 窗口初始化大小 */
        val INIT_WINDOW_SIZE = IntSize(800, 600)

        /** 默认显示界面 */
        val DEFAULT_PANEL = Panel.START_UP_PANEL
    }


}

/** 界面枚举 */
sealed class Panel {

    abstract fun panelName():String

    /** 主页面 */
    object MAIN_PANEL : Panel() {
        override fun panelName(): String = "主界面"
    }

    /** 任务执行界面 */
    object PROCESSING_PANEL : Panel(){
        override fun panelName(): String = "任务界面"
    }

    /** 错误界面 */
    object ERROR_PANEL : Panel(){
        override fun panelName(): String = "错误界面"
    }

    /** 启动初始化界面 */
    object START_UP_PANEL : Panel() {
        override fun panelName(): String = "启动初始化界面"

    }
}
