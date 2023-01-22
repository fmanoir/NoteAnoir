package com.anoirdev.test.presentation.xml

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.anoirdev.test.R
import com.anoirdev.test.databinding.ActivityXmlBinding
import com.anoirdev.test.presentation.xml.adapter.EventAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import javax.inject.Inject

@AndroidEntryPoint
@ExperimentalCoroutinesApi
@OptIn(InternalCoroutinesApi::class)
class XMLActivity : AppCompatActivity() {

    @Inject
    lateinit var eventAdapter: EventAdapter

    private val viewModel: XMLViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityXmlBinding>(
            this,
            R.layout.activity_xml
        )
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
        viewModel.observableDataEvent.observe(this) {
            eventAdapter.setItems(it.listOfData)
        }
    }

}