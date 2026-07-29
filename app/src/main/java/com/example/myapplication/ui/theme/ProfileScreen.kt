package com.example.myapplication.ui.theme

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Stretch Goal: Extract sizes into named constants
private val AvatarSize = 120.dp
private val AvatarBorderWidth = 2.dp
private val StandardPadding = 24.dp
private val SmallSpacer = 8.dp
private val MediumSpacer = 16.dp
private val LargeSpacer = 24.dp
private val ExtraLargeSpacer = 32.dp
private val CardHorizontalPadding = 8.dp
private val InfoRowVerticalPadding = 8.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    val cardInteractionSource = remember { MutableInteractionSource() }
    val isCardPressed by cardInteractionSource.collectIsPressedAsState()
    val cardScale by animateFloatAsState(if (isCardPressed) 0.98f else 1f, label = "cardScale")

    // Stretch Goal: Add a top app bar
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "My Profile",
                        fontWeight = FontWeight.ExtraBold,
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = StandardPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Task 2 — Circular avatar
            Box(
                modifier = Modifier
                    .size(AvatarSize)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .border(AvatarBorderWidth, MaterialTheme.colorScheme.onPrimary, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "KB",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }

            Spacer(modifier = Modifier.height(LargeSpacer))

            // Task 3 — Full name & subtitle
            Text(
                text = "KentVladimer S. Bitanghol",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(SmallSpacer))

            Text(
                text = "BSIT - 3-2",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(ExtraLargeSpacer))

            // Task 4 — The Info Card with "Hover" effect
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = CardHorizontalPadding)
                    .graphicsLayer(
                        scaleX = cardScale,
                        scaleY = cardScale
                    )
                    .clickable(
                        interactionSource = cardInteractionSource,
                        indication = null,
                        onClick = { /* Action */ }
                    ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 2.dp,
                    pressedElevation = 8.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
                )
            ) {
                Column(
                    modifier = Modifier.padding(MediumSpacer)
                ) {
                    // Task 5 — Reusable InfoRow (×5)
                    InfoRow(
                        icon = Icons.Default.Person,
                        label = "Full Name",
                        value = "KentVladimer S. Bitanghol"
                    )
                    InfoRow(
                        icon = Icons.Default.School,
                        label = "Course",
                        value = "Bachelor of Science in Information Technology"
                    )
                    InfoRow(
                        icon = Icons.Default.Groups,
                        label = "Section",
                        value = "3-2"
                    )
                    InfoRow(
                        icon = Icons.Default.Phone,
                        label = "Mobile No.",
                        value = "09452758372"
                    )
                    InfoRow(
                        icon = Icons.Default.Email,
                        label = "Email Address",
                        value = "kvbitanghol051@liceo.edu.ph"
                    )
                }
            }
        }
    }
}

@Composable
fun InfoRow(icon: ImageVector, label: String, value: String) {
    // Stretch Goal: Make each InfoRow .clickable with a ripple
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { /* Handle row click */ }
            .padding(vertical = InfoRowVerticalPadding, horizontal = SmallSpacer),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.width(MediumSpacer))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Profile — Light")
@Composable
fun ProfileScreenPreview() {
    MyApplicationTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colorScheme.background) {
            ProfileScreen()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, name = "Profile — Dark")
@Composable
fun ProfileScreenDarkPreview() {
    MyApplicationTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colorScheme.background) {
            ProfileScreen()
        }
    }
}


