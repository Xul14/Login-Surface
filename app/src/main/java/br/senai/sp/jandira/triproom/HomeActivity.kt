package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                HomeScreen()
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen() {

    Surface(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(160, 156, 156, 1))
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.paris),
                    contentDescription = ""
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

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp)
            )
            {

                Text(
                    text = "Categories",
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier
                            .width(109.dp)
                            .height(64.dp),
                        backgroundColor = Color(207, 6, 240, 255)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Image(
                                painter = painterResource(id = R.drawable.mountains),
                                contentDescription = "",
                                modifier = Modifier.size(32.dp)
                            )

                            Text(
                                text = "Mountain",
                                fontSize = 14.sp,
                                color = Color.White
                            )
                        }


                    }
                }

                OutlinedTextField(
                    value = "Search your destinity",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(160, 156, 156, 255)
                        )
                    }
                )
            }
        }
    }
}