package com.example.myexpenses.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myexpenses.data.ExpenseDao
import com.example.myexpenses.model.Expense
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class ExpenseViewModel(private val expenseDao: ExpenseDao) : ViewModel() {

    val allExpenses: Flow<List<Expense>> = expenseDao.getAllExpenses()

    fun addExpense(expense: Expense) {
        viewModelScope.launch {
            expenseDao.insertExpense(expense)
        }
    }

    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            expenseDao.deleteExpense(expense)
        }
    }
}
