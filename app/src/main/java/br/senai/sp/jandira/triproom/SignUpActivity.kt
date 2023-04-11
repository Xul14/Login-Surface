package br.senai.sp.jandira.triproom

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.triproom.componentes.BottomShape
import br.senai.sp.jandira.triproom.componentes.TopShape
import br.senai.sp.jandira.triproom.model.User
import br.senai.sp.jandira.triproom.repository.UserRepository
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

    var userNameState by remember {
        mutableStateOf(value = "")
    }
    var phoneState by remember {
        mutableStateOf(value = "")
    }
    var emailState by remember {
        mutableStateOf(value = "")
    }
    var passwordState by remember {
        mutableStateOf(value = "")
    }
    var over18State by remember {
        mutableStateOf(value = false)
    }

    var context = LocalContext.current

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
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
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
                    value = userNameState,
                    onValueChange = { userNameState = it },
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
                    value = phoneState,
                    onValueChange = { phoneState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

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
                    value = emailState,
                    onValueChange = { emailState = it },
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
                    value = passwordState,
                    onValueChange = { passwordState = it },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp),
                    visualTransformation = PasswordVisualTransformation(),
                    label = { (Text(text = stringResource(id = R.string.input_password))) },
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
                        checked = over18State,
                        onCheckedChange = { over18State = it },
                        colors = CheckboxDefaults.colors(Color(207, 6, 240, 255))
                    )

                    Text(
                        text = stringResource(R.string.text_over),
                        fontSize = 16.sp,
                    )

                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {
                        userSave(
                            context,
                            emailState,
                            userNameState,
                            phoneState,
                            passwordState,
                            over18State
                        )
                    },
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

fun userSave(
    context: Context,
    email: String,
    userName: String,
    phone: String,
    password: String,
    isOver: Boolean
) {

    val userRepository = UserRepository(context)

    //Recupera no banco um usuário que tenha o email informado.
    var user = userRepository.findUserByEmail(email)

    //Se user for null gravamos o novo usuário,
    //se não avisamos que o usuário já existe.

    if (user == null) {
        val newUser = User(
            userName = userName,
            phone = phone,
            email = email,
            password = password,
            isOver18 = isOver
        )
        var id = userRepository.save(newUser)
        Toast.makeText(context, "User created #$id", Toast.LENGTH_LONG).show()
    }else{
        Toast.makeText(context, "User already exists!!!", Toast.LENGTH_LONG).show()
    }

}
