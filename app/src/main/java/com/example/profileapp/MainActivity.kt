package com.example.profileapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.profileapp.ui.theme.ProfileAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileAppTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Tombol ke ProfileActivity (Explicit Intent)
        Button(onClick = {
            val intent = Intent(context, ProfileActivity::class.java).apply {
                putExtra("EXTRA_NAME", "Safina Sabil")
                putExtra("EXTRA_NIM", "L0123126")
                putExtra("EXTRA_MAJOR", "Informatics")
                putExtra("EXTRA_BATCH", "2023")
                putExtra("EXTRA_DESCRIPTION", "Hi, perkenalkan nama saya Safina Sabil. Saya merupakan calon lulusan dari jurusan Informatika angkatan 2023. Saya memiliki ketertarikan dengan teknologi dan desain. Saya memiliki passion di bidang UI/UX dan pengembangan aplikasi mobile, terutama yang bisa memberikan dampak positif bagi penggunanya. Selain itu, saya juga aktif berkomunikasi dan selalu senang belajar hal baru, baik itu tentang coding, desain, atau teknologi terkini. Saya percaya bahwa teknologi itu tidak hanya soal kode, melainkan tentang menciptakan pengalaman yang menyenangkan dan memudahkan orang.")
            }
            context.startActivity(intent)
        }) {
            Text("Go To Profile")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Share (Implicit Intent)
        Button(onClick = {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    """
                    NIM: L0123126
                    Name: Safina Sabil
                    Major: Informatics
                    Batch: 2023
                    Description: Hi, perkenalkan nama saya Safina Sabil. Saya merupakan calon lulusan dari jurusan Informatika angkatan 2023. Saya memiliki ketertarikan dengan teknologi dan desain. Saya memiliki passion di bidang UI/UX dan pengembangan aplikasi mobile, terutama yang bisa memberikan dampak positif bagi penggunanya. Selain itu, saya juga aktif berkomunikasi dan selalu senang belajar hal baru, baik itu tentang coding, desain, atau teknologi terkini. Saya percaya bahwa teknologi itu tidak hanya soal kode, melainkan tentang menciptakan pengalaman yang menyenangkan dan memudahkan orang.
                    """.trimIndent()
                )
                type = "text/plain"
            }
            context.startActivity(Intent.createChooser(shareIntent, "Share via"))
        }) {
            Text("Share Profile")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tombol ke GitHub (Implicit Intent)
        Button(onClick = {
            val githubIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/username"))
            context.startActivity(githubIntent)
        }) {
            Text("Go To My Github")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ProfileAppTheme {
        MainScreen()
    }
}

