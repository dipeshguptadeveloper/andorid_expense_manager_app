package com.dkgtech.expensemanager.screens.add_expense

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dkgtech.expensemanager.R
import com.dkgtech.expensemanager.databinding.ActivityAddExpenseBinding
import com.dkgtech.expensemanager.repo.ExpenseRepo
import com.dkgtech.expensemanager.roomdb.AppDatabase
import com.dkgtech.expensemanager.screens.add_expense.viewModel.AddExpenseViewModel
import com.dkgtech.expensemanager.screens.add_expense.viewModel.AddExpenseViewModelFactory
import com.dkgtech.expensemanager.screens.dashboard.viewModel.DashboardViewModel
import com.dkgtech.expensemanager.screens.dashboard.viewModel.DashboardViewModelFactory

class AddExpenseActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddExpenseBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val appDb = AppDatabase.getDatabase(this)

        val expenseRepo = ExpenseRepo(appDb.ExpenseDao())

        val addExpenseViewModel = ViewModelProvider(
            this@AddExpenseActivity,
            AddExpenseViewModelFactory(expenseRepo)
        )[AddExpenseViewModel::class.java]


    }
}