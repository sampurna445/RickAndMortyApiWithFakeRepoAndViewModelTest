package com.example.rickandmortyapi.data

import com.example.rickandmortyapi.data.model.characters.CharactersModel
import com.example.rickandmortyapi.data.remote.ApiRequest
/*import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations


class RepositoryImpl {
    @Mock
    lateinit var apiRequest: ApiRequest
    @Before
    fun setUp()
    {
        MockitoAnnotations.openMocks(this)
    }


    @Test
    fun testGetCharacters_EmptyList()= runTest {
        val characters = CharactersModel()
        Mockito.`when`(apiRequest.getCharacters()).thenReturn(characters)

        val repositoryTest= RepositoryImpl()
        val result= repositoryTest.testGetCharacters_EmptyList()
        assertEquals(0,result.size)
    }

}*/