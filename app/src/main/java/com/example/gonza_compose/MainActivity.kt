package com.example.gonza_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gonza_compose.ui.theme.GonzacomposeTheme
import com.example.gonza_compose.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GonzacomposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    var name by remember { mutableStateOf("") }
    var maxLength = 10

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.TopStart),
            text = "Este texto estara a la izq top"
        )
        OutlinedTextField(
            modifier = Modifier
                .align(Alignment.Center),
            value = name,
            onValueChange = {
                name = if (it.length <= maxLength) it else it.take(maxLength)
            },
            label = {
                Text(text = "Nombre")
            },
            placeholder = { Text(text = "Escribe tu nombre") },
            maxLines = 1,
            textStyle = Typography.body1,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                keyboardType = KeyboardType.Text,
                autoCorrect = true,
                imeAction = ImeAction.Done
            )
        )
        Text(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(horizontal = 16.dp),
            text = "Este texto estara al centro"
        )
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "imagen de prueba"
        )
    }
}

@Preview(
    showBackground = true,
    apiLevel = 30,
    backgroundColor = 1111111111,
    showSystemUi = true,
    group = "Home",
    device = Devices.PIXEL_4
)
@Composable
fun DefaultPreview() {
    Greeting()
}