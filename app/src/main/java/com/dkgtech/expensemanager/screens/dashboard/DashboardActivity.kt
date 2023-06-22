package com.dkgtech.expensemanager.screens.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dkgtech.expensemanager.R
import com.dkgtech.expensemanager.RecyclerAdapter.RecyclerExpenseAdapter
import com.dkgtech.expensemanager.databinding.ActivityDashboardBinding
import com.dkgtech.expensemanager.model.CategoryModel
import com.dkgtech.expensemanager.model.ExpenseModel
import com.dkgtech.expensemanager.repo.ExpenseRepo
import com.dkgtech.expensemanager.roomdb.AppDatabase
import com.dkgtech.expensemanager.screens.dashboard.viewModel.DashboardViewModel
import com.dkgtech.expensemanager.screens.dashboard.viewModel.DashboardViewModelFactory
import java.util.Calendar
import java.util.Locale.Category

class DashboardActivity : AppCompatActivity() {
    lateinit var binding: ActivityDashboardBinding


    companion object {
        val arrCat = ArrayList<CategoryModel>().apply {
            add(CategoryModel(id = 1, name = "Shopping", imgPath = R.drawable.shopping))
            add(CategoryModel(id = 2, name = "Food", imgPath = R.drawable.food))
            add(CategoryModel(id = 3, name = "Grocery", imgPath = R.drawable.grocery))
            add(CategoryModel(id = 4, name = "Movie", imgPath = R.drawable.movie))
            add(CategoryModel(id = 5, name = "Massage", imgPath = R.drawable.massage))
            add(CategoryModel(id = 6, name = "Travel", imgPath = R.drawable.travel))
            add(CategoryModel(id = 7, name = "Petrol/Gas", imgPath = R.drawable.petrol))
            add(CategoryModel(id = 8, name = "Salon", imgPath = R.drawable.salon))

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val appDb = AppDatabase.getDatabase(this@DashboardActivity)

        val expenseRepo = ExpenseRepo(appDb.ExpenseDao())

        val dashboardViewModel =
            ViewModelProvider(
                this@DashboardActivity,
                DashboardViewModelFactory(expenseRepo)
            )[DashboardViewModel::class.java]


//        adding dummy data

        dashboardViewModel.addExpense(
            ExpenseModel(
                id = 0,
                title = "Clothing",
                desc = "Cloth Shopping",
                amount = 500.00,
                balance = 500.00,
                type = 1,
                catType = 1,
                date = Calendar.getInstance().timeInMillis.toString()
            )
        )


        dashboardViewModel.addExpense(
            ExpenseModel(
                id = 0,
                title = "Pizza Hut",
                desc = "Pizza Hut Mira Road",
                amount = 300.00,
                balance = 200.00,
                type = 1,
                catType = 2,
                date = Calendar.getInstance().timeInMillis.toString()
            )
        )

        dashboardViewModel.addExpense(
            ExpenseModel(
                id = 0,
                title = "Movie - Adipurush",
                desc = "Watched move at Inox in Mira Road",
                amount = 300.00,
                balance = 0.00,
                type = 1,
                catType = 4,
                date = Calendar.getInstance().timeInMillis.toString()
            )
        )

        dashboardViewModel.getAllExpense().observe(this) {
//            set recycler view here

            binding.rcExpenseView.apply {
                layoutManager = LinearLayoutManager(this@DashboardActivity)
                adapter =
                    RecyclerExpenseAdapter(this@DashboardActivity, it as ArrayList<ExpenseModel>)
            }
        }


    }

}