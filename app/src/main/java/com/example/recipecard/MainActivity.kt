/*
 * AI Usage
 * Used to get the recipe - ingredients and instructions
 * Wasn't sure how to integrate Row Composable, used it to generate ideas
 */


package com.example.recipecard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.recipecard.ui.theme.RecipeCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeCardTheme {
                RecipeCardScreen()
            }
        }
    }
}

@Composable
fun RecipeCardScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.LightGray)
            ) {
                RecipeCard(
                    title = "Classic Pancakes",
                    imageRes = R.drawable.pancakes,
                    ingredients = listOf(
                        "1 1/2 cups all-purpose flour",
                        "3 1/2 teaspoons baking powder",
                        "1 teaspoon salt",
                        "1 tablespoon white sugar",
                        "1 1/4 cups milk",
                        "1 egg",
                        "3 tablespoons melted butter"
                    ),
                    instructions =
                            "1. In a large bowl, sift together the flour, baking powder, salt, and sugar.\n" +
                            "2. Make a well in the center and pour in the milk, egg, and melted butter; mix until smooth.\n" +
                            "3. Heat a lightly oiled griddle or frying pan over medium-high heat.\n" +
                            "4. Pour or scoop the batter onto the griddle, using approximately 1/4 cup for each pancake.\n" +
                            "5. Brown on both sides and serve hot."
                )
            }
        }
    )
}

@Composable
fun RecipeCard(
    title: String,
    imageRes: Int,
    ingredients: List<String>,
    instructions: String
) {
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .background(Color.White, shape = RoundedCornerShape(8.dp)),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = title,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = Color.Red,
                    modifier = Modifier.size(24.dp)
                )
            }

            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Recipe Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.Gray),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Ingredients",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            ingredients.forEach { ingredient ->
                Text(
                    text = "• $ingredient",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 8.dp, bottom = 4.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                thickness = 1.dp,
                color = Color.Gray
            )

            Text(
                text = "Instructions",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = instructions,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RecipeCardPreview() {
    RecipeCardTheme {
        RecipeCardScreen()
    }
}