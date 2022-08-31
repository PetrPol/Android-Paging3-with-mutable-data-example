package com.example.paging3withmutabledata.feature.shared.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Scale
import com.example.paging3withmutabledata.R

@Composable
fun RemoteImage(
    modifier: Modifier = Modifier,
    imageUrl: String?,
    contentDescription: String?,
) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current).data(imageUrl).apply {
            placeholder(R.drawable.rick_and_morty_placeholder)
            error(R.drawable.rick_and_morty_placeholder)
            scale(Scale.FILL)
            crossfade(true)
        }.build(),
        contentScale = ContentScale.Crop
    )

    Image(
        modifier = modifier,
        painter = painter,
        contentDescription = contentDescription,
    )
}
