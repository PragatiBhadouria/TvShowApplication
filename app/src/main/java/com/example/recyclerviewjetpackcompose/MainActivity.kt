package com.example.recyclerviewjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.AnimationEndReason
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.recyclerviewjetpackcompose.compose.TvShowListItem
import com.example.recyclerviewjetpackcompose.data.TvShowList
import com.example.recyclerviewjetpackcompose.model.TvShow
import com.example.recyclerviewjetpackcompose.ui.theme.RecyclerViewJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            DisplayTvShow{
                startActivity(InfoActivity.intent(this,it))
            }
        }
    }
}

@Composable
fun DisplayTvShow(selectedItem: (TvShow) -> Unit){
    val tvShows = remember{TvShowList.tvShows}
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ){
        items(
           items = tvShows,
            itemContent = {
                TvShowListItem(it, selectedItem)
            }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecyclerViewJetpackComposeTheme {
    }
}