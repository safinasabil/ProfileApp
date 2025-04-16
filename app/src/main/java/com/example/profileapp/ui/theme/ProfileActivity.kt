package com.example.profileapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import com.example.profileapp.ui.theme.ProfileAppTheme

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ProfileScreen()
                }
            }
        }
    }
}

@Composable
fun ProfileScreen() {
    val context = LocalContext.current as ComponentActivity
    val intent = context.intent

    val name = intent.getStringExtra("EXTRA_NAME") ?: "Unknown"
    val nim = intent.getStringExtra("EXTRA_NIM") ?: "Unknown"
    val major = intent.getStringExtra("EXTRA_MAJOR") ?: "Unknown"
    val batch = intent.getStringExtra("EXTRA_BATCH") ?: "Unknown"
    val description = intent.getStringExtra("EXTRA_DESCRIPTION") ?: "No description"

    // Mengambil gambar profil dari resource drawable
    val profileImage: Painter = painterResource(id = R.drawable.profile_image) // Gambar profil yang ada di drawable

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Menampilkan gambar profil dengan bentuk bulat
        Image(
            painter = profileImage,
            contentDescription = "Profile Image",
            modifier = Modifier
                .size(120.dp) // Ukuran gambar 120 dp
                .clip(CircleShape) // Membuat gambar berbentuk lingkaran
                .padding(8.dp), // Opsional, bisa ditambahkan padding jika perlu
            contentScale = ContentScale.Crop // Memastikan gambar terpotong sesuai lingkaran
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Menampilkan data profil lainnya
        Text("Name: $name", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text("NIM: $nim", style = MaterialTheme.typography.bodyLarge)
        Text("Major: $major", style = MaterialTheme.typography.bodyLarge)
        Text("Batch: $batch", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text("Description: $description", style = MaterialTheme.typography.bodyLarge)
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    ProfileAppTheme {
        ProfileScreen()
    }
}
