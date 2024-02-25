package com.example.randompassword.screens

import android.content.ClipboardManager
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.randompassword.R
import com.example.randompassword.components.BoxComponent
import com.example.randompassword.viewmodel.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: MainViewModel) {
    val clipboardManager: androidx.compose.ui.platform.ClipboardManager = LocalClipboardManager.current
    val scope = rememberCoroutineScope()
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        item {

            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = stringResource(id = R.string.app_heading),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )

            //Passwords
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        MaterialTheme.colorScheme.primaryContainer,
                        shape = MaterialTheme.shapes.medium,
                    ),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .padding(end = 15.dp)
                        .size(40.dp)
                        .background(
                            MaterialTheme.colorScheme.primary.copy(alpha = .6f),
                            shape = CircleShape
                        ).align(Alignment.CenterEnd)
                        .clip(CircleShape)
                        .clickable {
                            clipboardManager.setText(AnnotatedString(viewModel.generatedPassword))
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .padding(10.dp)
                            .align(Alignment.CenterEnd),
                        tint = MaterialTheme.colorScheme.onPrimary,
                        painter = painterResource(id = R.drawable.copy), contentDescription = ""
                    )
                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Absolute.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        textAlign = TextAlign.Center,
                        modifier = Modifier.basicMarquee(),
                        text = viewModel.generatedPassword,
                        maxLines = 1,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }

            //Status Passwords
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = viewModel.passwordStatus,
                textAlign = TextAlign.Start,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelSmall
            )

            //Generate Passwords
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                shape = MaterialTheme.shapes.small,
                enabled = viewModel.visiblePassword,
                onClick = {
                    scope.launch {
                        viewModel.generatePasswords()
                    }
                }) {
                Text(text = "Generate", style = MaterialTheme.typography.titleMedium)
            }


            //Digit
            Spacer(modifier = Modifier.height(40.dp))
            BoxComponent(
                modifier = Modifier.height(65.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                MaterialTheme.colorScheme.primary.copy(alpha = .3f),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "0", style = MaterialTheme.typography.bodyMedium)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Digit", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.weight(.2f))
                    Switch(checked = viewModel.digit, onCheckedChange = { viewModel.digit = it })
                }
            }

            //Latter - Upper
            Spacer(modifier = Modifier.height(15.dp))
            BoxComponent(
                modifier = Modifier.height(65.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                MaterialTheme.colorScheme.primary.copy(alpha = .3f),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "A", style = MaterialTheme.typography.bodyMedium)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Latter - uppercase", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.weight(.2f))
                    Switch(
                        checked = viewModel.letterUpper,
                        onCheckedChange = { viewModel.letterUpper = it })
                }
            }

            //Later - lower
            Spacer(modifier = Modifier.height(15.dp))
            BoxComponent(
                modifier = Modifier.height(65.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                MaterialTheme.colorScheme.primary.copy(alpha = .3f),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "a", style = MaterialTheme.typography.bodyMedium)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Latter - lowercase", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.weight(.2f))
                    Switch(
                        checked = viewModel.letterLower,
                        onCheckedChange = { viewModel.letterLower = it })
                }
            }

            //Symbol
            Spacer(modifier = Modifier.height(15.dp))
            BoxComponent(
                modifier = Modifier.height(65.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                MaterialTheme.colorScheme.primary.copy(alpha = .3f),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "#", style = MaterialTheme.typography.bodyMedium)
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Symbol", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.weight(.2f))
                    Switch(checked = viewModel.symbol, onCheckedChange = { viewModel.symbol = it })
                }
            }

            //Length
            Spacer(modifier = Modifier.height(15.dp))
            BoxComponent(
                modifier = Modifier.height(65.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .background(
                                MaterialTheme.colorScheme.primary.copy(alpha = .3f),
                                shape = CircleShape
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = viewModel.length.toInt().toString(),
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Text(text = "Length", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.width(10.dp))
                    Slider(
                        valueRange = 6f..12f,
                        steps = 2,
                        value = viewModel.length,
                        onValueChange = { viewModel.length = it })
                }
            }
        }
    }

}

