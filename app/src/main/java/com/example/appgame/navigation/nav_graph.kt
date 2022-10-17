
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.appgame.navigation.Screens
import com.example.appgame.ui.SplashScreen
import com.example.appgame.ui.favorite.FavoriteScreen
import com.example.appgame.ui.home.HomeScreen

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController =  navController,
    startDestination = Screens.Splash.route){
        composable(route = Screens.Splash.route){
            SplashScreen(navController)
        }
        composable(route = Screens.Home.route){
            HomeScreen(navController)
        }
        composable(route = Screens.Favorite.route){
            FavoriteScreen(navController)
        }
    }
}