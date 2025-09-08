package com.compose.guide.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.guide.R

@Composable
fun MainScreen() {
    LazyColumn(modifier = Modifier.padding(top = 24.dp, bottom = 24.dp)) {
        item {
            HeaderRow()
        }
        items(composeElements) { element ->
            var showDetails by remember { mutableStateOf(false) }
            ComposeElementCard(
                element = element,
                onClick = { showDetails = !showDetails }
            )
            if (showDetails) {
                ComposableElementDetails(elementName = element.name)
            }
        }
    }
}

@Composable
private fun HeaderRow() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .background(Color.LightGray.copy(alpha = 0.1f))
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Name",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(1f),
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = "Description",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.weight(2f),
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.width(5.dp))
    }
}

@Composable
fun ComposeElementCard(element: ComposeElement, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = element.name,
                fontSize = 18.sp,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = element.description,
                fontSize = 14.sp,
                modifier = Modifier.weight(2f)
            )
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        fontWeight = FontWeight.Bold,
        fontSize = 15.sp,
        modifier = Modifier.padding(bottom = 6.dp, top = 8.dp)
    )
}

@Composable
fun CodeBlock(code: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF2A2828))
            .padding(12.dp)
    ) {
        Text(
            text = code,
            color = Color(0xFF2196F3),
            fontFamily = FontFamily.Monospace,
            fontSize = 13.sp,
            textAlign = TextAlign.Start
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComposableElementDetails(elementName: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        when (elementName) {
            "Text" -> TextDetail()
            "TextField" -> TextFieldDetail()
            "Button" -> ButtonDetail()
            "Icon" -> IconDetail()
            "Checkbox" -> CheckboxDetail()
            "RadioButton" -> RadioButtonDetail()
            "Switch" -> SwitchDetail()
            "Slider" -> SliderDetail()
            "ProgressBar" -> ProgressBarDetail()
            "Card" -> CardDetail()
            "FloatingActionButton" -> FloatingActionButtonDetail()
            "Image" -> ImageDetail()
            "AlertDialog" -> AlertDialogDetail()
            "Snackbar" -> SnackbarDetail()
            "LazyColumn" -> LazyColumnDetail()
            "LazyRow" -> LazyRowDetail()
            "Box" -> BoxDetail()
            "Column" -> ColumnDetail()
            "Row" -> RowDetail()
            "Spacer" -> SpacerDetail()
            "Divider" -> DividerDetail()
            "Scaffold" -> ScaffoldDetail()
            "TopAppBar" -> TopAppBarDetail()
            "BottomAppBar" -> BottomAppBarDetail()
            "NavigationRail" -> NavigationRailDetail()
            "ModalBottomSheetLayout" -> ModalBottomSheetLayoutDetail()
            "BackdropScaffold" -> BackdropScaffoldDetail()
            else -> DefaultDetail(elementName)
        }
    }
}

// --- Details Composable ---

@Composable
private fun TextDetail() {
    val codeString = """
Text(
    "This is a sample Text composable."
)
""".trim()
    Column {
        SectionTitle("Output")
        Text("This is a sample Text composable.")
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun TextFieldDetail() {
    var text by remember { mutableStateOf("") }
    val codeString = """
TextField(
    modifier = Modifier.fillMaxWidth(),
    value = text,
    onValueChange = { text = it },
    label = { Text("Enter Text") }
)
""".trim()
    Column {
        SectionTitle("Output")
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter Text") }
        )
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun ButtonDetail() {
    var buttonText by remember { mutableStateOf("Sample Button") }
    val codeString = """
Button(onClick = { buttonText = "Clicked" }) {
    Text("Sample Button")
}
""".trim()
    Column {
        SectionTitle("Output")
        Button(onClick = { buttonText = "Clicked" }) {
            Text(buttonText)
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun IconDetail() {
    val codeString = """
Icon(
    Icons.Filled.Add,
    contentDescription = "Sample Icon"
)
""".trim()
    Column {
        SectionTitle("Output")
        Icon(Icons.Filled.Add, contentDescription = "Sample Icon")
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun CheckboxDetail() {
    var checked by remember { mutableStateOf(true) }
    val codeString = """
Checkbox(
    checked = checked,
    onCheckedChange = { checked = it }
)
""".trim()
    Column {
        SectionTitle("Output")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked, onCheckedChange = { checked = it })
            Text("Sample Checkbox")
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun RadioButtonDetail() {
    var selected by remember { mutableStateOf(true) }
    val codeString = """
RadioButton(
    selected = selected,
    onClick = { selected = !selected }
)
""".trim()
    Column {
        SectionTitle("Output")
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(selected = selected, onClick = { selected = !selected })
            Text("Sample RadioButton")
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun SwitchDetail() {
    var switched by remember { mutableStateOf(true) }
    val codeString = """
Switch(
    checked = switched,
    onCheckedChange = { switched = it }
)
""".trim()
    Column {
        SectionTitle("Output")
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = switched, onCheckedChange = { switched = it })
            Text("Sample Switch")
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun SliderDetail() {
    var sliderPosition by remember { mutableStateOf(0f) }
    val codeString = """
Slider(
    value = sliderPosition,
    onValueChange = { sliderPosition = it }
)
""".trim()
    Column {
        SectionTitle("Output")
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
        Text("Slider Value: $sliderPosition")
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun ProgressBarDetail() {
    val codeString = """
LinearProgressIndicator()
CircularProgressIndicator()
""".trim()
    Column {
        SectionTitle("Output")
        LinearProgressIndicator()
        Spacer(modifier = Modifier.padding(8.dp))
        CircularProgressIndicator()
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun CardDetail() {
    val codeString = """
Card {
    Text("This is a sample Card", modifier = Modifier.padding(16.dp))
}
""".trim()
    Column {
        SectionTitle("Output")
        Card(modifier = Modifier.padding(8.dp)) {
            Text("This is a sample Card", modifier = Modifier.padding(16.dp))
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun FloatingActionButtonDetail() {
    val codeString = """
FloatingActionButton(onClick = { /*TODO*/ }) {
    Icon(Icons.Filled.Add, "Sample FAB")
}
""".trim()
    Column {
        SectionTitle("Output")
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Add, "Sample FAB")
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun ImageDetail() {
    val codeString = """
Image(
    painter = painterResource(id = R.drawable.ic_launcher_foreground),
    contentDescription = ""
)
""".trim()
    Column {
        SectionTitle("Output")
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = ""
        )
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun AlertDialogDetail() {
    var openDialog by remember { mutableStateOf(false) }
    val codeString = """
AlertDialog(
    onDismissRequest = { /*TODO*/ },
    confirmButton = { /*...*/ },
    title = { Text("Sample Dialog Title") },
    text = { Text("This is the message body of the AlertDialog.") }
)
""".trim()
    Column {
        SectionTitle("Output")
        Button(onClick = { openDialog = true }) {
            Text("Show Dialog")
        }
        if (openDialog) {
            AlertDialog(
                onDismissRequest = { openDialog = false },
                title = { Text(text = "Sample Dialog Title") },
                text = { Text("This is the message body of the AlertDialog.") },
                confirmButton = {
                    TextButton(onClick = { openDialog = false }) {
                        Text("Confirm")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { openDialog = false }) {
                        Text("Dismiss")
                    }
                }
            )
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun SnackbarDetail() {
    val codeString = """
Snackbar {
    Text("Sample Snackbar")
}
""".trim()
    Column {
        SectionTitle("Output")
        Snackbar {
            Text("Sample Snackbar")
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun LazyColumnDetail() {
    val codeString = """
LazyColumn {
    // items(...)
}
""".trim()
    Column {
        SectionTitle("Output")
        Text("LazyColumn - This list itself is a LazyColumn.")
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun LazyRowDetail() {
    val codeString = """
LazyRow {
    // items(...)
}
""".trim()
    Column {
        SectionTitle("Output")
        Text("LazyRow - Similar to LazyColumn, but horizontal.")
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun BoxDetail() {
    val codeString = """
Box {
    Text("Content in a Box")
}
""".trim()
    Column {
        SectionTitle("Output")
        Box(modifier = Modifier.padding(8.dp)) { Text("Content in a Box") }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun ColumnDetail() {
    val codeString = """
Column {
    Text("Item 1 in Column")
    Text("Item 2 in Column")
}
""".trim()
    Column {
        SectionTitle("Output")
        Column(modifier = Modifier.padding(8.dp)) {
            Text("Item 1 in Column")
            Text("Item 2 in Column")
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun RowDetail() {
    val codeString = """
Row {
    Text("Item 1 in Row")
    Spacer(modifier = Modifier.width(8.dp))
    Text("Item 2 in Row")
}
""".trim()
    Column {
        SectionTitle("Output")
        Row(modifier = Modifier.padding(8.dp)) {
            Text("Item 1 in Row")
            Spacer(modifier = Modifier.width(8.dp))
            Text("Item 2 in Row")
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun SpacerDetail() {
    val codeString = """
Row {
    Text("Before Spacer")
    Spacer(modifier = Modifier.width(16.dp))
    Text("After Spacer")
}
""".trim()
    Column {
        SectionTitle("Output")
        Row {
            Text("Before Spacer")
            Spacer(modifier = Modifier.width(16.dp))
            Text("After Spacer")
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun DividerDetail() {
    val codeString = """
Column {
    Text("Content above divider")
    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
    Text("Content below divider")
}
""".trim()
    Column {
        SectionTitle("Output")
        Column {
            Text("Content above divider")
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            Text("Content below divider")
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ScaffoldDetail() {
    val codeString = """
Box(
    modifier = Modifier.heightIn(max = 400.dp).fillMaxWidth()
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Title") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Filled.Add, "FAB")
            }
        }
    ) { innerPadding ->
        Text("Scaffold content", modifier = Modifier.padding(innerPadding))
    }
}
""".trim()
    Column {
        SectionTitle("Output")
        Box(modifier = Modifier.heightIn(max = 400.dp).fillMaxWidth()) {
            Scaffold(
                topBar = {
                    TopAppBar(title = { Text("Title") })
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { }) {
                        Icon(Icons.Filled.Add, "FAB")
                    }
                }
            ) { innerPadding ->
                Text("Scaffold content", modifier = Modifier.padding(innerPadding))
            }
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBarDetail() {
    val codeString = """
TopAppBar(title = { Text("Sample TopAppBar") })
""".trim()
    Column {
        SectionTitle("Output")
        TopAppBar(title = { Text("Sample TopAppBar") })
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun BottomAppBarDetail() {
    val codeString = """
BottomAppBar {
    Icon(Icons.Filled.Add, contentDescription = "Add")
}
""".trim()
    Column {
        SectionTitle("Output")
        BottomAppBar {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun NavigationRailDetail() {
    val codeString = """
NavigationRail {
    NavigationRailItem(
        selected = true,
        onClick = { },
        icon = { Icon(Icons.Filled.Add, null) }
    )
}
""".trim()
    Column {
        SectionTitle("Output")
        NavigationRail {
            NavigationRailItem(
                selected = true,
                onClick = {},
                icon = { Icon(Icons.Filled.Add, null) }
            )
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ModalBottomSheetLayoutDetail() {
    var showSheet by remember { mutableStateOf(false) }
    val codeString = """
var showSheet by remember { mutableStateOf(false) }
Button(onClick = { showSheet = true }) { Text("Show Bottom Sheet") }
if (showSheet) {
    ModalBottomSheet(onDismissRequest = { showSheet = false }) {
    Text("Sheet content")
}
}
""".trim()
    Column {
        SectionTitle("Output")
        Button(onClick = { showSheet = true }) { Text("Show Bottom Sheet") }
        if (showSheet) {
            ModalBottomSheet(onDismissRequest = { showSheet = false }) {
                Text("Sheet content", modifier = Modifier.padding(16.dp))
            }
        }
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun BackdropScaffoldDetail() {
    val codeString = """
BackdropScaffold(
    appBar = { TopAppBar(title = { Text("Backdrop") }) },
    backLayerContent = { Text("Back Layer") },
    frontLayerContent = { Text("Front Layer") }
)
""".trim()
    Column {
        SectionTitle("Output")
        Text("BackdropScaffold - requires accompanist or material library for full demo.")
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

@Composable
private fun DefaultDetail(elementName: String) {
    val codeString = "Details for $elementName will be shown here."
    Column {
        SectionTitle("Output")
        Text("Details for $elementName will be shown here.")
        SectionTitle("Code")
        CodeBlock(codeString)
    }
}

// --- Data Model ---
data class ComposeElement(val name: String, val description: String)

val composeElements = listOf(
    ComposeElement("Text", "Displays text on the screen."),
    ComposeElement("TextField", "Allows users to input text."),
    ComposeElement("Button", "A clickable element to perform actions."),
    ComposeElement("Image", "Displays images."),
    ComposeElement("Icon", "Displays vector graphics or icons."),
    ComposeElement("Checkbox", "Allows users to select or deselect an option."),
    ComposeElement("RadioButton", "Allows users to select one option from a set."),
    ComposeElement("Switch", "A toggle to switch between two states (on/off)."),
    ComposeElement("Slider", "Allows users to select a value from a range."),
    ComposeElement("ProgressBar", "Indicates the progress of an operation."),
    ComposeElement("Card", "A container with a shadow, often used to group related content."),
    ComposeElement("AlertDialog", "A dialog that informs the user about a situation that requires acknowledgement."),
    ComposeElement("Snackbar", "Provides brief messages about app processes at the bottom of the screen."),
    ComposeElement("LazyColumn", "A vertically scrolling list that only composes and lays out the currently visible items."),
    ComposeElement("LazyRow", "A horizontally scrolling list that only composes and lays out the currently visible items."),
    ComposeElement("Box", "A layout composable that positions its children relative to its edges."),
    ComposeElement("Column", "A layout composable that places its children in a vertical sequence."),
    ComposeElement("Row", "A layout composable that places its children in a horizontal sequence."),
    ComposeElement("Spacer", "An empty composable that defines a fixed space."),
    ComposeElement("Divider", "A thin line that separates content."),
    ComposeElement("Scaffold", "Implements the basic Material Design visual layout structure."),
    ComposeElement("TopAppBar", "Displays information and actions relating to the current screen."),
    ComposeElement("BottomAppBar", "Displays navigation and actions at the bottom of the screen."),
    ComposeElement("FloatingActionButton", "A circular button that triggers the primary action in an app's UI."),
    ComposeElement("NavigationRail", "Provides access to primary destinations in your app on larger screens."),
    ComposeElement("ModalBottomSheetLayout", "A layout that allows a bottom sheet to be displayed from the bottom of the screen."),
    ComposeElement("BackdropScaffold", "Implements the Backdrop Material Design component.")
)
