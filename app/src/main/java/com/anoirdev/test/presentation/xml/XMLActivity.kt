package com.anoirdev.test.presentation.xml

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.anoirdev.test.R
import com.anoirdev.test.databinding.ActivityXmlBinding
import com.anoirdev.test.presentation.base.BaseActivity
import com.anoirdev.test.presentation.xml.adapter.EventAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
@ExperimentalCoroutinesApi
@OptIn(InternalCoroutinesApi::class)
class XMLActivity : BaseActivity() {

    @Inject
    lateinit var eventAdapter: EventAdapter

    private val viewModel: XMLViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityXmlBinding>(
            this,
            R.layout.activity_xml
        )
        setSupportActionBar(binding.toolbar)
        registerBindingAndBaseObservers(binding)
        registerRecyclerView(binding)
        registerObservers()
    }


    private fun registerBindingAndBaseObservers(binding: ActivityXmlBinding) {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun registerRecyclerView(binding: ActivityXmlBinding) {
        binding.eventsRecyclerView.adapter = eventAdapter
    }

    private fun registerObservers() {
        registerBaseObservers(viewModel)
        viewModel.observableDataEvent.observe(this) {
            Log.e("Anir", it.listOfData.toString())
            eventAdapter.setItems(it.listOfData)
        }
    }

}