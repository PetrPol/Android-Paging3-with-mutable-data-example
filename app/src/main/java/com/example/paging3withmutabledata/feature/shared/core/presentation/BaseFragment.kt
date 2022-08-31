package com.example.paging3withmutabledata.feature.shared.core.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                ApplicationTheme {
                    Surface(
                        color = ApplicationTheme.colors.backgrounds.primary
                    ) {
                        FragmentContent()
                    }
                }
            }
        }
    }

    /**
     * Specifies Composable content that will be displayed within this fragment.
     */
    @Composable
    protected abstract fun FragmentContent()
}