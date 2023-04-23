package com.example.rickandmortyapi.ui.characters

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rickandmortyapi.data.model.characters.CharactersModel
import com.example.rickandmortyapi.data.model.characters.ResultModel
import com.example.rickandmortyapi.data.repository.FakeRepository
import com.example.rickandmortyapi.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CharactersViewModelTest {


    private val testDispatcher= StandardTestDispatcher()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var repository: Repository

    @Before
    fun setUP()
    {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(testDispatcher)
    }



    @Test
    fun testGetCharacters() = runTest {
        val characters = CharactersModel()


        // Return the mock ProductsModel object from the repository
        Mockito.`when`(repository.getCharacters()).thenReturn(characters)

        val viewModel = CharactersViewModel(repository)
        viewModel.getCharacters()

        // Calling the function that uses the repository to get the characters

        testDispatcher.scheduler.advanceUntilIdle()

        // Checking if the products LiveData contains the expected result
        viewModel.characters.value?.let { value ->
            assertEquals(0, value.results?.size ?: 0)
        }

    }

}