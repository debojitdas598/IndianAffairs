package com.example.indianaffairs.screens

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.indianaffairs.R
import com.example.indianaffairs.ViewModels.DetailsViewModel
import com.example.indianaffairs.models.NewsItem

@Composable
fun DetailScreen(){
    val detailsViewModel : DetailsViewModel = hiltViewModel()
    val news = detailsViewModel.news.collectAsState()
    LazyColumn(content = {
        items(news.value){
            NewsListItem(headline = it.title, source = it.sourceName, imageurl = it.image,url = it.link)
        }
    })
}

@Composable
fun NewsListItem(headline : String, source:String, imageurl:String,url:String){


    val localUriHandler = LocalUriHandler.current
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp,10.dp)
                .shadow(16.dp)
                .clip(shape = RoundedCornerShape(10.dp))
                .clickable {

                        }


        ) {
            // Background Image
            Image(
                painter = rememberAsyncImagePainter(model = imageurl), // Replace with your image resource
                contentDescription = null, // Content description can be set if the image conveys meaningful information
                modifier = Modifier
                    .fillMaxSize() // You can use another shape or remove this line based on your needs
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 0f,
                            endY = 300f // Adjust the endY based on your image size
                        )
                    ),
                contentScale = ContentScale.Crop
            )

            // Your content overlay goes here
            // This can include text, icons, or other composables
            // Make sure to adjust the positioning based on your layout requirements
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable {
                        localUriHandler.openUri(url)
                    }
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            )
                        )
                    ),

                contentAlignment = Alignment.Center
            ) {
                // Your overlay content goes here
                Column(modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(10.dp)) {
                    Text(text = headline, color = Color.White, fontSize = 20.sp)
                    Text(text = source, color = Color.White, fontSize = 10.sp)
                }

            }
        }

}
fun linkToWebpage(context: Context,url: String) {
    //val context = ContextAmbient.current
    val openURL = Intent(Intent.ACTION_VIEW)
    openURL.data = Uri.parse(url)
    startActivity(context, openURL, null )
}



