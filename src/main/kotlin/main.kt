import androidx.compose.desktop.Window
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.remember
import panel.MainPanel
import panel.ProcessingPanel
import panel.WaittingWithLogPanel
import state.ApplicationState
import state.Panel
import java.io.File
import javax.imageio.ImageIO


@ExperimentalFoundationApi
fun main(args:Array<String>) = Window(
    title = ApplicationState.WINDOW_TITLE,
    centered = true,
    size = ApplicationState.INIT_WINDOW_SIZE,
    icon = ImageIO.read(Thread.currentThread().contextClassLoader.getResourceAsStream("images/icon.jpg"))
) {
    val applicationState = remember { ApplicationState() }
    //处理界面显示
    when (applicationState.showingPanel) {
        //显示主界面
        Panel.MAIN_PANEL -> MainPanel(applicationState)
        //显示执行界面
        Panel.PROCESSING_PANEL -> ProcessingPanel(applicationState)
        //等待界面
        Panel.WATTING_PANEL -> WaittingWithLogPanel(applicationState)
    }

}



