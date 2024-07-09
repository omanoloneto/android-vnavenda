package br.com.omanoloneto.vnavenda.ui.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.omanoloneto.vnavenda.data.entities.ShoppingItem

@Composable
fun ShoppingItemRow(item: ShoppingItem, onCheckedChange: (ShoppingItem) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(item.copy(isChecked = item.isChecked.not())) }
            .padding(16.dp)
    ) {
        Checkbox(
            checked = item.isChecked,
            onCheckedChange = {
                onCheckedChange(item.copy(isChecked = it))
            }
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = item.name,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}