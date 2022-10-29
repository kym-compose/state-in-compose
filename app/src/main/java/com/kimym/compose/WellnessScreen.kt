package com.kimym.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier

/*
 * Don't do this!
 * val list = remember { mutableStateListOf()<WellnessTask>() }
 * list.addAll(getWellnessTasks())
 * It might result in unexpected recomposition and suboptimal UI performance.
 * It would result in duplicated items being added for every recomposition.
 *
 * Do this instead.
 * val list = remember {
 * mutableStateListOf<WellnessTask>().apply { addAll(getWellnessTasks()) }
 */

/*
 * If you try to use 'rememberSaveable()' to store the list,
 * you'll get a runtime exception.
 * You shouldn't be using rememberSaveable to store large amounts of data or
 * complex data structures that require lengthy serialization or deserialization.
 */

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatefulCounter()
        val list = remember { getWellnessTasks().toMutableStateList() }
        WellnessTasksList(list = list, onCloseTask = { task -> list.remove(task) })
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
