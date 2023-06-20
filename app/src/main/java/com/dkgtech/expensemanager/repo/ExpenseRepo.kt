package com.dkgtech.expensemanager.repo

import androidx.lifecycle.LiveData
import com.dkgtech.expensemanager.model.ExpenseModel
import com.dkgtech.expensemanager.roomdb.ExpenseDao

class ExpenseRepo(val dao: ExpenseDao) {

    fun addExpense(newExpense: ExpenseModel) {
        dao.addExpense(newExpense)
    }

    fun updateExpense(expense: ExpenseModel) {
        dao.updateExpense(expense)
    }

    fun deleteExpense(expense: ExpenseModel) {
        dao.deleteExpense(expense)
    }

    fun getAllExpense(): LiveData<List<ExpenseModel>> {
        return dao.getAllExpense()
    }
}