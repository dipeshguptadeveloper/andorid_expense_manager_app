package com.dkgtech.expensemanager.screens.add_expense.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dkgtech.expensemanager.repo.ExpenseRepo
import com.dkgtech.expensemanager.screens.dashboard.viewModel.DashboardViewModel

class AddExpenseViewModelFactory(val expenseRepo: ExpenseRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddExpenseViewModel(expenseRepo) as T
    }
}