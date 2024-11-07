package com.example.responsi_01.ui.screens.termsofservice

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TermsOfServiceScreen(
    modifier: Modifier = Modifier
) {
    Surface(modifier = modifier) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = "Terms of Service Screen",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
}