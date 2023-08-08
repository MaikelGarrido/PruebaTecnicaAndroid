package com.example.pruebatecnicaandroid.utils

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.pruebatecnicaandroid.R
import com.example.pruebatecnicaandroid.ui.login.LoginEvent
import com.example.pruebatecnicaandroid.ui.theme.ColorPrimary

@Composable
fun ShowErrorEthernet(onDismiss: (LoginEvent) -> Unit) {
    val isPlaying by remember { mutableStateOf(true) }
    val speed by remember { mutableStateOf(1f) }
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.connection_error))
    val progress by animateLottieCompositionAsState(
        // pass the composition created above
        composition,

        // Iterates Forever
        iterations = LottieConstants.IterateForever,

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = isPlaying,

        // pass speed we created above,
        // changing speed will increase Lottie
        speed = speed,

        // this makes animation to restart
        // when paused and play
        // pass false to continue the animation
        // at which it was paused
        restartOnPlay = false
    )

    Dialog(
        onDismissRequest = { onDismiss(LoginEvent.Clear) },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = ShapeDefaults.ExtraLarge
        ) {
            ConstraintLayout(
                constraintSet = myConstraintShowError,
                modifier = Modifier.padding(10.dp)
            ) {

                LottieAnimation(
                    composition = composition,
                    progress = { progress },
                    modifier = Modifier
                        .height(200.dp)
                        .width(300.dp)
                        .layoutId("composable1")
                )

                Text(
                    text = "¡ Se ha presentado un Error !",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier.layoutId("composable2")
                )

                Text(
                    text = "Verifique su conexión a Internet.",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier.layoutId("composable3")
                )

                OutlinedButton(
                    onClick = { onDismiss(LoginEvent.Clear) },
                    modifier = Modifier.layoutId("composable4"),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = ColorPrimary
                    ),
                    shape = ShapeDefaults.ExtraLarge
                ) {
                    Text(text = "OK")
                }

            }
        }
    }
}

@Composable
fun ShowError(
    message: String,
    onDismiss :(LoginEvent) -> Unit
) {
    val isPlaying by remember { mutableStateOf(true) }
    val speed by remember { mutableStateOf(1f) }
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.error))
    val progress by animateLottieCompositionAsState(
        // pass the composition created above
        composition,

        // Iterates Forever

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = isPlaying,

        // pass speed we created above,
        // changing speed will increase Lottie
        speed = speed,

        // this makes animation to restart
        // when paused and play
        // pass false to continue the animation
        // at which it was paused
        restartOnPlay = false
    )

    Dialog(
        onDismissRequest = { onDismiss(LoginEvent.Clear) },
        properties = DialogProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(10.dp),
            shape = ShapeDefaults.ExtraLarge
        ) {
            ConstraintLayout(
                constraintSet = myConstraintShowError,
                modifier = Modifier.padding(10.dp)
            ) {

                LottieAnimation(
                    composition = composition,
                    progress = { progress },
                    modifier = Modifier
                        .height(200.dp)
                        .width(300.dp)
                        .layoutId("composable1")
                )

                Text(
                    text = "¡ Se ha presentado un error !",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier.layoutId("composable2")
                )

                Text(
                    text = "$message. \n Vuelve a intentarlo.",
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    modifier = Modifier.layoutId("composable3")
                )

                OutlinedButton(
                    onClick = { onDismiss(LoginEvent.Clear) },
                    modifier = Modifier.layoutId("composable4"),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = Color.White,
                        containerColor = ColorPrimary
                    ),
                    border = BorderStroke(0.dp, Color.Transparent),
                    shape = ShapeDefaults.ExtraLarge
                ) {
                    Text(text = "OK")
                }


            }
        }
    }


}

private val myConstraintShowError = ConstraintSet {
    val composable1 = createRefFor("composable1")
    val composable2 = createRefFor("composable2")
    val composable3 = createRefFor("composable3")
    val composable4 = createRefFor("composable4")

    constrain(composable1) {
        start.linkTo(parent.start)
        end.linkTo(parent.end)
    }

    constrain(composable2) {
        top.linkTo(composable1.bottom, 10.dp)
        start.linkTo(composable1.start)
        end.linkTo(composable1.end)
    }

    constrain(composable3) {
        top.linkTo(composable2.bottom, 5.dp)
        start.linkTo(composable2.start)
        end.linkTo(composable2.end)
    }

    constrain(composable4) {
        top.linkTo(composable3.bottom, 20.dp)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        bottom.linkTo(parent.bottom, 20.dp)
    }


}