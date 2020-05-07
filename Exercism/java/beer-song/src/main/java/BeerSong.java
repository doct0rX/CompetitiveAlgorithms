class BeerSong {

    public String sing(int bottles, int repeats) {   // Bottles describe starting line (starting point) && Repeats describe number of lines (ending point)
        StringBuilder result = new StringBuilder();
        String basicLine = "%s bottles of beer on the wall, %s bottles of beer.\n" +
                "Take one down and pass it around, %s bottles of beer on the wall.\n\n";
        for (int i = bottles; i > bottles - repeats; i--) {
            if (i-1 > 1) {
                result.append(String.format(basicLine, i, i, i - 1));
            } else if(i - 1 == 1) {
                result.append(String.format("%s bottles of beer on the wall, %s bottles of beer.\n" +
                        "Take one down and pass it around, %s bottle of beer on the wall.\n\n", i, i, i - 1));
            } else if(i - 1 == 0) {
                result.append(String.format("%s bottle of beer on the wall, %s bottle of beer.\n" +
                        "Take it down and pass it around, no more bottles of beer on the wall.\n\n", i, i));
            } else {
                result.append("No more bottles of beer on the wall, no more bottles of beer.\n" + "Go to the store and buy some more, 99 bottles of beer on the wall.\n\n");
            }
        }
        return result.toString();
    }

    public String singSong(){
        return sing(99, 100);
    }
}