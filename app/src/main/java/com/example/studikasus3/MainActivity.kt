package com.example.studikasus3
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepam.ui.LoginScreen
import com.example.composepam.ui.DaftarScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    Surface(color = MaterialTheme.colorScheme.background) {
        NavHost(
            navController = navController,
            startDestination = "login"
        ) {
            composable("login") {
                LoginScreen(navController)
            }

            composable("daftar") {
                DaftarScreen(navController)
            }

            composable("detail/{nim}/{nama}/{email}") { backStackEntry ->
                val nim = backStackEntry.arguments?.getString("nim") ?: ""
                val nama = backStackEntry.arguments?.getString("nama") ?: ""
                val email = backStackEntry.arguments?.getString("email") ?: ""

                DetailScreen(
                    navController = navController,
                    nim = nim,
                    nama = nama,
                    email = email
                )
            }
        }
    }
}
