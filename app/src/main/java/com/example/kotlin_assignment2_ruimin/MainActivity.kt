package com.example.kotlin_assignment2_ruimin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlin_assignment2_ruimin.ui.theme.KotlinAssignment2RuiminTheme
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinAssignment2RuiminTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Bmi()
                }
            }
        }
    }

    @Composable
    fun Bmi() {
        var heightInput: String by remember { mutableStateOf("") }
        var weightInput: String by remember { mutableStateOf("") }
        val userHeight = heightInput.toFloatOrNull() ?: 0.0f
        val userWeight = weightInput.toIntOrNull() ?: 0
        val userBmi = if(userWeight > 0 && userHeight > 0) userWeight / (userHeight * userHeight) * 10000 else 0.0

        Column {
            Text(
                text = "Body mass index",
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp)
            )
            OutlinedTextField(
                value = heightInput,
                onValueChange = {heightInput = it.replace(',','.')},
                label =  {Text(stringResource(R.string.userHeight))},
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            )
            OutlinedTextField(
                value = weightInput,
                onValueChange = {weightInput = it.replace(',','.')},
                label = {Text(stringResource(R.string.userWeight))},
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            )
            Text(
                text = stringResource(R.string.body_mass_index_is) + userBmi,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp, bottom = 16.dp)
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinAssignment2RuiminTheme {
            Bmi()
        }
    }
}