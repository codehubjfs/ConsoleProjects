package com.account;

public class Welcome {
    public static void main(String[] args) {
        String message = "Welcome to SDEMY";
        printBoxedBigFontMessage(message);
    }

    public static void printBoxedBigFontMessage(String message) {
        String[] bigFontLines = generateBigFontLines(message);

        int maxLength = bigFontLines[0].length();
        String border = "+-" + "-".repeat(maxLength) + "-+";

        System.out.println(border);
        for (String line : bigFontLines) {
            System.out.println("| " + line + " |");
        }
        System.out.println(border);
    }

    public static String[] generateBigFontLines(String message) {
        String[] lines = new String[7]; // Adjust based on the height of the big font
        for (int i = 0; i < lines.length; i++) {
            lines[i] = "";
        }

        for (char c : message.toCharArray()) {
            String[] charLines = getBigChar(c);
            for (int i = 0; i < lines.length; i++) {
                lines[i] += charLines[i];
            }
        }

        return lines;
    }

    public static String[] getBigChar(char c) {
        switch (c) {
           case 'W':
                return new String[] {
                		 "_____         ____",
                		 "|  |          |  |",
                         "|  |          |  |",  
                         "|  |    __    |  |",
                         "|  |___|  |___|  |",
                         "|       __       |",
                         "|______|  |______|",
                };
            case 'e':
                return new String[] {
                    "  ____  ",
                    " |  __| ",
                    " | |__  ",
                    " |  __| ",
                    " | |___ ",
                    " |____/ ",
                    "        "
                };
            case 'l':
                return new String[] {
                    "  _     ",
                    " | |    ",
                    " | |    ",
                    " | |    ",
                    " | |___ ",
                    " |____/ ",
                    "        "
                };
            case 'c':
                return new String[] {
                    "  _____ ",
                    " / ____|",
                    "| |     ",
                    "| |     ",
                    "| |____ ",
                    " \\_____|",
                    "        "
                };
            case 'o':
                return new String[] {
                    "  ____  ",
                    " / __ \\ ",
                    "| |  | |",
                    "| |  | |",
                    "| |__| |",
                    " \\____/ ",
                    "        "
                };
            case 'm':
                return new String[] {
                    " __  __  ",
                    "|  \\/  | ",
                    "| \\  / | ",
                    "| |\\/| | ",
                    "| |  | | ",
                    "|_|  |_| ",
                    "         "
                };
            case 't':
                return new String[] {
                    "  _____ ",
                    " |_   _|",
                    "   | |  ",
                    "   | |  ",
                    "   | |  ",
                    "   |_|  ",
                    "        "
                };
            case 'S':
                return new String[] {
                    "  _____ ",
                    " / ____|",
                    "| (___  ",
                    " \\___ \\ ",
                    " ____) |",
                    "|_____/ ",
                    "        "
                };
            case 'D':
                return new String[] {
                    " ____  ",
                    "|  _ \\ ",
                    "| | | |",
                    "| | | |",
                    "| |_| |",
                    "|____/ ",
                    "       "
                };
            case 'E':
            	 return new String[] {
                         "  ____  ",
                         " |  __| ",
                         " | |__  ",
                         " |  __| ",
                         " | |___ ",
                         " |____/ ",
                         "        "
                     };
            case 'M':
            	return new String[] {
                        " __  __  ",
                        "|  \\/  | ",
                        "| \\  / | ",
                        "| |\\/| | ",
                        "| |  | | ",
                        "|_|  |_| ",
                        "         "
                    };
            	
            case 'Y':
                return new String[] {
                    " __     __ ",
                    " \\ \\   / / ",
                    "  \\ \\_/ /  ",
                    "   \\   /   ",
                    "    | |    ",
                    "    |_|    ",
                    "           "
                };
            case ' ':
                return new String[] {
                    "  ",
                    "  ",
                    "  ",
                    "  ",
                    "  ",
                    "  ",
                    "  "
                };
            default:
                return new String[] {
                    "        ",
                    "        ",
                    "        ",
                    "        ",
                    "        ",
                    "        ",
                    "        "
                };
        }
    }
}
