package com.example.pruebatecnicaandroid.ui.login.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.layoutId
import com.example.pruebatecnicaandroid.R
import com.example.pruebatecnicaandroid.ui.theme.ColorPrimary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OperationField(text: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = text,
        onValueChange = { onTextChanged(it) },
        modifier =  Modifier.layoutId("composable2"),
        enabled = false,
        readOnly = true,
        placeholder = { Text(text = "Operation") },
        maxLines = 1,
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_user),
                contentDescription = "Icon user"
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = ColorPrimary,
            unfocusedBorderColor = ColorPrimary
        ),
        shape = RoundedCornerShape(25.dp)
    )
}


@Preview()
@Composable
fun OperationFieldPreview() {
    OperationField(
        text = "Texto de prueba",
        onTextChanged = { }
    )
}