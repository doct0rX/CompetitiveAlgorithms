class BeerSong {

    BeerSong() {
    }

    String sing(int bottles, int repeats) {
        StringBuilder stringBuilder = new StringBuilder();
        while (bottles > 0 && repeats > 0) {
            if (bottles == 1 && repeats == 1) {
                stringBuilder.append("1 bottle of beer on the wall, 1 bottle of beer.\n" +
                        "Take it down and pass it around, no more bottles of beer on the wall.\n\n");
                break;
            }
            stringBuilder.append(takeOneDownAndPassAround(bottles, repeats));
            bottles--; repeats--;
        }
        if (bottles == 0 && repeats > 0) {
            stringBuilder.append(takeOneDownAndPassAround(bottles, repeats));
        }
        return stringBuilder.toString();
    }

    String singSong() {
        return sing(99, 100);
    }

    String takeOneDownAndPassAround(int nBottles, int nRepeats) {
        if (nBottles > 2) {
            return nBottles + " bottles of beer on the wall, " + nBottles + " bottles of beer.\n" +
                    "Take one down and pass it around, " + (nBottles - 1) + " bottles of beer on the wall.\n\n";
        } else if (nBottles < nRepeats && nBottles == 1) {
            return "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                    "Take it down and pass it around, no more bottles of beer on the wall.\n\n";
        } else if (nBottles > 1) {
            return "2 bottles of beer on the wall, 2 bottles of beer.\n" +
            "Take one down and pass it around, 1 bottle of beer on the wall.\n\n";
        } else if (nBottles == 1) {
            return "Take one down and pass it around, 1 bottle of beer on the wall.\n\n" +
            "Take it down and pass it around, no more bottles of beer on the wall.\n\n";
        } else {
            return "No more bottles of beer on the wall, no more bottles of beer.\n" +
                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n";
        }
    }
}