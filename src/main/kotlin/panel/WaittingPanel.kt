package panel

import state.ApplicationState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * 可以显示 log 的等待界面
 *
 * @author Jarvis Semou
 */
@ExperimentalFoundationApi
@Composable
fun WaittingWithLogPanel(
    applicationState: ApplicationState,
    centerContent: @Composable ()->Unit = {}
){
    Surface{
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            val lazyState = rememberLazyListState()

            LazyColumn (
                state=lazyState,
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ){
                for (i in 1..10000 ){
                    item{
                        Text("Jarvis Semou")
                    }
                }
            }
            VerticalScrollbar(
                modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                adapter = rememberScrollbarAdapter(lazyState,10000,16.dp)
            )
            //这里用来放 logo ？
            centerContent()
        }
    }
}