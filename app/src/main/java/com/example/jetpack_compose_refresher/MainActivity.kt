package com.example.jetpack_compose_refresher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
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
                    ClickableSample()
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
    Column() {
        Text(text = "Filled TextField")
        var text by remember { mutableStateOf(" ") }
        TextField(
            value = text,
            singleLine = true,
            onValueChange = { trimZeros -> text = trimZeros.trimStart { it == '0' } },
            label = { Text("Email Address") },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                autoCorrect = true,
                keyboardType = KeyboardType.Password
            ),
        )
    }
}

@Composable
fun TextOverflow() {
    Column() {
        Text(text = "Text Overflow\n")
        SelectionContainer() {
            Text(
                text = stringResource(id = R.string.text_long_paragraph),
                maxLines = 2,
                overflow = androidx.compose.ui.text.style.TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun ClickableSample() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val count = remember {
            mutableStateOf(0)
        }
        Text(
            text = count.value.toString(),
            fontSize = 40.sp,
            modifier = Modifier.clickable { count.value += 1 },
        )
    }
}