package com.anoirdev.test.presentation.compose.screens.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            shape = RoundedCornerShape(20),
            elevation = 2.dp
        ) {
            Text(
                stringResource(R.string.home_title), modifier = Modifier
                    .padding(20.dp), fontSize = 18.sp
            )
        }
        Spacer(Modifier.size(20.dp))
        ButtonHome(
            title = stringResource(id = R.string.home_title),
            icon = Icons.Filled.List
        )
    }
}