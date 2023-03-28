package br.senai.sp.jandira.triproom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.componentes.BottomShape
import br.senai.sp.jandira.triproom.componentes.TopShape
import br.senai.sp.jandira.triproom.ui.theme.TripRoomTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TripRoomTheme {
                SignUpScreen()
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpScreen() {

    Surface(
        modifier = Modifier.fillMaxSize(),
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            TopShape()
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(R.string.title_signup),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color(207, 6, 240, 255)
            )

            Text(
                text = stringResource(R.string.new_account),
                fontSize = 14.sp,
                color = Color(160, 156, 156, 255)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .size(100.dp)
            ) {

                Card(
                    modifier = Modifier
                        .size(100.dp)
                        .align(alignment = Alignment.TopEnd),
                    shape = CircleShape,
                    border = BorderStroke(
                        width = 2.dp,
                        Brush.horizontalGradient(colors = listOf(Color.Magenta, Color.White))
                    )
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.profile),
                        contentDescription = null,
                        modifier = Modifier
                            .size(28.dp)
                            .align(Alignment.BottomEnd),
                    )

                }


                Image(
                    painter = painterResource(id = R.drawable.baseline_camera_24),
                    contentDescription = null,
                    modifier = Modifier
                        .size(32.dp)
                        .align(Alignment.BottomEnd),
                )
            }


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            )
            {

                OutlinedTextField(
                    value = "Susanna Hoffs",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { (Text(text = stringResource(R.string.input_username))) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(207, 6, 240, 255)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))


                OutlinedTextField(
                    value = "99999-0987",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { (Text(text = stringResource(R.string.input_phone))) },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_phone_android_24),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(207, 6, 240, 255)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))


                OutlinedTextField(
                    value = "teste@email.com",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { (Text(text = stringResource(id = R.string.input_email))) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_email_24),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(207, 6, 240, 255)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))


                OutlinedTextField(
                    value = "***********",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    label = { (Text(text = stringResource(id = R.string.input_password))) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_lock_24),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                            tint = Color(207, 6, 240, 255)
                        )
                    }
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {},
                        colors = CheckboxDefaults.colors(Color(207, 6, 240, 255))
                    )

                    Text(
                        text = stringResource(R.string.text_over),
                        fontSize = 16.sp,
                    )

                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {},
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(Color(207, 6, 240, 255)),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = stringResource(R.string.button_account),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.End
                ) {

                    Row() {

                        Text(
                            text = stringResource(R.string.text_already),
                            fontSize = 16.sp,
                            color = Color(160, 156, 156, 255)
                        )

                        Text(
                            text = stringResource(R.string.text_signIn),
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(207, 6, 240, 255)
                        )

                    }
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Bottom
        ) {
            BottomShape()
        }

    }
}