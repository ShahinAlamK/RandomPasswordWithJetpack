package com.example.randompassword.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.randompassword.R

val poppins = FontFamily(
    Font(R.font.poppinsblack, weight = FontWeight.Black),
    Font(R.font.poppinsmedium, weight = FontWeight.Medium),
    Font(R.font.poppinssemibold, weight = FontWeight.SemiBold),
)

val Typography = Typography(

    titleLarge = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
    ),

    titleMedium = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
    ),

    bodyLarge = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Black,
        fontSize = 18.sp,
    ),

    bodyMedium = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
    )

)