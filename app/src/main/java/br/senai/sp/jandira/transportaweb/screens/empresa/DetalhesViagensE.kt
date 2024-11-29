package br.senai.sp.jandira.transportaweb.screens.empresas

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavHostController
import br.senai.sp.jandira.transportaweb.R
import br.senai.sp.jandira.transportaweb.model.ViaCepResponse
import br.senai.sp.jandira.transportaweb.model.Viagem
import br.senai.sp.jandira.transportaweb.model.ViagemResponse
import br.senai.sp.jandira.transportaweb.service.RetrofitFactory
import br.senai.sp.jandira.transportaweb.ui.theme.TransportaWebTheme
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.tasks.Task
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.time.LocalDate
import java.time.LocalTime
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

@Composable
fun DetalhesViagensE(controleDeNavegacao: NavHostController, id: String? = "1") {

    val viagemId = id ?: "1"

    var viagem by remember {
        mutableStateOf(Viagem(
            id = 0, // Exemplo de valor para o id
            id_viagem = "111-111-111", // Exemplo de ID de viagem
            dia_partida = "2024-11-21", // Exemplo de data de partida
            horario_partida = "10:00", // Exemplo de horário de partida
            dia_chegada = "2024-11-22", // Exemplo de data de chegada
            remetente = "Empresa A", // Exemplo de remetente
            destinatario = "Empresa B", // Exemplo de destinatário
            status_entregue = 0, // Exemplo de status (0 para não entregue, por exemplo)
            partida_cep = "06317200", // ID do local de partida (exemplo)
            destino_cep = "06317200", // ID do destino (exemplo)
            motorista_nome = "João Silva", // ID do motorista (exemplo)
            veiculo_modelo = "Scania", // ID do veículo (exemplo)
            tipo_carga_nome = "Pástico", // ID do tipo de carga (exemplo)
            empresa_nome = "" // ID da empresa (exemplo)
        ))
    }
    // Estados para armazenar os logradouros
    var logradouroPartida by remember { mutableStateOf("Carregando...") }
    var logradouroDestino by remember { mutableStateOf("Carregando...") }


    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val context = LocalContext.current
        val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }

        var currentLocation by remember { mutableStateOf<LatLng?>(null) }

        val cameraPositionState = rememberCameraPositionState()

        LaunchedEffect(Unit) {
            getLastKnownLocation(fusedLocationClient, context) { location ->
                currentLocation = location
                cameraPositionState.position = CameraPosition.fromLatLngZoom(location, 14f)
            }
        }
        Column {

            // Função para buscar logradouros via API do ViaCEP
            fun buscarLogradouros() {
                val viaCepService = RetrofitFactory().getViaCepService()

                // Busca logradouro de partida
                val callPartida = viaCepService.buscarCep(viagem.partida_cep)
                callPartida.enqueue(object : Callback<ViaCepResponse> {
                    override fun onResponse(
                        call: Call<ViaCepResponse>,
                        response: Response<ViaCepResponse>
                    ) {
                        if (response.isSuccessful && response.body() != null) {
                            logradouroPartida = response.body()?.logradouro ?: "Não encontrado"
                        } else {
                            logradouroPartida = "Erro ao buscar CEP"
                        }
                    }

                    override fun onFailure(call: Call<ViaCepResponse>, t: Throwable) {
                        logradouroPartida = "Erro: ${t.message}"
                    }
                })

                // Busca logradouro de destino
                val callDestino = viaCepService.buscarCep(viagem.destino_cep)
                callDestino.enqueue(object : Callback<ViaCepResponse> {
                    override fun onResponse(
                        call: Call<ViaCepResponse>,
                        response: Response<ViaCepResponse>
                    ) {
                        if (response.isSuccessful && response.body() != null) {
                            logradouroDestino = response.body()?.logradouro ?: "Não encontrado"
                        } else {
                            logradouroDestino = "Erro ao buscar CEP"
                        }
                    }

                    override fun onFailure(call: Call<ViaCepResponse>, t: Throwable) {
                        logradouroDestino = "Erro: ${t.message}"
                    }
                })
            }


            // Chamada API para obter informações da viagem
            val callViagem = RetrofitFactory()
                .getViagemService()
                .getViagemById(viagemId.toInt())

            callViagem.enqueue(object : Callback<ViagemResponse> {
                override fun onResponse(
                    call: Call<ViagemResponse>,
                    response: Response<ViagemResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val viagemResponse = response.body()!!

                        if (viagemResponse.motorista?.isNotEmpty() == true) {
                            viagem = viagemResponse.motorista?.first() ?: Viagem(
                                id = 0,
                                id_viagem = "111-111-111",
                                dia_partida = "2024-11-21",
                                horario_partida = "10:00",
                                dia_chegada = "2024-11-22",
                                remetente = "Empresa A",
                                destinatario = "Empresa B",
                                status_entregue = 0,
                                partida_cep = "06317200",
                                destino_cep = "06317200",
                                motorista_nome = "João Silva",
                                veiculo_modelo = "Scania",
                                tipo_carga_nome = "Pástico",
                                empresa_nome = ""
                            )
                            // **Chame buscarLogradouros após definir a viagem**
                            buscarLogradouros()
                        } else {
                            Log.e("DetalhesViagens", "Lista de motoristas está vazia")
                        }
                    } else {
                        Log.e("DetalhesViagens", "Erro na resposta: ${response.code()}")
                    }
                }

                override fun onFailure(call: Call<ViagemResponse>, t: Throwable) {
                    Log.e("DetalhesViagens", "Erro ao chamar API: ${t.message}")
                }
            })
            fun formatarData(dia_partida: String): String {
                return try {
                    val parsedDateTime = OffsetDateTime.parse(dia_partida) // Interpreta a string no formato ISO 8601
                    val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy") // Define o formato desejado
                    parsedDateTime.toLocalDate().format(dateFormatter) // Extrai a data e formata
                } catch (e: Exception) {
                    "Data inválida"
                }
            }

            fun formatarHorario(horario_partida: String): String {
                return try {
                    val parsedDateTime = OffsetDateTime.parse(horario_partida)
                    val timeFormatter = DateTimeFormatter.ofPattern("H:mm") // Remove os zeros extras
                    parsedDateTime.toLocalTime().format(timeFormatter)
                } catch (e: Exception) {
                    "Horário inválido"
                }
            }


            // Layout da Viagem
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp, start = 25.dp, end = 25.dp)
            ) {
                Button(
                    modifier = Modifier
                        .size(46.dp)
                        .padding(0.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(Color(0xFFF61221)),
                    onClick = {}
                ) {
                    // ícone ou conteúdo do botão
                }

                Card(
                    modifier = Modifier
                        .padding(start = 15.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.Transparent)
                ) {
                    Image(
                        painterResource(R.drawable.caixas),
                        contentDescription = "Caixa",
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .size(40.dp)
                            .padding(top = 5.dp)
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = "Detalhes da viagem:"
                    )

                    Row(
                        modifier = Modifier.padding(bottom = 0.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        Text(
                            text = "Postado dia: ${formatarData(viagem.dia_partida)}",
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF515151)
                        )
                        Text(
                            text = " | ",
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF515151)
                        )
                        Text(
                            text = "Às: ${formatarHorario(viagem.horario_partida)}",
                            textAlign = TextAlign.Center,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium,
                            color = Color(0xFF515151)
                        )
                    }
                }
            }

            Row(
                modifier = Modifier
                    .padding(top = 30.dp, start = 25.dp, end = 25.dp)
                    .fillMaxWidth()
                    .height(45.dp)
                    .background(Color(0xFFF61221), shape = RoundedCornerShape(10.dp))
            ) {
                Text(
                    text = "De: $logradouroPartida",
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 10.dp)
                )
                Text(
                    text = "",
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .padding(horizontal = 30.dp)
                )

                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "Até: $logradouroDestino",
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 10.dp)
                )
            }

            // Linha separadora
            Box(
                modifier = Modifier
                    .padding(top = 24.dp, start = 25.dp, end = 25.dp)
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(color = Color(0xFFDADADA))
            ) { }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
                    .padding(24.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .border(2.dp, Color.White, RoundedCornerShape(20.dp))
            ) {
                GoogleMap(
                    modifier = Modifier.fillMaxSize(),
                    cameraPositionState = cameraPositionState
                ) {
                    currentLocation?.let {
                        Marker(
                            state = com.google.maps.android.compose.rememberMarkerState(
                                position = it
                            ),
                            title = "Sua localização",
                            snippet = "Você está aqui!"
                        )
                    }
                }
            }


            // Linha separadora
            Box(
                modifier = Modifier
                    .padding(top = 24.dp, start = 25.dp, end = 25.dp)
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(color = Color(0xFFDADADA))
            ) { }

            // Caixas de status
            Column {
                Row(
                    modifier = Modifier
                        .padding(top = 14.dp, start = 55.dp, end = 55.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Caixas com imagem
                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .padding(0.dp)
                            .background(Color.Red, shape = RoundedCornerShape(12.dp))
                    ) {
                        Image(
                            painterResource(R.drawable.caixas),
                            contentDescription = "Caixa",
                            contentScale = ContentScale.Inside,
                            modifier = Modifier
                                .size(46.dp)
                                .padding(8.dp)
                        )
                    }

                    // Separador
                    Box(
                        modifier = Modifier
                            .padding(top = 23.dp, start = 6.dp, end = 6.dp)
                            .width(55.dp)
                            .height(2.dp)
                            .background(color = Color(0xFFDADADA))
                    ) {}

                    // Caixas com imagem
                    Box(
                        modifier = Modifier
                            .size(46.dp)
                            .padding(0.dp)
                            .background(Color.Red, shape = RoundedCornerShape(12.dp))
                    ) {
                        Image(
                            painterResource(R.drawable.caixas),
                            contentDescription = "Caixa",
                            contentScale = ContentScale.Inside,
                            modifier = Modifier
                                .size(46.dp)
                                .padding(8.dp)
                        )
                    }
                }

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(top = 5.dp, start = 35.dp, end = 35.dp)
                        .fillMaxWidth()
                ) {
                    Text(text = "Objeto Postado", fontSize = 12.sp)
                    Text(text = "Objeto Entregue", fontSize = 12.sp)
                }
            }

            // Informações adicionais de carga
            Box(
                modifier = Modifier
                    .padding(top = 20.dp, start = 25.dp, end = 25.dp)
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color(0xFFF61221), shape = RoundedCornerShape(10.dp))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .width(200.dp)
                            .fillMaxHeight()
                    ) {
                        Text(text = "ID da Viagem:  ${viagem.id_viagem}", fontSize = 14.sp, color = Color.White)
                        Text(text = "Material: ${viagem.tipo_carga_nome} ", fontSize = 14.sp, color = Color.White,
                            modifier = Modifier.padding(top = 10.dp))

                        Text(text = "Veículo: ${viagem.veiculo_modelo} ", fontSize = 14.sp, color = Color.White,
                            modifier = Modifier.padding(top = 10.dp))
                    }
                    Column(modifier = Modifier.fillMaxSize()) {
                        Button(
                            modifier = Modifier
                                .width(127.dp)
                                .height(30.dp)
                                .padding(0.dp),
                            shape = RoundedCornerShape(4.dp),
                            colors = ButtonDefaults.buttonColors(Color(0xFFF61221)),
                            onClick = {}
                        ) {
//                            Text(
//                                text = "Acompanhar",
//                                fontSize = 11.sp,
//                                color = Color.White
//                            )


                        }
                    }
                    // Informações adicionais de carga
                    Box(
                        modifier = Modifier
                            .padding(top = 20.dp, start = 25.dp, end = 25.dp)
                            .fillMaxWidth()
                            .height(120.dp)
                            .background(Color(0xFFF61221), shape = RoundedCornerShape(10.dp))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .width(200.dp)
                                    .fillMaxHeight()
                            ) {
                                Text(text = "Id da viagem:  ${viagem.id_viagem}", fontSize = 14.sp, color = Color.White,
                                    modifier = Modifier.padding(top = 10.dp))
                                Text(
                                    text = "Material: ${viagem.tipo_carga_nome} ",
                                    fontSize = 14.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = "Veículo: ${viagem.veiculo_modelo} ",
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    modifier = Modifier.padding(top = 10.dp)
                                )
                            }
                            Column(modifier = Modifier.fillMaxSize()) {
                                Button(
                                    modifier = Modifier
                                        .width(127.dp)
                                        .height(30.dp)
                                        .padding(0.dp),
                                    shape = RoundedCornerShape(4.dp),
                                    colors = ButtonDefaults.buttonColors(Color(0xFFF61221)),
                                    onClick = {}
                                ) {
                                    Text(
                                        text = "Status",
                                        fontSize = 11.sp,
                                        color = Color.White
                                    )


                                }
                            }
                        }
                    }
                }
            }
            // Linha separadora
            Box(
                modifier = Modifier
                    .padding(top = 24.dp, start = 25.dp, end = 25.dp)
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(color = Color(0xFFDADADA))
            ) { }
            // Informações adicionais de carga
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(top = 20.dp, start = 80.dp, end = 80.dp)
                    .width(250.dp)
                    .height(90.dp)
                    .background(Color(0xFFF61221), shape = RoundedCornerShape(10.dp)),
            ) {
                Text(text = "Reservar Viagem", fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic, color = Color.White)


            }
        }
    }
}

@Composable
fun LocationPermissionRequest() {
    val context = LocalContext.current
    var hasFineLocationPermission by remember { mutableStateOf(false) }
    val permissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasFineLocationPermission = granted
    }

    LaunchedEffect(Unit) {
        hasFineLocationPermission = ContextCompat.checkSelfPermission(
            context, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        if (!hasFineLocationPermission) {
            permissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
}

fun getLastKnownLocation(
    fusedLocationClient: FusedLocationProviderClient,
    context: Context,
    onLocationReceived: (LatLng) -> Unit
) {
    // Verifique se a permissão foi concedida
    if (ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    ) {
        try {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                location?.let {
                    onLocationReceived(LatLng(it.latitude, it.longitude))
                }
            }
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    } else {
        // Permissão não concedida; tratar ou notificar o usuário
        println("Permissão de localização não concedida.")
    }
}
@Preview
@Composable
fun DetalhesViagensPreview() {
    TransportaWebTheme {
        DetalhesViagensE(controleDeNavegacao = NavHostController(LocalContext.current))
    }
}