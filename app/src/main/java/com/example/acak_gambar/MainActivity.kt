package com.example.acak_gambar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.node.modifierElementOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.acak_gambar.ui.theme.Acak_GambarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Acak_GambarTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    acakGambar()
                }
            }
        }
    }
}

@Composable
fun acakGambar (modifier: Modifier = Modifier) {

    var result by remember {
        mutableStateOf(1)
    }
    val imageResouce = when (result){
        1 -> R.drawable.hewan_1
        2 -> R.drawable.hewan_2
        3 -> R.drawable.hewan_3
        4 -> R.drawable.hewan_4
        else -> R.drawable.hewan_5
    }


    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = imageResouce),
            contentDescription = result.toString()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { result = (1..5).random() }) {
            Text(stringResource(R.string.acak_buton_name))
        }
    }
}

@Preview(showBackground = true, device = "id:pixel_3a", showSystemUi = true)
@Composable
fun acakGambarPreview () {
    acakGambar ()
}