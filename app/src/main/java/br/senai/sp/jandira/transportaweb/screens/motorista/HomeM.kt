package br.senai.sp.jandira.transportaweb.screens.motoristas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
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
import br.senai.sp.jandira.transportaweb.model.Viagem
import br.senai.sp.jandira.transportaweb.repository.CardsRepository
import br.senai.sp.jandira.transportaweb.ui.theme.TransportaWebTheme
//import br.senai.sp.jandira.transportaweb.utils.encurtarData

@Composable
fun HomeM(controleDeNavegacao: NavHostController) {
    val cards = CardsRepository().listarTodosOsCards()

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
                    .height(225.dp)
                    .background(
                        Color.White, shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                    )
            ) {
                Row(
                    modifier = Modifier.padding(top = 30.dp, start = 0.dp)
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
                            .padding(top = 16.dp, start = 70.dp),
                        text = "Jamal",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .padding(end = 26.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .padding(0.dp)
                                .size(55.dp),
                            shape = CircleShape,
                            border = BorderStroke(2.dp, Color.White)
                        ) {
                            // Placeholder for image or content
                        }
                        Text(
                            modifier = Modifier
                                .padding(top = 12.dp)
                                .background(
                                    Color(0xFFF61221),
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            text = "Status",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
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
                    text = "À serviço da Vanderley Transportes.",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xFF868686)
                )
            }

            // Adicionando o card de Viagem
            ViagemCard(
                viagem = Viagem(
                    id = 1,
                    id_viagem = "12345",
                    dia_partida = "2024-12-05 08:00",
                    dia_chegada = "2024-12-05 18:00",
                    destino_cep = "06317-200",
                    partida_cep = "06317-200",
                    destinatario = "SDS",
                    remetente = "DHL",
                    veiculo_modelo = "Scania",
                    tipo_carga_nome = "Frágil",
                    status_entregue = 0,
                    empresa_nome = "DHL",
                    motorista_nome = "Pedro",
                    horario_partida = "08:00:00"
                    )
            )

            // Espaço dinâmico para empurrar a Box (Rodapé) para o final da tela
            Spacer(modifier = Modifier.weight(1f)) // Este espaçamento empurra a Box para o fundo

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
                            contentDescription = "Caminhao",
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
    }
}

@Composable
fun ViagemCard(viagem: Viagem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            .height(220.dp), // Aumentando a altura um pouco para um layout mais espaçado
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Título da viagem com um ícone
            Text(
                text = "Viagem #${viagem.id_viagem}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color(0xFF1A1A1A) // Cor mais escura para o título
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Linha com Partida e Chegada
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Data de partida com ícone
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Create,
                        contentDescription = "Partida",
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFF868686)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Partida: ${viagem.dia_partida}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF868686)
                    )
                }

                // Data de chegada com ícone
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Chegada",
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFF868686)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Chegada: ${viagem.dia_chegada}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF868686)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            // Linha com Remetente e Destinatário
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Remetente com ícone
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Remetente",
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFF868686)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Remetente: ${viagem.remetente}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF868686)
                    )
                }

                // Destinatário com ícone
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Destinatário",
                        modifier = Modifier.size(20.dp),
                        tint = Color(0xFF868686)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = "Destinatário: ${viagem.destinatario}",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF868686)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Divider para separar visualmente
            Divider(
                color = Color(0xFFDADADA),
                thickness = 1.dp,
                modifier = Modifier.padding(top = 8.dp)
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
