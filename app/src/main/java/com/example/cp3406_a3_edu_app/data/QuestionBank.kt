package com.example.cp3406_a3_edu_app.data

object QuestionBank {
    private const val PLANET_SOURCE = "https://science.nasa.gov/solar-system/planets/"
    private const val MERCURY_SOURCE = "https://science.nasa.gov/mercury/facts/"
    private const val VENUS_SOURCE = "https://science.nasa.gov/venus/venus-facts/"
    private const val EARTH_SOURCE = "https://science.nasa.gov/earth/facts/"
    private const val SOLAR_SYSTEM_SOURCE =
        "https://science.nasa.gov/solar-system/solar-system-facts/"
    private const val MARS_SOURCE = "https://science.nasa.gov/mars/facts/"
    private const val JUPITER_SOURCE = "https://science.nasa.gov/jupiter/jupiter-facts/"
    private const val SATURN_SOURCE = "https://science.nasa.gov/saturn/facts/"
    private const val URANUS_SOURCE = "https://science.nasa.gov/uranus/facts/"
    private const val NEPTUNE_SOURCE = "https://science.nasa.gov/neptune/neptune-facts/"
    private const val MOON_SOURCE = "https://science.nasa.gov/moon/facts/"
    private const val MOON_PHASE_SOURCE = "https://science.nasa.gov/moon/moon-phases/"
    private const val ECLIPSE_SOURCE = "https://science.nasa.gov/moon/eclipses/"
    private const val SMALL_BODY_SOURCE =
        "https://science.nasa.gov/asteroids-comets-meteors/"
    private const val COMET_SOURCE = "https://science.nasa.gov/solar-system/comets/facts/"
    private const val GALAXY_SOURCE = "https://science.nasa.gov/universe/galaxies/"
    private const val BLACK_HOLE_SOURCE = "https://science.nasa.gov/universe/black-holes/"

