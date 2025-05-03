package com.example.myexpenses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.myexpenses.data.ExpenseDatabase
import com.example.myexpenses.ui.screens.dashboard.DashboardScreen
import com.example.myexpenses.ui.theme.MyExpensesTheme
import com.example.myexpenses.viewmodel.ExpenseViewModel
import com.example.myexpenses.viewmodel.ExpenseViewModelFactory

class MainActivity : ComponentActivity() {

    // ViewModel: provides data from Room to UI
    private val viewModel: ExpenseViewModel by viewModels {
        ExpenseViewModelFactory(
            ExpenseDatabase.getDatabase(applicationContext).expenseDao()
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyExpensesTheme {
                // Observe Flow<List<Expense>> as State
                val expenses by viewModel.allExpenses.collectAsState(initial = emptyList())

                // Show DashboardScreen with actual expenses
                DashboardScreen(
                    expenses = expenses,
                    onAddExpenseClick = {
                        //  Hook to AddExpenseScreen in Step 11
                    }
                )
            }
        }
    }
}
