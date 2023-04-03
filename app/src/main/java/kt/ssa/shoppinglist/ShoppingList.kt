package kt.ssa.shoppinglist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ShoppingList(items: List<String>, onAddItem: () -> Unit, onRemoveItem: (Int) -> Unit = {}) {
    Column(
        modifier = Modifier
            .background(color = Color.Blue)
            .padding(8.dp)
    ) {
        if(items.isNotEmpty()) {
            LazyColumn(modifier = Modifier.weight(1f)) {
                itemsIndexed(items) { index, label ->
                    ShoppingListCard(modifier = Modifier
                        .padding(top = 8.dp, bottom = 8.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                        position = index, label = label,
                        onRemoveClick = onRemoveItem)
                }
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            onAddItem()
        }) {
            Text(text = "Add Random Item")
        }
    }
}

@Composable
fun ShoppingListCard(modifier: Modifier = Modifier, position: Int, label: String, onRemoveClick: (Int) -> Unit = {}){
  Card(modifier = modifier,
      colors = CardDefaults.cardColors(containerColor = Color.White)) {
     Row(modifier = Modifier
         .padding(8.dp)
         .fillMaxSize(), verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.SpaceBetween) {
         Text(text = "${position + 1}. $label", color = Color.Black)
         IconButton(onClick = {
             onRemoveClick(position)
         }) {
             Icon(imageVector = Icons.Rounded.Close, contentDescription = "delete", tint = Color.Red)
         }
     }
  }
}

@Preview(showBackground = true)
@Composable
fun MyShoppingListPreview() {
    val itemsToBuy = arrayListOf("Bread", "Egg", "Fish", "Goat")
    ShoppingList(items = itemsToBuy, onAddItem = {})
}

@Preview
@Composable
fun ShoppingListCardPreview(){
ShoppingListCard(modifier = Modifier
    .padding(top = 8.dp, bottom = 8.dp)
    .fillMaxWidth()
    .height(50.dp),
    position = 5, label = "Fresh Milk")
}
