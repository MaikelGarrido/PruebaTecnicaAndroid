package com.example.pruebatecnicaandroid.ui.scaffold

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.layoutId
import com.example.pruebatecnicaandroid.R
import com.example.pruebatecnicaandroid.data.db.entities.User
import com.example.pruebatecnicaandroid.domain.model.ResponseQuery

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldScreen(
    user: User?,
    onEvent: (ScaffoldEvent) -> Unit,
    items: List<ResponseQuery.Result>
) {
    LaunchedEffect(Unit) {
        onEvent(ScaffoldEvent.QUERY(user?.sessionName ?: ""))
    }

    Scaffold { paddingValues ->
        ConstraintLayout(
            modifier = Modifier.padding(paddingValues)
        ) {
            LazyColumn {
                items(items, key = { it.id } ) { Contact(it) }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Contact(item: ResponseQuery.Result? = null) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(10.dp),
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        onClick = { },
    ) {
        ConstraintLayout(
            constraintSet = myConstraintContact,
            modifier = Modifier.fillMaxSize().padding(5.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(70.dp)
                    .clip(CircleShape)
                    .layoutId("composable1"),
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = "Image"
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
                    .layoutId("composable2")
            ) {
                Text(
                    text = item?.lastname ?: "Apellido no disponible",
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = item?.contact_no ?: "No disponible"
                )
            }

            Text(
                text = item?.id ?: "ID",
                fontWeight = FontWeight.Bold,
                modifier = Modifier.layoutId("composable3")
            )

        }
    }
}

@Preview
@Composable
fun ContactPreview() {
    Contact()
}

@Preview
@Composable
fun ScaffoldScreenPreview() {
    ScaffoldScreen(
        user = null,
        onEvent = { },
        items = listOf()
    )
}

val myConstraintContact = ConstraintSet {
    val composable1 = createRefFor("composable1")  // creating refernce
    val composable2 = createRefFor("composable2")  // creating refernce
    val composable3 = createRefFor("composable3")  // creating refernce

    constrain(composable1) {
        start.linkTo(parent.start)
        top.linkTo(parent.top)
        bottom.linkTo(parent.bottom)
    }

    constrain(composable2) {
        start.linkTo(composable1.end)
        top.linkTo(composable1.top)
        bottom.linkTo(composable1.bottom)
    }

    constrain(composable3) {
        end.linkTo(parent.end)
        top.linkTo(parent.top)
    }
}