    val questions = listOf(
        SpaceQuestion(
            id = 1,
            prompt = "Which planet is known as the Red Planet?",
            answers = listOf("Venus", "Mars", "Jupiter", "Mercury"),
            correctAnswerIndex = 1,
            explanation = "Iron minerals in Martian soil oxidise and make Mars look red.",
            topic = "Planets",
            sourceUrl = MARS_SOURCE
        ),
        SpaceQuestion(
            id = 2,
            prompt = "What is the name of our galaxy?",
            answers = listOf("Andromeda", "Whirlpool", "Milky Way", "Sombrero"),
            correctAnswerIndex = 2,
            explanation = "Our Solar System is located in the Milky Way galaxy.",
            topic = "Universe",
            sourceUrl = GALAXY_SOURCE
        ),
        SpaceQuestion(
            id = 3,
            prompt = "Which planet is closest to the Sun?",
            answers = listOf("Earth", "Venus", "Mercury", "Mars"),
            correctAnswerIndex = 2,
            explanation = "Mercury is the first planet from the Sun.",
            topic = "Planets",
            sourceUrl = PLANET_SOURCE
        ),
        SpaceQuestion(
            id = 4,
            prompt = "Which is the smallest planet in our Solar System?",
            answers = listOf("Mercury", "Mars", "Venus", "Neptune"),
            correctAnswerIndex = 0,
            explanation = "Mercury is the smallest of the eight planets.",
            topic = "Planets",
            sourceUrl = PLANET_SOURCE
        ),
        SpaceQuestion(
            id = 5,
            prompt = "Which planet is the hottest?",
            answers = listOf("Mercury", "Venus", "Mars", "Jupiter"),
            correctAnswerIndex = 1,
            explanation = "Venus is hottest because its thick atmosphere traps heat.",
            topic = "Planets",
            sourceUrl = SOLAR_SYSTEM_SOURCE
        ),
        SpaceQuestion(
            id = 6,
            prompt = "Earth is which planet from the Sun?",
            answers = listOf("Second", "Third", "Fourth", "Fifth"),
            correctAnswerIndex = 1,
            explanation = "Earth is the third planet from the Sun.",
            topic = "Planets",
            sourceUrl = PLANET_SOURCE
        ),
        SpaceQuestion(
            id = 7,
            prompt = "Which is the largest planet in our Solar System?",
            answers = listOf("Saturn", "Neptune", "Earth", "Jupiter"),
            correctAnswerIndex = 3,
            explanation = "Jupiter is the largest planet in our Solar System.",
            topic = "Planets",
            sourceUrl = SOLAR_SYSTEM_SOURCE
        ),
        SpaceQuestion(
            id = 8,
            prompt = "Which two planets are gas giants?",
            answers = listOf(
                "Earth and Mars",
                "Jupiter and Saturn",
                "Uranus and Neptune",
                "Mercury and Venus"
            ),
            correctAnswerIndex = 1,
            explanation = "Jupiter and Saturn are gas giants.",
            topic = "Planets",
            sourceUrl = SOLAR_SYSTEM_SOURCE
        ),
        SpaceQuestion(
            id = 9,
            prompt = "Which two planets are ice giants?",
            answers = listOf(
                "Uranus and Neptune",
                "Jupiter and Saturn",
                "Earth and Mars",
                "Mercury and Venus"
            ),
            correctAnswerIndex = 0,
            explanation = "Uranus and Neptune are called ice giants.",
            topic = "Planets",
            sourceUrl = SOLAR_SYSTEM_SOURCE
        ),
        SpaceQuestion(
            id = 10,
            prompt = "Which planet is farthest from the Sun?",
            answers = listOf("Saturn", "Uranus", "Neptune", "Jupiter"),
            correctAnswerIndex = 2,
            explanation = "Neptune is the eighth and farthest planet from the Sun.",
            topic = "Planets",
            sourceUrl = PLANET_SOURCE
        ),
        SpaceQuestion(
            id = 11,
            prompt = "Which of these is a rocky planet?",
            answers = listOf("Saturn", "Neptune", "Jupiter", "Earth"),
            correctAnswerIndex = 3,
            explanation = "Earth is one of the four rocky inner planets.",
            topic = "Planets",
            sourceUrl = SOLAR_SYSTEM_SOURCE
        ),
        SpaceQuestion(
            id = 12,
            prompt = "How many planets are in our Solar System?",
            answers = listOf("Seven", "Eight", "Nine", "Ten"),
            correctAnswerIndex = 1,
            explanation = "Our Solar System has eight planets.",
            topic = "Solar System",
            sourceUrl = PLANET_SOURCE
        ),
        SpaceQuestion(
            id = 13,
            prompt = "Which dwarf planet is found in the asteroid belt?",
            answers = listOf("Pluto", "Eris", "Ceres", "Haumea"),
            correctAnswerIndex = 2,
            explanation = "Ceres is a dwarf planet in the main asteroid belt.",
            topic = "Small Bodies",
            sourceUrl = PLANET_SOURCE
        ),
        SpaceQuestion(
            id = 14,
            prompt = "Where is the main asteroid belt?",
            answers = listOf(
                "Between Earth and Mars",
                "Between Mars and Jupiter",
                "Beyond Neptune",
                "Between Mercury and Venus"
            ),
            correctAnswerIndex = 1,
            explanation = "Most known asteroids orbit between Mars and Jupiter.",
            topic = "Small Bodies",
            sourceUrl = SMALL_BODY_SOURCE
        ),
        SpaceQuestion(
            id = 15,
            prompt = "What are asteroids mainly made of?",
            answers = listOf("Rock and metal", "Liquid water", "Hot gas", "Wood and soil"),
            correctAnswerIndex = 0,
            explanation = "Asteroids are rocky, airless leftovers from planet formation.",
            topic = "Small Bodies",
            sourceUrl = SMALL_BODY_SOURCE
        ),
        SpaceQuestion(
            id = 16,
            prompt = "What are comets mainly made of?",
            answers = listOf("Only metal", "Ice, dust and rock", "Liquid lava", "Only gas"),
            correctAnswerIndex = 1,
            explanation = "Comets contain frozen gases, dust and rocky material.",
            topic = "Small Bodies",
            sourceUrl = COMET_SOURCE
        ),
        SpaceQuestion(
            id = 17,
            prompt = "What is a meteor?",
            answers = listOf(
                "A new planet",
                "A moon around an asteroid",
                "Space debris burning in an atmosphere",
                "A cloud around a galaxy"
            ),
            correctAnswerIndex = 2,
            explanation = "A meteor is the streak of light made when space debris burns in an atmosphere.",
            topic = "Small Bodies",
            sourceUrl = SMALL_BODY_SOURCE
        ),
        SpaceQuestion(
            id = 18,
            prompt = "How many natural moons does Earth have?",
            answers = listOf("None", "One", "Two", "Four"),
            correctAnswerIndex = 1,
            explanation = "Earth has one natural satellite, the Moon.",
            topic = "Moon",
            sourceUrl = MOON_SOURCE
        ),
        SpaceQuestion(
            id = 19,
            prompt = "About how far is the Moon from Earth?",
            answers = listOf("38,440 km", "384,400 km", "3,844,000 km", "150 million km"),
            correctAnswerIndex = 1,
            explanation = "The Moon is about 384,400 kilometres from Earth on average.",
            topic = "Moon",
            sourceUrl = MOON_SOURCE
        ),
        SpaceQuestion(
            id = 20,
            prompt = "Why can we see the Moon shining?",
            answers = listOf(
                "It makes its own light",
                "It reflects sunlight",
                "It reflects city lights",
                "It is covered in fire"
            ),
            correctAnswerIndex = 1,
            explanation = "The Moon does not make its own light; it reflects light from the Sun.",
            topic = "Moon",
            sourceUrl = MOON_PHASE_SOURCE
        ),
        SpaceQuestion(
            id = 21,
            prompt = "About how long is one complete cycle of Moon phases?",
            answers = listOf("One day", "Seven days", "29.5 days", "365 days"),
            correctAnswerIndex = 2,
            explanation = "The Moon completes a phase cycle in about 29.5 days.",
            topic = "Moon",
            sourceUrl = MOON_PHASE_SOURCE
        ),
        SpaceQuestion(
            id = 22,
            prompt = "Why do we usually see the same side of the Moon?",
            answers = listOf(
                "The Moon does not rotate",
                "Clouds hide the other side",
                "Its rotation and orbit take about the same time",
                "The Sun lights only one side"
            ),
            correctAnswerIndex = 2,
            explanation = "The Moon rotates once in about the same time that it orbits Earth.",
            topic = "Moon",
            sourceUrl = MOON_SOURCE
        ),
        SpaceQuestion(
            id = 23,
            prompt = "What happens during a solar eclipse?",
            answers = listOf(
                "Earth moves between the Sun and Moon",
                "The Moon moves between the Sun and Earth",
                "The Sun stops producing light",
                "Mars blocks the Sun"
            ),
            correctAnswerIndex = 1,
            explanation = "A solar eclipse happens when the Moon passes between the Sun and Earth.",
            topic = "Eclipses",
            sourceUrl = ECLIPSE_SOURCE
        ),
        SpaceQuestion(
            id = 24,
            prompt = "What happens during a lunar eclipse?",
            answers = listOf(
                "The Moon enters Earth's shadow",
                "The Sun enters Earth's shadow",
                "Venus blocks the Moon",
                "The Moon stops reflecting light forever"
            ),
            correctAnswerIndex = 0,
            explanation = "A lunar eclipse happens when the Moon passes through Earth's shadow.",
            topic = "Eclipses",
            sourceUrl = ECLIPSE_SOURCE
        ),
        SpaceQuestion(
            id = 25,
            prompt = "During which Moon phase can a solar eclipse occur?",
            answers = listOf("Full moon", "New moon", "First quarter", "Third quarter"),
            correctAnswerIndex = 1,
            explanation = "A solar eclipse can occur only near the new moon phase.",
            topic = "Eclipses",
            sourceUrl = ECLIPSE_SOURCE
        ),
        SpaceQuestion(
            id = 26,
            prompt = "During which Moon phase can a lunar eclipse occur?",
            answers = listOf("New moon", "First quarter", "Full moon", "Third quarter"),
            correctAnswerIndex = 2,
            explanation = "A lunar eclipse can occur only near the full moon phase.",
            topic = "Eclipses",
            sourceUrl = ECLIPSE_SOURCE
        ),
        SpaceQuestion(
            id = 27,
            prompt = "What holds the stars of a galaxy together?",
            answers = listOf("Wind", "Gravity", "Sound", "Sunlight"),
            correctAnswerIndex = 1,
            explanation = "Gravity holds a galaxy's stars, gas and dust together.",
            topic = "Universe",
            sourceUrl = GALAXY_SOURCE
        ),
        SpaceQuestion(
            id = 28,
            prompt = "Which is a common galaxy shape?",
            answers = listOf("Spiral", "Cube", "Pyramid", "Rectangle"),
            correctAnswerIndex = 0,
            explanation = "Spiral, elliptical and irregular are common galaxy shapes.",
            topic = "Universe",
            sourceUrl = GALAXY_SOURCE
        ),
        SpaceQuestion(
            id = 29,
            prompt = "What is Sagittarius A*?",
            answers = listOf(
                "A moon of Jupiter",
                "A comet",
                "The black hole at the centre of the Milky Way",
                "A crater on Mars"
            ),
            correctAnswerIndex = 2,
            explanation = "Sagittarius A* is the supermassive black hole at our galaxy's centre.",
            topic = "Universe",
            sourceUrl = BLACK_HOLE_SOURCE
        ),
        SpaceQuestion(
            id = 30,
            prompt = "About how old is our Solar System?",
            answers = listOf("4.6 million years", "46 million years", "4.6 billion years", "46 billion years"),
            correctAnswerIndex = 2,
            explanation = "Our Solar System formed about 4.6 billion years ago.",
            topic = "Solar System",
            sourceUrl = SOLAR_SYSTEM_SOURCE
        ),
        SpaceQuestion(
            id = 31,
            prompt = "About how long does our Solar System take to orbit the Milky Way?",
            answers = listOf("One year", "230 years", "230,000 years", "230 million years"),
            correctAnswerIndex = 3,
            explanation = "One orbit around the Milky Way takes about 230 million years.",
            topic = "Solar System",
            sourceUrl = SOLAR_SYSTEM_SOURCE
        ),
        SpaceQuestion(
            id = 32,
            prompt = "Where do many short-period comets come from?",
            answers = listOf("The Kuiper Belt", "Earth's atmosphere", "The asteroid belt only", "The Sun"),
            correctAnswerIndex = 0,
            explanation = "Many short-period comets come from the Kuiper Belt beyond Neptune.",
            topic = "Small Bodies",
            sourceUrl = COMET_SOURCE
        ),
        SpaceQuestion(
            id = 33,
            prompt = "Which planet travels around the Sun fastest?",
            answers = listOf("Mercury", "Venus", "Earth", "Mars"),
            correctAnswerIndex = 0,
            explanation = "Mercury completes an orbit in only 88 Earth days.",
            topic = "Planets",
            sourceUrl = MERCURY_SOURCE
        ),
        SpaceQuestion(
            id = 34,
            prompt = "Which statement about Mercury is correct?",
            answers = listOf(
                "It has bright rings",
                "It has two moons",
                "It has no moons or rings",
                "It is the hottest planet"
            ),
            correctAnswerIndex = 2,
            explanation = "Mercury has no moons and no rings.",
            topic = "Planets",
            sourceUrl = MERCURY_SOURCE
        ),
        SpaceQuestion(
            id = 35,
            prompt = "On which planet is one day longer than one year?",
            answers = listOf("Mars", "Venus", "Jupiter", "Neptune"),
            correctAnswerIndex = 1,
            explanation = "Venus rotates in 243 Earth days but orbits the Sun in 225 days.",
            topic = "Planets",
            sourceUrl = VENUS_SOURCE
        ),
        SpaceQuestion(
            id = 36,
            prompt = "Which planet rotates backward compared with most planets?",
            answers = listOf("Earth", "Mars", "Venus", "Jupiter"),
            correctAnswerIndex = 2,
            explanation = "Venus rotates in the opposite direction from most planets.",
            topic = "Planets",
            sourceUrl = VENUS_SOURCE
        ),
        SpaceQuestion(
            id = 37,
            prompt = "Which planet is known to have liquid water on its surface?",
            answers = listOf("Earth", "Mercury", "Venus", "Saturn"),
            correctAnswerIndex = 0,
            explanation = "Earth is the only planet known to have stable liquid water on its surface.",
            topic = "Planets",
            sourceUrl = EARTH_SOURCE
        ),
        SpaceQuestion(
            id = 38,
            prompt = "What is a Martian day called?",
            answers = listOf("A luna", "A sol", "A jovian", "A phase"),
            correctAnswerIndex = 1,
            explanation = "A day on Mars is called a sol and lasts about 24.6 hours.",
            topic = "Planets",
            sourceUrl = MARS_SOURCE
        ),
        SpaceQuestion(
            id = 39,
            prompt = "Which planet has the shortest day?",
            answers = listOf("Earth", "Mars", "Jupiter", "Saturn"),
            correctAnswerIndex = 2,
            explanation = "Jupiter rotates once in about 9.9 hours, the shortest planetary day.",
            topic = "Planets",
            sourceUrl = JUPITER_SOURCE
        ),
        SpaceQuestion(
            id = 40,
            prompt = "What is Jupiter's Great Red Spot?",
            answers = listOf("A volcano", "A giant storm", "A frozen lake", "An impact crater"),
            correctAnswerIndex = 1,
            explanation = "The Great Red Spot is a giant storm that is wider than Earth.",
            topic = "Planets",
            sourceUrl = JUPITER_SOURCE
        ),
        SpaceQuestion(
            id = 41,
            prompt = "What are Saturn's rings mainly made of?",
            answers = listOf("Ice and rock", "Liquid water", "Hot lava", "Clouds only"),
            correctAnswerIndex = 0,
            explanation = "Saturn's rings contain countless pieces of ice and rock.",
            topic = "Planets",
            sourceUrl = SATURN_SOURCE
        ),
        SpaceQuestion(
            id = 42,
            prompt = "Which planet rotates almost on its side?",
            answers = listOf("Mercury", "Earth", "Uranus", "Neptune"),
            correctAnswerIndex = 2,
            explanation = "Uranus has an extreme axial tilt of about 98 degrees.",
            topic = "Planets",
            sourceUrl = URANUS_SOURCE
        ),
        SpaceQuestion(
            id = 43,
            prompt = "About how long is one year on Neptune?",
            answers = listOf("12 Earth years", "29 Earth years", "84 Earth years", "165 Earth years"),
            correctAnswerIndex = 3,
            explanation = "Neptune takes about 165 Earth years to orbit the Sun.",
            topic = "Planets",
            sourceUrl = NEPTUNE_SOURCE
        ),
        SpaceQuestion(
            id = 44,
            prompt = "About how long does sunlight take to reach Neptune?",
            answers = listOf("Eight minutes", "One hour", "Four hours", "One day"),
            correctAnswerIndex = 2,
            explanation = "At Neptune's average distance, sunlight takes about four hours to arrive.",
            topic = "Planets",
            sourceUrl = NEPTUNE_SOURCE
        )
    )
}
