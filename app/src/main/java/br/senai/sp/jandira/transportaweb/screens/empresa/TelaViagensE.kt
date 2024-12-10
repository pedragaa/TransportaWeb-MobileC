package br.senai.sp.jandira.transportaweb.screens.motoristas

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import br.senai.sp.jandira.transportaweb.R

@Composable
fun TelaViagens(controleNavegacao: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFC00000)
    ) {
        Column(
            modifier = Modifier.fillMaxSize().clickable { controleNavegacao.navigate("detalhesViagensMotorista") },
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Box(
                modifier = Modifier
                    .size(430.dp, 209.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .align(Alignment.CenterHorizontally)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 30.dp, top = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card (
                            modifier = Modifier
                                .clickable {
                                    if (controleNavegacao.previousBackStackEntry != null) {
                                        controleNavegacao.popBackStack()
                                    }
                                }
                                .background(Color.White, shape = RoundedCornerShape(20.dp)),
                            colors = CardDefaults
                                .cardColors(
                                    containerColor = Color.Transparent
                                )
                        ){
                            Image(
                                painterResource(R.drawable.botaov),
                                contentDescription = "Logo",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(50.dp)
                            )
                        }
                        Text(
                            modifier = Modifier.padding(start = 12.dp),
                            text = "Olá, Yasmin",
                            style = TextStyle(
                                color = Color(0xFFBB4848),
                                fontSize = 20.sp
                            ),
                            fontWeight = FontWeight.Bold,
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Image(
                            painter = painterResource(id = R.drawable.logoo),
                            contentDescription = "Logotipo",
                            modifier = Modifier
                                .size(87.dp, 90.dp)
                                .padding(start = 10.dp)
                        )
                    }

                    // Texto "Histórico de Viagens"
                    Text(
                        text = "Histórico de Viagens",
                        style = TextStyle(
                            color = Color(0xFFBB4848),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(start = 30.dp, top = 10.dp, bottom = 16.dp)
                    )

                    // Linha de separação
                    Box(
                        modifier = Modifier
                            .padding(start = 30.dp, end = 30.dp)
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(color = Color(0xFFDADADA))
                    )

                    // Row com informações
                    Row(
                        modifier = Modifier
                            .padding(start = 30.dp, top = 8.dp)
                    ) {
                        Text(
                            text = "Concluídas",
                            style = TextStyle(
                                color = Color(0xFF000000),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = " | ",
                            style = TextStyle(
                                color = Color(0xFF000000),
                                fontSize = 15.sp
                            ),
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                        )

                        Text(
                            text = "Em Andamento",
                            style = TextStyle(
                                color = Color(0xFFBB4848),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = " | ",
                            style = TextStyle(
                                color = Color(0xFF000000),
                                fontSize = 15.sp
                            ),
                            modifier = Modifier.padding(start = 8.dp, end = 8.dp)
                        )

                        Text(
                            text = "Disponíveis",
                            style = TextStyle(
                                color = Color(0xFF000000),
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .width(369.dp)
                    .height(203.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Column {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Top
                    ) {
                        Text(
                            text = "DHL Jandira",
                            color = Color(0xFFBB4848),
                            style = TextStyle(fontSize = 20.sp),
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            text = "Dist: 14 mi",
                            color = Color(0xFFBB4848),
                            style = TextStyle(fontSize = 17.sp),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 6.dp)
                            .align(Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.localizacao),
                            contentDescription = "Localização",
                            modifier = Modifier.size(30.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "De: Antônio João, Até: Avenida Diniz ",
                            color = Color.Gray,
                            fontWeight = FontWeight.Bold,
                            style = TextStyle(fontSize = 14.sp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 6.dp)
                            .align(Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.box),
                            contentDescription = "Caixa",
                            modifier = Modifier.size(30.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Frágil",
                            color = Color.Gray,
                            style = TextStyle(fontSize = 14.sp)
                        )
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 6.dp)
                            .align(Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.caminhao),
                            contentDescription = "Círculo",
                            modifier = Modifier.size(30.dp)
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = "Scania S-560",
                            color = Color.Gray,
                            style = TextStyle(fontSize = 14.sp)
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .background(color = Color(0xFFDADADA))
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Box(
                            modifier = Modifier
                                .width(114.dp)
                                .height(22.dp)
                                .clip(RoundedCornerShape(2.dp))
                                .background(Color(0xFFC00000))
                        ) {

                            Text(
                                text = "123-456-789",
                                color = Color.White,
                                modifier = Modifier
                                    .align(Alignment.Center)
                                    .padding(horizontal = 8.dp),
                                style = TextStyle(fontSize = 12.sp)
                            )
                        }

                        Box(
                            modifier = Modifier
                                .size(35.64.dp, 32.dp)
                                .clip(RoundedCornerShape(4.dp))
                                .background(Color(0xFFC00000))
                        ) {
                            Text(
                                text = "01",
                                color = Color.White,
                                modifier = Modifier
                                    .align(Alignment.Center),
                                style = TextStyle(fontWeight = FontWeight.Bold)
                            )
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .padding(top = 760.dp)
                .background(
                    color = Color(0xFFFFFFFF), shape =
                    RoundedCornerShape(topStart = 36.dp, topEnd = 36.dp)
                )
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(start = 20.dp, top = 10.dp, end = 20.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ){
                Card (
                    modifier = Modifier
                        .clickable {
                            controleNavegacao.navigate("homeMotorista")
                        }
                        .background(Color.White, shape = RoundedCornerShape(20.dp)),
                    colors = CardDefaults
                        .cardColors(
                            containerColor = Color.Transparent
                        )
                ){
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Image(
                            painterResource(R.drawable.home),
                            contentDescription = "Home",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(42.dp)
                                .padding(start = 0.dp)
                        )
                        Text(
                            text = "Home",
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFF61221)
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .clickable {
                            controleNavegacao.navigate("telaViagens")
                        }
                        .background(Color.White, shape = RoundedCornerShape(20.dp)),
                    colors = CardDefaults
                        .cardColors(
                            containerColor = Color.Transparent
                        )
                ){
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Image(
                            painterResource(R.drawable.caminhao),
                            contentDescription = "Caminhao",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(start = 0.dp)
                        )
                        Text(
                            text = "Viagens",
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFF61221)
                        )
                    }
                }
                Card (
                    modifier = Modifier
                        .clickable {
                            controleNavegacao.navigate("contatos")
                        }
                        .background(Color.White, shape = RoundedCornerShape(20.dp)),
                    colors = CardDefaults
                        .cardColors(
                            containerColor = Color.Transparent
                        )
                ){
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Image(
                            painterResource(R.drawable.chat),
                            contentDescription = "Chat",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(40.dp)
                                .padding(start = 0.dp)
                        )
                        Text(
                            text = "Chat",
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFF61221)
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .clickable {
                            controleNavegacao.navigate("perfilMotorista")
                        }
                        .background(Color.White, shape = RoundedCornerShape(20.dp)),
                    colors = CardDefaults
                        .cardColors(
                            containerColor = Color.Transparent
                        )
                ) {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ){
                        Image(
                            painterResource(R.drawable.perfil),
                            contentDescription = "Perfil",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(42.dp)
                                .padding(start = 0.dp)
                        )
                        Text(
                            text = "Perfil",
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFF61221)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTelaViagens() {
    TelaViagens(controleNavegacao = NavHostController(LocalContext.current))
}