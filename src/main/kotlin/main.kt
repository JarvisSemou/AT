import androidx.compose.desktop.Window
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import panel.*
import state.ApplicationState
import state.Panel
import java.io.File
import javax.imageio.ImageIO

/**
 * 程序入口
 *
 * @author Jarvis Semou
 */
@ExperimentalFoundationApi
fun main() = Window(
    title = ApplicationState.WINDOW_TITLE,
    centered = true,
    size = ApplicationState.INIT_WINDOW_SIZE,
    icon = ImageIO.read(Thread.currentThread().contextClassLoader.getResourceAsStream("images/icon.jpg"))
) {
    val applicationState = remember { ApplicationState() }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        //调试时切换界面的按钮
        if (ApplicationState.DEBUG) debugPanelContent(applicationState)

        //处理界面显示
        PanelSwitcher(applicationState)
    }

}

/**
 * 调试调试面板内容
 *
 */
@Composable
fun debugPanelContent(applicationState: ApplicationState) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = { applicationState.showingPanel = Panel.START_UP_PANEL }) {
            Text(Panel.START_UP_PANEL.panelName())
        }
        Button(onClick = { applicationState.showingPanel = Panel.MAIN_PANEL }) {
            Text(Panel.MAIN_PANEL.panelName())
        }
        Button(onClick = { applicationState.showingPanel = Panel.PROCESSING_PANEL }) {
            Text(Panel.PROCESSING_PANEL.panelName())
        }
        Button(onClick = { applicationState.showingPanel = Panel.ERROR_PANEL }) {
            Text(Panel.ERROR_PANEL.panelName())
        }
    }
}

/**
 * 界面切换器
 *
 */
@ExperimentalFoundationApi
@Composable
fun PanelSwitcher(applicationState: ApplicationState) {
    when (applicationState.showingPanel) {
        //初始化界面
        Panel.START_UP_PANEL -> StartUpPanel(applicationState)
        //显示主界面
        Panel.MAIN_PANEL -> MainPanel(applicationState)
        //显示执行界面
        Panel.PROCESSING_PANEL -> ProcessingPanel(applicationState)
        //错误界面
        Panel.ERROR_PANEL -> ErrorPanel(applicationState)
    }
}
