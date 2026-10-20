package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1.logic.WordSorter
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    private val sorter = WordSorter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SortByVowels(
                        sorter = sorter,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun SortByVowels(sorter: WordSorter, modifier: Modifier = Modifier) {
    var text by rememberSaveable { mutableStateOf(WordSorter.SAMPLE_TEXT) }
    var result by rememberSaveable { mutableStateOf("") }
    val emptyMessage = stringResource(R.string.empty_input)
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = stringResource(R.string.title),
            style = MaterialTheme.typography.headlineSmall
        )
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(stringResource(R.string.input_label)) },
            minLines = 3,
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            // Обработчик кнопки: вызвать логику и показать ответ; пустой ответ — сообщение
            onClick = { result = sorter.sortWordsByVowels(text).ifEmpty { emptyMessage } },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.sort_button))
        }
        OutlinedTextField(
            value = result,
            onValueChange = { },
            readOnly = true,
            label = { Text(stringResource(R.string.result_label)) },
            minLines = 3,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SortByVowelsPreview() {
    Lab1Theme {
        SortByVowels(sorter = WordSorter())
    }
}