package com.example.kotlinraja.models

import com.example.kotlinraja.R

enum class Status {
    META,
    NON_META
}

enum class Difficult {
    EASY,
    MEDIUM,
    HARD,
    VERY_HARD
}

data class Hero(
    val id: Int,
    val heroName: String,
    val role: String,
    val recommendedLane: String,
    val status: Status,
    val difficult: Difficult,
    val imageUrl: Int
) {
    companion object {
        fun searchHero(query: String): List<Hero> {
            return getAllHero().filter {
                it.heroName.contains(query, ignoreCase = true)
            }
        }

        fun show(id: Int): List<Hero> {
            return getAllHero().filter { it.id ==  id}
        }

        fun filterMeta(): List<Hero> {
            return getAllHero().filter { it.status == Status.META }
        }

        fun filterNonMeta(): List<Hero> {
            return getAllHero().filter { it.status == Status.NON_META }
        }

        fun getAllHero(): List<Hero> {
            return listOf(
                Hero(
                    1,
                    "Chip",
                    "Tank",
                    "Roamer",
                    Status.META,
                    Difficult.MEDIUM,
                    R.drawable.hero1
                ),
                Hero(
                    2,
                    "Hilda",
                    "Tank, Fighter",
                    "Roamer, EXP Lane",
                    Status.META,
                    Difficult.MEDIUM,
                    R.drawable.hero2
                ),
                Hero(
                    3,
                    "GatotKaca",
                    "Tank, Fighter",
                    "Roamer, EXP Lane",
                    Status.META,
                    Difficult.EASY,
                    R.drawable.hero3
                ),
                Hero(
                    4,
                    "Julian",
                    "Fighter, Mage",
                    "Jungle, Mid Lane",
                    Status.META,
                    Difficult.HARD,
                    R.drawable.hero4
                ),
                Hero(
                    5,
                    "Khaleed",
                    "Fighter",
                    "EXP Lane",
                    Status.META,
                    Difficult.MEDIUM,
                    R.drawable.hero5
                ),
                Hero(
                    6,
                    "Phoveus",
                    "Fighter",
                    "EXP lane",
                    Status.META,
                    Difficult.HARD,
                    R.drawable.hero6
                ),
                Hero(
                    7,
                    "Fanny",
                    "Assasin",
                    "Jungle",
                    Status.META,
                    Difficult.VERY_HARD,
                    R.drawable.hero7
                ),
                Hero(
                    8,
                    "Joy",
                    "Assasin",
                    "Jungle",
                    Status.META,
                    Difficult.HARD,
                    R.drawable.hero8
                ),
                Hero(
                    9,
                    "Suyou",
                    "Assasin,Fighter",
                    "Jungle",
                    Status.META,
                    Difficult.HARD,
                    R.drawable.hero9
                ),
                Hero(
                    10,
                    "Aurora",
                    "Mage",
                    "Mid Lane",
                    Status.META,
                    Difficult.EASY,
                    R.drawable.hero10
                ),
                Hero(
                    11,
                    "Zhuxin",
                    "Mage",
                    "Mid lane",
                    Status.META,
                    Difficult.MEDIUM,
                    R.drawable.hero11
                ),
                Hero(
                    12,
                    "Natan",
                    "Marksman",
                    "Gold lane",
                    Status.META,
                    Difficult.HARD,
                    R.drawable.hero12
                ),
                Hero(
                    13,
                    "Irithel",
                    "Marksman",
                    "Gold lane",
                    Status.META,
                    Difficult.EASY,
                    R.drawable.hero13
                ),
                Hero(
                    14,
                    "Mathilda",
                    "Support",
                    "Roamer",
                    Status.META,
                    Difficult.HARD,
                    R.drawable.hero14
                ),
                Hero(
                    15,
                    "Angela",
                    "Support",
                    "Roamer",
                    Status.META,
                    Difficult.EASY,
                    R.drawable.hero15
                ),
                Hero(
                    16,
                    "Uranus",
                    "Tank",
                    "EXP lane, Roamer ",
                    Status.NON_META,
                    Difficult.EASY,
                    R.drawable.hero16
                ),
                Hero(
                    17,
                    "Baxia",
                    "Tank",
                    "Jungle, Roamer",
                    Status.NON_META,
                    Difficult.MEDIUM,
                    R.drawable.hero17
                ),
                Hero(
                    18,
                    "Silvana",
                    "Fighter",
                    "EXP Lane, Roamer",
                    Status.NON_META,
                    Difficult.EASY,
                    R.drawable.hero18
                ),
                Hero(
                    19,
                    "Zilong",
                    "Fighter",
                    "Jungle, EXP lane",
                    Status.NON_META,
                    Difficult.EASY,
                    R.drawable.hero19
                ),
                Hero(
                    20,
                    "Gusion",
                    "Assasin",
                    "Jungle, Mid Lane",
                    Status.NON_META,
                    Difficult.HARD,
                    R.drawable.hero20
                ),
                Hero(
                    21,
                    "Harley",
                    "Mage, Assasin",
                    "Jungler, Mid Lane",
                    Status.NON_META,
                    Difficult.MEDIUM,
                    R.drawable.hero21
                ),
                Hero(
                    22,
                    "Saber",
                    "Assasin",
                    "Jungle, Roamer",
                    Status.NON_META,
                    Difficult.EASY,
                    R.drawable.hero22
                ),
                Hero(
                    23,
                    "Valir",
                    "Mage",
                    "Roamer, Mid Lane",
                    Status.NON_META,
                    Difficult.EASY,
                    R.drawable.hero23
                ),
                Hero(
                    24,
                    "Chang'e",
                    "Mage",
                    "Mid Lane",
                    Status.NON_META,
                    Difficult.EASY,
                    R.drawable.hero24
                ),
                Hero(
                    25,
                    "Hanabi",
                    "Marksman",
                    "Gold Lane",
                    Status.NON_META,
                    Difficult.EASY,
                    R.drawable.hero25
                ),
                Hero(
                    26,
                    "Melissa",
                    "Marksman",
                    "Gold Lane",
                    Status.NON_META,
                    Difficult.MEDIUM,
                    R.drawable.hero25
                ),
                Hero(
                    27,
                    "Kimmy",
                    "Marksman",
                    "Gold Lane",
                    Status.NON_META,
                    Difficult.HARD,
                    R.drawable.hero27
                ),
                Hero(
                    28,
                    "Estes",
                    "Support",
                    "Roamer",
                    Status.NON_META,
                    Difficult.EASY,
                    R.drawable.hero28
                ),
                Hero(
                    29,
                    "Rafaela",
                    "Support",
                    "Roamer",
                    Status.NON_META,
                    Difficult.MEDIUM,
                    R.drawable.hero29
                ),
                Hero(
                    30,
                    "Hanzo",
                    "Assasin",
                    "Jungle",
                    Status.NON_META,
                    Difficult.HARD,
                    R.drawable.hero30
                )
            )
        }
    }
}