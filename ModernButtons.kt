/**
 * @author Kasey Claramonte Soler - kasclasol@proton.me
 * Date: 10/08/2025
 * @since 1.0.0
 */

package com.kcs.main.components

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text // M3 Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.onClick
import androidx.compose.ui.semantics.text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType.Companion
import androidx.compose.ui.text.input.KeyboardType.Companion.Password
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.kcs.main.resources.roundedCornerDp


/**
 * A highly configurable base button with a modern aesthetic, featuring customizable colors,
 * shapes, and a border that highlights on focus.
 *
 * This button serves as the foundation for more specific styled buttons.
 * The button text uses a monospace font with bold weight.
 *
 * @param text The text to be displayed on the button.
 * @param onClick Lambda to be invoked when the button is clicked.
 * @param containerColor The background color of the button.
 * @param modifier Optional [Modifier] for this button.
 * @param width The width of the button in Dp. Defaults to 200.dp.
 * @param height The height of the button in Dp. Defaults to 60.dp.
 * @param contentTextColor The color of the text on the button. Defaults to [Color.White].
 * @param borderShape The shape of the button's border. Defaults to a [RoundedCornerShape]
 *                    with `roundedCornerDp`.
 * @param clipShape The shape used to clip the button's content. Defaults to the `borderShape`.
 */
@Composable
fun ModernButton(
    text: String,
    onClick: () -> Unit,
    containerColor: Color,
    modifier: Modifier = Modifier,
    width: Int = 200,
    height: Int = 60,
    contentTextColor: Color = Color.White,
    borderShape: Shape = RoundedCornerShape(roundedCornerDp),
    clipShape: Shape = borderShape
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isFocused by interactionSource.collectIsFocusedAsState()

    val borderWidth = if (isFocused) 1.5.dp else 1.dp
    val borderColor = if (isFocused) Color.Yellow else Color.White

    Box(
        modifier = modifier
            .width(width.dp)
            .height(height.dp)
            .border(
                width = borderWidth,
                color = borderColor,
                shape = borderShape
            )
            .clip(clipShape),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxSize(),
            shape = RectangleShape,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = containerColor,
                contentColor = contentTextColor,
                disabledContainerColor = containerColor.copy(alpha = 0.6f),
                disabledContentColor = contentTextColor.copy(alpha = 0.7f)
            ),
            interactionSource = interactionSource
        ) {
            Text(
                text = text,
                style = TextStyle(
                    fontFamily = FontFamily.Monospace,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            )
        }
    }
}

/**
 * A "Save" action button derived from [ModernButton], styled with a distinct blue background.
 *
 * This button is visually styled to indicate a save or confirm operation.
 * It inherits the modern aesthetic, focus behavior, and text styling from [ModernButton].
 *
 * @param text The text to be displayed on the button (e.g., "Save", "Confirm").
 * @param onClick Lambda to be invoked when the button is clicked.
 * @param modifier Optional [Modifier] for this button.
 * @param width The width of the button in Dp. Defaults to 200.dp.
 * @param height The height of the button in Dp. Defaults to 60.dp.
 * @param contentTextColor The color of the text on the button. Defaults to [Color.White].
 * @param borderShape The shape of the button's border. Defaults to a [RoundedCornerShape]
 *                    with `roundedCornerDp`.
 * @param clipShape The shape used to clip the button's content. Defaults to the `borderShape`.
 */
@Composable
fun ModernSaveButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    width: Int = 200,
    height: Int = 60,
    contentTextColor: Color = Color.White,
    borderShape: Shape = RoundedCornerShape(roundedCornerDp),
    clipShape: Shape = borderShape
) {
    ModernButton(
        text = text,
        onClick = onClick,
        containerColor = Color(60, 141, 220),
        modifier = modifier,
        width = width,
        height = height,
        contentTextColor = contentTextColor,
        clipShape = clipShape
    )
}

/**
 * A "Delete" action button derived from [ModernButton], styled with a distinct red background.
 *
 * This button is visually styled to indicate a delete or destructive operation.
 * It inherits the modern aesthetic, focus behavior, and text styling from [ModernButton].
 *
 * @param text The text to be displayed on the button (e.g., "Delete", "Remove").
 * @param onClick Lambda to be invoked when the button is clicked.
 * @param modifier Optional [Modifier] for this button.
 * @param width The width of the button in Dp. Defaults to 200.dp.
 * @param height The height of the button in Dp. Defaults to 60.dp.
 * @param contentTextColor The color of the text on the button. Defaults to [Color.White].
 * @param borderShape The shape of the button's border. Defaults to a [RoundedCornerShape]
 *                    with `roundedCornerDp`.
 * @param clipShape The shape used to clip the button's content. Defaults to the `borderShape`.
 */
@Composable
fun ModernDeleteButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    width: Int = 200,
    height: Int = 60,
    contentTextColor: Color = Color.White,
    borderShape: Shape = RoundedCornerShape(roundedCornerDp),
    clipShape: Shape = borderShape
) {
    ModernButton(
        text = text,
        onClick = onClick,
        containerColor = Color(155, 40, 30),
        modifier = modifier,
        width = width,
        height = height,
        contentTextColor = contentTextColor,
        clipShape = clipShape
    )
}