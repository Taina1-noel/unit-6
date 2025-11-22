
Taina Noel
This app fetches character data from the Rick and Morty API and displays it in a scrollable list using Jetpack Compose’s LazyColumn. Each character entry shows their image, name, and status. The app also includes a search bar, clickable list items, and dividers between entries.
✅ Required Features (Completed)
✔ Make an API call using AsyncHTTPClient
The app uses AsyncHttpClient to fetch JSON data from
https://rickandmortyapi.com/api/character.
✔ Implement a RecyclerView (LazyColumn in Compose)
A LazyColumn displays the list of character cards.
✔ Display at least 3 pieces of data
Each card includes:
Image
Name
Status
⭐ Stretch Features (Completed)
⭐ Search Bar: Users can filter characters in real time.
⭐ Click Interaction: Tapping a character shows a Toast message.
⭐ Dividers: Clean dividers appear between list items.
⭐ Compose UI: Entire UI done using Jetpack Compose.
🧩 App Structure
MainActivity.kt       → API call + UI + LazyColumn display
Character.kt          → Data model class
ui/theme/*            → Theme + colors + typography
🛠 Technologies Used
Kotlin
Jetpack Compose
AsyncHttpClient
Coil (for image loading)
Material 3
🌐 API Used
Rick and Morty API
Endpoint: https://rickandmortyapi.com/api/character

📝 Notes
All feedback for Unit 6 has been addressed.
This project satisfies ALL required features ✨
and ALL stretch features 🎉.




“This project uses Jetpack Compose. RecyclerView is implemented using LazyColumn, which is the Compose replacement for RecyclerView.”

