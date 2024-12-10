package br.senai.sp.jandira.transportaweb.screens.geral

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.transportaweb.R

@Composable
fun ChatSreen(controleDeNavegacao: NavHostController) {

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color(0xFFC00000)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {
            Card (
                modifier = Modifier
                    .clickable {
                        if (controleDeNavegacao.previousBackStackEntry != null) {
                            controleDeNavegacao.popBackStack()
                        }
                    }
                    .background(Color.Transparent, shape = RoundedCornerShape(20.dp)),
                colors = CardDefaults
                    .cardColors(
                        containerColor = Color.Transparent
                    )
            ){
                Image(
                    painterResource(R.drawable.arrow),
                    contentDescription = "Logo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(50.dp)
                )
            }
            Image(
                painterResource(R.drawable.usuario),
                contentDescription = "Logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
            )
            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(start = 10.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = "Transporta Web",
                    fontSize = 16.sp,
                    color = Color.White

                )
                Text(
                    text = "Online",
                    fontSize = 16.sp,
                    color = Color.White
                )
            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 130.dp)
                .background(
                    Color.White, shape =
                    RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp)
                )
        ) {
            Column (
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ){
                Column (
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxWidth()
                ){
                    Box(
                        modifier = Modifier
                            .width(266.dp)
                            .height(85.dp)
                            .background(
                                color = Color(0xFFC00000), shape =
                                RoundedCornerShape(topEnd = 12.dp, topStart = 12.dp, bottomStart = 12.dp)
                            )
                    ){
                        Text(
                            text = "Bom dia, estou a caminho do ponto de coleta. Previsão de chegada em 30 minutos.",
                            color = Color.White,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
                Column (
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ){
                    Box(
                        modifier = Modifier
                            .width(266.dp)
                            .height(110.dp)
                            .background(
                                color = Color(0xFF868686), shape =
                                RoundedCornerShape(topEnd = 12.dp, topStart = 12.dp, bottomStart = 12.dp)
                            )
                    ){
                        Text(
                            text = "Bom dia! Perfeito. Assim que chegar, envie uma mensagem para confirmar e aguardaremos o status da coleta.",
                            color = Color.White,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
                Column (
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                ){
                    Box(
                        modifier = Modifier
                            .width(266.dp)
                            .height(110.dp)
                            .background(
                                color = Color(0xFFC00000), shape =
                                RoundedCornerShape(topEnd = 12.dp, topStart = 12.dp, bottomStart = 12.dp)
                            )
                    ){
                        Text(
                            text = "Cheguei ao destino e a descarga já começou. Preciso aguardar alguma assinatura ou posso seguir depois de descarregar?",
                            color = Color.White,
                            modifier = Modifier
                                .padding(5.dp)
                        )
                    }
                }
                Column (
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp)
                ){
                    Column (
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .width(158.dp)
                                .height(36.dp)
                                .background(
                                    color = Color(0xFF868686), shape =
                                    RoundedCornerShape(topEnd = 12.dp, topStart = 12.dp, bottomStart = 12.dp)
                                )
                        ){
                            Text(
                                text = "Certo, pode seguir.",
                                color = Color.White,
                                modifier = Modifier
                                    .padding(5.dp)
                            )
                        }
                    }
                }
                Column (
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .fillMaxHeight()
                ){
                    OutlinedTextField(
                        modifier = Modifier
                            .height(60.dp)
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(10.dp),
                        value = "",
                        onValueChange = {},
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFFF61221),
                            unfocusedBorderColor = Color.Transparent,
                            disabledBorderColor = Color.Transparent,
                            focusedContainerColor = Color(0xFF868686),
                            unfocusedContainerColor = Color(0xFF868686)
                        ),
                        label = {
                            Text(
                                text = "Type your text...",
                                color = Color.White,
                                modifier = Modifier
                                    .padding(start = 0.dp)
                            )
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewChatScreen() {
    ChatSreen(controleDeNavegacao = NavHostController(LocalContext.current))
}