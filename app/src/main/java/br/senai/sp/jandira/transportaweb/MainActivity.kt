package br.senai.sp.jandira.transportaweb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.transportaweb.screens.LoginM
import br.senai.sp.jandira.transportaweb.screens.empresas.CadastroE
import br.senai.sp.jandira.transportaweb.screens.empresas.DetalhesViagensE
import br.senai.sp.jandira.transportaweb.screens.empresas.LoginE
import br.senai.sp.jandira.transportaweb.screens.motoristas.CadastroM
import br.senai.sp.jandira.transportaweb.screens.motoristas.DetalhesViagensM
//import br.senai.sp.jandira.transportaweb.screens.motoristas.HomeM
import br.senai.sp.jandira.transportaweb.screens.motoristas.PerfilH
import br.senai.sp.jandira.transportaweb.ui.theme.TransportaWebTheme

class   MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TransportaWebTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val controleNavegacao = rememberNavController()
                    NavHost(
                        navController = controleNavegacao,
                        startDestination = "detalhesViagensEmpresa/1"
                    ) {
                        // ********************************** MOTORISTA ********************************** //

                        composable(route = "cadastroMotorista") { CadastroM(controleNavegacao) }
                        composable(route = "loginMotorista") { LoginM(controleNavegacao) }
//                        composable(route = "homeMotorista") { HomeM(controleNavegacao) }
                        composable(route = "perfilMotorista") { PerfilH(controleNavegacao) }
                        composable(route = "detalhesViagensMotorista") {
                            DetalhesViagensM(
                                controleNavegacao
                            )
                        }

                        // ********************************** EMPRESA ********************************** //
                        composable(route = "cadastroeEmpresa") { CadastroE(controleNavegacao) }
                        composable(route = "loginEmpresa") { LoginE(controleNavegacao) }
                        composable(route = "detalhesViagensEmpresa/{id}") { backStackEntry ->
                            // Acessando o parâmetro 'id' da rota
                            val viagemId = backStackEntry.arguments?.getString("id") ?: "1"

                            // Chama a função passando o id da viagem
                            DetalhesViagensE(controleDeNavegacao = controleNavegacao, id = viagemId)
                        }
                    }

                }
            }
        }
    }
}

