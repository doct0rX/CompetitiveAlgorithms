/**
 * Author: Mustafa Jamal
 * April 19, 2019
 * 
 * Given a 2-D matrix representing an image, a location of a pixel in the screen and a color C, replace the color of the given pixel and all adjacent same colored pixels with C.
 *
 *  For example, given the following matrix, and location pixel of (2, 2), and 'G' for green:
 *  B B W
 *  W W W
 *  W W W
 *  B B B
 * 
 * Becomes
 *  B B G
 *  G G G
 *  G G G
 *  B B B
 * 
 * 
 * > pseudocode:
 * 1. get to the array where I can check if the color exist in that location.
 * 2. if it's there (true) {
 *      for the current row {
 *           alter the current char (pixel) with new char
 *           update the char column
 *      }
 * }
 */

import java.util.Arrays;


class AlterAdjacentPixels {

    static String[][] mainImage0 = {
        {"B", "B", "W"},
        {"W", "W", "W"},
        {"W", "W", "W"},
        {"B", "B", "B"}
    };

    static String[][] resultImage0 = {
        {"B", "B", "G"},
        {"G", "G", "G"},
        {"G", "G", "G"},
        {"B", "B", "B"}
    };

    static String[][] mainImage = {
        {"B", "B", "W", "S"},
        {"W", "W", "W", "W"},
        {"W", "W", "W", "W"},
        {"W", "M", "W", "M"},
        {"B", "B", "B", "B"}
    };

    static String[][] resultImage = {
        {"B", "B", "G", "S"},
        {"G", "G", "G", "G"},
        {"G", "G", "G", "G"},
        {"G", "M", "G", "M"},
        {"B", "B", "B", "B"}
    };
    
    public static void main(String[] args) {
        System.out.println(printImage(mainImage));
        String[][] currentImage = alterAdjacentPixels(mainImage, 2, 2, "G");
        System.out.println(printImage(currentImage));

        System.out.println(test());
    }

    static private String[][] alterAdjacentPixels(String[][] currentImage, int column, int row, String newPixel) {
        String oldPixel = currentImage[column][row];
        updateCurrentRow(currentImage, column, row, oldPixel, newPixel); 
        return currentImage;
    }

    static private boolean test() {
        return Arrays.deepEquals(alterAdjacentPixels(mainImage, 2, 2, "G"), resultImage);
    }

    /************** HELPERS ************/

    static private void updateCurrentRow(String[][] currentImage, int column, int row, String oldPixel, String newPixel) {
        for (int ro = row; ro < currentImage[0].length; ro++) {
            if (currentImage[column][ro] == oldPixel) {
                currentImage[column][ro] = newPixel;
                updateCurrentColumn(currentImage, column, ro, oldPixel, newPixel);
            } else {
                break;
            }
        }
        for (int ro = row - 1; ro >= 0; ro--) {
            if (currentImage[column][ro] == oldPixel) {
                currentImage[column][ro] = newPixel;
                updateCurrentColumn(currentImage, column, ro, oldPixel, newPixel);
            } else {
                break;
            }
        }
    }

    static private void updateCurrentColumn(String[][] currentImage, int column, int row, String oldPixel, String newPixel) {
        for (int col = column + 1; col < currentImage.length; col++) {
            if (currentImage[col][row] == oldPixel) {
                currentImage[col][row] = newPixel;
            } else {
                break;
            }
        }
        for (int col = column - 1; col >= 0; col--) {
            if (currentImage[col][row] == oldPixel) {
                currentImage[col][row] = newPixel;
            } else {
                break;
            }
        }
    }

    /**
     * helper to visualize the image
     * @param twoDArray 2D array
     * @return 2D image
     */
    static private String printImage(String[][] twoDArray) {
        String imageArray = new String();
        for (int i = 0; i < twoDArray.length; i++) {
            for (int j = 0; j < twoDArray[i].length; j++) {
                imageArray += twoDArray[i][j] + " ";
            }
            imageArray += "\n";
        }
        return imageArray;
    }
}