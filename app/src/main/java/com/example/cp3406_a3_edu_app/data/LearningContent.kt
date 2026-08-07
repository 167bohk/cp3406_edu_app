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
            id = 2,
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
            id = 3,
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
            id = 4,
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
            id = 5,
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
            id = 6,
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
            id = 7,
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
            id = 8,
            title = "Space Exploration",
            summary = "Discover how NASA missions study Earth, the Solar System and space.",
            facts = listOf(
                "Space telescopes observe distant objects from above Earth's atmosphere.",
                "Orbiters study a world from space, while landers and rovers work on its surface.",
                "Robotic spacecraft can visit places that people cannot yet reach.",
                "Mission instruments send images and scientific measurements back to Earth."
            ),
            sourceUrl = "https://science.nasa.gov/science-missions/"
        ),
        LearningTopic(
            id = 9,
            title = "Star Life Cycles",
            summary = "Follow a star from a cloud of gas to the end of its life.",
            facts = listOf(
                "Stars form inside cold clouds of gas and dust called molecular clouds.",
                "Most stars are made mainly of hydrogen and helium.",
                "A main-sequence star produces energy by fusing hydrogen into helium in its core.",
                "A star's mass affects how quickly it uses fuel and how long it lives.",
                "The core left by a low-mass star can become a white dwarf.",
                "A massive star can end its life in a powerful explosion called a supernova."
            ),
            sourceUrl = "https://science.nasa.gov/universe/stars/",
            questionIds = listOf(45, 46, 47, 48, 49, 50)
        ),
        LearningTopic(
            id = 10,
            title = "Exoplanets",
            summary = "Learn how scientists find planets beyond our Solar System.",
            facts = listOf(
                "An exoplanet is a planet outside our Solar System, and most orbit other stars.",
                "Transit and radial velocity are two important ways to detect exoplanets.",
                "During a transit, a planet passes in front of its star and blocks a small amount of starlight.",
                "The habitable zone is the distance from a star where liquid water could exist on a rocky planet's surface.",
                "The radial velocity method looks for a small wobble in a star caused by an orbiting planet."
            ),
            sourceUrl = "https://science.nasa.gov/exoplanets/facts/",
            questionIds = listOf(51, 52, 53, 54, 55)
        ),
        LearningTopic(
            id = 11,
            title = "Space Telescopes",
            summary = "Compare how Hubble and Webb observe the universe from space.",
            facts = listOf(
                "Hubble orbits Earth above most of the atmosphere.",
                "Working above the atmosphere helps Hubble avoid atmospheric blur and observe wavelengths blocked from the ground.",
                "The James Webb Space Telescope is designed mainly to observe infrared light.",
                "Webb operates near the Sun-Earth L2 point and travels around the Sun with Earth.",
                "Webb observes deeper into infrared light, while Hubble also observes visible and ultraviolet light."
            ),
            sourceUrl = "https://science.nasa.gov/mission/hubble/observatory/hubble-vs-webb/",
            questionIds = listOf(56, 57, 58, 59, 60)
        )
    )
}
