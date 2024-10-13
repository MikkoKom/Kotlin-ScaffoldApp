package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons  // Import for Material Icons
import androidx.compose.material.icons.filled.Menu  // Import for Menu icon
import androidx.compose.material.icons.filled.MoreVert  // Import for More icon
import com.example.scaffoldapp.ui.theme.ScaffoldAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme {
                // Call the ScaffoldApp composable to display the UI
                ScaffoldApp()
            }
        }
    }
}

@Composable
fun ScaffoldApp() {
    // Scaffold layout containing the TopAppBar and content
    Scaffold(
        topBar = { MyTopBar() }, // Custom TopAppBar with menu and more icons
        content = {
            // Display some content for testing/demo purposes
            Text(
                text = "Hello, this is a simple content!",
                modifier = Modifier.fillMaxSize()
            )
        }
    )
}

@Composable
fun MyTopBar() {
    // State to control the expanded state of the DropDownMenu
    var expanded by remember { mutableStateOf(false) }

    // Custom TopAppBar with title, menu, and dropdown menu
    TopAppBar(
        title = { Text(text = "My App") },
        navigationIcon = {
            IconButton(onClick = { /* Menu action */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "Menu Icon")
            }
        },
        actions = {
            IconButton(onClick = { expanded = !expanded }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "More Icon")
            }

            // DropDownMenu that shows when the 'More' icon is clicked
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(onClick = { /* Handle Info click */ }) {
                    Text("Info")
                }
                DropdownMenuItem(onClick = { /* Handle Settings click */ }) {
                    Text("Settings")
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyAppTheme {
        ScaffoldApp() // Preview of the ScaffoldApp composable
    }
}
