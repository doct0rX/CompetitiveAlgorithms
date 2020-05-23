class RotationalCipher {

    int shiftKey;

    RotationalCipher(int shiftKey) {
        this.shiftKey = shiftKey;
    }

     String rotate(String data) {
        StringBuilder res = new StringBuilder();
        for (char chr: data.toCharArray()) {
            if (Character.isLetter(chr)) {
                if (Character.isUpperCase(chr)) {
                    int originalAlphabetPosition = chr - 'A';
                    int newAlphabetPosition = (originalAlphabetPosition + shiftKey) % 26;
                    res.append(Character.toChars('A' + newAlphabetPosition));
                } else {
                    int originalAlphabetPosition = chr - 'a';
                    int newAlphabetPosition = (originalAlphabetPosition + shiftKey) % 26;
                    res.append(Character.toChars('a' + newAlphabetPosition));
                }
            } else {
                res.append(chr);
            }
        }
        return res.toString();
    }

}
