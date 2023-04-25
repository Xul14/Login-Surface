package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.model.Category
import br.senai.sp.jandira.triproom.repository.CategoryRepository
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                HomeScreen(CategoryRepository.getCategories())
            }
        }
    }
}

@Composable
fun HomeScreen(categories: List<Category>) {

    Surface(modifier = Modifier.fillMaxSize()) {

        Column() {

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                shape = RectangleShape
            ) {
                Image(
                    painter = painterResource(id = R.drawable.paris),
                    contentDescription = "Logo",
                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.height(197.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {

                    Row(
                        modifier = Modifier.padding(horizontal = 18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_location_on_24),
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "You're in Paris",
                            fontSize = 18.sp,
                            color = Color.White
                        )
                    }
                    Text(
                        text = "My Trips",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.padding(horizontal = 36.dp)
                    )

                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(14.dp),
                    horizontalAlignment = Alignment.End
                ) {

                    Surface(
                        modifier = Modifier.padding(bottom = 3.dp),
                        shape = CircleShape,
                        border = BorderStroke(2.dp, color = Color.White)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.susanna_profile),
                            contentDescription = "",
                            modifier = Modifier.size(61.dp)
                        )
                    }

                    Text(
                        text = "Susanna Hoffs",
                        fontSize = 12.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Light
                    )
                }
            }

            Text(
                text = stringResource(id = R.string.categoties),
                modifier = Modifier.padding(top = 14.dp, start = 16.dp)
            )

            LazyRow() {

                items(categories) { category ->
                    Card(
                        modifier = Modifier
                            .width(110.dp)
                            .height(64.dp)
                            .padding(4.dp),
                        backgroundColor = Color(207, 6, 240, 255)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Icon(
                                painter =  category.icon ?: painterResource(id = R.drawable.no_image),
                                contentDescription = "",
                                modifier = Modifier.size(32.dp),
                                tint = Color.White
                            )

                            Text(
                                text = category.name,
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        }
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    TripRoomTheme() {
        HomeScreen(CategoryRepository.getCategories())
    }
}