package com.dkgtech.expensemanager.RecyclerAdapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dkgtech.expensemanager.databinding.ExpenseRowBinding
import com.dkgtech.expensemanager.model.ExpenseModel
import com.dkgtech.expensemanager.screens.dashboard.DashboardActivity

class RecyclerExpenseAdapter(val context: Context, val arrExpense: ArrayList<ExpenseModel>) :
    RecyclerView.Adapter<RecyclerExpenseAdapter.ViewHolder>() {
    class ViewHolder(val binding: ExpenseRowBinding) : RecyclerView.ViewHolder(binding.root) {
        /*val imgExpenseCat = itemView.findViewById<ImageView>(R.id.imgExpenseCat)
        val txtExpenseTitle = itemView.findViewById<TextView>(R.id.txtExpenseTitle)
        val txtExpenseDesc = itemView.findViewById<TextView>(R.id.txtExpenseDesc)
        val txtExpenseAmount = itemView.findViewById<TextView>(R.id.txtExpenseAmount)
        val txtExpenseBal = itemView.findViewById<TextView>(R.id.txtExpenseBal)*/

//        for data binding

        fun bind(expense: ExpenseModel) {
            binding.expense = expense

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.expense_row, parent, false))
        return ViewHolder(ExpenseRowBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return arrExpense.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

//        normal method
        /* holder.imgExpenseCat.setImageResource(DashboardActivity.arrCat[position].imgPath)
         holder.txtExpenseTitle.text = arrExpense[position].title
         holder.txtExpenseDesc.text = arrExpense[position].desc*/

//        view binding method

//        holder.binding.imgExpenseCat.setImageResource(DashboardActivity.arrCat[position].imgPath)
        /*        holder.binding.imgExpenseCat.setImageResource(DashboardActivity.arrCat[(arrExpense[position].id - 1)].imgPath)
                holder.binding.txtExpenseTitle.text = arrExpense[position].title
                holder.binding.txtExpenseDesc.text = arrExpense[position].desc
                holder.binding.txtExpenseAmount.text = arrExpense[position].amount.toString()
                holder.binding.txtExpenseBal.text = arrExpense[position].balance.toString()*/

//        by data binding method

        holder.bind(arrExpense[position])
    }
}