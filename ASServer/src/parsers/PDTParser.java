package parsers;

/**
 *
 * @author deigo-gabriel
 */
public class PDTParser {

    public String[][][] parse(String input) throws PDTInputNotParseable {
        String[][][] tables;

        String[] tokens = (input.trim() + "|").split("\\|");
        try {
            if (!input.trim().equals("")) {
                int nOfTables = Integer.parseInt(tokens[0]);

                tables = new String[nOfTables][][];

                int tokenIndex = 1;

                for (int aTableIndex = 0; aTableIndex < nOfTables; aTableIndex++) {
                    int nOfRows = Integer.parseInt(tokens[tokenIndex]);
                    tokenIndex++;
                    int nOfColumns = Integer.parseInt(tokens[tokenIndex]);
                    tokenIndex++;
                    tables[aTableIndex] = new String[nOfRows][nOfColumns];

                    for (int row = 0; row < nOfRows; row++) {
                        for (int column = 0; column < nOfColumns; column++, tokenIndex++) {
                            tables[aTableIndex][row][column] = tokens[tokenIndex];
                        }
                    }
                }
            } else {
                tables = new String[0][0][0];
            }
        } catch (NumberFormatException e) {
            throw new PDTInputNotParseable();
        }
        return tables;
    }
}
