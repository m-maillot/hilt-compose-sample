package hilt.compose.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import hilt.compose.feature.counter.CounterScreen
import hilt.compose.feature.counter.CounterViewModel
import hilt.compose.feature.timer.TimerScreen
import hilt.compose.sample.ui.theme.HiltComposeSampleTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HiltComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "counter") {
                        composable("counter") {
                            CounterScreen {
                                navController.popBackStack()
                                navController.navigate("timer")
                            }
                        }
                        composable("timer") {
                            TimerScreen {
                                navController.popBackStack()
                                navController.navigate("counter")
                            }
                        }
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        // Do nothing
    }
}
