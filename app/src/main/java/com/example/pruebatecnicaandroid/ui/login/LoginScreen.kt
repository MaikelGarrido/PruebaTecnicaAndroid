package com.example.pruebatecnicaandroid.ui.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pruebatecnicaandroid.R
import com.example.pruebatecnicaandroid.ui.login.components.OperationField
import com.example.pruebatecnicaandroid.ui.login.components.SubmitButton
import com.example.pruebatecnicaandroid.ui.login.components.UserField

@Composable
fun LoginScreen(
    operation: String,
    username: String,
    enabled: Boolean,
    onEvent: (LoginEvent) -> Unit,
) {
    ConstraintLayout(
        constraintSet = myConstraintSetLoginScreen,
        modifier = Modifier.fillMaxSize()
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.ic_logo)
                .crossfade(true)
                .build(),
            contentDescription = "Logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.layoutId("composable1")
        )

        OperationField(operation) {
            onEvent(LoginEvent.LoginChanged(it, username))
        }

        UserField(username) {
            onEvent(LoginEvent.LoginChanged(operation, it))
        }

        SubmitButton(enabled) {
            onEvent(LoginEvent.Login)
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        operation = "",
        username = "",
        enabled = true,
        onEvent = { }
    )
}

private val myConstraintSetLoginScreen = ConstraintSet {
    val composable1 = createRefFor("composable1")
    val composable2 = createRefFor("composable2")
    val composable3 = createRefFor("composable3")
    val composable4 = createRefFor("composable4")

    constrain(composable1) {
        top.linkTo(parent.top, 100.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

    constrain(composable2) {
        top.linkTo(parent.top)
        bottom.linkTo(parent.bottom)
        start.linkTo(parent.start, 30.dp)
        end.linkTo(parent.end, 30.dp)
        width = Dimension.fillToConstraints
        //height = Dimension.wrapContent
    }

    constrain(composable3) {
        top.linkTo(composable2.bottom, 10.dp)
        start.linkTo(parent.start, 30.dp)
        end.linkTo(parent.end, 30.dp)
        width = Dimension.fillToConstraints
        //height = Dimension.wrapContent
    }

    constrain(composable4) {
        top.linkTo(composable3.bottom, 36.dp)
        start.linkTo(composable3.start)
        end.linkTo(composable3.end)
        width = Dimension.fillToConstraints
        height = Dimension.wrapContent
    }

}