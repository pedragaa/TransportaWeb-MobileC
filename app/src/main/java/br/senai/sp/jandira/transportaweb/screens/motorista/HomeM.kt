package br.senai.sp.jandira.transportaweb.screens.motoristas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.transportaweb.R
import br.senai.sp.jandira.transportaweb.ui.theme.TransportaWebTheme

@Composable
fun HomeM(controleDeNavegacao: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF61221)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            // Header Section
            Column(
                modifier = Modifier
                    .height(200.dp)
                    .background(
                        Color.White, shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                    )
            ) {
                Row(
                    modifier = Modifier.padding(top = 30.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(175.dp)
                            .height(55.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.logoo),
                            contentDescription = "Logo",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                    Text(
                        modifier = Modifier
                            .padding(top = 16.dp, start = 90.dp),
                        text = "Yasmin Alex",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    text = "Home",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color(0xFFF61221)
                )

                Spacer(modifier = Modifier.height(8.dp))

                Divider(color = Color(0xFFDADADA), thickness = 2.dp)

                Text(
                    modifier = Modifier.padding(horizontal = 15.dp)
                        .padding(top = 12.dp),
                    text = "À serviço da Translog Expresso.",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF868686)
                )
            }

            // Adicionando os cards de Viagem com informações estáticas
            ViagemCard(
                idViagem = "123-456-789",
                diaPartida = "2024-12-05 08:00",
                diaChegada = "2024-12-05 18:00",
                partidaCep = "06317-200",
                destinoCep = "06317-200",
                destinatario = "Avenida Diniz",
                remetente = "Antônio João",
                veiculoModelo = "Scania",
                tipoCargaNome = "Frágil",
                statusEntregue = 0,
                empresaNome = "DHL",
                motoristaNome = "Pedro",
                horarioPartida = "08:00:00",
                controleDeNavegacao = controleDeNavegacao
            )

            ViagemCard(
                idViagem = "987-654-321",
                diaPartida = "2024-12-06 10:00",
                diaChegada = "2024-12-06 20:00",
                partidaCep = "04567-890",
                destinoCep = "01532-400",
                destinatario = "AlphaTech",
                remetente = "Omega Corp",
                veiculoModelo = "Volvo FH",
                tipoCargaNome = "Perecível",
                statusEntregue = 0,
                empresaNome = "Omega",
                motoristaNome = "Carlos",
                horarioPartida = "10:00:00",
                controleDeNavegacao = controleDeNavegacao
            )

            Spacer(modifier = Modifier.weight(1f)) // Espaço dinâmico para empurrar a Box para o final da tela

            // Footer Section
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White, shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.caminhao),
                            contentDescription = "Caminhão",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(40.dp)
                        )
                        Text(
                            text = "Viagens",
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFF61221)
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(R.drawable.perfil),
                            contentDescription = "Perfil",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(42.dp)
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
                            controleDeNavegacao.navigate("homeMotorista")
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
                            controleDeNavegacao.navigate("telaViagens")
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
                            controleDeNavegacao.navigate("contatos")
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
                            controleDeNavegacao.navigate("perfilMotorista")
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




@Composable
fun ViagemCard(
    idViagem: String,
    diaPartida: String,
    diaChegada: String,
    partidaCep: String,
    destinoCep: String,
    destinatario: String,
    remetente: String,
    veiculoModelo: String,
    tipoCargaNome: String,
    statusEntregue: Int,
    empresaNome: String,
    motoristaNome: String,
    horarioPartida: String,
    controleDeNavegacao: NavHostController
) {
    Card(
        modifier = Modifier
            .clickable {
                // Navegar para a tela de detalhes passando o id da viagem
                controleDeNavegacao.navigate("detalhesViagensMotorista")
            }
            .fillMaxWidth()
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            .height(140.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.fillMaxHeight()
            ) {
                // Status e ID da viagem
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Em andamento.",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF868686),
                        modifier = Modifier
                            .background(Color(0xFFE0E0E0), shape = RoundedCornerShape(8.dp))
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                    Text(
                        text = "#$idViagem",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF1A1A1A)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Informações de partida e destino
                Text(
                    text = "De: $remetente  -  Para: $destinatario",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF868686)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Datas de partida e chegada
                Text(
                    text = "$diaPartida   -   $diaChegada",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF868686)
                )
            }

            // Ícone de carga
            Image(
                painter = painterResource(id = R.drawable.box),
                contentDescription = "Ícone de carga",
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    TransportaWebTheme {
        HomeM(controleDeNavegacao = NavHostController(LocalContext.current))
    }
}
