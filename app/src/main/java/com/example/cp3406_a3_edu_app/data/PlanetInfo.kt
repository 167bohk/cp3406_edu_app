package com.example.cp3406_a3_edu_app.data

data class PlanetInfo(
    val name: String,
    val orderFromSun: Int,
    val planetType: String,
    val distanceFromSun: String,
    val dayLength: String,
    val yearLength: String,
    val description: String,
    val funFacts: List<String>,
    val sourceUrl: String,
    val orbitSpeed: Float,
    val displaySize: Float,
    val questionIds: List<Int> = emptyList()
)

object PlanetCatalog {
    val planets = listOf(
        PlanetInfo(
            name = "Mercury",
            orderFromSun = 1,
            planetType = "Rocky planet",
            distanceFromSun = "58 million km",
            dayLength = "59 Earth days",
            yearLength = "88 Earth days",
            description = "Mercury is the smallest planet and the closest planet to the Sun.",
            funFacts = listOf(
                "Mercury travels around the Sun faster than any other planet.",
                "Its surface has many impact craters, a little like Earth's Moon.",
                "Mercury has no moons and no rings."
            ),
            sourceUrl = "https://science.nasa.gov/mercury/facts/",
            orbitSpeed = 4.2f,
            displaySize = 4f,
            questionIds = listOf(3, 7, 11, 33, 34)
        ),
        PlanetInfo(
            name = "Venus",
            orderFromSun = 2,
            planetType = "Rocky planet",
            distanceFromSun = "108 million km",
            dayLength = "243 Earth days",
            yearLength = "225 Earth days",
            description = "Venus is similar in size to Earth, but it has a thick, hot atmosphere.",
            funFacts = listOf(
                "A day on Venus is longer than a year on Venus.",
                "Venus rotates backward compared with most planets.",
                "Its thick atmosphere makes Venus the hottest planet."
            ),
            sourceUrl = "https://science.nasa.gov/venus/venus-facts/",
            orbitSpeed = 3.4f,
            displaySize = 5f,
            questionIds = listOf(4, 35, 36)
        ),
        PlanetInfo(
            name = "Earth",
            orderFromSun = 3,
            planetType = "Rocky planet",
            distanceFromSun = "150 million km",
            dayLength = "23.9 hours",
            yearLength = "365.25 days",
            description = "Earth is our home planet and the only world known to support life.",
            funFacts = listOf(
                "Earth is the only planet known to have liquid water on its surface.",
                "Its name does not come from Greek or Roman mythology.",
                "Sunlight takes about eight minutes to reach Earth."
            ),
            sourceUrl = "https://science.nasa.gov/earth/facts/",
            orbitSpeed = 2.7f,
            displaySize = 5.5f,
            questionIds = listOf(5, 37)
        ),
        PlanetInfo(
            name = "Mars",
            orderFromSun = 4,
            planetType = "Rocky planet",
            distanceFromSun = "228 million km",
            dayLength = "24.6 hours",
            yearLength = "687 Earth days",
            description = "Mars is a cold desert world whose iron-rich soil gives it a red colour.",
            funFacts = listOf(
                "A Martian day is called a sol.",
                "Mars has seasons, but they last longer than Earth's seasons.",
                "Mars is about half the size of Earth."
            ),
            sourceUrl = "https://science.nasa.gov/mars/facts/",
            orbitSpeed = 2.2f,
            displaySize = 4.5f,
            questionIds = listOf(1, 38)
        ),
        PlanetInfo(
            name = "Jupiter",
            orderFromSun = 5,
            planetType = "Gas giant",
            distanceFromSun = "778 million km",
            dayLength = "9.9 hours",
            yearLength = "About 12 Earth years",
            description = "Jupiter is the largest planet in the Solar System.",
            funFacts = listOf(
                "Jupiter has the shortest day of all the planets.",
                "Its Great Red Spot is a giant storm bigger than Earth.",
                "Its four largest moons are called the Galilean moons."
            ),
            sourceUrl = "https://science.nasa.gov/jupiter/jupiter-facts/",
            orbitSpeed = 1.5f,
            displaySize = 9f,
            questionIds = listOf(6, 8, 39, 40)
        ),
        PlanetInfo(
            name = "Saturn",
            orderFromSun = 6,
            planetType = "Gas giant",
            distanceFromSun = "1.4 billion km",
            dayLength = "10.7 hours",
            yearLength = "29.4 Earth years",
            description = "Saturn is a gas giant best known for its bright ring system.",
            funFacts = listOf(
                "Saturn is about nine times wider than Earth.",
                "Its rings are made from countless pieces of ice and rock.",
                "Saturn experiences seasons because its axis is tilted."
            ),
            sourceUrl = "https://science.nasa.gov/saturn/facts/",
            orbitSpeed = 1.15f,
            displaySize = 8f,
            questionIds = listOf(41)
        ),
        PlanetInfo(
            name = "Uranus",
            orderFromSun = 7,
            planetType = "Ice giant",
            distanceFromSun = "2.9 billion km",
            dayLength = "About 17 hours",
            yearLength = "84 Earth years",
            description = "Uranus is a blue-green ice giant that rotates on its side.",
            funFacts = listOf(
                "Uranus has an extreme tilt of about 98 degrees.",
                "It rotates in the opposite direction from most planets.",
                "A dark winter near one pole can last about 21 Earth years."
            ),
            sourceUrl = "https://science.nasa.gov/uranus/facts/",
            orbitSpeed = 0.85f,
            displaySize = 6.5f,
            questionIds = listOf(9, 42)
        ),
        PlanetInfo(
            name = "Neptune",
            orderFromSun = 8,
            planetType = "Ice giant",
            distanceFromSun = "4.5 billion km",
            dayLength = "About 16 hours",
            yearLength = "About 165 Earth years",
            description = "Neptune is a cold, windy ice giant and the farthest planet from the Sun.",
            funFacts = listOf(
                "Sunlight takes about four hours to reach Neptune.",
                "Each season on Neptune lasts for more than 40 Earth years.",
                "Neptune was the first planet located using mathematical predictions."
            ),
            sourceUrl = "https://science.nasa.gov/neptune/neptune-facts/",
            orbitSpeed = 0.65f,
            displaySize = 6.5f,
            questionIds = listOf(10, 43, 44)
        )
    )
}
