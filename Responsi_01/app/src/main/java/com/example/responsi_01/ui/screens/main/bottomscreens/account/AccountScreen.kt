package com.example.responsi_01.ui.screens.main.bottomscreens.account

import androidx.annotation.StringRes
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.responsi_01.R
import com.example.responsi_01.ui.utils.Screens
import com.example.responsi_01.ui.utils.UserProfilePicture

@Composable
fun AccountScreen(
    onAccountMenuSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState: ScrollState = rememberScrollState()
    
    val accountMenus: List<AccountMenu> = listOf(
        AccountMenu(
            name = R.string.kelola_akun,
            route = Screens.ProfileScreen.name
        ),
        AccountMenu(
            name = R.string.notifikasi,
            route = Screens.NotificationScreen.name
        ),
        AccountMenu(
            name = R.string.privacy_policy,
            route = Screens.PrivacyPolicyScreen.name
        ),
        AccountMenu(
            name = R.string.terms_of_service,
            route = Screens.TermsOfServiceScreen.name
        ),
    )

    Surface(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .padding(top = 24.dp)
        ) {
            UserProfilePicture(
                userImage = painterResource(id = R.drawable.user_image),
                userName = "Nama Lengkap",
                userUniversity = "Asal Universitas",
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(bottom = 36.dp)
            )
            accountMenus.forEach { item ->
                AccountMenuItem(
                    name = stringResource(id = item.name), 
                    onClick = { onAccountMenuSelected(item.route) },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun AccountMenuItem(
    name: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onClick,
        shape = RectangleShape,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        ),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    top = 8.dp,
                    end = 12.dp,
                    bottom = 8.dp
                )
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge
            )
            Icon(
                painter = painterResource(id = R.drawable.arrow_forward_24px),
                contentDescription = null,
                modifier = Modifier.clickable { onClick() }
            )
        }
    }
}

data class AccountMenu(
    @StringRes val name: Int,
    val route: String
)