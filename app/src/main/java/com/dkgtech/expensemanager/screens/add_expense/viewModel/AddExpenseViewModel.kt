package com.dkgtech.expensemanager.screens.add_expense.viewModel

import androidx.lifecycle.ViewModel
import com.dkgtech.expensemanager.model.ExpenseModel
import com.dkgtech.expensemanager.repo.ExpenseRepo
import com.dkgtech.expensemanager.roomdb.ExpenseDao

class AddExpenseViewModel(val expenseRepo: ExpenseRepo) : ViewModel() {

    fun addExpense(newExpense: ExpenseModel) {
        expenseRepo.addExpense(newExpense)
    }

}