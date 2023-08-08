package com.example.pruebatecnicaandroid.ui.login.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.layoutId
import com.example.pruebatecnicaandroid.ui.theme.ColorPrimary

@Composable
fun SubmitButton(
    loginEnable: Boolean,
    onClick : () -> Unit
) {
    OutlinedButton(
        onClick = { onClick() },
        enabled = loginEnable,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Color.White,
            containerColor = ColorPrimary,
            disabledContainerColor = Color.LightGray
        ),
        border = BorderStroke(0.dp, Color.Transparent),
        modifier = Modifier.layoutId("composable4"),
        shape = ShapeDefaults.ExtraLarge
    ) {
        Text(
            text = "INICIAR SESIÓN",
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
fun SubmitButtonPreview() {
    SubmitButton(
        loginEnable = false,
        onClick = { }
    )
}


