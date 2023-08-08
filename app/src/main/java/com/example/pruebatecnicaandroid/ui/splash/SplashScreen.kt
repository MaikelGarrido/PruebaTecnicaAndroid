package com.example.pruebatecnicaandroid.ui.splash

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.pruebatecnicaandroid.R
import com.example.pruebatecnicaandroid.ui.activity.MainViewModel
import com.example.pruebatecnicaandroid.utils.asyncData
import kotlinx.coroutines.delay
import timber.log.Timber

@Composable
fun SplashScreen(onNavigation: (Boolean) -> Unit) {
    val mainViewModel: MainViewModel = hiltViewModel()
    val user by mainViewModel.user.collectAsStateWithLifecycle()

    LaunchedEffect(true) {
        delay(5000)
        asyncData(user) { result ->
            if (result != null) onNavigation(true) else onNavigation(false)
        }
    }

    ConstraintLayout(
        constraintSet = myConstraintSplashScreen,
        modifier = Modifier.fillMaxSize()
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.data))
        val progress by animateLottieCompositionAsState(
            // pass the composition created above
            composition = composition,

            // Iterates Forever
            iterations = LottieConstants.IterateForever,

            // pass isPlaying we created above,
            // changing isPlaying will recompose
            // Lottie and pause/play
            //isPlaying = isPlaying,

            // pass speed we created above,
            // changing speed will increase Lottie
            //speed = speed,

            // this makes animation to restart
            // when paused and play
            // pass false to continue the animation
            // at which it was paused
            //restartOnPlay = false
        )

        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier.layoutId("composable1")
        )

    }
}


@Preview
@Composable
fun SplashScreenPreview() {
    SplashScreen { }
}

private val myConstraintSplashScreen = ConstraintSet {
    val composable1 = createRefFor("composable1")

    constrain(composable1) {
        top.linkTo(parent.top)
        bottom.linkTo(parent.bottom)
        start.linkTo(parent.start)
        end.linkTo(parent.end)
        width = Dimension.value(300.dp)
        height = Dimension.value(300.dp)
    }

}