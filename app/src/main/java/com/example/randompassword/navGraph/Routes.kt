
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.randompassword.navGraph.RouteItem
import com.example.randompassword.screens.HomeScreen
import com.example.randompassword.screens.SplashScreen
import com.example.randompassword.viewmodel.MainViewModel

@Composable
fun Routes(navHost: NavHostController,viewModel: MainViewModel) {

    NavHost(navController = navHost, startDestination = RouteItem.SplashScreen.route) {

        composable(RouteItem.SplashScreen.route) {
            SplashScreen(navHost = navHost)
        }

        composable(RouteItem.HomeScreen.route) {
           HomeScreen(viewModel = viewModel)
        }

    }
}