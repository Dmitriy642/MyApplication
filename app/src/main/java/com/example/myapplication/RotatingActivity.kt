package com.example.myapplication

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class RotatingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
            setContent{
            MyApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Rotate()
                }
              
            }
        }

    }
}

@Composable
fun Rotate(){
    val configuration = LocalConfiguration.current
    val isLandscape = configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
        if(isLandscape) {
            Row (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
              RotatingText(stringResource(R.string.first_text), true)
                Spacer(modifier = Modifier.padding(10.dp))
                RotatingText(stringResource(R.string.second_text), true)
            }
        }else{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
                ){
                    RotatingText(stringResource(R.string.first_text), false)
                    RotatingText(stringResource(R.string.second_text), false)
                }
            }
        }

@Preview
@Composable
fun RotatingPreview(){
    MyApplicationTheme {
        Rotate()

    }
}
@Composable
fun RotatingText(text:String, isLandscape:Boolean, modifier: Modifier=Modifier){
    Text(
        text = text,
        fontSize = if(isLandscape) 24.sp else 20.sp,
    )

}
@Composable
fun ImageWolf(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(R.drawable._57677), null)
    }
}