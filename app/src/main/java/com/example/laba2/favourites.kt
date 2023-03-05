package com.example.laba2


import Common
import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.laba2.Interface.RetrofitServices
import com.example.laba2.databinding.FragmentFavouritesBinding
import com.example.laba2.model.CityModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import dmax.dialog.SpotsDialog
import kotlinx.coroutines.*


class favourites : Fragment() {
    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var dialog: AlertDialog
    lateinit var mRecyclerView: RecyclerView
    lateinit var mRecyclerViewMager: RecyclerView.LayoutManager
    lateinit var viewBinding: FragmentFavouritesBinding
    lateinit var mAdapter: MyRecyclerViewAdapter
    lateinit var responseList:MutableList<CityModel>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var mData:List<String> = resources.getStringArray(R.array.city).toList()
        viewBinding = FragmentFavouritesBinding.inflate(layoutInflater)
        mRecyclerView = viewBinding.recycler
        mRecyclerView.setHasFixedSize(true)
        mRecyclerView.layoutManager = LinearLayoutManager(context, VERTICAL,false)
        mAdapter = MyRecyclerViewAdapter(mData)
        mRecyclerView.adapter = mAdapter

        dialog = SpotsDialog.Builder().setCancelable(true).setContext(context).build()
        mService = Common.retrofitService
        this.getAllMovieList()

        return viewBinding.root
    }

    private fun launch(block: suspend CoroutineScope.() -> Unit) {

    }

    private fun getAllMovieList() {
        print("HERLHNkjhsdHGjweLYHWEJYYJWEHOI3WUT32JT32HKGJWE")
        dialog.show()
        mService.getMovieList().enqueue(object : Callback<MutableList<CityModel>> {
            override fun onFailure(call: Call<MutableList<CityModel>>, t: Throwable) {
            }

            override fun onResponse(call: Call<MutableList<CityModel>>, response: Response<MutableList<CityModel>>) {
               responseList = response.body() as MutableList<CityModel>
                print(responseList.size)
                if (responseList.isNullOrEmpty()) {
                    var nollCity:CityModel = CityModel()
                    responseList.add(nollCity)
                }
                dialog.dismiss()
            }
        })



    }

    override fun onResume() {
        super.onResume()



    }



}


