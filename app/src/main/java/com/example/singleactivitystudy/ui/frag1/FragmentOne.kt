package com.example.singleactivitystudy.ui.frag1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.singleactivitystudy.databinding.FragmentOneBinding
import kotlinx.coroutines.flow.collect

class FragmentOne : Fragment() {

	lateinit var binding: FragmentOneBinding
	private val viewModel by viewModels<FragOneViewModel>()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentOneBinding.inflate(inflater, container, false)
		binding.lifecycleOwner = viewLifecycleOwner
		binding.viewModel = viewModel
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setObservers()
	}


	private fun setObservers() = lifecycleScope.launchWhenStarted {
		viewModel.navigateToFragTwo.collect {
			findNavController().navigate(FragmentOneDirections.goToFragTwo())
		}
	}

}