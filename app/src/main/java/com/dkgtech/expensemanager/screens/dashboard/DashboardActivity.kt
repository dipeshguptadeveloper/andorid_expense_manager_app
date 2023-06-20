package com.dkgtech.expensemanager.screens.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.dkgtech.expensemanager.databinding.ActivityMainBinding
import com.dkgtech.expensemanager.repo.ExpenseRepo
import com.dkgtech.expensemanager.roomdb.AppDatabase
import com.dkgtech.expensemanager.screens.dashboard.viewModel.DashboardViewModel
import com.dkgtech.expensemanager.screens.dashboard.viewModel.DashboardViewModelFactory

class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val appDb = AppDatabase.getDatabase(this@DashboardActivity)

        val expenseRepo = ExpenseRepo(appDb.ExpenseDao())

        val dashboardViewModel =
            ViewModelProvider(
                this@DashboardActivity,
                DashboardViewModelFactory(expenseRepo)
            )[DashboardViewModel::class.java]


        dashboardViewModel.getAllExpense().observe(this) {
//            set recycler view here
        }



    }

}