package com.example.myexpenses.ui.screens.dashboard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myexpenses.model.Expense

@Composable
fun DashboardScreen(
    expenses: List<Expense>,
    onAddExpenseClick: () -> Unit
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = onAddExpenseClick) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).fillMaxSize().padding(16.dp)) {

            Text("Total Spent: Ksh ${expenses.sumOf { it.amount }}", style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(expenses) { expense ->
                    ExpenseItem(expense = expense)
                }
            }
        }
    }
}

@Composable
fun ExpenseItem(expense: Expense) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ksh ${expense.amount}", style = MaterialTheme.typography.titleMedium)
            Text(text = expense.category)
            Text(text = expense.note)
        }
    }
}
