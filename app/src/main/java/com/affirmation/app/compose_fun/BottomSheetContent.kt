package com.affirmation.app.compose_fun

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.affirmation.app.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetContent(
    isSheetOpen: MutableState<Boolean>,
    sharedTextState: MutableState<String>
) {
    val sheetState = rememberModalBottomSheetState()
    if (isSheetOpen.value) {
        ModalBottomSheet(
            sheetState = sheetState,
            onDismissRequest = {
                isSheetOpen.value = false
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .navigationBarsPadding()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Center)
                ) {
                    Text(

                        text = sharedTextState.value,
                        fontSize = 24.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.CenterHorizontally),
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(26.dp))

                    Image(
                        painterResource(id = R.drawable.image1),
                        null,
                        Modifier.align(Alignment.CenterHorizontally),
                    )

                    Spacer(modifier = Modifier.height(26.dp))

                    Button(
                        modifier = Modifier
                            .height(32.dp)
                            .align(Alignment.CenterHorizontally),
                        onClick = {
                            Log.d("message", "onClickBottomSheet")
                        }
                    ) {
                        Text(text = "BottomSheet")
                    }
                }
            }
        }
    }
}

class BooleanPreviewParameterProvider : PreviewParameterProvider<Boolean> {
    override val values = sequenceOf(true, false)
}

@Preview(showBackground = true)
@Composable
fun BottomSheetContentPreview(
    @PreviewParameter(BooleanPreviewParameterProvider::class) isSheetOpen: Boolean
) {
    val state = remember { mutableStateOf(isSheetOpen) }
    val sharedTextState = remember { mutableStateOf("") }

    BottomSheetContent(
        isSheetOpen = state,
        sharedTextState = sharedTextState
    )
}
