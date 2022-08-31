package com.example.paging3withmutabledata.feature.shared.core.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.paging3withmutabledata.R
import com.example.paging3withmutabledata.feature.characters.list.domain.Character
import com.example.paging3withmutabledata.feature.characters.list.domain.CharacterId
import com.example.paging3withmutabledata.feature.shared.core.presentation.ApplicationTheme
import com.example.paging3withmutabledata.feature.shared.core.presentation.RemoteImage

object Characters {

    @Composable
    fun ListItem(
        character: Character,
        onLikeClicked: (CharacterId, Boolean) -> Unit
    ) {
        val roundedCornerShape = RoundedCornerShape(topStart = 20.dp, bottomStart = 20.dp)
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .background(ApplicationTheme.colors.backgrounds.secondary, roundedCornerShape)
                .clip(roundedCornerShape)
        ) {
            RemoteImage(
                modifier = Modifier.size(100.dp),
                imageUrl = character.image,
                contentDescription = "Image of character ${character.name}"
            )

            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = character.name,
                    style = ApplicationTheme.typography.headlines.h1
                )
                listOfNotNull(character.type, character.species).joinToString(" | ").ifEmpty { null }?.let { typeAndSpecies ->
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = typeAndSpecies,
                        style = ApplicationTheme.typography.paragraphs.medium,
                        color = ApplicationTheme.colors.foregrounds.secondary
                    )
                }
                character.status?.let { status ->
                    Text(
                        modifier = Modifier.padding(top = 4.dp),
                        text = status,
                        style = ApplicationTheme.typography.paragraphs.medium,
                        color = ApplicationTheme.colors.foregrounds.secondary,
                    )
                }
            }

            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .clickable { onLikeClicked(character.id, !character.personalisation.isLiked) },
                painter = painterResource(if (character.personalisation.isLiked) R.drawable.ic_like else R.drawable.ic_like_empty),
                tint = ApplicationTheme.colors.foregrounds.secondary,
                contentDescription = "Like button for character ${character.name}"
            )
        }
    }
}