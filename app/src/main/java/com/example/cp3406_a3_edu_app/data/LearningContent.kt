package com.example.cp3406_a3_edu_app.data

data class LearningTopic(
    val id: Int,
    val title: String,
    val summary: String,
    val facts: List<String>,
    val sourceUrl: String,
    val questionIds: List<Int> = emptyList()
)

object LearningContent {
    val topics = listOf(
        LearningTopic(
            id = 1,
            title = "The Planets",
            summary = "Learn the order, size and main types of the eight planets.",
            facts = listOf(
                "Mars looks red because iron minerals in its soil oxidise.",
                "Mercury is the closest planet to the Sun and also the smallest planet.",
                "Venus is the hottest planet because its thick atmosphere traps heat.",
                "Earth is the third planet from the Sun.",
                "Jupiter is the largest planet in our Solar System.",
                "Mercury, Venus, Earth and Mars are rocky planets.",
                "Jupiter and Saturn are gas giants.",
                "Uranus and Neptune are ice giants.",
                "Neptune is the eighth and farthest planet from the Sun."
            ),
            sourceUrl = "https://science.nasa.gov/solar-system/planets/",
            questionIds = listOf(1, 3, 4, 5, 6, 7, 8, 9, 10, 11)
        ),
        LearningTopic(
            id = 2,
            title = "The Solar System",
            summary = "See how our planetary system fits into the Milky Way.",
            facts = listOf(
                "Eight planets orbit the Sun.",
                "Our Solar System formed about 4.6 billion years ago.",
                "It takes about 230 million years for our Solar System to orbit the Milky Way."
            ),
            sourceUrl = "https://science.nasa.gov/solar-system/solar-system-facts/",
            questionIds = listOf(12, 30, 31)
        ),
        LearningTopic(
            id = 3,
            title = "Our Sun",
            summary = "The Sun is the star at the centre of our Solar System.",
            facts = listOf(
                "The Sun is about 4.5 billion years old.",
                "It is a yellow dwarf star made mainly of hydrogen and helium.",
                "The Sun is about 150 million kilometres from Earth.",
                "Its gravity holds the Solar System together."
            ),
            sourceUrl = "https://science.nasa.gov/sun/facts/"
        ),
        LearningTopic(
            id = 4,
            title = "The Moon",
            summary = "Learn about Earth's natural satellite and its changing appearance.",
            facts = listOf(
                "Earth has one natural satellite, the Moon.",
                "The Moon is about 384,400 kilometres from Earth on average.",
                "The Moon does not make its own light; it reflects sunlight.",
                "One complete cycle of Moon phases takes about 29.5 days.",
                "We see the same side because the Moon rotates once in about the same time that it orbits Earth."
            ),
            sourceUrl = "https://science.nasa.gov/moon/facts/",
            questionIds = listOf(18, 19, 20, 21, 22)
        ),
        LearningTopic(
            id = 5,
            title = "Solar and Lunar Eclipses",
            summary = "Compare the positions of the Sun, Earth and Moon during eclipses.",
            facts = listOf(
                "A solar eclipse happens when the Moon moves between the Sun and Earth.",
                "A solar eclipse can occur only near the new moon phase.",
                "A lunar eclipse happens when the Moon passes through Earth's shadow.",
                "A lunar eclipse can occur only near the full moon phase."
            ),
            sourceUrl = "https://science.nasa.gov/moon/eclipses/",
            questionIds = listOf(23, 24, 25, 26)
        ),
        LearningTopic(
            id = 6,
            title = "Small Bodies",
            summary = "Compare dwarf planets, asteroids, comets and meteors.",
            facts = listOf(
                "Ceres is a dwarf planet in the main asteroid belt.",
                "Most known asteroids orbit between Mars and Jupiter.",
                "Asteroids are mainly rocky or metallic leftovers from planet formation.",
                "Comets contain frozen gases, dust and rocky material.",
                "A meteor is the streak of light made when space debris burns in an atmosphere.",
                "Many short-period comets come from the Kuiper Belt beyond Neptune."
            ),
            sourceUrl = "https://science.nasa.gov/asteroids-comets-meteors/",
            questionIds = listOf(13, 14, 15, 16, 17, 32)
        ),
        LearningTopic(
            id = 7,
            title = "Stars and Galaxies",
            summary = "Travel beyond the Solar System to enormous groups of stars.",
            facts = listOf(
                "Our Solar System is located in the Milky Way galaxy.",
                "Gravity holds a galaxy's stars, planets, gas and dust together.",
                "Spiral, elliptical and irregular are common galaxy shapes."
            ),
            sourceUrl = "https://science.nasa.gov/universe/galaxies/",
            questionIds = listOf(2, 27, 28)
        ),
        LearningTopic(
            id = 8,
            title = "Black Holes",
            summary = "Explore regions where gravity is extremely strong.",
            facts = listOf(
                "A black hole contains a great amount of matter in a very small region.",
                "The boundary around a black hole is called the event horizon.",
                "Sagittarius A* is the supermassive black hole at the centre of the Milky Way."
            ),
            sourceUrl = "https://science.nasa.gov/universe/black-holes/",
            questionIds = listOf(29)
        ),
        LearningTopic(
            id = 9,
            title = "Space Exploration",
            summary = "Discover how NASA missions study Earth, the Solar System and space.",
            facts = listOf(
                "Space telescopes observe distant objects from above Earth's atmosphere.",
                "Orbiters study a world from space, while landers and rovers work on its surface.",
                "Robotic spacecraft can visit places that people cannot yet reach.",
                "Mission instruments send images and scientific measurements back to Earth."
            ),
            sourceUrl = "https://science.nasa.gov/science-missions/"
        )
    )
}
