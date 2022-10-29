package com.kimym.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/*
 * Your stateless composable can now be reused.
 * @Composable
 * fun StatefulCounter() {
 *     var waterCount by remember { mutableStateOf(0) }
 *     var juiceCount by remember { mutableStateOf(0) }
 *     StatelessCounter(count = waterCount, onIncrement = { waterCount++ })
 *     StatelessCounter(count = juiceCount, onIncrement = { juiceCount++ })
 * }
 */

/*
 * Your stateful composable function can provide the same state to multiple composable functions.
 * @Composable
 * fun StatefulCounter() {
 *     var count by remember { mutableStateOf(0) }
 *     StatelessCounter(count, { count++ })
 *     AnotherStatelessMethod(count, { count *= 2 })
 * }
 */

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}

@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text(text = "You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}
