package com.dkgtech.expensemanager.screens.dashboard.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.dkgtech.expensemanager.model.ExpenseModel
import com.dkgtech.expensemanager.repo.ExpenseRepo

class DashboardViewModel(val expenseRepo: ExpenseRepo) : ViewModel() {

    fun getAllExpense(): LiveData<List<ExpenseModel>> {
        return expenseRepo.getAllExpense()
    }

    fun updateExpense(expense: ExpenseModel) {
        expenseRepo.updateExpense(expense)
    }

    fun deleteExpense(expense: ExpenseModel) {
        expenseRepo.deleteExpense(expense)
    }

}