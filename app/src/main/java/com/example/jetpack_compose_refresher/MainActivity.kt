package com.example.jetpack_compose_refresher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpack_compose_refresher.ui.theme.Jetpack_compose_refresherTheme
import com.example.jetpack_compose_refresher.ui.theme.montseratFamily

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Jetpack_compose_refresherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TextOverflow()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Jetpack_compose_refresherTheme {
        Text(
            stringResource(id = R.string.greeting_string),
            color = Color.Blue,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun MultiInlineTextSpanStyle() {
    Jetpack_compose_refresherTheme {
        Text(
            stringResource(id = R.string.greeting_string_spanstyle),
            color = Color.Blue,
            textAlign = TextAlign.Center,
            fontFamily = montseratFamily,
            fontWeight = FontWeight.W900,
            fontSize = 30.sp
        )

    }
}

@Composable
fun MultipleStyledText() {
    Text(text = "MultiStyled Text")
    Text(buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Magenta)) {
            append("M")
        }
        append("ose")
        withStyle(style = SpanStyle(color = Color.Cyan)) {
            append("s")
        }

    }, textAlign = TextAlign.Center)
}

@Composable
fun SimpleFilledTextFieldSample() {
    Text(text = "Filled TextField")
    var text by remember { mutableStateOf("first.last@domain.com") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Email Address") },
        keyboardOptions = KeyboardOptions(autoCorrect = true, keyboardType = KeyboardType.Password)
    )
}

@Composable
fun TextOverflow() {
    Text(text = "Text Overflow\n")
    Text(
        text = stringResource(id = R.string.text_long_paragraph),
        maxLines = 2,
        overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
    )
}