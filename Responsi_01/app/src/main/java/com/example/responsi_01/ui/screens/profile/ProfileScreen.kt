package com.example.responsi_01.ui.screens.profile

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.responsi_01.R
import com.example.responsi_01.ui.utils.TextFieldWithLabel
import com.example.responsi_01.ui.utils.UserProfilePicture

@Composable
fun ProfileScreen(
    onNavigateBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    var email: String by rememberSaveable {
        mutableStateOf("")
    }
    var nama: String by rememberSaveable {
        mutableStateOf("")
    }
    var noTelepon: String by rememberSaveable {
        mutableStateOf("")
    }
    var alamat: String by rememberSaveable {
        mutableStateOf("")
    }

    val scrollState: ScrollState = rememberScrollState()

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
        Box(
            modifier = Modifier.padding(paddingValues = innerPadding)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(state = scrollState)
                    .padding(
                        vertical = 24.dp,
                        horizontal = 16.dp
                    )
            ) {
                UserProfilePicture(
                    userImage = painterResource(id = R.drawable.user_image),
                    userName = "Nama Lengkap",
                    userUniversity = "Asal Universitas",
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(bottom = 36.dp)
                )
                TextFieldWithLabel(
                    label = stringResource(id = R.string.email),
                    value = email,
                    placeholder = "",
                    visualTransformation = VisualTransformation.None,
                    keyboardType = KeyboardType.Email,
                    imeAction = ImeAction.Done,
                    onValueChange = { email = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                )
                TextFieldWithLabel(
                    label = stringResource(R.string.nama),
                    value = nama,
                    placeholder = "",
                    visualTransformation = VisualTransformation.None,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                    onValueChange = { nama = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                )
                TextFieldWithLabel(
                    label = stringResource(R.string.nomor_telepon),
                    value = noTelepon,
                    placeholder = "",
                    visualTransformation = VisualTransformation.None,
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done,
                    onValueChange = { noTelepon = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp)
                )
                TextFieldWithLabel(
                    label = stringResource(R.string.alamat),
                    value = alamat,
                    placeholder = "",
                    visualTransformation = VisualTransformation.None,
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                    onValueChange = { alamat = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 40.dp)
                )
                Button(
                    onClick = { /*TODO*/ },
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
                        text = stringResource(R.string.ubah_profile),
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}