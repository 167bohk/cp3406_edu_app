package com.example.cp3406_a3_edu_app.data

object QuestionBank {
    private val easyQuestionIds = setOf(
        1, 2, 3, 4, 6, 7, 10, 11, 12, 18, 20, 23, 24, 27, 28,
        46, 47, 50, 51, 54, 56
    )
    private val hardQuestionIds = setOf(
        29, 31, 32, 33, 34, 35, 36, 38, 39, 40, 41, 42, 43, 44,
        48, 49, 55, 59, 60
    )

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
    private const val STAR_SOURCE = "https://science.nasa.gov/universe/stars/"
    private const val EXOPLANET_SOURCE = "https://science.nasa.gov/exoplanets/facts/"
    private const val TELESCOPE_SOURCE =
        "https://science.nasa.gov/mission/hubble/observatory/hubble-vs-webb/"

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
        ),
        SpaceQuestion(
            id = 45,
            prompt = "What process powers a main sequence star?",
            answers = listOf("Nuclear fusion", "Burning coal", "Radio waves", "Planet collisions"),
            correctAnswerIndex = 0,
            explanation = "Nuclear fusion joins hydrogen nuclei to form helium and releases energy.",
            topic = "Stars",
            sourceUrl = STAR_SOURCE
        ),
        SpaceQuestion(
            id = 46,
            prompt = "Which two elements make up most stars?",
            answers = listOf("Iron and nickel", "Hydrogen and helium", "Oxygen and carbon", "Gold and silver"),
            correctAnswerIndex = 1,
            explanation = "Stars are made mainly of hydrogen with a large amount of helium.",
            topic = "Stars",
            sourceUrl = STAR_SOURCE
        ),
        SpaceQuestion(
            id = 47,
            prompt = "Where do stars begin to form?",
            answers = listOf("Inside planets", "In molecular clouds", "Inside black holes", "In asteroid belts"),
            correctAnswerIndex = 1,
            explanation = "Stars form from cold clouds of gas and dust called molecular clouds.",
            topic = "Stars",
            sourceUrl = STAR_SOURCE
        ),
        SpaceQuestion(
            id = 48,
            prompt = "What mainly determines how quickly a star uses its fuel?",
            answers = listOf("Its number of planets", "Its colour name", "Its mass", "Its distance from Earth"),
            correctAnswerIndex = 2,
            explanation = "A star's mass determines how rapidly it uses its fuel and how long it lives.",
            topic = "Stars",
            sourceUrl = STAR_SOURCE
        ),
        SpaceQuestion(
            id = 49,
            prompt = "What can remain after a low-mass star loses its outer layers?",
            answers = listOf("A white dwarf", "A new galaxy", "A gas giant", "An asteroid belt"),
            correctAnswerIndex = 0,
            explanation = "The remaining core of a low-mass star becomes a white dwarf.",
            topic = "Stars",
            sourceUrl = STAR_SOURCE
        ),
        SpaceQuestion(
            id = 50,
            prompt = "What is the huge explosion at the end of a massive star's life called?",
            answers = listOf("A transit", "A supernova", "An eclipse", "A solar wind"),
            correctAnswerIndex = 1,
            explanation = "A massive star can end its life in a huge explosion called a supernova.",
            topic = "Stars",
            sourceUrl = STAR_SOURCE
        ),
        SpaceQuestion(
            id = 51,
            prompt = "What is an exoplanet?",
            answers = listOf("A planet outside our Solar System", "A moon of Earth", "A type of galaxy", "A dead star"),
            correctAnswerIndex = 0,
            explanation = "An exoplanet is a planet outside our Solar System, usually orbiting another star.",
            topic = "Exoplanets",
            sourceUrl = EXOPLANET_SOURCE
        ),
        SpaceQuestion(
            id = 52,
            prompt = "Which are the two main methods used to find exoplanets?",
            answers = listOf(
                "Transit and radial velocity",
                "Radar and sonar",
                "Eclipses and Moon phases",
                "Rovers and landers"
            ),
            correctAnswerIndex = 0,
            explanation = "Transit and radial velocity are the two main exoplanet detection methods.",
            topic = "Exoplanets",
            sourceUrl = EXOPLANET_SOURCE
        ),
        SpaceQuestion(
            id = 53,
            prompt = "What happens to a star's brightness during an exoplanet transit?",
            answers = listOf("It becomes slightly dimmer", "It doubles", "It turns green", "It disappears forever"),
            correctAnswerIndex = 0,
            explanation = "A planet passing in front of its star blocks a small amount of starlight.",
            topic = "Exoplanets",
            sourceUrl = EXOPLANET_SOURCE
        ),
        SpaceQuestion(
            id = 54,
            prompt = "What is a star's habitable zone?",
            answers = listOf(
                "An area where liquid water could exist on a rocky planet",
                "The hottest part of a star",
                "A group of black holes",
                "A planet's ring system"
            ),
            correctAnswerIndex = 0,
            explanation = "The habitable zone is the distance where liquid water could exist on a rocky planet's surface.",
            topic = "Exoplanets",
            sourceUrl = EXOPLANET_SOURCE
        ),
        SpaceQuestion(
            id = 55,
            prompt = "What does the radial velocity method look for?",
            answers = listOf("A star wobbling because of a planet", "A planet making sound", "A moon changing colour", "An asteroid burning"),
            correctAnswerIndex = 0,
            explanation = "An orbiting planet's gravity makes its star wobble and shifts the star's light spectrum.",
            topic = "Exoplanets",
            sourceUrl = EXOPLANET_SOURCE
        ),
        SpaceQuestion(
            id = 56,
            prompt = "Which telescope orbits Earth just above its atmosphere?",
            answers = listOf("Hubble", "Webb", "Kepler rover", "Voyager station"),
            correctAnswerIndex = 0,
            explanation = "Hubble operates in low-Earth orbit above most of the atmosphere.",
            topic = "Space Telescopes",
            sourceUrl = TELESCOPE_SOURCE
        ),
        SpaceQuestion(
            id = 57,
            prompt = "Why can Hubble take clearer images than many ground telescopes?",
            answers = listOf(
                "It is above Earth's blurring atmosphere",
                "It is close to every star",
                "It has no mirrors",
                "It creates its own stars"
            ),
            correctAnswerIndex = 0,
            explanation = "Hubble's position above the atmosphere avoids much atmospheric distortion.",
            topic = "Space Telescopes",
            sourceUrl = TELESCOPE_SOURCE
        ),
        SpaceQuestion(
            id = 58,
            prompt = "Which kind of light is Webb mainly designed to observe?",
            answers = listOf("Infrared light", "Only visible green light", "Sound waves", "Ocean waves"),
            correctAnswerIndex = 0,
            explanation = "Webb is designed for deep infrared observations.",
            topic = "Space Telescopes",
            sourceUrl = TELESCOPE_SOURCE
        ),
        SpaceQuestion(
            id = 59,
            prompt = "Around which location does Webb orbit the Sun with Earth?",
            answers = listOf("The L2 point", "The asteroid belt", "The Moon's surface", "Mars' north pole"),
            correctAnswerIndex = 0,
            explanation = "Webb travels around the Sun with Earth near the second Lagrange point, L2.",
            topic = "Space Telescopes",
            sourceUrl = TELESCOPE_SOURCE
        ),
        SpaceQuestion(
            id = 60,
            prompt = "Which statement correctly compares Hubble and Webb?",
            answers = listOf(
                "Webb has deeper infrared vision than Hubble",
                "Hubble is a rover on Mars",
                "Webb observes only radio waves",
                "Both telescopes orbit the Moon"
            ),
            correctAnswerIndex = 0,
            explanation = "Webb extends beyond Hubble's infrared range, while Hubble also observes visible and ultraviolet light.",
            topic = "Space Telescopes",
            sourceUrl = TELESCOPE_SOURCE
        )
    ).map { question ->
        question.copy(
            difficulty = when (question.id) {
                in easyQuestionIds -> "Easy"
                in hardQuestionIds -> "Hard"
                else -> "Medium"
            }
        )
    }
}
