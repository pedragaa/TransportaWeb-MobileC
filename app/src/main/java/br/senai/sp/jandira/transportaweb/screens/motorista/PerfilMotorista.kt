package br.senai.sp.jandira.transportaweb.screens.motoristas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.transportaweb.R
import br.senai.sp.jandira.transportaweb.ui.theme.TransportaWebTheme

@Composable
fun PerfilH(controleDeNavegacao: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 10.dp)
        ){
            Box(
                modifier = Modifier
                    .width(290.dp)
                    .height(140.dp)
                    .padding(start = 10.dp)
            ){
                Image(
                    painterResource(R.drawable.logoo),
                    contentDescription = "Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
            Row (
                modifier = Modifier
                    .padding(top = 20.dp)
            ){
                Text(
                    "Olá Junior!",
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xFF515151)
                )
            }
            Card(
                modifier = Modifier
                    .padding(top = 10.dp)
                    .size(90.dp),
                shape = CircleShape,
                border = BorderStroke(2.dp, Color.White)
            ) {

            }
            Text(
                text = "Nome:",
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 30.dp, end = 250.dp)
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 45.dp, end = 45.dp,)
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                value = "",
                onValueChange = { },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFF61221),
                    unfocusedBorderColor = Color(0xFF131313),
                    focusedContainerColor = Color(0xFFF4F4F4),
                    unfocusedContainerColor = Color(0xFFF4F4F4)
                ),
                label = {

                    Text(
                        text = "E-mail",
                        modifier = Modifier
                            .padding(start = 0.dp)
                    )
                }
            )
            Text(
                text = "Digite seu e-mail aqui:",
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 17.dp, end = 130.dp)
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 45.dp, end = 45.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                value = "",
                onValueChange = { },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFF61221),
                    unfocusedBorderColor = Color(0xFF131313),
                    focusedContainerColor = Color(0xFFF4F4F4),
                    unfocusedContainerColor = Color(0xFFF4F4F4)
                ),
                label = {

                    Text(
                        text = "E-mail",
                        modifier = Modifier
                            .padding(start = 0.dp)
                    )
                }
            )
            Text(
                text = "Digite seu e-mail aqui:",
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(top = 17.dp, end = 130.dp)
            )
            OutlinedTextField(
                modifier = Modifier
                    .padding(start = 45.dp, end = 45.dp)
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(10.dp),
                value = "",
                onValueChange = { },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color(0xFFF61221),
                    unfocusedBorderColor = Color(0xFF131313),
                    focusedContainerColor = Color(0xFFF4F4F4),
                    unfocusedContainerColor = Color(0xFFF4F4F4)
                ),
                label = {

                    Text(
                        text = "E-mail",
                        modifier = Modifier
                            .padding(start = 0.dp)
                    )
                }
            )
            Button(
                modifier = Modifier
                    .padding(top = 90.dp, start = 45.dp, end = 45.dp)
                    .fillMaxWidth()
                    .height(45.dp),
                shape = RoundedCornerShape(10   .dp),
                colors = ButtonDefaults
                    .buttonColors(Color(0xFFF61221)),
                onClick = {}
            ) {
                Text(

                    text = "FINALIZAR",
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun PerfilPreview() {
    TransportaWebTheme {
        PerfilH(controleDeNavegacao = NavHostController(LocalContext.current))
    }
}