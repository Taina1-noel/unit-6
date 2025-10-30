package com.example.unit6

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.unit6.ui.theme.Unit6Theme
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val characters = remember { mutableStateListOf<Character>() }

            // ✅ Make the API call safely inside LaunchedEffect
            LaunchedEffect(Unit) {
                val client = AsyncHttpClient()
                val url = "https://rickandmortyapi.com/api/character"

                client.get(url, object : JsonHttpResponseHandler() {
                    override fun onSuccess(
                        statusCode: Int,
                        headers: Array<Header>,
                        response: JSONObject
                    ) {
                        val results = response.getJSONArray("results")
                        for (i in 0 until results.length()) {
                            val obj = results.getJSONObject(i)
                            val character = Character(
                                name = obj.getString("name"),
                                status = obj.getString("status"),
                                image = obj.getString("image")
                            )
                            characters.add(character)
                        }
                    }

                    override fun onFailure(
                        statusCode: Int,
                        headers: Array<Header>,
                        throwable: Throwable,
                        errorResponse: JSONObject?
                    ) {
                        Log.e("API_ERROR", "Failed to fetch data", throwable)
                    }
                })
            }

            Unit6Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CharacterList(characters)
                }
            }
        }
    }
}
@Composable
fun CharacterList(characters: List<Character>) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(characters) { character ->
            CharacterCard(character)
        }
    }
}

@Composable
fun CharacterCard(character: Character) {
    Row(modifier = Modifier.padding(vertical = 8.dp)) {
        Image(
            painter = rememberAsyncImagePainter(model = character.image),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = character.name, style = MaterialTheme.typography.titleMedium)
            Text(text = "Status: ${character.status}")
        }
    }
}
