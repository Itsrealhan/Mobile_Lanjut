package com.example.responsi_01.ui.screens.forgotpassword

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.responsi_01.R
import com.example.responsi_01.ui.utils.TextFieldWithLabel

@Composable
fun ForgotPasswordScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email: String by rememberSaveable {
        mutableStateOf("")
    }
    val verticalScrollState: ScrollState = rememberScrollState()

    Scaffold(
        topBar = {
            IconButton(
                onClick = onNavigateBack,
                modifier = Modifier
                    .padding(
                        start = 4.dp,
                        top = 24.dp
                    )
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back_24px),
                    contentDescription = stringResource(R.string.kembali)
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = verticalScrollState)
                .padding(paddingValues = innerPadding)
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(size = 252.dp)
            )
            Text(
                text = stringResource(R.string.lupa_password_02),
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 32.dp)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 44.dp,
                        end = 44.dp,
                        bottom = 20.dp,
                    )
            ) {
                Text(
                    text = stringResource(R.string.pesan),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(R.string.masukan_email_anda_dan_tunggu_kode_etik_akan_dikirimkan),
                    style = MaterialTheme.typography.bodySmall
                )
            }
            TextFieldWithLabel(
                label = stringResource(
                    R.string.masukan,
                    stringResource(R.string.email)
                ),
                value = email,
                placeholder = stringResource(R.string.email),
                visualTransformation = VisualTransformation.None,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 44.dp,
                        end = 44.dp,
                        bottom = 32.dp
                    )
            )
            Button(
                onClick = {
                    if (email.isNotBlank()) {
                        onNavigateBack()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color.White
                ),
                shape = ShapeDefaults.Medium,
                modifier = Modifier
                    .width(width = 252.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = stringResource(R.string.kirim),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}