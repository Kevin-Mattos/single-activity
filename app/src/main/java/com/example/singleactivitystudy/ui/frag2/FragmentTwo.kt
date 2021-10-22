package com.example.singleactivitystudy.ui.frag2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.singleactivitystudy.R
import com.example.singleactivitystudy.databinding.FragmentOneBinding
import com.example.singleactivitystudy.databinding.FragmentTwoBinding
import kotlinx.coroutines.flow.collect

class FragmentTwo : Fragment() {

	lateinit var binding: FragmentTwoBinding
	private val viewModel by viewModels<FragTwoViewModel>()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		binding = FragmentTwoBinding.inflate(inflater, container, false)
		binding.lifecycleOwner = viewLifecycleOwner
		binding.viewModel = viewModel
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		setObservers()
	}

	private fun setObservers() = lifecycleScope.launchWhenStarted {
		viewModel.navigateToFragOne.collect{
			findNavController().navigate(FragmentTwoDirections.goToFragOne())
		}
	}
}