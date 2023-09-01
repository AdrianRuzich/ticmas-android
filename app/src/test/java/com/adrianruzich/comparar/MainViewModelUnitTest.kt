package com.adrianruzich.comparar

import com.adrianruzich.comparar.view.MainViewModel
import org.junit.Test
import org.junit.Assert.*
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.Rule
import org.junit.Before
import org.junit.After

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_ValoresIniciales() = runTest {
        assertEquals("", viewModel.comparador.value?.cadena1)
        assertEquals("", viewModel.comparador.value?.cadena2)
        assertEquals(true, viewModel.comparador.value?.iguales)
    }

    @Test
    fun mainViewModel_CompararCadenasIguales() = runTest {
        launch {
            viewModel.compararCadenas("Manzanas 56", "Manzanas 56")
        }
        advanceUntilIdle()
        assertEquals("Manzanas 56", viewModel.comparador.value?.cadena1)
        assertEquals("Manzanas 56", viewModel.comparador.value?.cadena2)
        assertEquals(true, viewModel.comparador.value?.iguales)
    }
    @Test fun mainViewModel_CompararCadenasDistintas() = runTest {
        launch {
            viewModel.compararCadenas("Patata 357", "Batata 357")
        }
        advanceUntilIdle()
        assertEquals("Patata 357", viewModel.comparador.value?.cadena1)
        assertEquals("Batata 357", viewModel.comparador.value?.cadena2)
        assertEquals(false, viewModel.comparador.value?.iguales)
    }
}
