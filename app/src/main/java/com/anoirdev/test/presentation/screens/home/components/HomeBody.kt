package com.anoirdev.test.presentation.screens.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.anoirdev.test.R

@Composable
fun HomeBody() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painterResource(R.drawable.home_top),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(20),
            elevation = 2.dp
        ) {
            Text(
                stringResource(R.string.home_body_review), modifier = Modifier
                    .padding(20.dp), fontSize = 18.sp
            )
        }
        Spacer(Modifier.size(20.dp))
        ButtonHome(
            title = stringResource(id = R.string.home_button_show_note),
            icon = Icons.Filled.List
        )
        Spacer(Modifier.size(20.dp))
        ButtonHome(
            title = stringResource(id = R.string.home_button_show_state),
            icon = Icons.Filled.AccountBox
        )
    }
}