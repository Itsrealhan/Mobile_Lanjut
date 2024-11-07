package com.example.responsi_01.ui.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.responsi_01.R
import com.example.responsi_01.ui.utils.TextFieldWithLabel

@Composable
fun SignupScreen(
    onSigninClick: () -> Unit,
    onSignupClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email: String by rememberSaveable {
        mutableStateOf("")
    }
    var password: String by rememberSaveable {
        mutableStateOf("")
    }
    var repeatPassword: String by rememberSaveable {
        mutableStateOf("")
    }
    val verticalScrollState: ScrollState = rememberScrollState()

    Surface(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = verticalScrollState)
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = null,
                modifier = Modifier
                    .size(size = 252.dp)
            )
            Text(
                text = stringResource(R.string.daftar),
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
            TextFieldWithLabel(
                label = stringResource(
                    R.string.masukan,
                    stringResource(R.string.email)
                ),
                value = email,
                placeholder = stringResource(R.string.email),
                visualTransformation = VisualTransformation.None,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next,
                onValueChange = { email = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 44.dp,
                        end = 44.dp,
                        bottom = 16.dp
                    )
            )
            TextFieldWithLabel(
                label = stringResource(
                    R.string.masukan,
                    stringResource(R.string.password)
                ),
                value = password,
                placeholder = stringResource(R.string.password),
                visualTransformation = PasswordVisualTransformation(),
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next,
                onValueChange = { password = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 44.dp,
                        end = 44.dp,
                        bottom = 16.dp
                    )
            )
            TextFieldWithLabel(
                label = stringResource(
                    R.string.masukan,
                    stringResource(R.string.kembali_password)
                ),
                value = repeatPassword,
                placeholder = stringResource(R.string.password),
                visualTransformation = PasswordVisualTransformation(),
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
                onValueChange = { repeatPassword = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 44.dp,
                        end = 44.dp,
                        bottom = 12.dp
                    )
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = 44.dp,
                        end = 44.dp,
                        bottom = 32.dp,
                    )
            ) {
                Row {
                    Text(
                        text = stringResource(R.string.sudah_memiliki_akun),
                        style = MaterialTheme.typography.bodySmall,
                        modifier = Modifier
                            .padding(end = 4.dp)
                    )
                    Text(
                        text = stringResource(R.string.masuk),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .clickable { onSigninClick() }
                    )
                }
            }
            Button(
                onClick = {
                    if (email.isNotBlank() && password.isNotBlank() && repeatPassword.isNotBlank()) {
                        onSignupClick()
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
                    text = stringResource(id = R.string.daftar),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}