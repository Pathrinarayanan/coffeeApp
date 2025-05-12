package com.example.coffeeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.coffeeapp.ui.theme.CoffeeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = false

        setContent {
                MainScreen()

        }
    }
}


@Composable
fun CustomBottomBar(){
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
            .height(90.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){

        val items = listOf(
            Icons.Filled.Home,
            Icons.Filled.Favorite,
            Icons.Filled.ShoppingCart,
            Icons.Filled.Notifications,

        )
        items.forEach {
            Icon(
                it,
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                tint =  Color(0xffB7B7B7)
            )
        }
    }
}
@Composable
fun HorizontalSlider(){
        val items = listOf(
            "Cappucinno",
            "machiato",
            "lattie",
            "cold coffe"
        )
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp).horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ){
        items.forEachIndexed {index, data->
            SliderItem(index ==0,data)
        }
    }
}

@Composable
fun SliderItem(isSelected : Boolean , text: String){

    Box(
        modifier = Modifier.height(40.dp).background(if(isSelected)Color(0xffC67C4E) else Color.White, RoundedCornerShape(8.dp))
            .padding(vertical = 10.dp, horizontal = 16.dp)
    ){
        Text(text.toUpperCase(),
            modifier = Modifier,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = if(isSelected) Color.White else Color(0xff2F4B4E)
        )

    }
}

@Composable
fun SearchBox(){
    Row(
        modifier = Modifier.height(60.dp).fillMaxWidth()
            .padding(10.dp)
            .background(Color.White, RoundedCornerShape(20.dp))
            .border(1.dp,color = Color.LightGray, RoundedCornerShape(20.dp)),
        verticalAlignment = Alignment.CenterVertically
    ){
        Icon(
            Icons.Filled.Search,
            contentDescription = null,
            modifier = Modifier
                .padding(start = 10.dp)
                .size(20.dp)
        )
        Text(
            "Search coffee",
            Modifier.padding(start = 8.dp),
            color = Color(0xff989898)
        )
        Spacer(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier.padding(end =15.dp).size(30.dp).background(Color(0xffC67C4E), RoundedCornerShape(8.dp))
        ){
            Icon(
                Icons.Filled.List,
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                tint = Color.White
            )
        }
    }
}
@Preview
@Composable
fun CustomTopBar(){
    val gradient = Brush
        .verticalGradient(
            listOf(
                Color(0xfff131313),
                Color(0xe0313131)
            )
        )
    Column (
        modifier = Modifier.padding(bottom = 16.dp)
    ){
        Box(
            modifier = Modifier.height(160.dp)
                .fillMaxWidth()
                .background(gradient)
        ) {
            Column {
                Text(
                    "Cappucino",
                    modifier = Modifier.padding(top = 50.dp, start = 16.dp),
                    fontSize = 12.sp,
                    color = Color(0xffB7B7B7),
                    fontWeight = FontWeight.Normal,
                )
                Row(
                    modifier = Modifier.padding(top = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "West, Balurghat",
                        modifier = Modifier.padding(start = 16.dp),
                        fontSize = 14.sp,
                        color = Color(0xffDDDDDD),
                        fontWeight = FontWeight.Normal,
                    )
                    Icon(
                        Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier.padding(start = 5.dp).size(14.dp),
                        tint = Color.White
                    )
                }
            }
        }
        Box(
            modifier = Modifier.padding(horizontal = 10.dp)
                .offset(y = -30.dp)
        ) {
            SearchBox()
        }
        HorizontalSlider()
    }
}
@Preview
@Composable
fun MainScreen(){
    Scaffold(
        modifier = Modifier,
        topBar = {
            CustomTopBar()
        },
        bottomBar = {
            CustomBottomBar()
        }

    ) {
        HomeScreen(it)
    }
}
@Composable
fun HomeScreen(values: PaddingValues) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        Modifier.background(Color.White).padding(values),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(10) {
            Product()
        }
    }
}
@Composable
fun Product(){
    Column (modifier = Modifier.width(149.dp).height(260.dp)){
        Box(
            modifier = Modifier
                .padding(6.dp)
                .size(height = 150.dp, width = 142.dp)
            .clip(RoundedCornerShape(10.dp))
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        Text(
            "Cappucino",
            modifier = Modifier.padding(top = 4.dp).fillMaxWidth(),
            fontSize = 16.sp,
            color = Color(0xff2F2D2C),
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        Text(
            "with chocolate",
            modifier = Modifier.padding(top = 4.dp).fillMaxWidth(),
            fontSize = 12.sp,
            color = Color(0xff9B9B9B),
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                "$ 4.53",
                modifier = Modifier,
                fontSize = 18.sp,
                color = Color(0xff2F4B4E),
                fontWeight = FontWeight.SemiBold,
            )
            Spacer(modifier = Modifier.weight(1f))
            Box(
                modifier = Modifier.padding(end = 24.dp).size(32.dp).background(Color(0xffC67C4E), RoundedCornerShape(8.dp))
            ){
                Icon(
                    Icons.Filled.Add,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    tint = Color.White
                )
            }
        }
    }
}


@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xff1E1E1E))
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "splash",
            modifier = Modifier.height(500.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds
        )
        Text(
            "Time for a coffee break....",
            modifier = Modifier.padding(top = 18.5.dp).fillMaxWidth(),
            fontSize = 24.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )
        Text(
            "Your daily dose of fresh brew delivered to\n" +
                    "your doorstep. Start your coffee journey now!",
            modifier = Modifier.padding(top = 18.5.dp).fillMaxWidth(),
            fontSize = 17.sp,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier
                .padding(top = 80.dp)
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(50.dp)
                .background(Color(0xffE27D19), RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                "Get Started",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 16.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        }
    }
}

