package kt.ssa.shoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import kt.ssa.shoppinglist.ui.theme.SSATodoTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SSATodoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var myItems by remember { mutableStateOf(emptyList<String>()) }
                    val addItem = {
                        val randomNumber = Random.nextInt(1000)
                        val item = "Item -> $randomNumber"
                        val newList = myItems.toMutableList()
                        newList.add(item)
                        myItems = newList
                    }
                    val removeItem = { index:Int ->
                    val newList = myItems.toMutableList()
                        newList.removeAt(index)
                        myItems = newList
                    }
                    ShoppingList(items = myItems, onAddItem = addItem, onRemoveItem = removeItem)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column() {
        Text(text = "Hi", fontSize = 30.sp)
        Text(text = "My Name is $name")

        Button(onClick = {}) {
            Text(text = "Click Me Please")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SSATodoTheme {
        Greeting(name = "Rotary")
    }
}
