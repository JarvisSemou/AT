package common_layout

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import state.ApplicationState
import state.Panel


/**
 * 可以显示 log 的等待界面控件
 *
 */
@ExperimentalFoundationApi
@Composable
fun WaittingWithLog(
    applicationState: ApplicationState,
    successPanel:Panel,
    errorPanel: Panel =Panel.ERROR_PANEL,
    logTask: CoroutineScope.(logList:SnapshotStateList<String>)->Unit = { },
    centerContent: @Composable ()->Unit = {}
){
    Surface{
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            val lazyState = rememberLazyListState()
            val logList = remember{ mutableStateListOf<String>()}
            val mScrollbalAdapter = rememberScrollbarAdapter(lazyState,logList.size,16.dp)
            val mLogTask=remember<Job>{
                CoroutineScope(Dispatchers.Default).launch {
                    logTask(logList)
                }
            }
            LazyColumn (
                state=lazyState,
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.Start
            ){
                items(
                    items=logList
                ){
                    Text(text=it,Modifier.selectable(selected = false){})
                }
            }
            VerticalScrollbar(
                modifier = Modifier.align(Alignment.CenterEnd).fillMaxHeight(),
                adapter = mScrollbalAdapter
            )
            //这里用来放 logo ？
            centerContent()
        }
    }
}


/**
 * 等待界面控件的状态
 *
 */
class WaittingWithLogState {

}